### install docker
- docker 대체제 [colima](https://github.com/abiosoft/colima) 설치
```shell
brew install colima
colima start --cpu 2 --memory 4 --disk 10

docker ps
docker run -it --rm ubuntu # interactive mode
 # cat /etc/os-release
 # exit
docker ps -a # 삭제 확인
```

### docker를 자바에서 실행할 때의 문제?
- 예전에는 자바가 리눅스 cgroup으로 지정한 자원 할당량을 무시했었다고 함..! <br/>
  컨테이너에 허용된 메모리가 아닌 도커 호스트의 전체 메모리를 JVM에 할당했다고 함..! 

- java versions
  ```shell
  # list java installations
  /usr/libexec/java_home -V
  ```
  
  ```shell
  # 여러 자바 버전 쉽게 쓰기 (.zshrc 파일)
  
  export PATH=/opt/homebrew/bin:$PATH
  
  # Java Paths
  export JAVA_HOME_8=$(/usr/libexec/java_home -v8)
  export JAVA_HOME_11=$(/usr/libexec/java_home -v11)
  export JAVA_HOME_17=$(/usr/libexec/java_home -v17)
  
  # Java 11
  alias java17='export JAVA_HOME=$JAVA_HOME_17'
  alias java8='export JAVA_HOME=$JAVA_HOME_8'
  alias java11='export JAVA_HOME=$JAVA_HOME_11'
  
  export JAVA_HOME=$JAVA_17_HOME
  ```

- local, docker container에서의 동작 확인하기
  ```shell
  # in local
  echo 'Runtime.getRuntime().availableProcessors()' | jshell -q
  java -XX:+PrintFlagsFinal -version | grep MaxHeapSize
  
  # in docker container
   # openjdk 15에서는 리소스 제한 제대로 동작 안 함..
   # openjdk 12는 정상인듯?
  echo 'Runtime.getRuntime().availableProcessors()' | docker run --rm -i openjdk:12.0.2 jshell -q
  
  docker pull --platform linux/x86_64 openjdk:12.0.2
  
  # cpu 제한
  echo 'Runtime.getRuntime().availableProcessors()' | docker run --rm -i --cpus 2 openjdk:12.0.2 jshell -q
  
  # 메모리 제한(1 giga -> 0.25 giga를 컨테이너에 할당)
  docker run -m=1024M openjdk:12.0.2 java -XX:+PrintFlagsFinal -version | grep MaxHeapSize
  
  # OOM 에러 발생시키기
  echo 'new int[500_000_000]' | docker run -i --rm -m=1024M openjdk:12.0.2 jshell -q
  ```


### docker로 단일 MS 실행
- docker 컨테이너에서 MS를 실행할 때 로컬과 다른점
  - docker에서 MS를 실행하면 각자 IP주소, 호스트, 포트를 가지며 각각이 격리되기 때문에 포트 충돌 문제가 없다고 함!
  - localhost로 통신할 수 없게 됨
  
  ```shell
  gralde build # app jar 생성
  
  # 에러남..  ERROR [internal] load metadata for docker.io/library/openjdk:12.0.2
  # openjdk 로컬에 존재하는 걸로 바꾸니까 해결됨... (근데 원격 레지스트리에서 다운 왜 안받지..)    
  docker build -t app-image:0.0.1 .
  
  # 이렇게 하면 springboot 실행됨...!!!!!!!! 신기..
  docker run --rm p8080:8080 -e "SPRING_PROFILES_ACTIVE=docker" app-image:0.0.1
  
  # 컨테이너 log 확인
  docker ps
  docker logs ${컨테이너 NAME} -f
  
  # 컨테이너 제거
  docker rm -f ${컨테이너 NAME}
  # 그냥 컨트롤+C 해도 종료되는데..
  ```
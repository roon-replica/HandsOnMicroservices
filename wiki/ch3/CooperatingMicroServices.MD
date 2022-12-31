### 0. 차례
1. MS 환경 소개
2. MS 골격 생성
3. API 추가
4. 복합 MS? 추가
5. 예외 처리 추가
6. API 수동 테스트
7. 자동화된 MS 테스트
8. 반자동화된? MS 환경 테스트

### 마이크로서비스 골격 생성
- 코드는 [책에서 제공하는 코드 실행해보면 됨](https://github.com/PacktPublishing/Hands-On-Microservices-with-Spring-Boot-and-Spring-Cloud)
- spring cli 설치
    ```shell
    brew tap spring-io/tap
    brew install springboot # 에러 발생했었는데, CLI에서 어떻게 하라고 안내 메시지 나왔었음.
    ```
- `spring init` 명령으로 스프링 이니셜라이즈로 골격 코드 생성

### 구현
- 구조 어색함........ 

### 빌드, 실행
- 빌드
  - `./gradlew build`
  - 오류나면 gradle 버전과 호환되는 java 버전으로 변경
  - mac에서 기본 자바 버전 변경
    - export JAVA_HOME=`/usr/libexec/java_home -v {자바 버전}`

- 실행
  - `./gradlew build`
  - `java -jar microservices/product-service/build/libs/*.jar &` 하면 스프링부트 띄워짐
  - api 호출 테스트: `curl http://localhost:7001/product/1`
  - 종료: ctrl + C로 interrupt 후 `kill $(jobs -p)`

### 테스트
  - 자동화된 테스트

  - script에서 curl 명령으로 반자동 테스트도 가능하다고 함.
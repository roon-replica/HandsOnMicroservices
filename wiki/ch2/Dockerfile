# sample Dockerfile

FROM openjdk:11.0.1

MAINTAINER roon <think.roon@naver.com>

# application을 외부에 공개할 포트
# docker run -p 8080:8080 app
EXPOSE 7001

# host 머신 -> 도커 이미지로 하위의 파일과 디렉토리들을 복사
ADD ../../build/libs/*.jar app.jar

# 도커 컨테이너가 시작할 때 실행할 명령
# 아래 명령은 'java -jar /app.jar'을 실행하게 됨
ENTRYPOINT ["java","-jar","/app.jar"]
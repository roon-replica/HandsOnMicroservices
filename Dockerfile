FROM adoptopenjdk:11-jdk

#port 공개
EXPOSE 8080

# 도커 이미지에 jar 파일을 ADD 한다는거
ADD ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
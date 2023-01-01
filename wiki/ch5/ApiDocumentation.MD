### 개요
- API는 사용 편의성이 중요해서 접근이 쉬운 문서가 있어야 한다고 함.
- 스웨거는 API 서비스를 문서화할 때 일반적으로 사용하는 것. 주요 API 게이트웨이가 스웨거를 기본 지원한다는데 API 게이트웨이가 뭐지..

### spring fox
- spring fox를 이용하면 API 구현 소스코드와 연동해 API를 문서화 가능
  - 자바 코드와 API 문서의 수명 주기를 같게 만든다는 점에서 큰 의의가 있다고 함!!
  - 이 책에서 제공하는 버전은 스웨거 V3이 아닌 V2 기반이라고 함.

### 적용
- gradle 의존성 추가
  ```yaml
    implementation('io.springfox:springfox-swagger2:3.0.0')
  ```
  




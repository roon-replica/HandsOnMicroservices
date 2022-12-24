### 0. 개요
- MS의 장단점 소개
- MS 기반 아키텍처 소개
- 관련 디자인 패턴

### 1. MS 소개
- [c4 models for S/W architecture](https://www.infoq.com/articles/C4-architecture-model/)
  - 더 좋은 S/W 아키텍처 다이어그램을 만들려고 `C4 model`을 만들었다고 함
  - 4 different zoom levels
    - system context > containers > components > code라서 C4.

### 2. MS 정의
  - 다음 2가지 목표를 당성하려고 `일체형 앱을 작은 컴포넌트로 나누는 것`이라고 함.
    1. 빠르게? 개발해 지속적으로 배포가능하게 하기
    2. 쉬운 스케일링


### 3. MS 문제점들
  - 연쇄 장애 가능성
  - 로깅, 자원 사용량 분석, 관리의 어려움


### 4. MS 디자인 패턴
  - service discovery?
    - k8s service 객체가 해주는거 말하는듯
  - edge server?
    - 외부 공개와 관련된 것. gateway 말하는 듯
  - central configuration?
    - helm 차트 말하는듯
    - k8s의 ConfigMap, Secret
  - centralized log 분석?
    - 로그 중앙화.. 그러게 어떻게 함?
    - 수집, 검색 가능한 형식, API와 그래픽 도구가 필요하다고 함.
  - distributed tracing?
    - 모든 요청과 메시지?에 `correlation ID`?를 넣어야 한다고 함...
  - control loop?
    - 이것도 k8s의 control plane이 해주는거라고 보면 되겠지?
  - centralized monitoring and alarm
    - grafana, prometheus가 하는 일인듯.
    - 모든 서버의 로그 수집, 조회 및 분석 API, 그래픽 제공해야 함.
  - circuit breaker (`self-healing`)
    - 에러 전파를 막기 위한 것.
    - resilience4j 써서 적용해본 적 있음.
  - reactive microservices
    - blocking I/O를 사용하는데 지연 시간이 증가하면 OS 가용 스레드 부족 문제 발생 가능.
    - non-blocking I/O로 기다리는 동안은 스레드가 할당되지 않도록 하는 방식

### 5. MS 구현 시 추가 고려 사항
- devops
  - 자동화된 배포 파이프라인이 필요하다고 함.
- conway 법칙
  - 조직 구성이 아키텍처에 큰 영향을 미치기 때문.  
- 일체형 앱을 MS로 분리할 때가 제일 어렵다고 함
- 적절한 경계를 찾아 MS로 나누려면 `DDD`의 bounded context 개념을 쓰는게 좋다고 함
- API 설계할 때
- 온프레미스에서 클라우드로 마이그레이션할 때
- MS 설계를 위한 12가치 원칙이 있다고 함
  - https://12factor.net/

### 궁금증
- MS의 확장성, 관리 편의성이 구체적으로 어떤 형태일지
- WAR, JAR 패키징 차이
- vertical scaling?
- 분산 시스템?
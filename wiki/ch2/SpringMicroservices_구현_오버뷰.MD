### 0. 개요
- spring boot, spring webflux, spring fox, spring data, spring cloud stream?, docker 소개

### 1. spring boot
- J2EE(=Java EE, 현 Jakarta EE)의 대체자가 spring framework.
- spring boot은 spring framework에 `convention over configuration` 디자인 패턴을 적용한 것.


### 2. spring webflux
- spring 5.0을 기반으로 하는 spring boot 2.0은 reactive 앱 개발을 기본으로 지원한다고 함
- 스프링은 Proejct Reactor를 기본 구현으로 하여 리액티브를 지원한다고 함.

### 3. spring fox
- spring fox는 spring 프레임워크와는 별개의 오픈 소스
- 런타임에 스웨거 기반의 API 문서를 생성

### 4. spring data
- rdb
- nosql

### 5. spring cloud stream
- spring cloud stream은 `게시-구독-통합 패턴`?을 기반으로 하는 메시징 방식의 스트리밍 추상화를 제공한다고 함..
- `kafka` 지원
- consumer group, partitioning, persistence, durability, retry, dead letter queue 등을 재정의할 수 있다는데 감 없음.

### 6. Docker
- Dockerfile
- docker-compose
  - 단일 명령으로 여러 컨테이너 지휘하고 싶을 때 사용(시작 및 중지)
    ```
    docker-compose up
    docker-compose down
    docker-compose logs -f --tail=0
    ```
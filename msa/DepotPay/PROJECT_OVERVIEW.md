# DepotPay - 마이크로서비스 아키텍처 기반 금융 서비스

## 📋 프로젝트 개요

DepotPay는 헥사고날 아키텍처(Hexagonal Architecture)와 마이크로서비스 패턴을 적용한 금융 서비스 플랫폼입니다. Spring Boot 3.5.3과 Java 17을 기반으로 구축되었으며, 회원 관리와 뱅킹 서비스를 제공합니다.

## 🏗️ 아키텍처 개요

### 마이크로서비스 구조
- **membership-service**: 회원 관리 서비스 (포트: 8080)
- **banking-service**: 뱅킹 계좌 관리 서비스 (포트: 8081)
- **common**: 공통 모듈 (어노테이션, 공통 인터페이스)

### 헥사고날 아키텍처 적용
각 서비스는 다음과 같은 헥사고날 아키텍처 구조를 따릅니다:

```
├── adapter/
│   ├── in/web/          # 입력 어댑터 (Controller)
│   └── out/
│       ├── persistence/ # 출력 어댑터 (JPA Repository)
│       └── external/    # 외부 시스템 어댑터
├── application/
│   ├── port/
│   │   ├── in/         # 입력 포트 (Use Case Interface)
│   │   └── out/        # 출력 포트 (Repository Interface)
│   └── service/        # 비즈니스 로직 구현
├── domain/             # 도메인 모델
└── config/             # 설정 파일
```

## 🔧 기술 스택

### 백엔드
- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **Spring Web**
- **Lombok**
- **MySQL 8.0**

### 문서화
- **Swagger/OpenAPI 3** (SpringDoc)

### 컨테이너화
- **Docker & Docker Compose**
- **MySQL 컨테이너 연동**

### 빌드 도구
- **Gradle 8.x**
- **Docker Spring Boot Application Plugin**

## 📦 서비스 상세

### 1. Membership Service (회원 서비스)

**기능:**
- 회원 등록 (Register)
- 회원 조회 (Find)
- 회원 정보 수정 (Modify)

**도메인 모델:**
```java
public class Membership {
    private String membershipId;
    private String name;
    private String email;
    private String address;
    private boolean isValid;
    private boolean isCorp;
}
```

**API 엔드포인트:**
- `POST /membership/register` - 회원 등록
- `GET /membership/{membershipId}` - 회원 조회
- `PUT /membership/modify` - 회원 정보 수정

### 2. Banking Service (뱅킹 서비스)

**기능:**
- 은행 계좌 등록 (Register Bank Account) - ✅ 완전 구현
- 은행 계좌 조회 (Find Bank Account) - ✅ 완전 구현
- 실물 계좌 이체 요청 (Request Firm Banking) - ✅ 완전 구현
- 외부 은행 시스템 연동 (Mock 구현)
- 회원-계좌 연결 상태 관리

**비즈니스 로직 흐름:**

*은행 계좌 등록 프로세스:*
1. 외부 은행 시스템을 통한 계좌 유효성 검증 (`BankAccountAdapter`)
2. 유효한 계좌인 경우 데이터베이스에 계좌 정보 저장
3. 회원 ID와 계좌 연결 상태 관리
4. 등록된 계좌 정보 반환

*은행 계좌 조회 프로세스:*
- 회원 ID 기반 등록된 계좌 정보 조회

*실물 계좌 이체 요청 프로세스:*
1. 이체 요청 정보 검증 (출금 계좌, 입금 계좌, 금액)
2. 외부 은행 시스템을 통한 실물 이체 실행 (`BankAccountAdapter`)
3. 이체 요청 결과를 데이터베이스에 저장
4. 이체 완료 정보 반환

**도메인 모델:**
```java
// 은행 계좌 등록
public class RegisterBankAccount {
    private String registeredBankAccountId;  // 등록된 계좌 ID
    private String membershipId;             // 회원 ID  
    private String bankName;                 // 은행명
    private String bankAccountNumber;        // 계좌번호
    private Boolean linkedStatusIsValid;     // 연결 상태 유효성
    
    // Value Objects (DDD 패턴 적용)
    - RegisteredBankAccountId
    - MembershipId  
    - BankName
    - BankAccountNumber
    - LinkedStatusIsValid
}

// 실물 계좌 이체 요청
public class FirmBankRequest {
    private String firmBankRequestId;        // 실물계좌 요청 ID
    private String fromBankName;             // 출금 은행명
    private String fromBankAccountNumber;    // 출금 계좌번호
    private String toBankName;               // 입금 은행명
    private String toBankAccountNumber;      // 입금 계좌번호
    private int moneyAmount;                 // 이체 금액
    private int firmBankingStatus;           // 이체 상태
    private UUID uuid;                       // 고유 식별자
    
    // Value Objects (DDD 패턴 적용)
    - FirmBankRequestId
    - FormBankName
    - FormBankAccountNumber
    - ToBankName
    - ToBankAccountNumber
    - MoneyAmount
    - FirmBankingStatus
}
```

**외부 시스템 연동:**
- `BankAccountAdapter`: 외부 은행 API 연동 어댑터 (현재 Mock 구현)
- `RequestBankAccountInfoPort`: 은행 계좌 정보 요청 포트
- `RequestExternalFirmBankingPort`: 외부 은행 실물 이체 요청 포트

**API 엔드포인트:**
- `POST /banking/account/register` - 은행 계좌 등록
- `GET /banking/account/{membershipId}` - 회원별 은행 계좌 조회
- `POST /banking/firmbanking/register` - 실물 계좌 이체 요청

## 🗄️ 데이터베이스 설정

### MySQL 설정
- **Host**: localhost:3306
- **Database**: depot_pay
- **Username**: mysqluser
- **Password**: dosel2
- **Dialect**: MySQL8Dialect
- **DDL**: update (자동 테이블 생성/수정)

### JPA 설정
- Hibernate DDL: create-drop (개발 환경)
- Show SQL: true (개발 환경)
- Format SQL: true

## 🐳 Docker 설정

### 서비스 구성
```yaml
services:
  mysql:8.0          # 데이터베이스
  membership-service # 회원 서비스 (이미지: depotpay-membership-service:1.0.3)
  banking-service    # 뱅킹 서비스 (이미지: depotpay-banking-service:1.0.0)
```

### 네트워크
- `depotpay_network`: 모든 서비스가 연결된 브리지 네트워크

## 🔄 개발 워크플로우

### 빌드 및 실행
```bash
# 전체 프로젝트 빌드
./gradlew build

# Docker 이미지 생성
./gradlew dockerBuildImage

# 서비스 실행
docker-compose up -d
```

### 테스트
- 단위 테스트: JUnit 5
- 통합 테스트: Spring Boot Test
- 컨트롤러 테스트: MockMvc

## 📝 공통 모듈 (Common)

### 어노테이션
- `@UseCase`: 유스케이스 클래스 표시
- `@WebAdapter`: 웹 어댑터 클래스 표시
- `@PersistenceAdapter`: 영속성 어댑터 클래스 표시
- `@ExternalSystemAdapter`: 외부 시스템 어댑터 클래스 표시

### 공통 기능
- `SelfValidating<T>`: 자체 검증 기능을 제공하는 추상 클래스

## 🔧 설정 및 환경

### 환경 변수
- Spring Profile 기반 설정
- Docker Compose 환경 변수 주입
- MySQL 연결 정보 외부화

### API 문서
- **Swagger UI 자동 생성** (SpringDoc OpenAPI 3)
- **OpenAPI 3.0 스펙 준수**
- **각 서비스별 독립적인 API 문서**
- **상세한 API 문서화:**
  - `@Tag`: API 그룹별 분류
  - `@Operation`: 각 엔드포인트 상세 설명
  - `@ApiResponses`: HTTP 상태 코드별 응답 설명
  - `@Schema`: 요청/응답 모델 상세 설명 및 예시값
  - `@Parameter`: 경로 변수 및 파라미터 설명

**Banking Service API 문서:**
- 은행 계좌 등록/조회 API 그룹화
- 한국어 설명과 실제 사용 예시값 제공
- 에러 코드별 상세 응답 가이드 (400, 404, 409, 500)

## 📊 모니터링 및 로깅

### 개발 도구
- Spring Boot DevTools (자동 재시작)
- JRebel 설정 (hot reload)

### 로깅
- Hibernate SQL 로깅 활성화
- 포맷팅된 SQL 출력

## 🚀 배포 전략

### 컨테이너 이미지
- Java 17 기반 Slim 이미지 사용
- 각 서비스별 독립적인 Docker 이미지
- 버전 태깅 관리

### 확장성
- 마이크로서비스 간 독립적 배포 가능
- 수평 확장 지원
- 서비스별 독립적인 데이터베이스 접근

## 🚧 현재 개발 상태

### 완료된 기능
- ✅ **Membership Service**: 회원 등록/조회/수정 (완전 구현)
- ✅ **Banking Service - 계좌 등록**: 외부 은행 연동 포함 (완전 구현)
- ✅ **Banking Service - 계좌 조회**: 회원별 연결계좌 조회 (완전 구현)
- ✅ **Banking Service - 실물 이체**: 계좌간 실물 이체 요청 (완전 구현)
- ✅ **Docker 컨테이너화**: MySQL 연동 및 서비스 배포
- ✅ **Swagger API 문서화**: 상세한 API 문서 및 예시값
- ✅ **헥사고날 아키텍처**: Clean Architecture 적용

### 진행 중인 작업
- ⚠️ **에러 핸들링**: 현재 기본적인 null 반환, 체계적인 예외 처리 필요
- ⚠️ **API 문서화**: 새로 추가된 실물 이체 API 문서화 필요

### 기술 부채
- 공통 예외 처리 및 에러 응답 표준화
- 통합 테스트 케이스 확장
- 실물 이체 API Swagger 문서화

## 📈 향후 개발 계획

### 단기 계획 (1-2개월)
- 실물 이체 API Swagger 문서화 완성
- 공통 예외 처리 모듈 개발
- 통합 테스트 환경 구축
- 이체 내역 조회 기능 추가

### 중기 계획 (3-6개월)
- 결제 서비스 (Payment Service) 개발
- 거래 내역 서비스 (Transaction Service) 개발
- 알림 서비스 (Notification Service) 개발

### 장기 계획 (6개월 이상)
- 서비스 간 통신 (REST API → Event-driven)
- 분산 트레이싱 (Zipkin/Jaeger)
- 서비스 메시 (Istio)
- API Gateway 도입
- 실제 은행 API 연동

## 👨‍💻 작성자
- **Author**: DongMin Kim
- **Architecture**: Hexagonal Architecture + Microservices
- **Development Period**: 2024 ~ 현재진행중
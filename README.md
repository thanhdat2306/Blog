# SpringBoot-Blog-practice

이 프로젝트는 Spring Boot를 사용하여 블로그 애플리케이션을 연습하기 위한 프로젝트입니다.

## 주요 기능

- **사용자 인증:** 회원가입 및 로그인 기능이 포함된 기본 인증 시스템.
- **블로그 글:** 블로그 글의 생성, 조회, 수정, 삭제 기능.
- **댓글:** 블로그 글에 댓글 작성 기능.

## 사용된 기술

- **Spring Boot:** 독립적이고 생산적인 Spring 기반 애플리케이션 개발 도구.
- **Spring Data JPA:** ORM 접근 방식을 통해 데이터 접근을 간소화하는 도구.
- **Thymeleaf:** 서버 사이드 Java 템플릿 엔진으로 웹 및 독립형 환경에서 사용됩니다.
- **Bootstrap:** 반응형 및 모바일 우선 웹사이트 개발을 위한 프론트엔드 프레임워크.
- **MySQL:** 관계형 데이터베이스 관리 시스템.


## 준비물

이 Spring Boot 애플리케이션을 실행하기 전에 다음을 설치해야 합니다:

- Java Development Kit (JDK) 8 이상
- Gradle
- MySQL (또는 선택한 다른 관계형 데이터베이스)


## 시작하기

1. **저장소 클론하기:**
git clone https://github.com/Lee2ee/SpringBoot-Blog-practice.git

2. **프로젝트 디렉토리로 이동하기:**
cd SpringBoot-Blog-practice

3. **MySQL 데이터베이스 설정:**
- `blogdb`라는 새로운 데이터베이스 스키마를 생성합니다 (`application.properties`에서 데이터베이스 이름을 수정할 수 있습니다).
- 필요하다면 `src/main/resources/application.properties`에서 데이터베이스 사용자 이름과 비밀번호를 업데이트합니다.

4. **애플리케이션 실행하기:**
Gradle을 사용하여 애플리케이션을 실행할 수 있습니다. 프로젝트 디렉토리로 이동하고 다음 명령을 실행합니다:
./gradlew bootRun

5. **애플리케이션 접속하기:**
애플리케이션이 실행된 후 `http://localhost:8080`에서 접속할 수 있습니다.

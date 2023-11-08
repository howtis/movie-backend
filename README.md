# movie-backend

Spring Boot 백엔드 애플리케이션입니다. 영화 프로젝트에서 프론트엔드와 TMDb API, DB 간의 통신을 담당하여 데이터를 저장 및 프론트엔드로 제공합니다.

<br>

## 영화 프로젝트 구조

- **<a href="https://github.com/howtis/tmdb-java-api" target="_blank">tmdb-java-api</a>**:
자바로 개발된 라이브러리로, 영화 프로젝트를 위해 The Movie Database (TMDb) API와 통신하여 영화 정보를 검색하고 제공하는 라이브러리입니다.

- **<a href="https://github.com/howtis/movie-frontend" target="_blank">movie-frontend</a>**:
Vue 3 웹 프론트엔드 애플리케이션입니다. 영화 정보를 검색하고 표시하는 사용자 인터페이스를 제공합니다.  

- **<a href="https://github.com/howtis/movie-helm-chart" target="_blank">movie-helm-chart</a>**:
Kubernetes에서 영화 프로젝트를 배포하기 위한 Helm Chart입니다.

<br>

## 프로젝트 사이트

[p01076322603.site](https://p01076322603.site)

<br>

## 사용한 주요 기술

```
Java 17, Spring Boot 3
Hibernate + MyBatis // 데이터베이스: Amazon RDS를 사용하여 생성된 PostgreSQL을 사용하고 있습니다.
Lombok
```

<br>

## Github Action Workflows
[build-push.yml](https://github.com/howtis/movie-backend/blob/master/.github/workflows/build-push.yml)
다음과 같은 작업을 수행합니다:
```
지정한 branch의 코드를 gradle로 빌드 후 Github Packages에 배포합니다.
```
[movie-backend-dev](https://github.com/howtis/movie-backend/pkgs/container/movie-backend-dev)  
[movie-backend-prod](https://github.com/howtis/movie-backend/pkgs/container/movie-backend-prod)

<br>

## 테스트
개발 환경 실행을 위해 다음 환경변수가 설정되어야 합니다.
```
application.yaml 수정 (또는 별도의 설정 파일)

spring:
  datasource:
    driver-class-name: org.postgresql.Driver
    url: ${database_url}
    username: ${database_username}
    password: ${database_password}

tmdb:
  api-key: ${tmdb_api_key}
  api-access-token: ${tmdb_api_access_token}

recaptcha:
  secretkey: ${recaptcha_secretkey}

database_url, database_username, database_password: 
데이터베이스 정보입니다.

tmdb_api_key, tmdb_api_access_token: 
사용하기 위해 TMDb 가입 후 API key, token 발급이 필요합니다.

recaptcha_secretkey: 
reCAPTCHA v3 비밀 키 발급이 필요합니다.
```
[[TMDb 링크]](https://www.themoviedb.org)  
[[reCAPTCHA v3 링크]](https://www.google.com/recaptcha/admin/create?hl=ko)

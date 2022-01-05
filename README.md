# keep_distance_back
Keep Distance Back End Project

## 목차
* 개발 환경
* 기능 설명

## 개발 환경

| 언어 및 툴 | 버전 | 비고 |
|--|--|--|
| Spring Tools 4 | Spring Tools 4 (aka Spring Tool Suite 4) 4.13.0.RELEASE | |
| Gradle  | Buildship Gradle Integration 3.0 | |
| Gradle Editor | Minimalist Gradle Editor 1.0.1 | 선택 |
| jdk | jdk-15.0.1_windows-x64_bin | |
| mysql | mysql-installer-community-8.0.19.0 | |

## commit 규칙
	FEAT : 새로운 기능의 추가 
	FIX: 버그 수정 
	DOCS: 문서 수정 
	STYLE: 스타일 관련 기능(코드 포맷팅, 세미콜론 누락, 코드 자체의 변경이 없는 경우) 
	REFACTOR: 코드 리펙토링 
	TEST: 테스트 코트, 리펙토링 테스트 코드 추가 
	CHORE: 빌드 업무 수정, 패키지 매니저 수정(ex .gitignore 수정 같은 경우) 
	
## application.properties 설정
**해당 부분** 수정 후 실행. 
	spring.datasource.hikari.jdbc-url=jdbc:mysql://**localhost:3306**/keep_distance_db 
	spring.datasource.hikari.username=**root** 
	spring.datasource.hikari.password=**1010** 
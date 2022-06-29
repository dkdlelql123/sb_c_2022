#작업 진행
---
#개발환경세팅 
1. STS설치 및 JSP,javascript 지원 및 emmet 설치  
  1-1. emmet JSP 설정  
    ![emmet jsp 설정](https://user-images.githubusercontent.com/55184138/176319908-f5d4354c-4cb5-4362-ac64-fd54f36b6525.png)  
  1-2. javascript 지원  
    - HELP > Install New Software... > Latest Eclipse...(4가지 체크)
      + Eclipse Java EE Developer Tools
      + Eclipse Java Web EE Developer Tools
      + Eclipse Java Web EE Developer Tools - JavaScript Support
      + Eclipse Java Developer Tools  
      ![javascript지원](https://user-images.githubusercontent.com/55184138/176319871-4ab968a2-ca48-4ee1-a7a0-69d1ddaca35e.png)  
      
2. XAMPP 설치
	* 기본포트(3306) 변경 방법 : config - my.ini  
	![xampp](https://user-images.githubusercontent.com/55184138/176321449-835411d5-b3f3-4eca-a4e8-0469e7756e53.png)  
3. vs code 설치  
4. git 설치 및 저장소 생성  
	- git 연동을 위한 이름, 이메일 설정  
	(git config --global user.name "내 git 이름", git config --global user.email "내 git 이메일"을 각각 입력하여 연동)
	- git init  
	- git remote add origin 로컬 저장소(원격 저장소와 연결)
	- gitingnore 설정  
	
5. SQLyog  
6. 일반설정, utf8 관련 설정  

---
#스프링부트 MVC
### 작업순서 C M V
M  
	- 서비스  
	- 리포지터리  
	- DB 데이터  
	  
V  
	- JSP  
	- HTML  
	- CSS  
	- JAVASCRIPT  
	  
C  
	- 컨트롤러


---
#마이바티스, MySQL JDBC 드라이버 추가, 설정 파일에 DB접속정보 기입
자바의 관계형 데이터베이스의 프로그래밍을 쉽게 도와주는 프레임워크로  
자바 프로그램이 데이터베이스와 연결되어 데이터를 주고 받는 인터페이스, JDBC(Java Database Connectivity)  
마이바티스를 통해 JDBC를 보다 편리하게 사용할 수 있게 해줌(코드 파라미터 설정 및 매핑 대신 해줌)

1. pom.xml 의존성 추가   
<https://github.com/dkdlelql123/sb_c_2022/commit/774a61c9170f9de1f00a74061f832f83a87b0f9d>  
![마이바티스](https://user-images.githubusercontent.com/55184138/176325285-a2e12cc2-d16c-4b02-a2bb-ebb0b39d14c9.png)
2. JDBC 드라이버 추가 (위 1번 링크 참조)  
3. repository.java 변경  
	- @Component > @Mapper  
	- class > interface  
4. repository.java 와 같은 경로에 repository.xml 생성  
	- mapper namespace에 연결할 경로(repository.java) 넣어주기
![마이바티스xml](https://user-images.githubusercontent.com/55184138/176325787-26c79044-b7eb-470d-9a5c-249649dd2963.png)

---
#SQL LOGER 적용
쿼리와 결과를 console에서 확인할 수 있음  
DAO > Mybatis > JDBC > (Loger) > DB  

1. pom.xml 의존성 추가
2. application.yml 수정  
3. log4jdbc.log4j2.properties, logback-spring.xml 파일 추가
4. git에서 관리하지 않을 폴더 설정  
	- git bash > notepad .gitignore 명령어 입력 후 맨 밑에 2줄 추가
<pre>
LOG_PATH_IS_UNDEFINED/
log/
</pre>
	- 이후 LOG_PATH_IS_UNDEFINED, log 폴더 삭제
	

참고링크 1~3번 <https://github.com/dkdlelql123/sb_c_2022/commit/676e5e2cd667890fb8660819d3348cc1384dce14>  
참고링크 4번 <https://github.com/dkdlelql123/sb_c_2022/commit/7127ebced023611b6a3b1ec0a3f41ed623e92a9f>

---
#JSP 적용

---
#프론트엔드 라이브러리 불러오기
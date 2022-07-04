# 작업 진행
---
# 개발환경세팅 
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
# MVC패던
	디자인 패턴 중 하나
	'디자인 패턴'이란 개발하는 하는 도중 발생했던 문제점을 정리해서 상황에 따라 간편하게 적용해서 쓸 수 있는 것들을 정리하여 특정한 '규약'에 의해 쉽게 쓸 수 있는 형태로 만든 것을 말함
	
	하나의 어플리케이션을 구성할 때 구성요소를 세 가지의 역할로 구분한 패턴
	
	장점: 사용자가 보는 페이지, 데이터 처리 그리고 중간에서 두 가지를 제어하는 컨트롤.
	3가지로 구성되는 어플리케이션을 만들면 각각의 역할에 집중할 수 있게 됨.
	각자의 역할에 기대할 수 있게끔 개발하다보면, 유지보수성, 유연성이 증가 + 중복코드 문제점을 해결할 수 있음

# 스프링부트 MVC
	작업순서 C → M → V
	M(model)  
		- 서비스  
		- 리포지터리  
		- DB 데이터  
	  
	V(view)  
		- JSP  
		- HTML  
		- CSS  
		- JAVASCRIPT  
	  
	C(controller)  
		- 컨트롤러


---
# 마이바티스, MySQL JDBC 드라이버 추가, 설정 파일에 DB접속정보 기입
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
# SQL LOGER 적용
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
# JSP 적용

---
# 프론트엔드 라이브러리 불러오기
##### 제이쿼리
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> 

##### 테일윈드
	노말라이즈, 테일윈드 라이브러리 한 번에 해결
	<script src="https://unpkg.com/tailwindcss-jit-cdn"></script>  
	장점 : 섬세한 작업이 가능함 ex) w-[100px]
	단점 : 라이브러리가 무거워 로딩 시간이 길어짐
	
	추후 변경 그리고 daisyUI 추가
	<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2/dist/tailwind.min.css" rel="stylesheet" type="text/css" />
	<!-- 데이지UI -->
	<link href="https://cdn.jsdelivr.net/npm/daisyui@2.13.4/dist/full.css" rel="stylesheet" type="text/css" /> 
	
	* CSS Normalize
		- 브라우저마다 제공하는 스타일 기본값이 있는데, 스타일의 오차를 줄이고 버그를 줄이는 방향으로 스타일을 재지정한 것.
		- CSS Reset는 기본값을 다 싸그리 엎는 데 반해 CSS Normalize는 기본값들을 최대한 보존하고 수정을 최소화한다
		- 오픈소스 <https://necolas.github.io/normalize.css>

##### 폰트어썸
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />

---
# JsHistoryBack & JsReplace
##### JsHistoryBack
	- 사용법: history.back(); 을 이용해서 뒤로가기
##### JsReplace
	- 사용법 : location.replace('이동할 주소');
	- 특징 
		* 히스토리가 남지 않는다. 즉, 뒤로가기가 안된다.
		* '뒤로가기' 버튼을 눌렀을 때 이전 페이지로 이동할 수 없어야 할 때
			+ ex) 결제, 회원가입, 로그인
			+ 'usr/article/detail' 게시물상세 삭제 > 'usr/article/doDelete' 삭제 처리 > 'usr/article/list' 게시판목록  
			게시판 목록에서 뒤로가기를 누르면 삭제 처리 동작이 다시 실행되서 에러가 발생할 수 있음
					
---
# getForPrintArticle & getArticle 차이점
##### getArticle 
	: 단순하게 article의 정보를 가져오는 것
	SELETE * FROM article

##### getForPrintArticle	
	: 현재 로그인한 회원의 정보(id)로 해당 게시물의 수정, 삭제 권한까지 담겨있는 정보 
	SELETE * 
	FROM article a 
	inner join member m 
	on a.memberId = m.id 
	where a.id = ${articleId}


--- 
# Form 과 AJAX
	- 공통점 : 브라우저에서 서버로 데이터를 전송하는 하는 방법(=서버와 데이터를 주고 받는 방법)
		+ Form 동기 방식
		+ AJAX 비동기 방식
	- 차이점 
	form은 데이터를 주고 받을 때, 페이지 전체가 리로드 됨. 주로 로그인 이후 페이지를 이동할 때 사용함.
		+ 페이지 전체가 리로드 되다보니 서버의 부하가 크고, 시간이 보다 오래걸림.
	AJAX는 세밀하게 조절이 가능하므로 HTML 일부만 변경하는 것처럼도 사용이 가능하다.
	즉, 페이지의 전환 없이 데이터를 주고 받을 수 있다. ex) 좋아요, 조회수 등
		+ 대기 시간이 줄어듬
	
### GET, POST 차이
	: HTTP로 클라이언트에서 서버로 무언가를 요청할 때 사용함	 
##### HTTP
	: WWW상에서 사용하는 프로토콜
	1990년대 팀 버너리스가 월드와이드 웹을 만들어서 하이퍼텍스트 문서들을 주고 받기 위한 규약으로 만든 것이 HTTP 이다. 
		+ 하이퍼텍스트(HyperText) : 참조(하이퍼링크)를 통해 한 문서에서 다른 문서로 즉시 접근할 수 있는 텍스트를 의미
		+ 월드와이드 웹(www, World Wide Web) : 인터넷에 연결된 컴퓨터를 통해 사람들이 정보를 공유할 수 있는 가상의 공간

##### GET
	: 클라이언트가 서버로 부터 어떤 리로스의 정보를 묘청할 때 사용되는 메서드
	- URL 주소 끝에 파라미터로 포함되어 전송되며, 이런 부분을 '쿼리 스트링'이라고 함
	ex) https://naver.com?name=banana&age=1
	
##### POST
	: 클라이언트가 서버로 리로스를 생성하거나 업데이트하기 위해 데이터를 보낼 때 사용되는 메서드
	- 전송할 데이터를 http body부분에 담아서 보내지므로, get 방식보다는 더 큰 데이터를 보낼 수 있고, 외부적으로 들어나지 않아 보다 보안적으로 사용할 수 있다

##### 차이점
| 차이 | GET | POST |
|:---|:---:|:---:|
| 캐시 | 가능 | 불가능 |
| 브라우저 히스토리 | 남는다 | 남지 않는다. |
| 사용목적 | 리소스 요청 | 리소스 생성, 업데이트 |
| BODY 유무 | 무 | 유 |



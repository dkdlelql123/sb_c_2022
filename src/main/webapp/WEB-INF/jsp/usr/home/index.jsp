<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="main" value="true" />
<c:set var="pageTitle" value="홈" />
<%@ include file="../common/head.jspf"%>

<style>
div[id^=slide] h1 {text-shadow: 0 0 20px #00000020;}
</style>

<div class="carousel w-full" >
  <div id="slide1" class="carousel-item relative w-full" style="display:block;">
    <img src="../resource/220210.png" alt="메인배너" class="absolute transform -translate-y-1/2 top-1/2" />
    <div  class="absolute flex justify-center w-full transform -translate-y-1/2 top-1/2">
      <h1 class="text-6xl center text-white font-bold">FREE BANNER</h1>
    </div>
    <div class="absolute flex justify-between transform -translate-y-1/2 left-5 right-5 top-1/2">
      <a href="#slide2" class="btn btn-circle btn-outline" style="color:#fff; border-color:#fff">❮</a> 
      <a href="#slide2" class="btn btn-circle btn-outline" style="color:#fff; border-color:#fff">❯</a>
    </div>
  </div> 
  <div id="slide2" class="carousel-item relative w-full" style="display:block" >
    <img src="../resource/32.png" alt="메인배너" class="w-full" />
     <div  class="absolute flex justify-center w-full transform -translate-y-1/2 top-1/2">
      <h1 class="text-6xl center text-white font-bold">FREE BANNER</h1>
    </div>
    <div class="absolute flex justify-between transform -translate-y-1/2 left-5 right-5 top-1/2">
      <a href="#slide1" class="btn btn-circle btn-outline" style="color:#fff; border-color:#fff">❮</a>
      <a href="#slide1" class="btn btn-circle btn-outline" style="color:#fff; border-color:#fff">❯</a>
    </div>
  </div> 
</div>

<section class="py-40 bg-gray-200">
  <h5 class="text-lg text-center">SUB TITLE</h5>
  <h2 class="font-title text-4xl font-extrabold sm:text-5xl lg:text-7xl text-center mt-3">BEST TITLE</h2>
  
  <div class="flex justify-between items-center mt-24 w-3/4 mx-auto gap-8">
  <c:forEach var="article" items="${bestArticles}">
    <a class="card card-compact w-1/3 bg-base-100 shadow-xl" href="/usr/article/detail?id=${article.id}">
      <div class="card-body">
         <h2 class="card-title flex-col h-24" style="align-items:flex-start">
            <div class="badge badge-${article.boardId == 1 ? 'primary' : 'secondary'}">${article.extra__boardName}</div>
            ${article.title}
         </h2>       
         <p class="text-sm mt-4">${article.extra__writerName} | ${article.getForPrintType1RegDate()}</p>
      </div>
    </a>
  </c:forEach>
  </div>
</section>


<section class="pt-40">
  <h5 class="text-lg text-center">SUB TITLE</h5>
  <h2 class="font-title text-4xl font-extrabold sm:text-5xl lg:text-7xl text-center mt-3">NEW TITLE</h2>
  
  <div class="flex justify-between items-center mt-24 w-3/4 mx-auto gap-8">
  <c:forEach var="article" items="${newArticles}">
    <a class="card card-compact w-1/3 bg-base-100 shadow-xl" href="/usr/article/detail?id=${article.id}">
      <div class="card-body">
         <h2 class="card-title flex-col h-24" style="align-items:flex-start">
            <div class="badge badge-${article.boardId == 1 ? 'primary' : 'secondary'}">${article.extra__boardName}</div>            
              ${article.title}
         </h2>       
         <p class="text-sm mt-4">${article.extra__writerName} | ${article.getForPrintType1RegDate()}</p>
      </div>
    </a>
  </c:forEach>
  </div>
</section>


<%@ include file="../common/tail.jspf"%>
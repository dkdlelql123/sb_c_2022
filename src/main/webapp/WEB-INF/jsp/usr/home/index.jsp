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

<%@ include file="../common/tail.jspf"%>
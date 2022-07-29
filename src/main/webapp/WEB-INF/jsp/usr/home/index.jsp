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


<section class="pt-40">
  <h5 class="text-lg text-center">SUB TITLE</h5>
  <h2 class="text-6xl text-center font-bold mt-3">BEST TITLE</h2>
  
  <div class="flex justify-around items-center mt-24 w-3/4 mx-auto">
    <div class="card w-1/4 bg-base-100 shadow-xl image-full">
      <figure><img src="https://placeimg.com/400/225/arch" alt="Shoes" /></figure>
      <div class="card-body">
        <h2 class="card-title">Shoes!</h2>
        <p>If a dog chews shoes whose shoes does he choose?</p>
        <div class="card-actions justify-end">
          <button class="btn btn-primary">Buy Now</button>
        </div>
      </div>
    </div>
    
    <div class="card w-1/4 bg-base-100 shadow-xl image-full">
      <figure><img src="https://placeimg.com/400/225/arch" alt="Shoes" /></figure>
      <div class="card-body">
        <h2 class="card-title">Shoes!</h2>
        <p>If a dog chews shoes whose shoes does he choose?</p>
        <div class="card-actions justify-end">
          <button class="btn btn-primary">Buy Now</button>
        </div>
      </div>
    </div>
    
    <div class="card w-1/4 bg-base-100 shadow-xl image-full">
      <figure><img src="https://placeimg.com/400/225/arch" alt="Shoes" /></figure>
      <div class="card-body">
        <h2 class="card-title">Shoes!</h2>
        <p>If a dog chews shoes whose shoes does he choose?</p>
        <div class="card-actions justify-end">
          <button class="btn btn-primary">Buy Now</button>
        </div>
      </div>
    </div>
  </div>
</section>


<section class="pt-40">
  <h5 class="text-lg text-center">SUB TITLE</h5>
  <h2 class="text-6xl text-center font-bold mt-3">NEW TITLE</h2>
</section>


<%@ include file="../common/tail.jspf"%>
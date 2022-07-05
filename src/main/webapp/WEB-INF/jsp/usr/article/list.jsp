<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${board.name} 리스트" />
<%@ include file="../common/head.jspf"%>

<div class="form-control">
  <form class="input-group justify-center" name="search-form">
   <input type="hidden" name="boardId" value="${boardId}" />
   <select id="select" name="searchKeywordType" data-value="${param.searchKeywordType}" class="select select-sm select-bordered border-r-0 rounded-r-none" style="border-bottom-right-radius: 0px;border-top-right-radius: 0px">
      <option value="title" selected>제목</option>
      <option value="body">내용</option>
      <option value="title,body">제목+내용</option>
    </select>
    <input type="text" name="searchKeyword" value="${param.searchKeyword}" placeholder="Search…" class="input input-sm input-bordered" />
    <button type="submit" class="btn btn-sm btn-square">
      <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke="#fff" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" /></svg>
    </button>
  </form>
</div> 

<div class="flex itmes-center justify-between my-4">
  <div>${board.name} 총 ${articlesCount}개</div>
  <div>
    <a href="/usr/article/write?boardId=${board.id}"
      class="btn btn-sm btn-info">글쓰기</a>
  </div>
</div>

<div class="table-box-type-1">
  <table id="boardtable">
    <colgroup>
      <col width="100">
      <col width="500">
    </colgroup>
    <thead>
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>조회수</th>
        <th>좋아요</th>
        <th>작성자</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="article" items="${articles}">
        <tr>
          <td class="text-center">${article.id}</td>
          <td>
            <a href="/usr/article/detail?id=${article.id}">${article.title}</a>
            [0]
          </td>
          <td class="text-center">${article.hit}</td>
          <td class="text-center">10</td>
          <td class="text-center">${article.extra__writerName}</td>
          <td class="text-center">${article.regDate.substring(2,10)}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<!-- 페이지 관련 -->
<c:set var="pageRange" value="9" />
<c:set var="startPage" value="${page - pageRange >= 1 ? page - pageRange : 1}" />
<c:set var="endPage" value="${ startPage+pageRange <= pagesCount ? startPage+pageRange : pagesCount }" />

<c:set var="baseUri" value="?boardId=${board.id}" />
<c:set var="baseUri" value="${baseUri}&searchKeywordType=${param.searchKeywordType}" />
<c:set var="baseUri" value="${baseUri}&searchKeyword=${param.searchKeyword}" />

<div class="flex justify-center mt-4">
  <div class="btn-group">
    <c:if test="${page != 1}">
      <a href="${baseUri}&page=1"  class="btn btn-sm text-white">«</a>
    </c:if>
    
    <c:forEach begin="${startPage}" end="${endPage}" var="i">
      <a
        href="${baseUri}&page=${i}"
       class="btn btn-sm text-white ${page == i ? 'btn-active' : '' }">${i}</a>
    </c:forEach>
    
    <c:if test="${page != pagesCount && pagesCount != 1 }">
    <a 
      href="${baseUri}&page=${pagesCount}" 
      class="btn btn-sm text-white">»</a>
    </c:if>
  </div>
</div>

<%@ include file="../common/tail.jspf"%>

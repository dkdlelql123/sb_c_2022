<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${board.name} 리스트" />
<%@ include file="../common/head.jspf"%>

<div class="form-control">
  <div class="input-group justify-center">
   <select class="select select-sm select-bordered border-[#6b7280] border-r-0">
      <option selected>제목</option>
      <option>내용</option>
      <option>제목+내용</option>
    </select>
    <input type="text" placeholder="Search…" class="input input-sm input-bordered" />
    <button class="btn btn-sm btn-square">
      <svg xmlns="http://www.w3.org/2000/svg" class="h-4 w-4" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke="#fff" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" /></svg>
    </button>
  </div>
</div> 

<div class="flex itmes-center justify-between my-4">
  <div>${board.name}총 ${articlesCount}개</div>
  <div>
    <a href="/usr/article/write?boardId=${board.id}"
      class="btn btn-sm btn-info">글쓰기</a>
  </div>
</div>

<div class="table-box-type-1">
  <table>
    <colgroup>
      <col width="500">
    </colgroup>
    <thead>
      <tr>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>작성일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="article" items="${articles}">
        <tr>
          <td>
            <a href="/usr/article/detail?id=${article.id}">${article.title}</a>
            [0]
          </td>
          <td class="text-center">${article.extra__writerName}</td>
          <td class="text-center">10</td>
          <td class="text-center">${article.regDate.substring(2,10)}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

<div class="flex justify-center mt-4">
  <div class="btn-group">
    <a class="btn btn-sm text-white">«</a>
    <a class="btn btn-sm text-white btn-active ">1</a>
    <a class="btn btn-sm text-white">2</a>
    <a class="btn btn-sm text-white">3</a>
    <a class="btn btn-sm text-white">4</a>
    <a class="btn btn-sm text-white ">5</a>
    <a class="btn btn-sm text-white">»</a>
  </div>
</div>

<%@ include file="../common/tail.jspf"%>

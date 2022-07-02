<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="${board.name} 리스트" />
<%@ include file="../common/head.jspf"%>

<div class="flex itmes-center justify-between mb-4">
  <div>${board.name} 총 ${articlesCount}개</div>
  <div>
    <a href="/usr/article/write" class="btn btn-type-1 px-2 py-1">글쓰기</a>
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

<%@ include file="../common/tail.jspf"%>

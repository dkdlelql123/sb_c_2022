<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 리스트" />
<%@ include file="../common/head.jspf"%>

<div class="table-box-type-1">
<table>
  <colgroup>
    <col width="500">
  </colgroup>
  <thead>
    <tr>
      <th>제목</th>
      <th>작성자</th>
      <th>작성일</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="article" items="${articles}">
      <tr>
        <td>
          <a href="/usr/article/detail?id=${article.id}">${article.title}</a>
        </td>
        <td>${article.extra__writerName}</td>
        <td>${article.regDate.substring(2,10)}</td>
      </tr>
    </c:forEach>
  </tbody>
</table>
</div>

<%@ include file="../common/tail.jspf"%>

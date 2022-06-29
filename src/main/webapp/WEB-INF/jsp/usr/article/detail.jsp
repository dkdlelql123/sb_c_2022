<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 상세페이지" />
<%@ include file="../common/head.jspf" %>

<div class="table-box-type-1">
<table> 
  <colgroup>
    <col width="200">
  </colgroup>
  <tr class="">
    <td>번호</td>
    <td>${article.id}</td>
  </tr>
  <tr>
    <td>제목</td>
    <td>${article.title}</td>
  </tr>
  <tr>
    <td>작성자</td>
    <td>${article.extra__writerName}</td>
  </tr>
  <tr>
    <td>작성일</td>
    <td>${article.regDate}</td>
  </tr>
  <tr>
    <td>수정일</td>
    <td>${article.updateDate}</td>
  </tr>
  <tr>
    <td>내용</td>
    <td>${article.body}</td>
  </tr>
</table>
</div>

<%@ include file="../common/tail.jspf" %>

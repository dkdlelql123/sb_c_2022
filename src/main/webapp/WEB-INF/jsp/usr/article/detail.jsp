<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 상세페이지" />
<%@ include file="../common/head.jspf"%>

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
      <td class="flex items-center gap-2">
        <span>${article.extra__writerName}</span>
        <c:if test="${article.extra__actorCanModify}">
          <a class="btn btn-type-1"
            href="/usr/article/modify?id=${article.id}">수정</a>
          <a class="btn btn-type-2"
            onclick="if( confirm('정말 삭제하시겠습니까?') == false) return false;"
            href="/usr/article/doDelete?id=${article.id}">삭제</a>
        </c:if>
      </td>
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

<%@ include file="../common/tail.jspf"%>

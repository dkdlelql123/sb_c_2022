<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 상세페이지" />
<%@ include file="../common/head.jspf"%>

<c:if test="${article.extra__actorCanEdit}">
  <div class="flex justify-end mb-4 gap-2">
    <a href="/usr/article/modify?id=${article.id}"
      class="btn btn-type-1 px-2 py-1">수정</a>
    <a
      href="/usr/article/doDelete?id=${article.id}"
      onclick="if( confirm('삭제하시겠습니까?') == false) return false; "
      class="btn btn-type-2 px-2 py-1"> 삭제</a>
  </div>
</c:if>

<div class="table-box-type-1">
  <table>
    <colgroup>
      <col width="200">
    </colgroup>
    <tr>
      <td>번호</td>
      <td>${article.id}</td>
    </tr>
    <tr>
      <td>조회수</td>
      <td>10</td>
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
      <td>
        <div class="p-1 bg-gray-100 h-[200px]">${article.body}</div>
      </td>
    </tr>
  </table>
</div>

<div class="py-8">
  <h4 class="py-2 border-b border-gray-400">댓글💬</h4>
  <table>
    <tr>
      <div class="flex gap-1 items-center py-2 border-b border-gray-200">
        <p>댓글내용...</p>
        <span class="text-sm text-gray-500">작성자</span>
        <span class="text-sm text-gray-500">작성일</span>
        <a class="btn btn-type-1 text-xs" href="/usr/reply/modify?id=">수정</a>
        <a class="btn btn-type-2 text-xs"
          onclick="if( confirm('정말 삭제하시겠습니까?') == false) return false;"
          href="/usr/reply/doDelete?id=">삭제</a>
      </div>
    </tr>
  </table>
</div>

<%@ include file="../common/tail.jspf"%>

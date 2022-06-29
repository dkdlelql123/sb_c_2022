<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 수정페이지" />
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
      <td>
        <input type="text" class="w-full input-sm"  name="title"  value="${article.title}" />
      </td>
    </tr>
    <tr>
      <td>작성자</td>
      <td class="flex items-center gap-2">
        <span>${article.extra__writerName}</span>
        <a 
        class="btn btn-type-1"
        href="/usr/article/doModify?id=${article.id}"
        >수정완료</a> 
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
      <td><textarea name="body" class="w-full textarea" cols="10" rows="10">${article.body}</textarea></td>
    </tr>
  </table>
</div>

<%@ include file="../common/tail.jspf"%>

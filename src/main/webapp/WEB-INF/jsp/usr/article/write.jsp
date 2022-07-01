<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 글쓰기" />
<%@ include file="../common/head.jspf"%>

<form action="">   
  <div class="flex justify-end mb-4 ">
    <button class="btn btn-type-1 px-2 py-1">작성하기</button>
  </div>
  
  <div class="table-box-type-1">
    <table>
      <colgroup>
        <col width="200">
      </colgroup>
      <tr>
        <td>제목</td>
        <td>
          <input type="text" class="w-full input-sm" name="title"
            placeholder="제목을 입력해주세요." />
        </td>
      </tr>
      <tr>
        <td>내용</td>
        <td>
          <textarea name="body" class="w-full textarea" cols="10"
            rows="10" placeholder="제목을 입력해주세요."></textarea>
        </td>
      </tr>
    </table>
  </div>
</form>

<%@ include file="../common/tail.jspf"%>

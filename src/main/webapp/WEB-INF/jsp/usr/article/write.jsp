<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 글쓰기" />
<%@ include file="../common/head.jspf"%>

<div>
  <form class="table-box-type-1" action="/usr/article/doWrite"
    method="POST">
    <input type="hidden" name="memberId" value="${rq.loginedMemberId}" />
    <table>
      <colgroup>
        <col width="200">
      </colgroup>
      <tr>
        <td>작성자</td>
        <td>
          <input type="text" class="w-full input-sm" value="${rq.member.nickname}" readonly />
        </td>
      </tr>
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
            rows="10" placeholder="내용을 입력해주세요."></textarea>
        </td>
      </tr>
    </table>

    <div class="flex justify-end mt-4">
      <input type="submit" class="btn btn-type-1 px-2 py-1" value="작성하기" />
    </div>
  </form>
</div>

<%@ include file="../common/tail.jspf"%>

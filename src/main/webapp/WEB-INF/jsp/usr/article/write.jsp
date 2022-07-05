<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 글쓰기" />
<%@ include file="../common/head.jspf"%>

<c:set var="board_id" value="${param.boardId}" />
<input type="hidden" id="board_id" value="${board_id}" />

<script type="text/javascript">
$(document).ready(function(){ 
	 //const url_href = window.location.href; 
	 //const url = new URL(url_href);
	 //const boardId = url.searchParams.get("boardId");  
	 const boardId = $("#board_id").val();
	 $("#boardCategory option[data=cate"+boardId+"]").prop("selected", true);
});
</script>

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
          <input type="text" class="w-full input-sm"
            value="${rq.member.nickname}" readonly />
        </td>
      </tr>
      <tr>
        <td>카테고리</td>
        <td>
          <select name="boardId" id="boardCategory" class="select border border-gray-300" >
            <option>-선택해주세요-</option>
            <c:forEach var="board" items="${boards}">
              <option value="${board.id}" data="cate${board.id}">${board.name}</option>
            </c:forEach>
          </select>
        </td>
      </tr>
      <tr>
        <td>제목</td>
        <td>
          <input type="text" class="w-full input-sm" name="title" required="required"  
            placeholder="제목을 입력해주세요." />
        </td>
      </tr>
      <tr>
        <td>내용</td>
        <td>
          <textarea name="body" class="w-full textarea" cols="10" rows="10" required="required"  
            placeholder="내용을 입력해주세요."></textarea>
        </td>
      </tr>
    </table>

    <div class="flex justify-end mt-4">
      <button class="btn btn-info btn-sm">작성하기</button>
    </div>
  </form>
</div>

<%@ include file="../common/tail.jspf"%>

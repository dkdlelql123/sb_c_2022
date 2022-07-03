<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 수정페이지" />
<%@ include file="../common/head.jspf"%>

<form class="table-box-type-1" action="/usr/article/doModify"
  method="POST">

  <c:if test="${article.extra__actorCanEdit}">
    <div class="flex justify-end mb-4 gap-2">
      <input type="submit" class="btn btn-type-1 px-2 py-1" value="저장" />
    </div>
  </c:if>

  <table>
    <colgroup>
      <col width="200">
    </colgroup>
    <tr class="">
      <td>번호</td>
      <td>
        <input type="text" name="id" value="${article.id}" readonly />
      </td>
    </tr>
    <tr>
        <td>카테고리</td>
        <td>
          <select name="boardId" id="boardCategory" class="select" >
            <option>-선택해주세요-</option>
            <c:forEach var="board" items="${boards}">
              <c:choose>
                <c:when test="${board.id == article.boardId}"> 
                  <option value="${board.id}" data="cate${board.id}" selected >${board.name}</option>
                </c:when>
                <c:otherwise>
                  <option value="${board.id}" data="cate${board.id}">${board.name}</option>
                </c:otherwise>
              </c:choose>
              
            </c:forEach>
          </select>
        </td>
      </tr>
    <tr>
      <td>제목</td>
      <td>
        <input type="text" class="w-full input-sm" name="title"
          value="${article.title}" />
      </td>
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
        <textarea name="body" class="w-full textarea" cols="10"
          rows="10">${article.body}</textarea>
      </td>
    </tr>
  </table>
</form>

<%@ include file="../common/tail.jspf"%>
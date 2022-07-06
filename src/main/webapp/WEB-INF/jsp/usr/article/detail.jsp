<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 상세페이지" />
<%@ include file="../common/head.jspf"%>

<input type="hidden" name="articleId" value="${param.id}" />
<script type="text/javascript" defer="defer">
let articleId = $("input[name='articleId']").val();
articleId =  parseInt(articleId);

function ArticleDetail__increaseHitCount() { // 게시물 조회수 관련 함수
	const localStorageKey = "article__"+articleId+"__viewDone"; 
	
	if(localStorage.getItem(localStorageKey)){ 
		return ;
	}
	
	localStorage.setItem(localStorageKey, true);

	$.ajax({
		url:'/usr/article/increaseHitCount?id='+articleId, 
		success :  function(data){ 
			console.log("성공");
			console.log(data);
            $(".articleHit").html(data.data1); 
        }, error:function(request,status,error){     
        	console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);       
        }
	})
}

ArticleDetail__increaseHitCount();
</script>

<div class="flex justify-between mb-4 ">
  <a href="/usr/article/list?boardId=${article.boardId}">목록으로</a>

  <c:if test="${article.extra__actorCanEdit}">  
    <div class="flex justify-end gap-2">
      <a href="/usr/article/modify?id=${article.id}"
        class="btn btn-info btn-sm">수정</a>
      <a
        href="/usr/article/doDelete?id=${article.id}"
        onclick="if( confirm('삭제하시겠습니까?') == false) return false; "
        class="btn btn-error btn-sm"> 삭제</a>
    </div>
  </c:if>
</div>

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
      <td>조회</td>
      <td><div class="articleHit">${article.hit}</div></td>
    </tr>
    <tr>
      <td>추천</td>
      <td><div class="goodReactionPoint">${article.extra__goodReactionPoint}</div></td>
    </tr>
    <tr>
        <td>카테고리</td>
        <td>
          ${article.extra__boardName}
        </td>
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
      <td>${article.forPrintType2RegDate}</td>
    </tr>
    <tr>
      <td>수정일</td>
      <td>${article.forPrintType2UpdateDate}</td>
    </tr>
    <tr>
      <td>내용</td>
      <td>
        <div class="p-1 bg-gray-100" style="min-height:120px">${article.body}</div>
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
        <a class="btn btn-info btn-xs" href="/usr/reply/modify?id=">수정</a>
        <a class="btn btn-error btn-xs"
          onclick="if( confirm('정말 삭제하시겠습니까?') == false) return false;"
          href="/usr/reply/doDelete?id=">삭제</a>
      </div>
    </tr>
  </table>
</div>

<%@ include file="../common/tail.jspf"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="게시물 상세페이지" />
<%@ include file="../common/head.jspf"%>

<input type="hidden" name="articleId" value="${param.id}" />
<script type="text/javascript" defer="defer">

	// 게시물 조회수 처리 함수
	let articleId = $("input[name='articleId']").val();
	articleId = parseInt(articleId);

	function ArticleDetail__increaseHitCount() { // 게시물 조회수 관련 함수
		const localStorageKey = "article__" + articleId + "__viewDone";

		if (localStorage.getItem(localStorageKey)) {
			return;
		}

		localStorage.setItem(localStorageKey, true);

		$.ajax({
			url : '/usr/article/increaseHitCount?id=' + articleId,
			success : function(data) {
				console.log("성공");
				console.log(data);
				$(".articleHit").html(data.data1);
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
			}
		})
	}
	ArticleDetail__increaseHitCount();
	
	// 댓글 작성하기 	
	let submitReplyDone = false;
	function checkReplyForm(form) {
		if (submitReplyDone) {
			alert("처리중입니다.");
			return;
		}

		let body = form.body.value.trim();

		if (body.length <= 2) {
			alert("댓글은 두글자 이상 입력이 가능합니다.");
			$("#replyBody").focus();
			return;
		}

		submitReplyDone = true;
		form.submit();
	}
</script>


<div class="flex justify-between mb-4 ">
  <a href="/usr/article/list?boardId=${article.boardId}">목록으로</a>

  <c:if test="${article.extra__actorCanEdit}">
    <div class="flex justify-end gap-2">
      <a href="/usr/article/modify?id=${article.id}"
        class="btn btn-info btn-sm">수정</a>
      <a href="/usr/article/doDelete?id=${article.id}"
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
      <td>
        <div class="articleHit">${article.hit}</div>
      </td>
    </tr>
    <tr>
      <td>추천</td>
      <td>
        <div class="flex gap-2 items-center">
          <div class="goodReactionPoint">${article.goodReactionPoint}</div>
          <c:if test="${actorCanMakeReactionPoint}">
            <a
              href="/usr/reactionPoint/doGoodReaction?relTypeCode=article&relId=${param.id}&replaceUri=${rq.encodedCurrentUri}"
              class="btn btn-xs btn-info btn-outline">좋아요👍</a>
            <a
              href="/usr/reactionPoint/doBadReaction?relTypeCode=article&relId=${param.id}&replaceUri=${rq.encodedCurrentUri}"
              class="btn btn-xs btn-outline btn-secondary">싫어요👎</a>
          </c:if>

          <c:if test="${actorCanMakeCancleGoodReactionPoint}">
            <a
              href="/usr/reactionPoint/doCancleReaction?relTypeCode=article&relId=${param.id}&replaceUri=${rq.encodedCurrentUri}&cancleReaction=good"
              class="btn btn-xs btn-info">좋아요👍</a>
            <a href="#" onclick="alert(this.title); return false;"
              title="좋아요를 취소해주세요"
              class="btn btn-xs btn-secondary btn-outline">싫어요👎</a>
          </c:if>

          <c:if test="${actorCanMakeCancleBadReactionPoint}">
            <a href="#" onclick="alert(this.title); return false;"
              title="싫어요를 취소해주세요"
              class="btn btn-xs btn-info btn-outline">좋아요👍</a>
            <a
              href="/usr/reactionPoint/doCancleReaction?relTypeCode=article&relId=${param.id}&replaceUri=${rq.encodedCurrentUri}&cancleReaction=bad"
              class="btn btn-xs btn-secondary">싫어요👎</a>
          </c:if>
        </div>
      </td>
    </tr>
    <tr>
      <td>카테고리</td>
      <td>${article.extra__boardName}</td>
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
        <div class="p-1 bg-gray-100" style="min-height: 120px">${article.body}</div>
      </td>
    </tr>
  </table>
</div>

<div class="py-8">
  <h4 class="py-2 border-b border-gray-400">💬 댓글 ${replyCount}개</h4>
  <table>
    <c:if test='${replyCount == 0}'>
      <div class="py-2">댓글이 없습니다.</div>
    </c:if>
    <c:forEach var="reply" items='${replies}'>
      <tr>
        <div
          class="flex gap-2 items-center py-2 border-b border-gray-200">
          <p>${reply.body}</p>
          <c:if test="${reply.extra__sumReactionPoint == 0}">
            <a href="" class="btn btn-xs btn-success btn-outline">0👍</a>
            <a href="" class="btn btn-xs btn-secondary btn-outline">0👎</a>
          </c:if>
          <span class="text-xs text-gray-500">${reply.extra__writerName}</span>
          <span class="text-xs text-gray-500">${reply.forPrintType1RegDate}</span>
          <c:if test="${reply.extra__actorCanEdit}">
            <a class="text-xs underline"
              href="/usr/reply/modify?id=${reply.id}">수정</a>
            <a class="text-xs underline"
              onclick="if( confirm('정말 삭제하시겠습니까?') == false) return false;"
              href="/usr/reply/doDelete?id=${reply.id}">삭제</a>
          </c:if>
        </div>
      </tr>
    </c:forEach>
  </table>

  <c:if test="${rq.isLogined()}">
    <form action="/usr/reply/doWrite?replaceUri=${rq.encodedCurrentUri}"
      method="post" class="mt-8"
      onsubmit="checkReplyForm(this); return false;">
      <input type="hidden" name="id" value="${article.id}" />
      <div class="flex items-end gap-2">
        <textarea id="replyBody" name="body" cols="30" rows="3"
          class="flex-grow"></textarea>
        <button type="submit" class="btn btn-sm btn-outline">입력</button>
      </div>
    </form>
  </c:if>
</div>
 
 
<%@ include file="../common/tail.jspf"%>

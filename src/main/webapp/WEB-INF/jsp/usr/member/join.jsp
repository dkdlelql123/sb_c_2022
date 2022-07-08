<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원가입" />
<%@ include file="../common/head.jspf"%>

<script type="text/javascript" defer="defer">
	function isNull(el) {
		let str = el.trim();
		if (str.length <= 0) {
			return false
		}
		return true;
	}

	let submitJoinFormDone = false;
	let validLoginId = "";

	function checkForm(form) {
		//alert(form.loginId.value.length);

		if (submitJoinFormDone) {
			alert("처리중입니다.");
			return;
		}

		if (!isNull(form.loginId.value)) {
			console.log("아이디(을)를 입력해주세요.");
			form.loginId.focus();
			return;
		}
		;

		if (!isNull(form.loginPw.value)) {
			console.log("비밀번호(을)를 입력해주세요.");
			form.loginPw.focus();
			return;
		}
		;

		if (!isNull(form.loginPw2.value)) {
			console.log("비밀번호(을)를 입력해주세요.");
			form.loginPw2.focus();
			return;
		}

		if (form.loginPw.value.trim() != form.loginPw2.value.trim()) {
			alert("비밀번호가 동일하지 않습니다. \n다시 확인해주세요.");
			form.loginPw.focus();
			return;
		}

		alert("성공");
		// submitJoinFormDone = true;
		// form.submit();
		return false;
	} 
	
	$(document).ready(function(){
		var timeout;
	    var delay = 500;   // 0.5 seconds

	    $('input#loginId').keyup(function() { 
			const loginId = $(this).val();			
	        if(timeout) {
	            clearTimeout(timeout);
	        }
	        timeout = setTimeout(function() {
	        	checkLoginIdDup(loginId);
	        }, delay);
	    });

	    function checkLoginIdDup(loginId){
			if(loginId.length <= 0){
				$('.loginId-message').html('<div class="loginId-message text-xs">* 중복체크 필수입니다.</div>');
			} else {
				$.ajax({
					url:'/usr/member/doCheckLoginId',
					type: "GET",
					data: { "loginId" : loginId },
					success: function(result){
						console.log(result)
						let resultCode = result.resultCode.substr(0,1);
						if(resultCode == 'S'){
							$('.loginId-message').html('<div class="loginId-message text-xs text-green-600">✔️ 사용가능한 아이디입니다</div>');					
						} else if(resultCode == 'F'){
							$('.loginId-message').html('<div class="loginId-message text-xs text-red-600">🚫 이미 사용중인 아이디입니다.</div>');
						} 
					}, error: function(error){
						console.log(error)
					}
				})		
			}
		}
	})
	 
</script>

<div class="table-box-type-1 m-auto w-full lg:w-1/2">
  <form onsubmit="checkForm(this); return false;">
    <table>
      <colgroup>
        <col width="200">
      </colgroup>
      <tr>
        <td>아이디</td>
        <td>
          <div class="flex items-center gap-1 mb-1">
            <input type="text" id="loginId"  name="loginId" class="input w-full" placeholder="아이디" value="user" autocomplete="off" />
          </div>
          <div class="text-xs loginId-message">* 중복체크 필수입니다.</div>
        </td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td>
          <input type="password" id="loginPw" name="loginPw" class="input w-full loginPw"  
            value="1234" />
      </tr>
      <tr>
        <td>비밀번호 재확인</td>
        <td>
          <input type="password" name="loginPw2" class="input w-full"
            value="1234" />
        </td>
      </tr>
      <tr>
        <td>이름</td>
        <td>
          <input type="text" name="name" class="input w-full" value="유저" />
        </td>
      </tr>
      <tr>
        <td>이메일</td>
        <td>
          <input type="text" name="email" class="input w-full"
            value="12@cc.com" />
        </td>
      </tr>
      <tr>
        <td>별명</td>
        <td>
          <input type="text" name="nickname" class="input w-full"
            value="별명" />
        </td>
      </tr>
      <tr>
        <td>전화번호</td>
        <td>
          <input type="text" name="phoneNumber" class="input w-full"
            value="01012341234" />
        </td>
      </tr>
    </table>
    <button type="submit"
      class="w-full btn btn-info mt-4 py-2 block text-center">회원가입</button>
  </form>
</div>

<%@ include file="../common/tail.jspf"%>

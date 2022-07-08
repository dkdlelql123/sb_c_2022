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

  function checkForm(form) { 
    if (submitJoinFormDone) {
      alert("처리중입니다.");
      return;
    }
    if (!isNull(form.loginPw.value)) {
      console.log("비밀번호(을)를 입력해주세요.");
      form.loginPw.focus();
      return;
    };
 
    submitJoinFormDone = true;
    form.submit();
  }  
</script>

<div class="table-box-type-1 m-auto w-full lg:w-1/2">
  <form onsubmit="checkForm(this); return false;" action="/usr/member/doModify"
    method="post">
    <table>
      <colgroup>
        <col width="200">
      </colgroup>
      <tr>
        <td>아이디</td>
        <td>
          <input type="text" id="loginId" value="${member.loginId}"
            name="loginId" class="input input-disabled w-full" required
            disabled /> 
        </td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td>
          <input type="password" name="loginPw" class="input w-full"
            placeholder="비밀번호" required />
      </tr>
      <tr>
        <td>이름</td>
        <td>
          <input type="text" value="${member.name}" name="name"
            class="input input-disabled w-full" placeholder="이름" required disabled/>
        </td>
      </tr>
      <tr>
        <td>이메일</td>
        <td>
          <input type="email" value="${member.email}" name="email"
            class="input w-full" placeholder="abc@abc.com" required />
        </td>
      </tr>
      <tr>
        <td>별명</td>
        <td>
          <input type="text" value="${member.nickname}" name="nickname"
            class="input w-full" placeholder="별명" required />
        </td>
      </tr>
      <tr>
        <td>전화번호</td>
        <td>
          <input type="text" value="${member.phoneNumber}"
            name="phoneNumber" class="input w-full" placeholder="전화번호"
            required />
        </td>
      </tr>
    </table>
    <button type="submit"
      class="w-full btn btn-info mt-4 py-2 block text-center">정보수정</button>
  </form>
</div>

<%@ include file="../common/tail.jspf"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageTitle" value="회원가입" />
<%@ include file="../common/head.jspf"%>

<div class="table-box-type-1 w-2/3 m-auto">
  <form action="">
    <table>
      <colgroup>
        <col width="200">
      </colgroup>
      <tr>
        <td>아이디</td>
        <td>
          <input type="text" name="loginPw" class="input" />
        </td>
      </tr>
      <tr>
        <td>비밀번호</td>
        <td>
          <input type="password" name="loginPw" class="input" />
        </td>
      </tr>
      <tr>
        <td>비밀번호 재확인</td>
        <td>
          <input type="password" name="loginPw2" class="input" />
        </td>
      </tr>
      <tr>
        <td>이름</td>
        <td>
          <input type="text" name="loginPw" class="input" />
        </td>
      </tr>
      <tr>
        <td>이메일</td>
        <td>
          <input type="text" name="loginPw" class="input" />
        </td>
      </tr> 
      <tr>
        <td>별명</td>
        <td>
          <input type="text" name="loginPw" class="input" />
        </td>
      </tr> 
      <tr>
        <td>이메일</td>
        <td>
          <input type="text" name="loginPw" class="input" />
        </td>
      </tr>
    </table>
    <button class="w-full btn btn-type-1 mt-4 py-2 block text-center text-base">회원가입</button>
  </form>
</div>

<%@ include file="../common/tail.jspf"%>

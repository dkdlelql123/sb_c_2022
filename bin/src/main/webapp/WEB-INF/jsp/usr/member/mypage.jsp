<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.nyj.exam.demo.util.Ut" %>

<c:set var="pageTitle" value="마이페이지" />
<%@ include file="../common/head.jspf"%>

<div class="table-box-type-1 m-auto w-full lg:w-1/2">
  <div class="messege mb-4 text-red-500 text-center bg-red-100 rounded"></div> 
    <table>
      <colgroup>
        <col width="200">
      </colgroup>
      <tr>
        <td>아이디</td>
        <td>
         ${member.loginId}
        </td>
      </tr>  
      <tr>
        <td>이름</td>
        <td>
          ${member.name}
        </td>
      </tr>
      <tr>
        <td>이메일</td>
        <td>
          ${member.email}
        </td>
      </tr>
      <tr>
        <td>별명</td>
        <td>
          ${member.nickname}
        </td>
      </tr>
      <tr>
        <td>전화번호</td>
        <td>
          ${member.phoneNumber}
        </td>
      </tr>
    </table> 
    <a href="/usr/member/checkPassword?replaceUri=${Ut.getUriEncoded('../member/modify')}" 
    class="w-full btn btn-success mt-4 py-2 block text-center">정보수정하기</a>
</div>

<%@ include file="../common/tail.jspf"%>

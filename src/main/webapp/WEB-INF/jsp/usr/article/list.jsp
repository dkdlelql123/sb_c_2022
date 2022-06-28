<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf" %>

<ul>
  <c:forEach var="article" items="${articles}">
    <li>
      <a href="#">${article.title}</a>
      <span>${article.regDate}</span>
    </li>
  </c:forEach>
</ul>

<%@ include file="../common/tail.jspf" %>

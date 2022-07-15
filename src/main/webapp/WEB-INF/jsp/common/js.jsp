<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script>
	let msg = '${msg}'.trim();
	let historyBack = '${historyBack}' == 'true' ;
	
	console.log(msg);
	console.log(historyBack);
	
	if(msg.length > 0){
		alert(msg);
	}
	
	if(historyBack){
		history.back();
	}
</script>
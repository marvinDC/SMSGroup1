<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/prototype.js"></script>
<script>
	var contextPath = '${pageContext.request.contextPath}';
</script>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="js/IssueSupplies.js"></script>
</head>
<body>
	<input type="button" value="Supply Issuance" id="initBtn" onclick="supplyIssuance()">
	<div id="mainContents">
	</div>
</body>

</html>
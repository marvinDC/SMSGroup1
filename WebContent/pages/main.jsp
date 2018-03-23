<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="navigationBar.jsp"></jsp:include>
<div id="mainContents">
	<c:choose>
		<c:when test="${currentUser != null}">
			<jsp:include page="home.jsp"></jsp:include>
		</c:when>
		<c:otherwise>
			<jsp:include page="login.jsp"></jsp:include>
		</c:otherwise>
	</c:choose>
</div>
<jsp:include page="footer.jsp"></jsp:include>
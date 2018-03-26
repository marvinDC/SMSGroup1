<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <div class="col-md-8">
 	<br><br>
 	<img style="width: 100%; height: 400px;" src="https://www.brookdalecc.edu/images/college-store/school-supplies.jpg" />
 </div>
 <div class="container col-md-4" style="padding-left: 50px; padding-right: 50px; margin-top: 150px;">
 	<c:if test="${loginError != null}">
		<div class="alert alert-danger">${loginError}</div>
 	</c:if>
 	<div id="requiredAlert" class="alert alert-danger hidden">Input required fields.</div>
	<input id="userId" type="text" class="form-control" placeholder="Username" required autofocus><br>
	<input id="password" type="password" class="form-control" placeholder="Password" required><br>
	<button class="btn btn-lg btn-primary btn-block" id="btnLogin" onClick="login()">
	     LOGIN TO YOUR ACCOUNT</button>
	<a href="#" class="pull-right need-help">forgot password</a><span class="clearfix"></span>
</div>
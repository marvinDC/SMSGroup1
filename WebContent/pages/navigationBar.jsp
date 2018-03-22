<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<nav class="navbar navbar-default" style="background: #e5f4f9;">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">SMS</a>
    </div>
    <c:if test="${currentUser != null}">
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li><a href="#"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a></li>
	        <c:if test="${currentUser.accessLevel == 'A'}">
	        <li><a href="#"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Maintenance</a></li>
	        </c:if>
	        <li><a href="#"><span class="glyphicon glyphicon-inbox" aria-hidden="true"></span> Issue Supplies</a></li>
	        <li><a href="#"><span class="glyphicon glyphicon-th-large" aria-hidden="true"></span> Add Stocks</a></li>
	        <c:if test="${currentUser.accessLevel == 'A'}">
	        	<li><a href="#"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Reports</a></li>
	        </c:if>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> ${currentUser.userId}</a></li>
	        <li><a href="#" id="btnLogout" onclick="logout()"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Logout</a></li>
	      </ul>
	    </div>
    </c:if>
  </div>
</nav>
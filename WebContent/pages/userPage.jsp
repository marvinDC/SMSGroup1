<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
	<script type="text/javascript" src="../js/prototype.js"></script>
	<script>
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</head>
<body>
<center>
<div id="mainDiv">	
		<h3>User Maintenance</h3>
	<c:if test="${Error != null}">
		<div id="errorPopup">${Error}</div>
 		</c:if>
 		<div align="right" style="font-family: courier; font-size: 14pt; position: absolute; top: 16%; left: 20%;">
 	<a href="#" onclick="toUserPage()">User</a><br>
 	<a href="#" onclick="">Supply Types</a><br>
 	<a href="#" onclick="suppliesMaintenance()">Supplies</a><br>
 	</div>
<table>
	<tr><td>User ID </td><td><input type="text" id="userId" class="formInput form-control" name="UserId" value="${currentUser.userId}" disabled></td><td></td></tr>
	<tr><td>Password </td><td><input type="password" id="pWord" class="formInput form-control" name="password" value="${currentUser.password}" disabled></td>
		<td></td><td><input type="button" id="CPBtn" class="formBtn btn btn-primary" value="Change Password"></td>
		<td><input type="button" id="saveUserChanges" class="formBtn btn btn-primary" value="Save" style="width: 100px;"></td></tr>
	<tr><td>First Name</td><td><input type="text" id="userFName" class="formInput form-control" name="firstName"></td>
		<td></td><td style="width: 200px;"></td> 
		<td><input type="button" id="cancel" class="formBtn btn btn-primary" value="Cancel" style="width: 100px;"></td></tr>
	<tr><td>Last Name </td><td><input type="text" id="userLName" class="formInput form-control" name="lastName"></td></tr>
	<tr><td>Middle Initial</td><td> <input type="text" id="userMInitial" class="formInput form-control" name="midInitial"></td></tr>
	<tr><td>Email Address</td><td><input type="text" id="userEmail" class="formInput form-control" name="emailAdd"></td></tr>
</table>
</div>
</center>
</body>
<script>

	$("CPBtn").observe("click", function(){
		new Ajax.Request(contextPath + "/maintenance", {
			method: "GET",
			parameters: {
				action: "changepass"
			},
			onComplete: function(response){
				$("mainDiv").update(response.responseText);
			}
		});
	})
	
	$("saveUserChanges").observe("click", function(){
		new Ajax.Request(contextPath + "/maintenance", {
			method: "GET",
			parameters: {
				userId: $F("userId"),
				firstnameUser: $F("userFName"),
				lastnameUser:	$F("userLName"),
				midinitialUser: $F("userMInitial"),
				emailUser: $F("userEmail"),
				action: "saveUserChanges"
			},
			onComplete: function(response){
				$("mainDiv").update(response.responseText);
			}
		});
	})
	
	$("cancel").observe("click", function(){
		new Ajax.Request(contextPath + "/maintenance", {
			method: "GET",
			parameters: {
				action: "cancel"
			},
			onComplete: function(response){
				$("mainDiv").update(response.responseText);
			}
		});
	})
</script>
</html>
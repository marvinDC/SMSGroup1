<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
	<link rel="stylesheet" type="text/css" href="../css/mycss.css">
	<script type="text/javascript" src="../js/prototype.js"></script>
	<script>
		var contextPath = '${pageContext.request.contextPath}';
	</script>
</head>
<body>
<div id="mainDiv">
<center>
	<h3>CHANGE PASSWORD</h3>
	<c:if test="${Error != null}">
		<div id="errorPopup">${Error}</div>
 	</c:if>
	<table>
		<tr align="left"><td>Current Password</td><td><input type="password" id="cPassword" class="formInput form-control" name="currentPassword"></td></tr>
		<tr><td>New Password</td><td><input type="password" id="nPassword" class="formInput form-control" name="newPassword"></td>
		<td style="width: 100px;"></td>
		<td><input type="button" id="savePW" class="formBtn btn btn-primary" value="Save" style="width: 100px;"></tr>
		<tr><td>Retype Password</td><td><input type="password" id="rPassword" class="formInput form-control" name="retypePassword"></td>
		<td></td><td><input type="button" id="cancel" class="formBtn btn btn-primary" value="Cancel" style="width: 100px;"></td></tr>
	</table>
</center>
</div>

	<script>

	$("savePW").observe("click", function(){
		new Ajax.Request(contextPath + "/maintenance", {
			method: "GET",
			parameters: {
				currPassword: $F("cPassword"),
				newPassword: $F("nPassword"),
				retypePassword: $F("rPassword"),
				action: "savePW"
			},
			onComplete: function(response){
				$("mainDiv").update(response.responseText);
			}
		});
		//validation here//
		
		
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
</body>
</html>
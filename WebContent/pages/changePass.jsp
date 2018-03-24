<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<body>
<div id="mainDiv">
<center>
	<h3>CHANGE PASSWORD</h3>
	<table>
		<tr><td>Current Password</td><td><input type="password" id="cPassword" name="currentPassword"></td></tr>
		<tr><td>New Password</td><td><input type="password" id="nPassword" name="newPassword"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="button" id="savePW" value="Save"></tr>
		<tr><td>Retype Password</td><td><input type="password" id="rPassword" name="retypePassword"></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="button" id="cancel" value="Cancel"></td></tr>
	</table>
</center>
</div>
	<script>
	alert()
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
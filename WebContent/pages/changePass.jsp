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
<div style="margin-left: 10px;">You are Here || Maintenance >>
		Users >> Change Password</div>
<div class="content">
<center>
	<h3>CHANGE PASSWORD</h3>
	<c:if test="${Error != null}">
		<div class="alertDiv alert alert-danger" style="width: 50%">${Error}</div>
 	</c:if>
 	<div class="maintenanceLinks"
				style="width: 100px; height: 300px; position: absolute; top: 16%; left: 5%;">
				<table style="color: black;">
					<tr>
						<td><a style="color: black;" href="#" onclick="maintenance()">Users</a></td>
					</tr>
					<tr>
						<td><a style="color: black;" href="#" onclick="">Supply
								Types</a></td>
					</tr>
					<tr>
						<td><a style="color: black;" href="#"
							onclick="suppliesMaintenance()">Supplies</a></td>
					</tr>
				</table>
			</div>
	<table>
		<tr><td class="fieldLabel">Current Password</td><td><input type="password" id="cPassword" class="formInput form-control" name="currentPassword"></td></tr>
		<tr><td class="fieldLabel">New Password</td><td><input type="password" id="nPassword" class="formInput form-control" name="newPassword"></td>
		<td style="width: 100px;"></td>
		<td><input type="button" id="savePW" class="formBtn btn btn-primary" value="Save" style="width: 100px;"></tr>
		<tr><td class="fieldLabel">Retype Password</td><td><input type="password" id="rPassword" class="formInput form-control" name="retypePassword"></td>
		<td></td><td><input type="button" id="cancel" class="formBtn btn btn-primary" value="Cancel" style="width: 100px;"></td></tr>
	</table>
</center>
</div>
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
		/* new Ajax.Request(contextPath + "/maintenance", {
			method: "GET",
			parameters: {
				action: "cancel"
			},
			onComplete: function(response){
				$("mainDiv").update(response.responseText);
			}
		}); */
		
		location.reload();
	})
	</script>
</body>
</html>
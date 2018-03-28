<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New</title>
<!-- <link rel="stylesheet" type="text/css" href="css/mycss.css">
<script type="text/javascript" src="js/prototype.js"></script>
<script>
	var contextPath = '${pageContext.request.contextPath}';
</script> -->
</head>
<body>
<div id="mainDiv">
<center>
	<h3>User Maintenance</h3>
	<c:if test="${Error != null}">
		<div class="alertDiv alert alert-danger">${Error}</div>
 	</c:if>
 	<div align="right" style="font-family: courier; font-size: 14pt; position: absolute; top: 16%; left: 5%;">
 	<a href="#" onclick="toUserPage()">User</a><br>
 	<a href="#" onclick="">Supply Types</a><br>
 	<a href="#" onclick="suppliesMaintenance()">Supplies</a><br>
 	</div>
<table>
	<tr><td class="fieldLabel">User ID </td><td><input type="text" id="userId" class="formInput form-control" name="UserId"></tr>
	<tr><td class="fieldLabel">Password </td><td><input type="password" id="pWord" class="formInput form-control" name="password"></td>
		<td style="width: 150px;"></td><td><input type="button" id="saveAdded" class="formBtn btn btn-primary" value="Save" style="width: 100px;"></td></tr>
	<tr><td class="fieldLabel">First Name</td><td><input type="text" id="fName" class="formInput form-control" name="firstName"></td>
		<td></td><td><input type="button" id="cancel" class="formBtn btn btn-primary" value="Cancel" style="width: 100px;"></td></tr>
	<tr><td class="fieldLabel">Last Name </td><td><input type="text" id="lName" class="formInput form-control" name="lastName"></td></tr>
	<tr><td class="fieldLabel">Middle Initial</td><td> <input type="text" id="mInitial" class="formInput form-control" name="midInitial" ></td></tr>
	<tr><td class="fieldLabel">Email Address</td><td><input type="text" id="email" class="formInput form-control" name="emailAdd" ></td></tr>
	<tr><td class="fieldLabel">Active Tag 	</td><td><input type="radio" id="yag" name="ID" value="Y">Yes<input type="radio" id="nag" name="ID" value="N">No</td></tr>
	<tr><td class="fieldLabel">Access Level</td>
		<td><select id="accessLevel" class="formInput form-control">
		<option value=""></option>        
		<option value="A">Admin</option>
		<option value="U">User</option>
	</select></td></tr>
</table>
</center>
</div>
</body>
	<script>

$("saveAdded").observe("click", function(){
	new Ajax.Request(contextPath + "/maintenance", {
		method: "GET",
		parameters: {
			userid: $F("userId"),
			password: $F("pWord"),
			firstname: $F("fName"),
			lastname:	$F("lName"),
			midinitial: $F("mInitial"),
			email: $F("email"),
			acttag: $("yag").checked == true ? $("yag").value : $("nag").value,
			acclevel: $F("accessLevel"),
			action: "saveAdded"
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
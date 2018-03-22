<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listing Page</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<script type="text/javascript" src="prototype/prototype.js"></script>
<script>
	var contextPath = '${pageContext.request.contextPath}';
</script>
</head>
<body>
<center>	
<div id="mainDiv">	
	<h3>User Maintenance</h3>
<table>
	<tr><td>User ID </td><td><input type="text" id="userId" name="UserId"></td><td></td>
		<td><input type="button" id="addNewBtn" value="Add New"></td></tr>
	<tr><td>Password </td><td><input type="password" id="pWord" name="password"></td>
		<td><input type="button" id="CPBtn" value="Change Password"></td>
		<td><input type="button" id="save" value="Save"></td></tr>
	<tr><td>First Name</td><td><input type="text" id="fName" name="firstName"></td><td></td> 
		<td><input type="button" id="cancel" value="Cancel"></td></tr>
	<tr><td>Last Name </td><td><input type="text" id="lName" name="lastName"></td></tr>
	<tr><td>Middle Initial</td><td> <input type="text" id="mInitial" name="midInitial" ></td></tr>
	<tr><td>Email Address</td><td><input type="text" id="email" name="emailAdd" ></td></tr>
	<tr><td>Active Tag 	</td><td><input type="radio" name="tag" value="Y">Yes<input type="radio" name="tag" value="N">No</td></tr>
	<tr><td>Access Level</td>
		<td><select id="accessLevel">
		<option value=""></option>        
		<option value="A">Admin</option>
		<option value="U">User</option>
	</select></td></tr>
	<tr><td>Search</td><td><input type="text" id="search" name="Search"></td></tr>
</table>
<table id="listTable" class="ListTable">
	<tr><th>User ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>M.I.</th>
		<th>Email</th>
		<th>Active Tag</th>
		<th>Access Level</th>
		<th>Entry Date</th>
		<th>Last Login</th>
		<th>Last Update By</th>
		<th>Last Update</th>
	</tr>
	<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
	<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
</table>
</div>
</center>
</body>

<script>
$('addNewBtn').observe("click", function(){
	new Ajax.Request(contextPath + "/adding", {
		method: "GET",
		parameters: {
			action: "adding"
		},
		onComplete: function(response){
			$("mainDiv").update(response.responseText);
		}
	});
	
})

$('CPBtn').observe("click", function(){
	new Ajax.Request(contextPath + "/adding", {
		method: "GET",
		parameters: {
			action: "changepass"
		},
		onComplete: function(response){
			$("mainDiv").update(response.responseText);
		}
	});
	
})

</script>
</html>

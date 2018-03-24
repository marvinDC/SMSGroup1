<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listing Page</title>
<link rel="stylesheet" type="text/css" href="css/mycss.css">
<script type="text/javascript" src="js/prototype.js"></script>
<script>
	var contextPath = '${pageContext.request.contextPath}';
</script>
</head>
<body>
<center>	
<div id="mainDiv">	
	<h3>User Maintenance</h3>
<table>
	<tr><td>User ID </td><td><input type="text" id="userId" name="UserId" disabled></td><td></td>
		<td><input type="button" id="addNewBtn" value="Add New"></td></tr>
	<tr><td>Password </td><td><input type="password" id="pWord" name="password" disabled></td>
		<td><input type="button" id="CPBtn" value="Change Password"></td>
		<td><input type="button" id="save1" value="Save"></td></tr>
	<tr><td>First Name</td><td><input type="text" id="fName" name="firstName"></td><td></td> 
		<td><input type="button" id="cancel" value="Cancel"></td></tr>
	<tr><td>Last Name </td><td><input type="text" id="lName" name="lastName"></td></tr>
	<tr><td>Middle Initial</td><td> <input type="text" id="mInitial" name="midInitial" ></td></tr>
	<tr><td>Email Address</td><td><input type="text" id="email" name="emailAdd" ></td></tr>
	<tr><td>Active Tag 	</td><td><input type="radio" id="ytag" name="Tag" value="Y">Yes
								 <input type="radio" id="ntag" name="Tag" value="N">No</td></tr>
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
	
	<c:forEach var="user" items="${queryList}">
			<tr id="listTableRow">
				<td><c:out value="${user.userId}"/></td>
				<td style="display: none;"><c:out value="${user.passWord}"/></td>
				<td><c:out value="${user.firstName}"/></td>
				<td><c:out value="${user.lastName}"/></td>
				<td><c:out value="${user.midInitial}"/></td>
				<td><c:out value="${user.email}"/></td>
				<td><c:out value="${user.activeTag}"/></td>
				<td><c:out value="${user.accessLevel}"/></td>
				<td><c:out value="${user.entryDate}"/></td>
				<td><c:out value="${user.lastLogin}"/></td>
				<td><c:out value="${user.lastUser}"/></td>
			</tr>
		</c:forEach> 
	<c:forEach var="search" items="${querySearch}">
			<tr id="listTableRow">
				<td><c:out value="${search.userId}"/></td>
				<td style="display: none;"><c:out value="${user.passWord}"/></td>
				<td><c:out value="${search.firstName}"/></td>
				<td><c:out value="${search.lastName}"/></td>
				<td><c:out value="${search.midInitial}"/></td>
				<td><c:out value="${search.email}"/></td>
				<td><c:out value="${search.activeTag}"/></td>
				<td><c:out value="${search.accessLevel}"/></td>
				<td><c:out value="${search.entryDate}"/></td>
				<td><c:out value="${search.lastLogin}"/></td>
				<td><c:out value="${search.lastUser}"/></td>
			</tr>
		</c:forEach> 

</table>
</div>
</center>
</body>

<script>








/////////////////////////////////////////////////////////////////////////////

$("search").observe("keypress", function(e){
	var key = e.keyCode;
	if(key == 13){
	alert("Enter");
		new Ajax.Request(contextPath + "/maintenance", {
			method: "GET",
			parameters: {
				searchKeyWord: $F("search"),
				action: "search"
				
			},
			onComplete: function(response){
				$("mainDiv").update(response.responseText);
			}
		});
	}
})

$("save1").observe("click", function(){
	new Ajax.Request(contextPath + "/maintenance", {
		method: "GET",
		parameters: {
			userid: $F("userId"),
			firstnameUpd: $F("fName"),
			lastnameUpd:	$F("lName"),
			midinitialUpd: $F("mInitial"),
			emailUpd: $F("email"),
			acttagUpd: $("ytag").checked == true ? $("ytag").value : $("ntag").value,
			acclevelUpd: $F("accessLevel"),
			action: "save1"
		},
		onComplete: function(response){
			$("mainDiv").update(response.responseText);
		}
	});
	
})
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
$('addNewBtn').observe("click", function(){
	new Ajax.Request(contextPath + "/maintenance", {
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
	new Ajax.Request(contextPath + "/maintenance", {
		method: "GET",
		parameters: {
			currentPass: $F("pWord"),
			action: "changepass"
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

/////////////////////////////////////////////////////////////
var table = $("listTable");	
	for (var i = 1; i < table.rows.length; i++) {
		table.rows[i].onclick= function(){

			$("userId").value =	this.cells[0].innerHTML;
			$("pWord").value = 	this.cells[1].innerHTML;
			$("fName").value =	this.cells[2].innerHTML;
			
			$("lName").value =	this.cells[3].innerHTML;
			$("mInitial").value =	this.cells[4].innerHTML;
			$("email").value =	this.cells[5].innerHTML;	
			
			var activeTag = this.cells[6].innerHTML;
			if (activeTag == "N"){
				$("ntag").setAttribute("checked", true);
			} else {
				$("ytag").setAttribute("checked", true);
			}
			
			$("accessLevel").selectedIndex = this.cells[7].innerHTML == "A" ? 1 : 2; 	
			
		 }
	}
		
</script>
</html>

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
<script type="text/javascript" src="js/maintenance.js"></script>
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
 	<div align="right" style="font-family: courier;  position: absolute; top: 15%; left: 20%;">
 	<a href="#" onclick="toUserPage()">User</a><br>
 	<a href="#" onclick="toUserPage()">Supply Types</a><br>
 	<a href="#" onclick="toUserPage()">Supplies</a><br>
 	</div>
 	
<table>
	<tr><td>User ID</td><td><input type="text" id="userId" class="formInput form-control" name="UserId" disabled></td>
		<td style="width: 150px;"></td>
		<td><input type="button" id="addNewBtn" class="formBtn btn btn-primary" value="Add New" style="width: 100px;"></td></tr>
	<tr><td>Password </td><td><input type="password" id="pWord" class="formInput form-control" name="password" disabled></td>
		<td></td>
		<td><input type="button" id="saveUpdate" class="formBtn btn btn-primary" value="Save" style="width: 100px;"></td></tr>
	<tr><td>First Name</td><td><input type="text" id="fName" class="formInput form-control" name="firstName"></td>
		<td></td> 
		<td><input type="button" id="cancel" class="formBtn btn btn-primary" value="Cancel" style="width: 100px;"></td></tr>
	<tr><td>Last Name </td><td><input type="text" id="lName" class="formInput form-control" name="lastName"></td></tr>
	<tr><td>Middle Initial</td><td> <input type="text" id="mInitial" class="formInput form-control" name="midInitial" ></td></tr>
	<tr><td>Email Address</td><td><input type="text" id="email" class="formInput form-control" name="emailAdd" ></td></tr>
	<tr><td>Active Tag 	</td><td><input type="radio" id="ytag" name="Tag" value="Y">Yes
								 <input type="radio" id="ntag" name="Tag" value="N">No</td></tr>
	<tr><td>Access Level</td>
		<td><select id="accessLevel" class="formInput form-control">
		<option value=""></option>        
		<option value="A">Admin</option>
		<option value="U">User</option>
	</select></td></tr>
	<tr><td>Search</td><td><input type="text" id="search" class="formInput form-control" name="Search"></td></tr>
</table>
<table id="listTable" class="ListTable" border="1">
	<tr class="tableHeader"><th>User ID</th>
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
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.entryDate}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.lastLogin}"/></td>
				<td><c:out value="${user.lastUser}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.lastUpdate}"/></td>
				
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
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${search.entryDate}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${search.lastLogin}"/></td>
				<td><c:out value="${search.lastUser}"/></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.lastUpdate}"/></td>
			</tr>
		</c:forEach> 

</table>
</div>

</center>
</body>

<script>

$("search").observe("keypress", function(e){
	var key = e.keyCode;
	if(key == 13){
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

$("saveUpdate").observe("click", function(){
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
			action: "saveUpdate"
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

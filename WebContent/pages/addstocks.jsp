<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%--        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="Prototype/prototype.js"></script>

</head>
<body>

	<center>
<h3>Stocks</h3>


	<table>
		<tr>
			<td align="right"><label><b>Item Name: </b></label></td>
			<td><input type="text" id="txtItemName"></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		
		</tr>

		<tr>
			<td align="right"><label><b>Quantity: </b></label></td>
			<td><input type="text" id="txtQuantity"></td>
			<td></td>
			<td><input type="button" id="btnSave" value="&nbsp;&nbsp;&nbsp;&nbsp;Save&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"></td>
		</tr>
		
		<tr>
			<td align="right"><label><b>Reference No: </b></label></td>
			<td><input type="text" id="txtRefNo"></td>
			<td></td>
			<td><input type="button" id="btnCancel" value="&nbsp;&nbsp;&nbsp;Cancel&nbsp;&nbsp;&nbsp;&nbsp;"></td>
		</tr>
		
		<tr>
			<td align="right"><label><b>Date Added: </b></label></td>
			<td><input type="text" id="txtDateAdded"></td>
		</tr>
		
		<tr>
			<td align="right"><label><b>Purchase Added: </b></label></td>
			<td><input type="text" id="txtPurchaseAdded"></td>
		</tr>
		
	<tr>
	<td> &nbsp;&nbsp;&nbsp;</td>
	</tr>
	
	<tr>
	<td><label><b>Search </b></label> </td> 
	<td><input type="text" id="txtSearch"> </td>
	<br>
	</tr>
	</table>
	<br>
	
		<div id="mainContents">
		</div>
	
	</center>
	
	</body>
	</html>
	
	
	<script>
	$("btnSave").observe("click", function() {
		addStock();
	})
	
 		function addStock() {
		alert($F("txtItemName"));
		new Ajax.Request("${pageContext.request.contextPath}" + "/addstock", {
			method : "GET",
			parameters : {
				itemname : $("txtItemName").value,
				quantity : $F("txtQuantity"),
				refno : $F("txtRefNo"),
				
				actionSave : "save"
			},
			onComplete : function(response) {
				alert("success");
			//	$("mainContents").update(response.responseText);
			}
		});
	

	
	} 
	
	
	
	
	</script>
	
	
	
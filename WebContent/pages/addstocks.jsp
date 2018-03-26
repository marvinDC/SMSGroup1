<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<script src="js/prototype.js"></script>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<center>

<h3>Stocks</h3>

<div id = "mainContents">
	<table>
		<tr>
			<td align="right"><label><b>Item Name: </b></label></td>
			<td><select id="selItem" name="supplies"  style="width: 200px" class="formInput form-control">
			<c:forEach var="itemss" items="${item1}">
			<option value="${itemss.supplyId}">
			<c:out value="${itemss.itemName}"></c:out></option>
			</c:forEach>
			</select>
			</td>
			<td  style="width: 200px"></td>
		
		</tr>

		<tr>
			<td align="right"><label><b>Quantity: </b></label></td>
			<td><input type="text" id="txtQuantity" style="width: 200px" class="formInput form-control" ></td>
			<td></td>
			<td><input type="button" id="btnSave" value="Save" style="width: 100px" class="formBtn btn btn-primary"></td>
		</tr>
		
		<tr>
			<td align="right"><label><b>Reference No: </b></label></td>
			<td><input type="text" id="txtRefNo" style="width: 200px" class="formInput form-control"></td>
			<td></td>
			<td><input type="button" id="btnCancel" value="Cancel" style="width: 100px" class="formBtn btn btn-primary"></td>
		</tr>
		
		<tr>
			<td align="right"><label><b>Date Added: </b></label></td>
			<td><input type="text" id="txtDateAdded" style="width: 200px" class="formInput form-control"></td>
		</tr>
		
		<tr>
			<td align="right"><label><b>Purchase Added: </b></label></td>
			<td><input type="text" id="txtPurchaseAdded" style="width: 200px" class="formInput form-control"></td>
		</tr>
		

	</table>
	<br>
	<br>
	<br>
	<br>
		</div> 
	

	</center>
	</body>
	</html>
	
	
	<script>
	
	$("btnSave").observe("click", function() {
		addStock();
	})
	
 		function addStock() {
		new Ajax.Request("${pageContext.request.contextPath}" + "/suppliesstocks", {
			method : "GET",
			parameters : {
				itemname : $F("selItem"),
				quantity : $F("txtQuantity"),
				refno : $F("txtRefNo"),
				dateadded: $F("txtDateAdded"),
				datepurchase: $F("txtPurchaseAdded"),
				actionSave : "save"
			},
			onComplete : function(response) {
				alert("success");
				$("mainContents").update(response.responseText);
			}
		});
	}
	
	$("btnCancel").observe("click", function(){
		new Ajax.Request("${pageContext.request.contextPath}" + "/suppliesstocks", {
			method: "get",
			parameters: {
				actionBack : "backToStock"
			},
			onComplete: function(response){
				$("mainContents").update(response.responseText);
			}
		})
	});
	
	
	
	
	</script>
	
	
	
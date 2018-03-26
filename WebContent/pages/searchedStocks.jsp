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
<style>
tr:hover {background-color:#f5f5f5;}
</style>
</head>
<body>
<center>


	
	<table id="stockTable" border="1">
	<tr>
		<th>Stock ID</th>
		<th>Item Name</th>
		<th>Qty</th>
		<th>Reference No</th>
		<th>Date Added</th>
		<th>Purchase Date</th>
		<th>Last Updated by</th>
		<th>Last Update</th>
	</tr>	
	
	<c:forEach var="stocks1" items="${SearchedstockList}">
	<tr>
	<td><c:out value="${stocks1.stockId}"></c:out></td>
	<td><c:out value="${stocks1.itemName}"></c:out></td>
	<td><c:out value="${stocks1.quantity}"></c:out></td>
	<td><c:out value="${stocks1.refNo}"></c:out></td>
	<td><c:out value="${stocks1.dateAdded}"></c:out></td>
	<td><c:out value="${stocks1.purchaseDate}"></c:out></td>
	<td><c:out value="${stocks1.lastUser}"></c:out></td>
	<td><c:out value="${stocks1.lastUpdate}"></c:out></td>
	<tr>
	</c:forEach>
	
	
	
	</table>
	
	
	
		


<script>
 	var table = $('stockTable');
	
	for (var i = 1; i < table.rows.length; i++) 
	{
		table.rows[i].onclick = function()
		{
			$("selItem").value = this.cells[1].innerHTML;
			$("txtQuantity").value = this.cells[2].innerHTML;
			$("txtRefNo").value = this.cells[3].innerHTML;
			$("txtDateAdded").value = this.cells[4].innerHTML;
			$("txtPurchaseAdded").value = this.cells[5].innerHTML;
			$("txtStockId").value = this.cells[0].innerHTML;
		};
	} 
</script>
	</center>
	</body>
</html>
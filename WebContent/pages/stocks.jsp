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
#listTableRow:hover {background-color: powderblue;}
</style>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div style="margin-left: 10px;">You are Here || Stocks</div>
<center><div class="content" style="margin-top:20px">
<h3>Stocks</h3>
	
	<c:if test="${message != null}">
	<div class="alertDiv alert alert-danger">${message}</div>
	</c:if>
			
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
			<td style="width: 200px"></td>
			<td><input type="button" id="btnAddStocks" value="Add Stocks" style="width: 100px" class="formBtn btn btn-primary"></td>
		</tr>

		<tr>
			<td align="right"><label><b>Quantity: </b></label></td>
			<td><input type="text" id="txtQuantity" style="width: 200px" class="formInput form-control"></td>
			<td></td>
			<td><input type="button" id="btnSave" style="width: 100px" value="Save" class="formBtn btn btn-primary"></td>
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
		
		<tr>
		<td><input type="hidden" id="txtStockId" style="width: 200px"></td>
		</tr>
		
		<tr>
		<td align="right"><label><b>Search:</b></label> </td> 
		<td><input type="text" id="txtSearch" style="width: 200px" class="formInput form-control"><br></td>
		<br>
		</tr>
	</table>
	
	

		
	<br>
	
	<div id="stock">
	<table id="stockTable" border="1">
	<tr>
		<th>Stock ID</th>
		<td style="display:none;">Supply ID</td>
		<th>Item Name</th>
		<th>Qty</th>
		<th>Reference No</th>
		<th>Date Added</th>
		<th>Purchase Date</th>
		<th>Last Updated by</th>
		<th>Last Update</th>
	</tr>	
	
	<c:forEach var="stocks" items="${stockList}">
	<tr id=listTableRow>
	<td><c:out value="${stocks.stockId}"></c:out></td>
	<td style="display:none;"><c:out value="${stocks.supplyId}"></c:out></td>
	<td><c:out value="${stocks.itemName}"></c:out></td>
	<td><c:out value="${stocks.quantity}"></c:out></td>
	<td><c:out value="${stocks.refNo}"></c:out></td>
	<td><c:out value="${stocks.dateAdded}"></c:out></td>
	<td><c:out value="${stocks.purchaseDate}"></c:out></td>
	<td><c:out value="${stocks.lastUser}"></c:out></td>
	<td><c:out value="${stocks.lastUpdate}"></c:out></td>
	</tr>
	</c:forEach>
	
	
	
	</table>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	
	
</div>
</center>		
</body>


	
	<script>
	
	$("txtSearch").observe("blur", function() {
		search();
	})
	
 		function search() {
		new Ajax.Request("${pageContext.request.contextPath}" + "/suppliesstocks", {
			method : "GET",
			parameters : {
				search : $F("txtSearch"),
				actionSearch : "search"
			},
			onComplete : function(response) {
				$("stock").update(response.responseText);
			}
		});
	}
	
	
	
	
 	var table = $('stockTable');
	
	for (var i = 1; i < table.rows.length; i++) 
	{
		table.rows[i].onclick = function()
		{
			$("selItem").value = this.cells[1].innerHTML;
			$("txtQuantity").value = this.cells[3].innerHTML;
			$("txtRefNo").value = this.cells[4].innerHTML;
			$("txtDateAdded").value = this.cells[5].innerHTML;
			$("txtPurchaseAdded").value = this.cells[6].innerHTML;
			$("txtStockId").value = this.cells[0].innerHTML;
		};
	} 

	
	
	$("btnAddStocks").observe("click", function(){
		new Ajax.Request("${pageContext.request.contextPath}" + "/suppliesstocks", {
			method: "get",
			parameters: {
				actionAdd : "goToAdd"
			},
			onComplete: function(response){
				$("mainContents").update(response.responseText);
			}
		})
	});
	
	
	$("btnSave").observe("click", function(){
		new Ajax.Request("${pageContext.request.contextPath}" + "/suppliesstocks", {
			method: "get",
			parameters: {
				stockid : $F("txtStockId"),
				itemname : $F("selItem"),
				quantity : $F("txtQuantity"),
				refno : $F("txtRefNo"),
				dateadded : $F("txtDateAdded"),
				purchaseadded : $F("txtPurchaseAdded"),
				actionUpdate : "update"
			},
			onComplete: function(response){
				$("mainContents").update(response.responseText);
			}
		})
	});
	
	
	
 	$("btnCancel").observe("click", function(){
		new Ajax.Request("${pageContext.request.contextPath}" + "/", {
			method: "get",
			parameters: {
				actionBack : "backToHome"
			},
			onComplete: function(response){
				$("mainContents").update(response.responseText);
			}
		})
	}); 
	
	</script>
	
	
	
	
</html>
	
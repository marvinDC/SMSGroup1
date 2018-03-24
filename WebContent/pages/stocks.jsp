<center>
<h3>Stocks</h3>


	<table>
		<tr>
			<td align="right"><label><b>Item Name: </b></label></td>
			<td><input type="text" id="txtItemName"></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td><input type="button" id="btnAddStocks" value="Add Stocks"></td>
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
	
	
	<table border="1">
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
	</table>
	
	
	
	
	
	</center>
	
	
	<script>
	
	newDiv.observe("click", function() {
		$("txtItemName").value=newDiv.down("td", 0).innerHTML;
		$("txtQuantity").value=newDiv.down("td", 1).innerHTML;
		$("txtRefNo").value=newDiv.down("td", 2).innerHTML;
		$("txtDateAdded").value=newDiv.down("td", 3).innerHTML;
		$("txtPurchaseAdded").value=newDiv.down("td", 4).innerHTML;
		newDiv.setAttribute("id", "tr1")
	})
	
	</script>
	
	
	
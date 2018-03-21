<div>
	<h3>Issue Supplies</h3>
	<table>
		<tr>
			<td>Item Name :</td>
			<td><select id="selectItem" class="formInput">
				<option value="1">item1</option>
				<option value="2">item2</option>
				<option value="3">item3</option>
			</select></td>
		</tr>
		<tr>
			<td>Quantity :</td>
			<td><input id="quantity" type="number" class="formInput"></td>
		</tr>
		<tr>
			<td>Requested by :</td>
			<td><input id="requestedBy" type="text" class="formInput"></td>
		</tr>
		<tr>
			<td>Department Name :</td>
			<td><select id="selectDept" class="formInput">
				<option value="1">Department 1</option>
				<option value="2">Department 2</option>
				<option value="3">Department 3</option>
			</select></td>
		</tr>
		<tr>
			<td>Issue Date :</td>
			<td><input id="issueDate" type="date" class="formInput"></td>
		</tr>
	</table>
	<div>
		<div>
			<input type="button" class="formBtn" id="issueRequestBtn" value="Issue Request" onclick="issueRequest()">
		</div>
		<div>
			<input type="button" class="formBtn" id="saveBtn" value="Save" onclick="saveIssuedSupply('update')"><br>
		</div>
		<div>
			<input type="button" class="formBtn" id="cancelBtn" value="Cancel" onclick="cancelIssuedSupply()">
		</div>
	</div><br>
	<hr>
	<div>
		<table>
			<tr>
				<td>Search : </td>
				<td><input type="text" id="search" class="formInput" onfocusout="searchIssuedSupply()"></td>
			</tr>
		</table><br>
	</div>
	<div>
		<table border="1" id="issuedListing">
			<tr class="tableHeader">
				<th style="width:80px">Issue ID</th>
				<th style="width:100px">Item Name</th>
				<th style="width:40px">Qty</th>
				<th style="width:110px">Requested By</th>
				<th style="width:140px">Department Name</th>
				<th style="width:85px">Issue Date</th>
				<th style="width:130px">Last Updated By</th>
				<th style="width:100px">Last Update</th>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
</div>

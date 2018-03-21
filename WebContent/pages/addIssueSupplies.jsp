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
			<input type="button" class="formBtn" id="saveBtn" value="Save" onclick="saveIssuedSupply('add')"><br>
		</div>
		<div>
			<input type="button" class="formBtn" id="cancelBtn" value="Cancel" onclick="cancelAddIssue()">
		</div>
	</div>
</div>
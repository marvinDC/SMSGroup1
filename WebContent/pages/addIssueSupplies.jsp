<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="margin-left: 10px;">You are Here || Issue Supplies || Add</div>
<div class="content">
	<h3>Issue Supplies</h3>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-6">
			<table>
				<tr>
					<td align="right">Item Name </td>
					<td align="right"><select id="selectItem" class="formInput form-control">
						<option value="1">item1</option>
						<option value="2">item2</option>
						<option value="3">item3</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">Quantity </td>
					<td><input id="quantity" type="number" class="formInput form-control"></td>
				</tr>
				<tr>
					<td align="right">Requested by </td>
					<td><input id="requestedBy" type="text" class="formInput form-control"></td>
				</tr>
				<tr>
					<td align="right">Department Name </td>
					<td><select id="selectDept" class="formInput form-control">
						<option value="1">Department 1</option>
						<option value="2">Department 2</option>
						<option value="3">Department 3</option>
					</select></td>
				</tr>
				<tr>
					<td align="right">Issue Date </td>
					<td><input id="issueDate" type="date" class="formInput form-control"></td>
				</tr>
			</table>
		</div>
		<div class="col-md-4">
			<div>
				<button class="formBtn btn btn-primary" id="saveBtn" onclick="saveIssuedSupply('add')">Save</button>
			</div>
			<div>
				<button class="formBtn btn btn-primary" id="cancelBtn" onclick="supplyIssuance()">Cancel</button>
			</div>
		</div>
	</div>
</div>
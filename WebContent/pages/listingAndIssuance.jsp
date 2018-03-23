<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="margin-left: 10px;">You are Here || Issue Supplies</div>
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
						<option value="AD">Administration</option>
						<option value="HR">Human Resources</option>
						<option value="PU">Purchasing</option>
						<option value="MK">Marketing</option>
						<option value="IT">IT</option>
						<option value="FI">Finance</option>
						<option value="AC">Accounting</option>
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
				<button class="formBtn btn btn-primary" id="issueRequestBtn" onclick="issueRequest()">Issue Request</button>
			</div>
			<div>
				<button class="formBtn btn btn-primary" id="saveBtn" onclick="saveIssuedSupply('update')">Save</button>
			</div>
			<div>
				<button class="formBtn btn btn-primary" id="cancelBtn" onclick="backToHome()">Cancel</button>
			</div>
		</div>
	</div>
	<hr>
	<div align="center">
		<div>
			<table>
				<tr>
					<td>Search : </td>
					<td><input type="text" id="search" class="formInput form-control" style="width:200px" onfocusout="searchIssuedSupply()"></td>
				</tr>
			</table><br>
		</div>
		<div>
			<table border="1" id="issuedListing">
				<tr class="tableHeader">
					<th >Issue ID</th>
					<th>Item Name</th>
					<th>Qty</th>
					<th>Requested By</th>
					<th>Department Name</th>
					<th>Issue Date</th>
					<th>Last Updated By</th>
					<th>Last Update</th>
				</tr>
				<c:forEach var="issuedSupply" items="${issuedSupplies}">
					<tr class="row">
						<td title="${issuedSupply.issueId}"><a href="#">${issuedSupply.issueId}</a></td>
						<td>${issuedSupply.itemName}</td>
						<td>${issuedSupply.quantity}</td>
						<td>${issuedSupply.requestor}</td>
						<td>${issuedSupply.deptId}</td>
						<td><fmt:formatDate pattern="MM/dd/YYYY" value="${issuedSupply.issueDate}"/></td>
						<td></td>
						<td><fmt:formatDate pattern="MM/dd/YYYY" value="${issuedSupply.lastUpdate}"/> </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

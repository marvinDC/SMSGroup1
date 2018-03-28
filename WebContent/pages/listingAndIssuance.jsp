<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="margin-left: 10px;">You are Here || Issue Supplies</div>
<div class="content">
	<h3 class="pageHeader">Issue Supplies</h3>
	<div align="center">
		<div id="issueAlert" class="alert alert-danger ${message != null ? '':'hidden'}">${message}</div>
	</div>
	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-6">
			<table>
				<tr>
					<td align="right">Item Name </td>
					<td align="right"><select id="selectItem" class="formInput form-control">
						<c:forEach var="supply" items="${supplies}">
							<c:if test="${supply.obsoleteTag != 'Y'}">
								<option value="${supply.supplyId}">${supply.itemName}</option>
							</c:if>
						</c:forEach>
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
						<c:forEach var="department" items="${departments}">
							<option value="${department.deptId}">${department.deptName}</option>
						</c:forEach>
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
					<td><input type="text" id="search" class="formInput form-control" style="width:200px" onkeypress="searchIssuedSupply(event)"></td>
				</tr>
			</table><br>
		</div>
		<div>
			<table border="1" id="issuedListing">
				<tr class="tableHeader">
					<th>Issue ID</th>
					<th class="hidden">supply id</th>
					<th>Item Name</th>
					<th>Qty</th>
					<th>Requested By</th>
					<th  class="hidden">Dept ID</th>
					<th>Department Name</th>
					<th>Issue Date</th>
					<th>Last Updated By</th>
					<th>Last Update</th>
				</tr>
				<c:forEach var="issuedSupply" items="${issuedSupplies}">
					<tr class="row">
						<td title="${issuedSupply.issueId}"><a href="#">${issuedSupply.issueId}</a></td>
						<td class="hidden">${issuedSupply.supplyId}</td>
						<td>${issuedSupply.itemName}</td>
						<td>${issuedSupply.quantity}</td>
						<td>${issuedSupply.requestor}</td>
						<td  class="hidden">${issuedSupply.deptId}</td>
						<td>${issuedSupply.deptName}</td>
						<td><fmt:formatDate pattern="MM/dd/YYYY" value="${issuedSupply.issueDate}"/></td>
						<td>${issuedSupply.lastUserName}</td>
						<td><fmt:formatDate pattern="MM/dd/YYYY" value="${issuedSupply.lastUpdate}"/> </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>

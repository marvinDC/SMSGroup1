<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div style="margin-left: 10px;">You are Here || Issue Supplies || Add</div>
<div class="content">
	<h3 class="pageHeader">Issue Supplies</h3>
	<div align="center">
		<div id="issueAlert" class="alert alert-danger hidden"></div>
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
					<td><input id="quantity" type="text" class="formInput form-control"></td>
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
					<td><input id="issueDate" type="text" class="formInput form-control" placeholder="MM/DD/YYYY"></td>
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
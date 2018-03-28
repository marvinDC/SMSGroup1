<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
	var contextPath = '${pageContext.request.contextPath}';
</script>
</head>
<body>
	<div style="margin-left: 10px;">You are Here || Maintenance >>
		Supplies</div>

	<div class=content>
		<br />
		<div id="suppliesInputsDiv" align="center">
			<div class="maintenanceLinks"
				style="width: 100px; height: 300px; position: absolute; top: 16%; left: 5%;">
				<table style="color: black;">
					<tr>
						<td><a style="color: black;" href="#" onclick="toUserPage()">Users</a></td>
					</tr>
					<tr>
						<td><a style="color: black;" href="#" onclick="">Supply
								Types</a></td>
					</tr>
					<tr>
						<td><a style="color: black;" href="#"
							onclick="suppliesMaintenance()">Supplies</a></td>
					</tr>
				</table>
			</div>
			<div id="errorMsg" style="width: 800px; align: center;"
				class="alert alert-danger hidden"></div>
			<table class="supplyForms" style="width: 800px; align: center">
				<tr>
					<td align="right"><label>Supply Type</label></td>
					<td><select class="formInput form-control" id="txtSupplyTye">
							<c:forEach var="rec" items="${supplyTypes}">
								<option value=<c:out value="${rec.getSupplyType()}"/>><c:out
										value="${rec.getSupplyType()}" /></option>
							</c:forEach>
					</select></td>
					<td style="width: 100px; text-align: right;"><label>Entered
							Date</label></td>
					<td colspan=3><input placeholder="MM/DD/YYYY" type="text"
						disabled id="txtEnteredDate" style="width: 327px;"
						class="formInput form-control"></td>
				</tr>
				<tr>
					<td align="right"><label>Item Name</label></td>
					<td><input type="text" id="txtItemName"
						class="formInput form-control"></td>
					<td style="width: 100px; text-align: right;"><label>Reorder
							Level</label></td>
					<td><input type="text" id="txtReorderLevel"
						style="width: 100px;" class="formInput form-control"></td>
					<td style="width: 100px; text-align: right;"><label>Actual
							Count</label></td>
					<td><input type="text" id="txtActualCount" disabled
						style="width: 100px;" class="formInput form-control"></td>
				</tr>
				<tr>
					<td align="right"><label>Item Unit</label></td>
					<td><input type="text" id="txtItemUnit"
						class="formInput form-control required"></td>
					<td style="width: 150px; text-align: right;"><label>Remarks</label></td>
					<td colspan=3 rowspan=3><textarea rows=4 style="width: 327px;"
							id="txtRemarks" class="formInput form-control"></textarea></td>
				</tr>
				<tr>
					<td align="right"><label>Obsolete Tag</label></td>
					<td><input style="margin-left: 10px;" type="radio"
						name="obsoleteRadioGroup" id="radioObsoleteTagYes" value="Y">Yes
						<input style="margin-left: 10px;" type="radio" checked
						name="obsoleteRadioGroup" id="radioObsoleteTagNo" value="N">No
					</td>
				</tr>
				<tr>
					<td align="right"><label>Location</label></td>
					<td><input type="text" id="txtLocation"
						class="formInput form-control"></td>
				</tr>
			</table>

		</div>
		<br /> <br />
		<div align="center">

			<button class="formBtn btn btn-primary" id="bttnAddNew"
				onclick="gotoAddSupplies()">Add New</button>
			<button class="formBtn btn btn-primary" id="bttnSave"
				onclick="UpdateSupplies()">Save</button>
			<button class="formBtn btn btn-primary" id="bttnCancel"
				onclick="backToHome()">Cancel</button>

		</div>
		<br />
		<div align="center">

			<input type="text" id="txtSearchSupplyId"
				onkeypress="searchSupplies(event)" style="width: 327px;"
				placeholder="Search" class="formInput form-control">
		</div>

		<div id="suppliesTabDiv" align="center">
			<table style="width: 100px;" border=1>
				<thead id="suppliesTabHeader" class="tableHeader">
					<tr>
						<th
							style="text-align: center; padding-left: 0px; padding-right: 0px;">Supply
							ID</th>
						<th
							style="text-align: center; width: 121px; padding-left: 0px; padding-right: 0px;">Supply
							Type</th>
						<th
							style="text-align: center; width: 121px; padding-left: 0px; padding-right: 0px;">Item
							Name</th>
						<th>Item Unit</th>
						<th
							style="text-align: center; padding-left: 0px; padding-right: 0px;">Obsolete
							Tag</th>
						<th>Location</th>
						<th
							style="text-align: center; padding-left: 0px; padding-right: 5px;">Reorder
							Level</th>
						<th
							style="text-align: center; padding-left: 5px; padding-right: 5px;">Actual
							Count</th>
						<th
							style="text-align: center; width: 121px; padding-left: 0px; padding-right: 0px;">Remarks</th>
						<th>Entry Date</th>
						<th
							style="width: 121px; padding-left: 0px; padding-right: 0px; text-align: center;">Last
							Update By</th>
						<th>Last Update</th>
					</tr>
				</thead>
				<tbody id="suppliesTabBody">
					<c:forEach var="rec" items="${supplies}">
						<tr>
							<td class="varchar"><a href="#">${rec.getSupplyId()}</a></td>
							<td class="varchar"><c:out value="${rec.getSupplyType()}" /></td>
							<td class="varchar"><c:out value="${rec.getItemName()}" /></td>
							<td class="varchar"><c:out value="${rec.getItemUnit()}" /></td>
							<td class="digits"><c:out value="${rec.getObsoleteTag()}" /></td>
							<td class="varchar"><c:out value="${rec.getLocation()}" /></td>
							<td class="digits"><c:out value="${rec.getReorderLevel()}" /></td>
							<td class="digits"><c:out value="${rec.getActualCount()}" /></td>
							<td class="varchar"><c:out value="${rec.getRemarks()}" /></td>
							<td class="numeral"><fmt:formatDate pattern="MM/dd/YYYY"
									value="${rec.getDateAdded()}" /></td>
							<td class="varchar"><c:out value="${rec.getLastUser()}" /></td>
							<td class="numeral"><fmt:formatDate pattern="MM/dd/YYYY"
									value="${rec.getLastUpdate()}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<br /> <br />
	</div>
</body>
</html>
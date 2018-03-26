<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script type="text/javascript" src="../js/prototype.js"></script>
<script type="text/javascript" src="../js/suppliesMaintenance.js"></script>
<script>
	var contextPath = '${pageContext.request.contextPath}';
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<h3>Supplies Maintenance</h3>
	<div id=content>



		<div id="suppliesInputsDiv" align="center">
			<table class="supplyForms" style="width:800px;align:center">
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
					<td colspan=3><input placeholder="MM/DD/YYYY" type="text" id="txtEnteredDate" style="width:327px;"
						class="formInput form-control"></td>
				</tr>
				<tr>
					<td align="right"><label>Item Name</label></td>
					<td><input type="text" id="txtItemName"
						class="formInput form-control"></td>
					<td style="width: 100px; text-align: right;"><label>Reorder
							Level</label></td>
					<td><input type="text" id="txtReorderLevel" style="width: 100px;"
						class="formInput form-control"></td>
					<td style="width: 100px; text-align: right;"><label>Actual
							Count</label></td>
					<td><input type="text" id="txtActualCount" style="width: 100px;"
						class="formInput form-control"></td>
				</tr>
				<tr>
					<td align="right"><label>Item Unit</label></td>
					<td><input type="text" id="txtItemUnit"
						class="formInput form-control"></td>
					<td style="width: 150px; text-align: right;"><label>Remarks</label></td>
					<td colspan=3 rowspan=3><textarea  rows=5 style="width:327px;"
							id="txtRemarks" class="formInput form-control"></textarea></td>
				</tr>
				<tr>
					<td align="right"><label>Obsolete Tag</label></td>
					<td><input style="margin-left: 10px;" type="radio"
						name="obsoleteRadioGroup" id="radioObsoleteTagYes" value="Y">Yes
						<input style="margin-left: 10px;" type="radio"
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

		<div align="center">

			<button class="formBtn btn btn-primary" id="bttnAddNew"
				onclick="gotoAddSupplies()">Add New</button>
			<button class="formBtn btn btn-primary" id="bttnSave"
				onclick="UpdateSupplies()">Save</button>
			<button class="formBtn btn btn-primary" id="bttnCancel">Cancel</button>

		</div>

		<div align="center">

			<input type="text" id="txtSearchSupplyId" onkeypress="searchSupplies(event)" style="width:327px;" placeholder="Search"
				class="formInput form-control">
		</div>

		<div id="suppliesTabDiv" align="center">
			<table style="width:100px;">
				<thead id="suppliesTabHeader" class="tableHeader">
					<tr>
						<th>Supply ID</th>
						<th>Supply Type</th>
						<th>Item Name</th>
						<th>Item Unit</th>
						<th>Obsolete Tag</th>
						<th>Location</th>
						<th>Reorder Level</th>
						<th>Actual Count</th>
						<th>Remarks</th>
						<th>Entry Date</th>
						<th>Last Update By</th>
						<th>Last Update</th>
					</tr>
				</thead>
				<tbody id="suppliesTabBody">
					<c:forEach var="rec" items="${supplies}">
						<tr>
							<td><a href="#">${rec.getSupplyId()}</a></td>
							<td><c:out value="${rec.getSupplyType()}" /></td>
							<!--  Binago -->
							<td><c:out value="${rec.getItemName()}" /></td>
							<td><c:out value="${rec.getItemUnit()}" /></td>
							<td><c:out value="${rec.getObsoleteTag()}" /></td>
							<td><c:out value="${rec.getLocation()}" /></td>
							<td><c:out value="${rec.getReorderLevel()}" /></td>
							<td><c:out value="${rec.getActualCount()}" /></td>
							<td><c:out value="${rec.getRemarks()}" /></td>
							<td><fmt:formatDate pattern="MM/dd/YYYY"
									value="${rec.getDateAdded()}" /></td>
							<td><c:out value="${rec.getLastUser()}" /></td>
							<td><fmt:formatDate pattern="MM/dd/YYYY"
									value="${rec.getLastUpdate()}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
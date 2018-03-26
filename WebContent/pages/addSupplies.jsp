<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id=content> 
		 
		<div id="suppliesInputsDiv" align="center">
			<table class="supplyForms" > 
				<tr> 
					<td align="right"><label>Supply Type</label></td>
					<td > 
					<select  class="formInput form-control" id="txtSupplyTye"> 
						<c:forEach var="rec" items="${supplyTypes}">
							<option value = <c:out value="${rec.getSupplyTypeId()}"/> ><c:out value="${rec.getSupplyType()}"/></option>
						</c:forEach>
					</select> 
					</td>
					<td style="width:200px; text-align:right;"><label>Entered Date</label></td>
					<td colspan=3><input type="text" id= "txtEnteredDate" class="formInput form-control" ></td>
				</tr> 
				<tr>  
					<td align="right"><label>Item Name</label></td>
					<td><input type="text" id= "txtItemName" class="formInput form-control"></td>
					<td style="width:100px; text-align:right;"><label>Reorder Level</label></td>
					<td><input type="text" id= "txtReorderLevel" class="formInput form-control"></td>
					<td style="width:150px; text-align:right;"><label>Actual Count</label></td>
					<td><input type="text" id= "txtActualCount" class="formInput form-control"></td>					
				</tr>
				<tr>  
					<td align="right"><label>Item Unit</label></td>  
					<td><input type="text" id= "txtItemUnit" class="formInput form-control" ></td>
					<td style="width:200px; text-align:right;"><label>Remarks</label></td>   
					<td colspan=3 rowspan=3><textarea cols=50 rows=5  id= "txtRemarks" class="formInput form-control" ></textarea></td>					
				</tr>				
				<tr>  
					<td align="right"><label>Obsolete Tag</label></td> 
					<td ><input style="margin-left: 10px;"  type="radio" name="obsoleteRadioGroup" id ="radioObsoleteTagYes"  value= "Y" >Yes 
						<input style="margin-left: 10px;" type="radio" name="obsoleteRadioGroup"  id ="radioObsoleteTagNo"  value= "N" >No
					</td>				 
				</tr>				
				<tr>   
					<td align="right"><label>Location</label></td> 
					<td><input type="text"  id= "txtLocation" class="formInput form-control"></td>	 		 	
				</tr>				
			</table>
		
		</div>
	 
	 	<div align="center">
				<button onclick="AddSupplies()" class="formBtn btn btn-primary" id="bttnSave" >Save</button>
				<button class="formBtn btn btn-primary" id="bttnCancel" >Cancel</button>

		</div>
	</div>
</body>
</html>
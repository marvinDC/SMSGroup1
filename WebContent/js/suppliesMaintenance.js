/**
 * 
 */

function suppliesMaintenance() {
	new Ajax.Request(contextPath + "/supplies", {
		method : "GET",
		parameters : {
			action : "populate"
		},
		onComplete : function(response) {
			$("mainContents").update(response.responseText);
			RowsBehavior();
		}
	});
}

function searchSupplies(event) {
	if (event.keyCode == 13){
		new Ajax.Request(contextPath + "/supplies", {
			method : "GET",
			parameters  : {
				action  : "searchSupplies",
				supplyId: $F("txtSearchSupplyId")
			},
			onComplete : function(response) {
				$("mainContents").update(response.responseText);
				RowsBehavior();
				console.log(response);
				$("txtSearchSupplyId").value = response.request.parameters.supplyId;
				console.log(response.request.parameters.supplyId);
			}
		}); 
	}
}

function gotoAddSupplies() {
	new Ajax.Request(contextPath + "/supplies", {
		method : "GET",
		parameters : {
			action : "goAddSupplies"
		},
		onComplete : function(response) {
			$("mainContents").update(response.responseText);
			RowsBehavior();
		}
	});
}

function AddSupplies() {

	var isCompleteFields = false;
	var errorMsg = "";
	var timestamp=Date.parse($F("txtEnteredDate"));

	if(!$F("txtItemName") || !$F("txtItemUnit") || !$F("txtReorderLevel") ||
	   !$F("txtActualCount") || !$F("txtRemarks") || !$F("txtLocation") || !$F("txtEnteredDate")){
		isCompleteFields = false;
		errorMsg = "Please fill out form completely";
	}else if(isNaN($F("txtReorderLevel")) || isNaN($F("txtActualCount"))){
		isCompleteFields = false;
		errorMsg = "Input Number only for Re-Order Level or Actual Count";
	}else if(!isNaN($F("txtReorderLevel")) || !isNaN($F("txtActualCount"))){
		if($F("txtReorderLevel") <= 0 || $F("txtActualCount") <= 0){
			isCompleteFields = false;
			errorMsg = "Value for Re-Order Level/Actual Count";
		}else{
			isCompleteFields = true;
			if(!isNaN(timestamp)){
				  var date = new Date($F("txtEnteredDate"));
				  var day = date.getDate();
				  var month = date.getMonth() + 1;
				  var year = date.getFullYear();
				  var newDate = month+"/"+day+"/"+year;
				  alert(newDate);
				isCompleteFields = true;
			}else{
				isCompleteFields = false;
				errorMsg= "Invalid Date for Entered Date";
			}
			
		}
	}else{
		if(!isNaN(timestamp)){
			  var date = new Date($F("txtEnteredDate"));
			  var day = date.getDate();
			  var month = date.getMonth() + 1;
			  var year = date.getFullYear();
			  var newDate = month+"/"+day+"/"+year;
			  alert(newDate);
			isCompleteFields = true;
		}else{
			isCompleteFields = false;
			alert("Error");
			errorMsg= "InValid Date for Entered Date";
		}
		
		
	}  	
	
	if(isCompleteFields){
	new Ajax.Request(contextPath + "/supplies", {
		method : "POST",
		parameters : {
			action : "addSupplies",
			supplyTypeId : $F("txtSupplyTye"),
			dateAdded : newDate,
			itemName : $F("txtItemName"),
			reorderLevel : $F("txtReorderLevel"),
			actualCount : $F("txtActualCount"),
			itemUnit : $F("txtItemUnit"),
			remarks : $F("txtRemarks"),
			obsolete : ($("radioObsoleteTagYes").checked) ? "Y" : "N",
			location : $F("txtLocation")
		},
		onComplete : function(response) {
			$("mainContents").update(response.responseText);
			RowsBehavior();
		}
	}); 
	}else{
		$("errorMsg").removeClassName("hidden");
		$("errorMsg").innerHTML = errorMsg;
	}
}

function checkChildRecord(){
	
	var isCompleteFields = false;
	var errorMsg = ""

	if(!$F("txtItemName") || !$F("txtItemUnit") || !$F("txtReorderLevel")){
		isCompleteFields = false;
	}else{
		isCompleteFields = true;}
	if(isCompleteFields){
		new Ajax.Request(contextPath + "/supplies", {
			method : "GET",
			parameters : {
				action 			: "checkChildRecord",
				supplyId 		: $$("#suppliesTabBody .active")[0].down("td", 0).down("a", 0).innerHTML
			},
			onComplete : function(response) {
				$("mainContents").update(response.responseText);
				console.log(response);
				RowsBehavior();
				
			}
		});
	}
}

function UpdateSupplies() {
	var isCompleteFields = false;
	var errorMsg = ""

	if(!$F("txtItemName") || !$F("txtItemUnit") || !$F("txtReorderLevel")){
		isCompleteFields = false;
	}else{
		isCompleteFields = true;
	}  
	if(isCompleteFields){
		new Ajax.Request(contextPath + "/supplies", {
			method : "POST",
			parameters : {
				action 			: "updateSupplies",
				supplyTypeId 	: $F("txtSupplyTye"),
				dateAdded 		: $F("txtEnteredDate"),
				itemName 		: $F("txtItemName"),
				reorderLevel 	: $F("txtReorderLevel"),
				actualCount		: $F("txtActualCount"),
				itemUnit 		: $F("txtItemUnit"),
				remarks 		: $F("txtRemarks"),
				obsolete 		: ($("radioObsoleteTagYes").checked) ? "Y" : "N",
				location 		: $F("txtLocation"),
				supplyId 		: $$("#suppliesTabBody .active")[0].down("td", 0).down("a", 0).innerHTML
			},
			onComplete : function(response) {
				alert("complete");
				$("mainContents").update(response.responseText);
				alert(response.responseText); 
				RowsBehavior();
			}
		});
	}else{
		$("errorMsg").removeClassName("hidden");
		$("errorMsg").innerHTML = "Please fill out form completely";

	}
}

function RowsBehavior() {
	$$("tbody#suppliesTabBody tr").each(function(r) {
		$(r).observe("mouseover", function() {
			$(r).addClassName('hover');

		});
		$(r).observe("mouseout", function() {
			$(r).removeClassName('hover');
		});

		$(r).observe("click", function() {
			$$("tbody#suppliesTabBody tr").each(function(row) {
				row.removeClassName("active");				
			});
			$(r).addClassName("active");


			$("txtSupplyTye").value = $(r).down("td", 1).innerHTML;
			$("txtEnteredDate").value = $(r).down("td", 9).innerHTML;
			$("txtItemName").value = $(r).down("td", 2).innerHTML;
			$("txtReorderLevel").value = $(r).down("td", 6).innerHTML;
			$("txtActualCount").value = $(r).down("td", 7).innerHTML;
			$("txtItemUnit").value = $(r).down("td", 3).innerHTML;
			$("txtRemarks").value = $(r).down("td", 8).innerHTML;
			$("txtLocation").value = $(r).down("td", 5).innerHTML;

			if ($(r).down("td", 4).innerHTML == "Y") {
				$("radioObsoleteTagYes").checked = true;
			} else {
				$("radioObsoleteTagNo").checked = true;
			}

		});
	});
}
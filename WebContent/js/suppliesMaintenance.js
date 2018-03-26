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

	new Ajax.Request(contextPath + "/supplies", {
		method : "POST",
		parameters : {
			action : "addSupplies",
			supplyTypeId : $F("txtSupplyTye"),
			dateAdded : $F("txtEnteredDate"),
			itemName : $F("txtItemName"),
			reorderLevel : $F("txtReorderLevel"),
			actualCount : $F("txtActualCount"),
			itemUnit : $F("txtItemUnit"),
			remarks : $F("txtRemarks"),
			obsolete : ($("radioObsoleteTagYes").checked) ? "Y" : "N",
			location : $F("txtLocation")
		},
		onComplete : function(response) {
			alert("complete");
			$("mainContents").update(response.responseText);
			alert(response.responseText); 
			RowsBehavior();
		}
	}); 
}

function UpdateSupplies() {

	alert($$("#suppliesTabBody .active")[0].down("td", 0).down("a", 0).innerHTML);
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
			$(r).addClassName('active');

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
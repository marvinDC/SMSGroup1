function supplyIssuance() {
	new Ajax.Request(contextPath + "/supply-issuance", {
		method: "GET",
		parameters: {
			action: "table"
		},
		onComplete: function(response){
			$("mainContents").update(response.responseText);
			console.log(response);
			initRowFunctions();
		}
	});
}

function issueRequest() {
	console.log('issueRequest');
	new Ajax.Request(contextPath + "/supply-issuance", {
		method: "GET",
		parameters: {
			action: "add"
		},
		onComplete: function(response){
			$("mainContents").update(response.responseText);
		}
	});
	
}

function cancelAddIssue() {
	console.log('issueRequest');
	new Ajax.Request(contextPath + "/supply-issuance", {
		method: "GET",
		parameters: {
			action: "table"
		},
		onComplete: function(response){
			$("mainContents").update(response.responseText);
		}
	});
}

function initRowFunctions(){
	$$("#issuedListing .row").each(function(elem){
		elem.observe('mouseover', function(){
			elem.addClassName('hover');
		})
		elem.observe('mouseout', function(){
			elem.removeClassName('hover');
			})
		elem.observe('click', function(){
			if (elem.hasClassName("active")) {
				elem.removeClassName("active");
				reset();
			}
			else {		
				$$('#issuedListing .row').each(function(elem){
					elem.removeClassName("active");
				})
				elem.addClassName('active');
				var date = new Date(elem.down('td',5).innerHTML);
				$("selectItem").value = elem.down('td',1).innerHTML;
				$("quantity").value = elem.down('td',2).innerHTML;
				$("requestedBy").value = elem.down('td',3).innerHTML;
				$("selectDept").value = elem.down('td',4).innerHTML;
				$("issueDate").value = (date.getFullYear()) + "-" +
					("00" + (date.getMonth() + 1)).slice(-2) + "-" + ("00" + date.getDate()).slice(-2);
			}
		})
	})
}

function reset() {
	$("selectItem").value = "1";
	$("quantity").value = "";
	$("requestedBy").value = "";
	$("selectDept").value = "1";
	$("issueDate").value = "";
}

function saveIssuedSupply(action) {
	console.log('save');
	var obj = {
		supplyId: $F("selectItem"),
		quantity: $F("quantity"),
		requestedBy: $F("requestedBy"),
		departmentId: $F("selectDept"),
		issueDate: $F("issueDate"),
		action: action
	};
	if (action == "update") {
		obj.issueId = $$("#issuedListing .active")[0].down("td", 0).title;
	}
	var message = validateIssueFields(obj);
		if (!message) {
			//send to servlet
			console.log(obj);
			new Ajax.Request(contextPath + "/supply-issuance", {
				method: "POST",
				parameters: obj,
				onComplete: function(response){
					$("mainContents").update(response.responseText);
				}
			});
		}
	else {
		alert(message);
	}
}

function cancelIssuedSupply() {
	console.log('cancel');
	//back to home page
	new Ajax.Request(contextPath + "/supply-issuance", {
		method: "GET",
		parameters: {
			action: "home"
		},
		onComplete: function(response){
			$("mainContents").update(response.responseText);
		}
	});
	
	new Ajax.updater()
}

function searchIssuedSupply(){
	var searchItem = $F("search")
	console.log('search', searchItem);
	
}

function validateIssueFields(obj){
	for ( var key in obj) {
		if(!obj[key]){
			return "Error: Missing field value";
		}
	}
	if(isNaN(obj.quantity)){
		return "invalid quantity"
	}
		
	return false;
}
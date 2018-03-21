function supplyIssuance() {
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
	var message = validateIssueFields(obj);
	if (!message) {
		//send to servlet
		console.log(obj);
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
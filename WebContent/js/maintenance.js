function maintenance() {
	console.log("maintenance")
	new Ajax.Request(contextPath + "/maintenance", {
		method: "GET",
		parameters: {
			action: "cancel"
		},
		onComplete: function(response) {
			$("mainContents").update(response.responseText);
		}
	});
}

function toUserPage(){
	new Ajax.Request(contextPath + "/maintenance", {
		method: "GET",
		parameters: {
			action: "userPage"
		},
		onComplete: function(response){
			$("mainDiv").update(response.responseText);
		}
	});
}

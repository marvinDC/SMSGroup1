function login() {
	new Ajax.Request(contextPath + "/", {
		method: "POST",
		parameters: {
			action: 'login',
		},
		onComplete: function(response) {
			$("contents").update(response.responseText);
		}
	});
}

function logout() {
	new Ajax.Request(contextPath + "/", {
		method: "POST",
		parameters: {
			action: 'logout',
		},
		onComplete: function(response) {
			$("contents").update(response.responseText);
		}
	});
}
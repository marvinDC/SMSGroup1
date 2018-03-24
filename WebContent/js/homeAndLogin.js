function login() {
	for (var i=0; i<$$('.alert').length; i++) {
		$$('.alert')[i].addClassName('hidden')
	};
	
	var userId = $('userId').value;
	var password = $('password').value;
	
	if (userId == '' || password == '')
		$('requiredAlert').removeClassName('hidden');
	else {
		new Ajax.Request(contextPath + "/", {
			method: "POST",
			parameters: {
				action: 'login',
				userId: userId,
				password: password
			},
			onComplete: function(response) {
				$("contents").update(response.responseText);
			}
		});
	}
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

function backToHome() {
	new Ajax.Request(contextPath + "/", {
		method: "GET",
		parameters: {},
		onComplete: function(response) {
			$("contents").update(response.responseText);
		}
	});
}
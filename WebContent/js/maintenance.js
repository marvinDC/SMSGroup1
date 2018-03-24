function maintenance() {
	new Ajax.Request(contextPath + "/maintenance", {
		method: "GET",
		parameters: {},
		onComplete: function(response) {
			$("mainContents").update(response.responseText);
		}
	});
}

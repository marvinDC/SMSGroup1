function linkSuppliesStocks() {
	new Ajax.Request(contextPath + "/suppliesstocks", {
		method: "GET",
		parameters: {
			action: 'stocks',
		},
		onComplete: function(response) {
			$("mainContents").update(response.responseText);
		}
	});
}
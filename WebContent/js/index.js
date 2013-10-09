$(document).ready(function(){
	$("#addurl").click(function(){
		var clone = $("#datarow").first().clone();
		clone.find(".domainInput").val("");
		clone.find(".yearsel").val("1");
		clone.appendTo("#datatable");
	});
});
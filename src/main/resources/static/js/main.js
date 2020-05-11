$(document).ready(function () {

	$('.table .dBtn').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delref').attr('href', href);
		$('#deleteModal').modal();
	});

	$('.table .aBtn').on('click', function (event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#annuleModal #delref').attr('href', href);
		$('#annuleModal').modal();
	});
});
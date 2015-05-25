$(document).ready(function() {
	wyslijGet();
	wyslijPost();
})			

function wyslijPost() {
	$.ajax({
		type     : "POST",
		url		 : "zapisz_do_bazy_post.php",
		dataType : "json",
		data	 : {
			imie 	 : 'Jan',
			nazwisko : 'Kowalski'
		},
		success 	: function(json) {
			console.log("Post");
			alert( json["msg"] );
		},
		complete : function(r) {
			//ten fragment wykona się po ZAKONCZENIU połączenia
			//"r" to przykładowa nazwa zmiennej, która zawiera dane zwrócone
		},
		error:function(error) {
			//ten fragment wykona się w przypadku BŁĘDU
		}
	});
}

function wyslijGet() {
	$.ajax({
		type     : "GET",
		url		 : "zapisz_do_bazy_get.php",
		dataType : "json",
		data	 : "imie=Jan&nazwisko=Kowalski",
		success 	: function(json) {
			console.log("Get");
			alert( json["msg"] );
		},
		complete : function(r) {
			//ten fragment wykona się po ZAKONCZENIU połączenia
			//"r" to przykładowa nazwa zmiennej, która zawiera dane zwrócone
		},
		error:function(error) {
			//ten fragment wykona się w przypadku BŁĘDU
		}
	});
}
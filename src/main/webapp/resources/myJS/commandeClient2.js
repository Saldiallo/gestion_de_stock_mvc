$(document).ready(function() {

	$("#code_article").on("keypress", function(e) {
		if (e.which == '13') {
			var codeArticle = $("#code_article").val();
			if (verifierClient() && codeArticle) {
				searchArticle(codeArticle);
			}
		}
	});
	$("#listeClients").on("change", function(e) {
		creerCommande($("#listeClients option:selected").val());
		$("#choiceClient").hide("slow", function() {
			$("#choiceClient").hide()
		});
	});
	$("#btnSaveCommande").on("click",function(){
		$.getJSON("enregisterCammande",function(data){
			if(data) window.location=""+data;
		});
	});

	$("#wrongCodeArticle").hide();
	$("#choiceClient").hide("slow", function() {
		$("#choiceClient").hide()
	});

});

function searchArticle(codeArticle) {
	if (codeArticle) {
		var detailHtml = "";
		$.getJSON("ajouterLigne",{
				codeArticle : codeArticle,
				ajax : true
			},
			function(data) {
				if(data){
					var total = data.quantite * data.prixUnitaire;
					if ($("#qte" + data.article.idArticle).length > 0 && $("#total" + data.article.idArticle).length > 0) {
						$("#qte" + data.article.idArticle).text(data.quantite);
						$("#total" + data.article.idArticle).text(total);
					} else {
						detailHtml += 
								"<tr id='ligne" + data.article.idArticle + "'>" +
									"<td>" + data.article.codeArticle + "</td>" +
									"<td id='qte" + data.article.idArticle + "'>" + data.quantite + "</td>" + 
									"<td>"	+ data.prixUnitaire + "</td>" +
									"<td id='total"	+ data.article.idArticle + "'>" + total + "</td>" +
									"<td><button class='btn btn-link' onclick='supprimerLigneCommande(" + data.article.idArticle + ")'><i class='fa fa-trash'></i></button></td>"+
								"</tr>";
						$("#detailNewCommande").append(detailHtml);
					}
					$("#wrongCodeArticle").hide("slow", function() {$("#wrongCodeArticle").hide()});
					$("#code_article").val("");
				}
			}).fail(function() {
					$("#wrongCodeArticle").fadeIn(3000);
				});
	}
}

function supprimerLigneCommande(idArticle) {
	if($("#ligne" + idArticle).length > 0) {
		$.getJSON("supprimerLigne", {
			idArticle: idArticle,
			ajax: true
		},
		function(data){
			if(data) {
				$("#ligne" + idArticle).hide("slow", function() {$("#ligne" + idArticle).remove()});
			}
		});
	}
}

function verifierClient() {
	var idClient = $("#listeClients option:selected").val();
	if (idClient) {
		if (idClient === "-1") {
			$("#choiceClient").show("slow", function() {
				$("#choiceClient").show()
			});
			return false;
		}
		return true;
	}
}

function creerCommande(idClient) {
	if (idClient) {
		$.getJSON("creerCommande", {
			idClient : idClient,
			ajax : true
		}, function(data) {
			console.log("le Client a été mis à jour !!");
		});
	}
}

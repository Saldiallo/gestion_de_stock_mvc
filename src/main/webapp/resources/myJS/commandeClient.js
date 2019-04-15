$(document).ready(function(){
	$("#cache").hide();	
});

function updateDetailCommande(idComm){
	$("#cache").delay(1500).show();
	var json = $.parseJSON($("#json" + idComm).text());
	var detailHtml = "";
	
	console.log(json);
	
	if(json) {
		for(var index = 0; index < json.length; index++) {
			detailHtml += 
						"<tr>"+
							"<td>" + json[index].article.codeArticle + "</td>"+
							"<td>" + json[index].quantite + "</td>"+
							"<td>" + json[index].prixUnitaire + "</td>"+
							"<td>0</td>"+
						"</tr>";
		}
		$("#detailCommande").html(detailHtml);
	}
}

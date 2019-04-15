$(document).ready(function(){
	$("#taux").on("keyup",function(){
		tvaKeyUp();
	});
});

tvaKeyUp=function(){
	var prixUnitHT=parseFloat($("#prixUnitaireHT").val());
	var taux=parseFloat($("#taux").val());
	var prixUnitTTC=parseFloat((prixUnitHT*taux/100)+prixUnitHT);
	$("#prixUnitaireTTC").val(prixUnitTTC);
}
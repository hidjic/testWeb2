/**
 * 
 */
window.onload = function(){
	var listE = document.getElementsByClassName('rowClient');
	var lg =listE.length;
	while(lg--){
		listE[lg].onclick = sendId;
	}
}

function sendId(e){
	var pNode = e.target.parentNode.id;
	var id = pNode.split("_")[1];
	console.log(pNode);
	console.log(id);
	document.location.href="nouvellepage"
}

function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	if (nome === "") {
		alert('Preencha o Campo Nome')
		frmContato.nome.focus()
		return false
	} else if (fone === "") {
		alert('Preencha o Campo Fone')
		frmContato.fone.focus()
		return false
	} else {
		document.forms["frmContato"].submit()

	}
}

function confirmar(idcon){
	let resposta = confirm("Comfima a exclusão deste contato?")
	if(resposta === true){
		window.location.href= 'delete?idcon=' + idcon
		
	} 
	 
 }
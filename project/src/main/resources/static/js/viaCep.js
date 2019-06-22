function limpa_formulário_cep() {
	// Limpa valores do formulário de cep.
	document.getElementById('rua').focus();
	document.getElementById('rua').value = ("");
	document.getElementById('bairro').focus();
	document.getElementById('bairro').value = ("");
	document.getElementById('cidade').focus();
	document.getElementById('cidade').value = ("");
	document.getElementById('uf').focus();
	document.getElementById('uf').value = ("");

	document.getElementById('cep').focus();
}

function meu_callback(conteudo) {
	if (!("erro" in conteudo)) {
		// Atualiza os campos com os valores.
		document.getElementById('rua').focus();
		document.getElementById('rua').value = (conteudo.logradouro);
		document.getElementById('bairro').focus();
		document.getElementById('bairro').value = (conteudo.bairro);
		document.getElementById('cidade').focus();
		document.getElementById('cidade').value = (conteudo.localidade);
		document.getElementById('uf').focus();
		document.getElementById('uf').value = (conteudo.uf);

		document.getElementById('email').focus();
	} // end if.
	else {
		// CEP não Encontrado.
		limpa_formulário_cep();
		document.getElementById('cep').classList.add('invalid');
	}
}

function pesquisacep(valor) {

	// Nova variável "cep" somente com dígitos.
	var cep = valor.replace(/\D/g, '');

	// Verifica se campo cep possui valor informado.
	if (cep != "") {

		// Expressão regular para validar o CEP.
		var validacep = /^[0-9]{8}$/;

		// Valida o formato do CEP.
		if (validacep.test(cep)) {

			document.getElementById('cep').classList.remove('invalid');

			// Cria um elemento javascript.
			var script = document.createElement('script');

			// Sincroniza com o callback.
			script.src = 'https://viacep.com.br/ws/' + cep
					+ '/json/?callback=meu_callback';

			// Insere script no documento e carrega o conteúdo.
			document.body.appendChild(script);

		} // end if.
		else {
			// cep é inválido.
			limpa_formulário_cep();
			document.getElementById('cep').classList.add('invalid');
		}
	} // end if.
	else {
		// cep sem valor, limpa formulário.
		limpa_formulário_cep();
	}
};
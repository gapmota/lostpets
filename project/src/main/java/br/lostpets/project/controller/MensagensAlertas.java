package br.lostpets.project.controller;

public enum MensagensAlertas {

	EMAIL_SENHA_INCORRETO("<div id=\"card-alert\" class=\"card red\">\r\n" + 
			"                      <div class=\"card-content white-text\">\r\n" + 
			"                        <p><font style=\"vertical-align: inherit;\"><font style=\"vertical-align: inherit;\">" +
			" 							AVISO: Email ou senha INCORRETO" +
			"						</font></font></p>\r\n" + 
			"                      </div>\r\n" + 
			"                    </div>"),
	VAZIO("");
	
	
	private String mensagem;
	
	MensagensAlertas(String descricao){
		this.mensagem = descricao;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
}

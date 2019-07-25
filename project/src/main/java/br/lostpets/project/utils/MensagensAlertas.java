package br.lostpets.project.utils;

public enum MensagensAlertas {

	VAZIO(""),
	EMAIL_SENHA_INCORRETO("<div id=\"card-alert\" class=\"card red\">\r\n" + 
			"                      <div class=\"card-content white-text\">\r\n" + 
			"                        <p><font style=\"vertical-align: inherit;\"><font style=\"vertical-align: inherit;\">" +
			" 							AVISO: Email ou senha INCORRETO" +
			"						</font></font></p>\r\n" + 
			"                      </div>\r\n" + 
			"                    </div>"),
	EMAIL_JA_CADASTRADO("<div id=\"card-alert\" class=\"card red\">\r\n" + 
			"                      <div class=\"card-content white-text\">\r\n" + 
			"                        <p><font style=\"vertical-align: inherit;\"><font style=\"vertical-align: inherit;\">" +
			" 							AVISO: Email já cadastrado" +
			"						</font></font></p>\r\n" + 
			"                      </div>\r\n" + 
			"                    </div>"),
	PET_CADASTRADO_SUCESSO("<div id=\"card-alert\" class=\"card green\">\r\n" + 
			"                      <div class=\"card-content white-text\">\r\n" + 
			"                        <p><font style=\"vertical-align: inherit;\"><font style=\"vertical-align: inherit;\">" +
			" 							INFO: Animal cadastrado com SUCESSO" +
			"						</font></font></p>\r\n" + 
			"                      </div>\r\n" + 
			"                    </div>");
	
	
	private String mensagem;
	
	MensagensAlertas(String descricao){
		this.mensagem = descricao;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
}

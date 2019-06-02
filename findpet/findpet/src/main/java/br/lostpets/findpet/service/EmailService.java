package br.lostpets.findpet.service;

import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.lostpets.findpet.model.AnimaisAchados;
import br.lostpets.findpet.model.Usuario;

@Service
public class EmailService {

	private final static String URL = "http://findlostpets.azurewebsites.net/animaisAchados/confirmar/";
	
	@Autowired
	private AnimaisAchadosService animaisAchadosService;
	@Autowired
	private JavaMailSender mailSender;

	private String sendMail(String html, Usuario donoAnimal) {
		try {
			MimeMessage mail = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo("mateus.covos@gmail.com");
			helper.setSubject("Olá, " + donoAnimal.getNome() + "! Talvez seu animal tenha sido achado :D");
			helper.setText(html, true);
			mailSender.send(mail);

			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "erro";
		}
	}

	private String sendMailFind(String html, Usuario usuarioQueAchou, Usuario dono) {
		try {
			MimeMessage mail = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setTo("mateus.covos@gmail.com");
			helper.setSubject("Olá, " + usuarioQueAchou.getNome() + "! temos atualizações");
			helper.setText(html, true);
			mailSender.send(mail);

			return "ok";
		} catch (Exception e) {
			e.printStackTrace();
			return "erro";
		}
	}

	private String formatHtml(String nomeDono, String nomeUsuarioQueAchou, UUID idAnimalAchado) {
		String urlFind = URL + idAnimalAchado + "/1";
		String urlNotFind = URL + idAnimalAchado + "/0";
		String html = "<html><head> <meta http-equiv='Content-Type' content='text/html;charset=UTF-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <style>*{margin: 0px; padding: 0px; box-sizing: border-box;}html, body{width: 100%; height: 100%;}.center{position: relative; width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; background-color: #fff;}.modal{position: relative; width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; flex-wrap: wrap;padding: 10px;}.btn{position: relative; width: 50%; height: 50px; display: flex; justify-content: center; align-items: center; cursor: pointer; user-select: none;color: #fff !important;width:100%;text-align: center;text-decoration: none;}.red{background-color: rgb(214, 82, 82);}.red:hover{background-color: rgb(182, 29, 29);}.green{background-color: rgb(95, 189, 95);}.green:hover{background-color: rgb(35, 156, 35);}.content-btn{width: 100%; display: flex; justify-content: center; align-items: center; margin-top: 20px; margin-bottom: 30px;}.content{width: 100%;}.text{padding: 15px 0px; font-family: Verdana, Geneva, Tahoma, sans-serif; text-align: center;}</style></head><body> <div class='center'> <div class='modal'> <div class='content'> "
				+ "<p class='text'>Olá <b>" + nomeDono + "</b>, seu pet foi encontrado por <b>" + nomeUsuarioQueAchou
				+ "</b>.</p><p class='text'>Por gentileza, poderia nós informar se foi realmente este usuário que encontrou seu pet?</p>"
				+ "<div class='content-btn'> <a href='" + urlFind + "' class='btn green text'>foi ele</a> <a href='"
				+ urlNotFind
				+ "' class='btn red text'>não foi ele</a> </div><p class='text'>lostpets &copy 2019</p></div></div></div></body></html>";
		return html;
	}

	private String formatHtmlToFind(String nomeDono, String nomeUsuarioQueAchou, boolean achou) {
		String html = "<html><head> <meta http-equiv='Content-Type' content='text/html;charset=UTF-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <style>*{margin: 0px; padding: 0px; box-sizing: border-box;}html, body{width: 100%; height: 100%;}.center{position: relative; width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; background-color: #fff;}.modal{position: relative; width: 100%; height: 100%; display: flex; justify-content: center; align-items: center; flex-wrap: wrap;padding: 10px;}.btn{position: relative; width: 50%; height: 50px; display: flex; justify-content: center; align-items: center; cursor: pointer; user-select: none;color: #fff !important;width:100%;text-align: center;text-decoration: none;}.red{background-color: rgb(214, 82, 82);}.red:hover{background-color: rgb(182, 29, 29);}.green{background-color: rgb(95, 189, 95);}.green:hover{background-color: rgb(35, 156, 35);}.content-btn{width: 100%; display: flex; justify-content: center; align-items: center; margin-top: 20px; margin-bottom: 30px;}.content{width: 100%;}.text{padding: 15px 0px; font-family: Verdana, Geneva, Tahoma, sans-serif; text-align: center;}</style></head><body> <div class='center'> <div class='modal'> <div class='content'> ";
		if (achou)
			html += "<p class='text'>Olá <b>" + nomeUsuarioQueAchou + "</b>, " + nomeDono
					+ " confirmou que você achou o pet.<br>Aguarde que em alguns instantes seus pontos serão contabilizados. Parabéns :DD</p>";
		else
			html += "<p class='text'>Olá <b>" + nomeUsuarioQueAchou + "</b>, " + nomeDono
					+ " não confirmou que você achou o pet.<br>Você não receberá pontos.</p>";
		return html;
	}

	public String sendFind(UUID idAnimaAchado, boolean achou) {

		AnimaisAchados animal = animaisAchadosService.getAnimalById(idAnimaAchado);
		if (animal == null) {
			return null;
		}

		String htmlFormatado = this.formatHtmlToFind(animal.getPetPerdido().getUsuario().getNome(),
				animal.getUsuarioAchou().getNome(), achou);

		return sendMailFind(htmlFormatado, animal.getUsuarioAchou(), animal.getPetPerdido().getUsuario());
	}

	public String send(UUID idAnimaAchado) {

		AnimaisAchados animal = animaisAchadosService.getAnimalById(idAnimaAchado);
		if (animal == null) {
			return null;
		}

		String htmlFormatado = this.formatHtml(animal.getPetPerdido().getUsuario().getNome(),
				animal.getUsuarioAchou().getNome(), animal.getId());

		return sendMail(htmlFormatado, animal.getPetPerdido().getUsuario());
	}

}
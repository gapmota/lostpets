package br.lostpets.project.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ServiceGeral {
	
	private Date dataHoraAtual = new Date();
	
	public String getDateHour() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		
		/*SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date hora = Calendar.getInstance().getTime();
		String dataFormatada = sdf.format(hora);*/
		System.out.println("DATA E HORA? "+data + " " + hora);
		return data + " " + hora;
	}
	
	public String getDate() {
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		return data;
	}
	
	public String getHour() {
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		return hora;
	}
	
	
	
}

package br.com.enviando_email;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {

	private String userName = "fernandodiego_web@yahoo.com.br";
	private String senha = "xhzhnkhtznvawkym";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String textoEmail = "";
	
	
	public ObjetoEnviaEmail(String listaDestinatarios, 
							String nomeRemetente, 
							String assuntoEmail, 
							String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.textoEmail = textoEmail;
		
	}

	public void enviarEmail(boolean envioHTML) throws Exception {
		Properties properties = new Properties();

		// CONFIGURAÇÃO EMAIL GMAIL
		/*
		 * properties.put("mail.smtp.ssl.trust", "*"); // Autenticação SSL
		 * properties.put("mail.smtp.auth", "true"); // autorizacao
		 * properties.put("mail.smtp.starttls", "true"); // autenticacao
		 * properties.put("mail.smtp.host", "smtp.gmail.com"); // servidor gmail Google
		 * properties.put("mail.smtp.port", "465"); // porta do servidor
		 * properties.put("mail.smtp.socketFactory.port", "465"); // especifica a porta
		 * a ser conectada pelo socket properties.put("mail.smtp.socketFactory.class",
		 * "javax.net.ssl.SSLSocketFactory");// Classe Socket de
		 */

		// CONFIGURAÇÃO EMAIL YAHOO
		properties.put("mail.smtp.auth", "true"); // autorizacao
		properties.put("mail.smtp.starttls.enable", "true"); // autenticacao
		properties.put("mail.smtp.host", "smtp.mail.yahoo.com"); // servidor gmail Google
		properties.put("mail.smtp.port", "587"); // porta do servidor

		// conexao ao SMTP
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(userName, senha);
			}
		});

		Address[] toUser = InternetAddress.parse(listaDestinatarios);
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, nomeRemetente)); // Quem está enviando
		message.setRecipients(Message.RecipientType.TO, toUser); // para onde será enviado
		message.setSubject(assuntoEmail); // assunto do email
		
		if(envioHTML) {
			message.setContent(textoEmail, "text/html; charset=utf-8"); // envio com HTML
		}else {
			message.setText(textoEmail); // corpo do email		
		}

		Transport.send(message);

	}

}

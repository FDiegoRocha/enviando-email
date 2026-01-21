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

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private String userName = "fernandodiego_web@yahoo.com.br";
	private String senha = "xhzhnkhtznvawkym";

	@org.junit.Test
	public void testeEmail() {

		// Olhe as configurações SMTP do seu email
		try {
			Properties properties = new Properties();
			
			// CONFIGURAÇÃO EMAIL GMAIL
			/*properties.put("mail.smtp.ssl.trust", "*"); // Autneticação SSL 
			properties.put("mail.smtp.auth", "true"); // autorizacao
			properties.put("mail.smtp.starttls", "true"); // autenticacao
			properties.put("mail.smtp.host", "smtp.gmail.com"); // servidor gmail Google
			properties.put("mail.smtp.port", "465"); // porta do servidor
			properties.put("mail.smtp.socketFactory.port", "465"); // especifica a porta a ser conectada pelo socket
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");// Classe Socket de*/
			
			//CONFIGURAÇÃO EMAIL YAHOO
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
			
			Address[] toUser = InternetAddress.parse("fdiego.rs@gmail.com, janmillesaragao@gmail.com, fernandodiego_web@yahoo.com.br");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(userName, "Fernando Diego")); // Quem está enviando
			message.setRecipients(Message.RecipientType.TO, toUser); // para onde será enviado
			message.setSubject("Chegou e-mail enviado com java Yahoo"); // assunto do email
			message.setText("Olá programador, voce acaba de receber um email enviado com Java do curso Formação java Web do Alex pelo email yahoo"); // corpo do email
			
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}

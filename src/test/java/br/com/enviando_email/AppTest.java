package br.com.enviando_email;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	

	@org.junit.Test
	public void testeEmail() throws Exception {
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		stringBuilderTextoEmail.append("Olá, <br/><br/>");
		stringBuilderTextoEmail.append("Voçê está recebendo o acesso ao curso de Java. <br/><br/>");
		stringBuilderTextoEmail.append("Para ter acesso clique no botão abaixo. <br/><br/>");
		
		stringBuilderTextoEmail.append("<b>Login:</b> Diego@gmail.com <br/>");
		stringBuilderTextoEmail.append("<b>Senha:</b> Diego1234 <br/><br/>");
		
		stringBuilderTextoEmail.append("<a target=\"_blank\" href=\"http://projetojavaweb.com/certificado-aluno/login\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration:none; display:inline-block; border-radius:30px; font-size:20px; font-family:courier; border: 3px solid green; background-color:#99DA39;\">Acessar Portal do Aluno</a><br/><br/>");
		
		stringBuilderTextoEmail.append("<span style=\"font-size:8px\">Ass.: Diego Rocha </span>");

		ObjetoEnviaEmail enviarEmail = new ObjetoEnviaEmail("fdiego.rs@gmail.com, janmillesaragao@gmail.com, fernandodiego_web@yahoo.com.br",
															"Fernando Diego", 
															"Testando Email com javamail", 
															stringBuilderTextoEmail.toString());
		
		
		enviarEmail.enviarEmail(true);
	}

}

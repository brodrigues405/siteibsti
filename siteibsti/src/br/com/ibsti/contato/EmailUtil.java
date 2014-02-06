/**
 * 
 */
package br.com.ibsti.contato;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @author v0rtex
 *
 */
public class EmailUtil {
	/**
	 * Metodo responsavel por enviar o email.
	 * 
	 * @param usuario - O usuario que ira autenticar no smtp.
	 * @param senha - A senha do usuario que autentica no smtp;
	 * @param titulo - O assunto do email
	 * @param mensagem - O corpo do email
	 * @param destinatario - O destinatario
	 * @param nomeDestinatario - O nome do destinatario
	 * @param smtp - O endereco do smtp.
	 */
	public static boolean enviarEmail(String usuario, String senha, String titulo, String mensagem, String destinatario, String nomeDestinatario, String smtp) {
 
		boolean retorno = false;
		
		SimpleEmail email = new SimpleEmail();
		
		//Utilize o hostname do seu provedor de email
		//email.setHostName("smtp.gmail.com");
		email.setHostName(smtp);
		
		//Quando a porta utilizada não é a padrão (gmail = 465)
		email.setSmtpPort(587);
		
		try {
			//Adicione os destinatários
			email.addTo(destinatario, nomeDestinatario);

			//Configure o seu email do qual enviará - email do remetente, nome do remetente.
			email.setFrom("sistemas@ibsti.com.br", "Contato IBSTI");
			
			//Adicione um assunto
			email.setSubject(titulo);
			
			//Adicione a mensagem do email
			email.setMsg(mensagem);
			
			//Efetua a autenticacao do email.
			//email.setSSL(true);	//Habilita o ssl na autenticacao, use no gmail
			email.setTLS(true);	//Habilita o tls, use na kinghost
		
			//Envia o usuario e a senha
			email.setAuthentication(usuario, senha); 

			//Envia o email.
			email.send();
			
			retorno = true;
		}
		catch (EmailException e) {
			e.printStackTrace();
		}			
		
		return retorno;
	}

}

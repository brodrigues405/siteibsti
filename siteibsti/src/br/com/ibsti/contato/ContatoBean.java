package br.com.ibsti.contato;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.x104.jsf.WebUtil;

/**
 * @author v0rtex
 *
 */

@ManagedBean
@RequestScoped
public class ContatoBean {
	
	private String nome;
	private String email;
	private String mensagem;
	private String setor;
	
	/**
	 * Metodo responsavel por enviar a mensagem do contato.
	 */
	public void enviarMensagem() {
		
		String smtp = "smtp.ibsti.com.br";
		String login = "sistemas@ibsti.com.br";
		String senha = "515t3m451b5t1";
		String destinario = "contato@ibsti.com.br";
		
		String msgView = "Erro, por favor tente novamente.";
		
		StringBuffer sb = new StringBuffer("");
		sb.append("Nome: ");
		sb.append(this.nome);
		sb.append("\nEmail: ");
		sb.append(this.email);
		sb.append("\nMensagem: ");
		sb.append(this.mensagem);
		
		if(EmailUtil.enviarEmail(login, senha, "Mensagem enviada pelo site", sb.toString(), 
				destinario, this.nome, smtp)) {
			msgView = "Mensagem enviada com sucesso, entraremos em contato!";
		}
		
		WebUtil.enviarMsg(msgView);
	}

	/**
	 * @return o nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome o nome para setar
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return o email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email o email para setar
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return o mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}

	/**
	 * @param mensagem o mensagem para setar
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	/**
	 * @return o setor
	 */
	public String getSetor() {
		return setor;
	}

	/**
	 * @param setor o setor para setar
	 */
	public void setSetor(String setor) {
		this.setor = setor;
	}
}
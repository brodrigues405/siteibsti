package org.x104.jsf;
import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;


/**
 * Classe com metodos uteis para lidar com jsf.
 * 
 * @author v0rtex
 * @since 0.5
 */
public class WebUtil {

	/**
	 * Recupera o EntityManager, que foi instanciado pelo JPAFilter.
	 * 
	 * @return
	
	public static EntityManager getEntityManager() {		
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		EntityManager manager = (EntityManager) request.getAttribute("EntityManager");		
		
		return manager;
	} */
	
	/**
	 * Metodo que envia uma mensagem informativa para a tela.
	 * 
	 * @param msg
	 */
	public static void enviarMsg(String msg) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg , null);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	

	/**
	 * Metodo que envia uma mensagem de aviso para a tela.
	 * 
	 * @param msg
	 */
	public static void enviarMsgAviso(String msg) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, msg , null);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	/**
	 * Metodo que envia uma mensagem  de erro para a tela.
	 * 
	 * @param msg
	 */
	public static void enviarMsgErro(String msg) {
		FacesMessage fm = new FacesMessage(msg) ;
		fm.setSeverity(FacesMessage.SEVERITY_ERROR ) ;
		FacesContext.getCurrentInstance().addMessage(null, fm) ;
	}
	
	/**
	 * Metodo que envia uma mensagem de erro fatal para a tela.
	 * 
	 * @param msg
	 */
	public static void enviarMsgFatal(String msg) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg , null);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	/**
	 * Metodo que efetua o redirecionamento de pagina.
	 * Utiliza JSF;
	 * 
	 * @param pagina - Pagina destino onde devera redirecionar.
	 */
	public static void redirecionar(String pagina) {
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}	

	/**
	 * Metodo responsavel por criar a sessao e setar os atributos.
	 * 
	 * @param login - Login do usuario.
	 * @param id - Id do usuario.
	 */
	@Deprecated
	public static void setLogin(String login) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(true);
		session.setAttribute("usuario", login);
	}
	
	/**
	 * Metodo responsavel por criar a sessao e setar os atributos.
	 * Utilizando JSF.
	 *  
	 * @param login - Login do usuario.
	 * @param id - Id do usuario.
	 */
	public static void setSessao(String chave, String valor) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(true);
		session.setAttribute(chave, valor);
	}
	
	/**
	 * Metodo que remove os atributos da sessao e finaliza esta.
	 * Utilizando JSF.
	 * 
	 * @param atributo
	 */
	public static void finalizaSessao(List<String> atributo) {

		//Recupera sessao
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		
		//Remove os atributos da sessao
		for (String string : atributo) {
			session.removeAttribute(string);
		}
	
		//Mata a sessao
		session.invalidate();
	}
}

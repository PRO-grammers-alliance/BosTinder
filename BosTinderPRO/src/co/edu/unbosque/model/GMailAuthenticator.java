package co.edu.unbosque.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GMailAuthenticator extends  Authenticator {
	
	private String user;
	private String psw;
	/**
	 * Autentifica el usuario y la contrase�a que permiten el acceso al servidor de emails
	 * @param username
	 * @param password
	 */
	public GMailAuthenticator (String username, String password)
    {
       super();
       this.user = username;
       this.psw = password;
    }
	/**
	 * devuelve el usuario y contrase�a ya autentificados.
	 */
   public PasswordAuthentication getPasswordAuthentication()
   {
      return new PasswordAuthentication(user, psw);
   }

}

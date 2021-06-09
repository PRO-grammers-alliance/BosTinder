package co.edu.unbosque.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
/**
 * Esta clase hereda de la clase Authenticator para validar el usuario y la contraseña con el que se intenta ingresar al servidor smtp y devolverlos autentificados para su correcto funcionamiento.
 * @author FELIPE SEGURA
 *
 */
public class GMailAuthenticator extends  Authenticator {
	
	private String user;
	private String psw;
	/**
	 * Autentifica el usuario y la contraseña que permiten el acceso al servidor de emails
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
	 * devuelve el usuario y contraseña ya autentificados.
	 */
   public PasswordAuthentication getPasswordAuthentication()
   {
      return new PasswordAuthentication(user, psw);
   }

}

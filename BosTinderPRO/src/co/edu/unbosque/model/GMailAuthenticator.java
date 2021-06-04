package co.edu.unbosque.model;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class GMailAuthenticator extends  Authenticator {
	
	private String user;
	private String psw;
	
	public GMailAuthenticator (String username, String password)
    {
       super();
       this.user = username;
       this.psw = password;
    }
   public PasswordAuthentication getPasswordAuthentication()
   {
      return new PasswordAuthentication(user, psw);
   }

}

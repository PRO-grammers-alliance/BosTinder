package co.edu.unbosque.model;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	private final Properties Properties = new Properties();

	private String contraseña;

	private Session sesion;
/**
 * Inicializacion de las propiedades para el envio de correos
 */
	private void init() {

		Properties.put("mail.smtp.host", "smtp.gmail.com");
		Properties.put("mail.smtp.starttls.enable", "true");
		Properties.put("mail.smtp.port", 587);
		Properties.put("mail.smtp.mail.sender", "Programmers.allianse@gmail.com");
		Properties.put("mail.smtp.user", "Programmers.allianse@gmail.com");
		Properties.put("mail.smtp.auth", "true");
		contraseña = "PRO-grammers1234";
		sesion = sesion.getDefaultInstance(Properties, new GMailAuthenticator((String)Properties.get("mail.smtp.user"), contraseña));	
	}
/**
 * enviarMail utiliza las propiedades para conectar con el servidor de emails, envia un mensaje personalizado con el usuario y la contraseña .
 * @param nombre
 * @param usuario
 * @param correo
 * @param contraseña
 */
	public void enviarMail(String nombre, String usuario, String correo, String contraseña) {
		init();
		try {
			MimeMessage mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress((String)Properties.get("mail.smtp.mail.sender")));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
			mensaje.setSubject("Confirmacion Bos Tinder");
			mensaje.setText("BIENVENID@ A BOS TINDER!!!!\nEstimad@ "+nombre+".\nNos alegra que te hayas unido a nuestra comunida =)<3=).\nEsperamos encuentres pareja pronto.\nNombre de usuario : "+usuario+"\nContraseña : "+contraseña+"\nTe deseamos lo mejor.\n\n\n\nPor favor no responder este correo,Este correo fue enviado de forma automatica.");
			Transport t = sesion.getTransport("smtp");
			t.connect((String)Properties.get("mail.smtp.host"),(String)Properties.get("mail.smtp.user"),this.contraseña);
			t.sendMessage(mensaje, mensaje.getAllRecipients());
			t.close();
		}catch(MessagingException e){
			System.out.println("fallo email");
			e.printStackTrace();
		}
		
	}

}

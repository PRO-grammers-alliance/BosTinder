package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;

import javax.swing.ImageIcon;

import co.edu.unbosque.model.BosTinder;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener {

	private View vista;
	private BosTinder bosT;

	private String fecha;
	private String sex;
	private String divorcios;
	private int estatura;
	private double ingresos;
	private int i;

	public Controller() {
		vista = new View();
		bosT = new BosTinder();
		asignarOyentes();
		bosT.getMaFi().leerCsv();
	}

	public void asignarOyentes() {
		vista.getvIng().getpIngreso().getB_ingresar().addActionListener(this);
		vista.getvIng().getpIngreso().getB_registro().addActionListener(this);
		vista.getvEdad().getpEdad().getB_validar().addActionListener(this);
		vista.getvReg().getpRegistro().getValidarRegistro().addActionListener(this);
		vista.getvPri().getPu().getLike().addActionListener(this);
		vista.getvPri().getPu().getDislike().addActionListener(this);
		vista.getvReg().getpRegistro().getSexoH().addActionListener(this);
		vista.getvReg().getpRegistro().getSexoM().addActionListener(this);
		vista.getvAdm().getPConsul().getBox_ordenar().addActionListener(this);
		vista.getvAdm().getPConsul().getB_ascendente().addActionListener(this);
		vista.getvAdm().getPConsul().getB_descendente().addActionListener(this);
		vista.getvAdm().getPConsul().getBox_filtrar().addActionListener(this);
		vista.getvReg().getpRegistro().getDivorcioNo().addActionListener(this);
		vista.getvReg().getpRegistro().getDivorcioSi().addActionListener(this);
		vista.getvAdm().getpInf().getBox_Edad1().addActionListener(this);
		vista.getvAdm().getpInf().getBox_Edad2().addActionListener(this);
		vista.getvAdm().getpInf().getBox_Edad3().addActionListener(this);
		vista.getvAdm().getpInf().getBox_Ingresos1().addActionListener(this);
		vista.getvAdm().getpInf().getBox_Ingresos2().addActionListener(this);
		vista.getvAdm().getpInf().getBox_Ingresos3().addActionListener(this);
		vista.getvAdm().getpInf().getBox_LikesOt1().addActionListener(this);
		vista.getvAdm().getpInf().getBox_LikesOt2().addActionListener(this);
		vista.getvAdm().getpInf().getBox_LikesOt3().addActionListener(this);
		vista.getvAdm().getpInf().getBox_LikesRec1().addActionListener(this);
		vista.getvAdm().getpInf().getBox_LikesRec2().addActionListener(this);
		vista.getvAdm().getpInf().getBox_LikesRec3().addActionListener(this);
		vista.getvAdm().getpInf().getB_GenerarInf().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		if (arg0.getActionCommand().equals("INGRESAR")) {
			String user = vista.getvIng().getpIngreso().getC_usuario().getText();
			char[] clave = vista.getvIng().getpIngreso().getC_clave().getPassword();
			String claveT = String.valueOf(clave);

			if (bosT.getValIn().comprobarLoginAdmin(user, claveT)) {
				vista.getvIng().setVisible(false);
				vista.getvAdm().setVisible(true);
			} else if (bosT.validarLogin(user, claveT)) {
				int j =bosT.usuarioRandom();
				if(j==0) {
					vista.getvPri().getPu().getFotoSecreta().setVisible(true);
				}else if(j==1) {
					vista.getvPri().getPu().getFotoSecreta1().setVisible(true);
				}else if(j==2) {
					vista.getvPri().getPu().getFotoSecreta2().setVisible(true);
				}
				i = bosT.usuarioRandom(bosT.getMaFi().getId().size());
				vista.getvPri().getPu().getNombreCompleto().setText(bosT.getMaFi().getNombre().get(i) + " "
						+ bosT.getMaFi().getApellido1().get(i) + " " + bosT.getMaFi().getApellido2().get(i));
				vista.getvPri().getPu().getEdadNumero().setText(bosT.getMaFi().getEdad().get(i)+"");
				vista.getvPri().getPu().getMoney().setText(bosT.getMaFi().getIngresos().get(i) + "");
				if (bosT.getMaFi().getSexo().get(i).equals("M")) {
					vista.getvPri().getPu().getGenero().setText("Femenino");
					vista.getvPri().getPu().getEstatura().setVisible(false);
					vista.getvPri().getPu().getDivircios().setVisible(true);
					vista.getvPri().getPu().getEoD().setText(bosT.getMaFi().getDivorcios().get(i));
				} else if (bosT.getMaFi().getSexo().get(i).equals("H")) {
					vista.getvPri().getPu().getGenero().setText("Masculino");
					vista.getvPri().getPu().getEstatura().setVisible(true);
					vista.getvPri().getPu().getDivircios().setVisible(false);
					vista.getvPri().getPu().getEoD().setText(bosT.getMaFi().getEstatura().get(i) + "");
				}
				
				vista.getvIng().setVisible(false);
				vista.getvPri().setVisible(true);
			} else {
				vista.getvIng().getpIngreso().getC_usuario().setText("");
				vista.getvIng().getpIngreso().getC_clave().setText("");
				vista.mostrarMensaje("Ingrese un usuario y contrase�a v�lidos", "error");
			}
		}

		if (arg0.getActionCommand().equals("REGISTRO")) {
			vista.getvEdad().getpEdad().getA�o().setText("");
			vista.getvEdad().getpEdad().getMes().setText("");
			vista.getvEdad().getpEdad().getDia().setText("");
			vista.getvIng().setVisible(false);
			vista.getvEdad().setVisible(true);
		}

		if (arg0.getActionCommand().equals("VALIDAR")) {
			String a�o = vista.getvEdad().getpEdad().getA�o().getText();
			String mes = vista.getvEdad().getpEdad().getMes().getText();
			String dia = vista.getvEdad().getpEdad().getDia().getText();
			fecha = dia + "/" + mes + "/" + a�o;
			try {
				if (bosT.getValIn().validadEdad(fecha)) {
					vista.getvEdad().setVisible(false);
					vista.getvReg().setVisible(true);
				} else {
					vista.mostrarMensaje(
							"Debe ser mayor de edad" + "\n" + "para poder usar BosTinder" + "\n" + "Hasta pronto",
							"error");
					vista.getvReg().setVisible(false);
					vista.getvIng().setVisible(true);
				}
			} catch (DateTimeParseException e) {
				vista.mostrarMensaje("Ingrese fecha v�lida DD/MM/YYYY", "error");
				vista.getvEdad().getpEdad().getA�o().setText("");
				vista.getvEdad().getpEdad().getMes().setText("");
				vista.getvEdad().getpEdad().getDia().setText("");
			}
		}

		if (arg0.getActionCommand().equals("HOMBRE")) {
			if (vista.getvReg().getpRegistro().getSexoH().isSelected()) {
				vista.getvReg().getpRegistro().getSexoM().setSelected(false);
				sex = "H";
				divorcios = "No Aplica";
				vista.getvReg().getpRegistro().getTextoEstatura().setVisible(true);
				vista.getvReg().getpRegistro().getEstatura().setVisible(true);
				vista.getvReg().getpRegistro().getTextoIngresosM().setVisible(true);
				vista.getvReg().getpRegistro().getIngresosM().setVisible(true);
				vista.getvReg().getpRegistro().getTextoDivorcio().setVisible(false);
				vista.getvReg().getpRegistro().getDivorcioSi().setVisible(false);
				vista.getvReg().getpRegistro().getDivorcioNo().setVisible(false);
			} else if (!vista.getvReg().getpRegistro().getSexoH().isSelected()) {
				vista.getvReg().getpRegistro().getSexoM().setSelected(true);
				sex = "M";
				vista.getvReg().getpRegistro().getTextoEstatura().setVisible(false);
				vista.getvReg().getpRegistro().getEstatura().setVisible(false);
				vista.getvReg().getpRegistro().getTextoIngresosM().setVisible(false);
				vista.getvReg().getpRegistro().getIngresosM().setVisible(false);
				vista.getvReg().getpRegistro().getTextoDivorcio().setVisible(true);
				vista.getvReg().getpRegistro().getDivorcioSi().setVisible(true);
				vista.getvReg().getpRegistro().getDivorcioNo().setVisible(true);
			}
		}

		if (arg0.getActionCommand().equals("MUJER")) {
			if (vista.getvReg().getpRegistro().getSexoM().isSelected()) {
				vista.getvReg().getpRegistro().getSexoH().setSelected(false);
				sex = "M";
				vista.getvReg().getpRegistro().getTextoEstatura().setVisible(false);
				vista.getvReg().getpRegistro().getEstatura().setVisible(false);
				vista.getvReg().getpRegistro().getTextoDivorcio().setVisible(true);
				vista.getvReg().getpRegistro().getDivorcioSi().setVisible(true);
				vista.getvReg().getpRegistro().getDivorcioNo().setVisible(true);
				vista.getvReg().getpRegistro().getTextoIngresosM().setVisible(false);
				vista.getvReg().getpRegistro().getIngresosM().setVisible(false);
			} else if (!vista.getvReg().getpRegistro().getSexoM().isSelected()) {
				vista.getvReg().getpRegistro().getSexoH().setSelected(true);
				sex = "H";
				divorcios = "No Aplica";
				vista.getvReg().getpRegistro().getTextoEstatura().setVisible(true);
				vista.getvReg().getpRegistro().getEstatura().setVisible(true);
				vista.getvReg().getpRegistro().getTextoDivorcio().setVisible(false);
				vista.getvReg().getpRegistro().getDivorcioSi().setVisible(false);
				vista.getvReg().getpRegistro().getDivorcioNo().setVisible(false);
			}
		}

		if (arg0.getActionCommand().equals("DVSI")) {
			if (vista.getvReg().getpRegistro().getDivorcioSi().isSelected()) {
				vista.getvReg().getpRegistro().getDivorcioNo().setSelected(false);
				divorcios = "Si";
			} else if (!vista.getvReg().getpRegistro().getDivorcioSi().isSelected()) {
				vista.getvReg().getpRegistro().getDivorcioNo().setSelected(true);
				divorcios = "No";
			}
		}

		if (arg0.getActionCommand().equals("DVNO")) {
			if (vista.getvReg().getpRegistro().getDivorcioNo().isSelected()) {
				vista.getvReg().getpRegistro().getDivorcioSi().setSelected(false);
				divorcios = "No";
			} else if (!vista.getvReg().getpRegistro().getDivorcioNo().isSelected()) {
				vista.getvReg().getpRegistro().getDivorcioSi().setSelected(true);
				divorcios = "Si";
			}
		}

		if (arg0.getActionCommand().equals("VALIDARREGISTRO")) {
			try {
				String nombre = vista.getvReg().getpRegistro().getNombreU().getText();
				String apellido1 = vista.getvReg().getpRegistro().getApellido1().getText();
				String apellido2 = vista.getvReg().getpRegistro().getApellido2().getText();
				String user = vista.getvReg().getpRegistro().getAlias().getText();
				String contrase�a = vista.getvReg().getpRegistro().getContrase�a().getText();
				String contrase�a1 = vista.getvReg().getpRegistro().getConfirmarC().getText();
				String correo = vista.getvReg().getpRegistro().getCorreoE().getText();
				String correo1 = vista.getvReg().getpRegistro().getConfirmarCorreo().getText();
				if (vista.getvReg().getpRegistro().getEstatura().getText().equals("")) {
					estatura = 0;
				} else {
					estatura = Integer.parseInt(vista.getvReg().getpRegistro().getEstatura().getText());
				}
				if (vista.getvReg().getpRegistro().getIngresosM().getText().equals("")) {
					ingresos = 0;
				} else {
					ingresos = Double.parseDouble(vista.getvReg().getpRegistro().getIngresosM().getText());
				}

				String validacion = bosT.validacionR(nombre, apellido1, apellido2, user, contrase�a, contrase�a1,
						correo, correo1, estatura, ingresos);

				if (validacion == "error1") {
					vista.mostrarMensaje("Por favor ingrese su nombre, primer apellido y segundo apellido sin n�meros",
							"error");
				} else if (validacion == "error2") {
					vista.mostrarMensaje("El username ya existe por favor ingrese otro", "error");
				} else if (validacion == "error3") {
					vista.mostrarMensaje("Su contrase�a no coincide", "error");
				} else if (validacion == "error4") {
					vista.mostrarMensaje("Su correo no coincide", "error");
				} else if (validacion == "error5") {
					vista.mostrarMensaje("Por favor ingrese un correo v�lido", "error");
				} else if (validacion == "no") {
					int newId = bosT.getMaFi().getId().size() + 1;
					int edad = bosT.getValIn().getEdad1();
					// bosT.getMail().enviarMail(nombre, user, correo, contrase�a);
					bosT.a�adirUsuario(newId, nombre, apellido1, apellido2, sex, user, contrase�a, correo, fecha, edad,
							ingresos, divorcios, 0, 0, estatura, 0, "Disponible");
					bosT.getMaFi().escribirArchivo();
					vista.getvReg().setVisible(false);
					vista.getvReg().getpRegistro().getNombreU().setText("");
					vista.getvReg().getpRegistro().getApellido1().setText("");
					vista.getvReg().getpRegistro().getApellido2().setText("");
					vista.getvReg().getpRegistro().getCorreoE().setText("");
					vista.getvReg().getpRegistro().getConfirmarCorreo().setText("");
					vista.getvReg().getpRegistro().getAlias().setText("");
					vista.getvReg().getpRegistro().getContrase�a().setText("");
					vista.getvReg().getpRegistro().getConfirmarC().setText("");
					vista.getvReg().getpRegistro().getEstatura().setText("");
					vista.getvReg().getpRegistro().getIngresosM().setText("");
					vista.getvIng().setVisible(true);
				}
			} catch (NumberFormatException e) {
				vista.mostrarMensaje(
						"Ingrese un n�mero v�lido.\nSi sus ingresos son en decimales separelos por un punto ej: xx.x\nSu edad debe estar en cent�metros sin decimales",
						"error");
			}
		}

		if (arg0.getActionCommand().equals("LIKE")) {
			int j =bosT.usuarioRandom();
			if(j==0) {
				vista.getvPri().getPu().getFotoSecreta().setVisible(true);
				vista.getvPri().getPu().getFotoSecreta1().setVisible(false);
				vista.getvPri().getPu().getFotoSecreta2().setVisible(false);
			}else if(j==1) {
				vista.getvPri().getPu().getFotoSecreta1().setVisible(true);
				vista.getvPri().getPu().getFotoSecreta2().setVisible(false);
				vista.getvPri().getPu().getFotoSecreta().setVisible(false);
			}else if(j==2) {
				vista.getvPri().getPu().getFotoSecreta2().setVisible(true);
				vista.getvPri().getPu().getFotoSecreta().setVisible(false);
				vista.getvPri().getPu().getFotoSecreta1().setVisible(false);
			}
			bosT.getMaFi().getNumeroLikesRecibidos().set(i, bosT.getMaFi().getNumeroLikesRecibidos().get(i) + 1);
			bosT.getMaFi().getNumeroLikesOtorgados().set(bosT.getPosicionU(),bosT.getMaFi().getNumeroLikesOtorgados().get(bosT.getPosicionU()) + 1);
			bosT.getMaFi().escribirArchivo();
			i = bosT.usuarioRandom(bosT.getMaFi().getId().size());
			vista.getvPri().getPu().getNombreCompleto().setText(bosT.getMaFi().getNombre().get(i) + " "+ bosT.getMaFi().getApellido1().get(i) + " " + bosT.getMaFi().getApellido2().get(i));
			vista.getvPri().getPu().getMoney().setText(bosT.getMaFi().getIngresos().get(i) + "");
			vista.getvPri().getPu().getEdadNumero().setText(bosT.getMaFi().getEdad().get(i)+"");
			if (bosT.getMaFi().getSexo().get(i).equals("M")) {
				vista.getvPri().getPu().getGenero().setText("Femenino");
				vista.getvPri().getPu().getEstatura().setVisible(false);
				vista.getvPri().getPu().getDivircios().setVisible(true);
				vista.getvPri().getPu().getEoD().setText(bosT.getMaFi().getDivorcios().get(i));
			} else if (bosT.getMaFi().getSexo().get(i).equals("H")) {
				vista.getvPri().getPu().getGenero().setText("Masculino");
				vista.getvPri().getPu().getEstatura().setVisible(true);
				vista.getvPri().getPu().getDivircios().setVisible(false);
				vista.getvPri().getPu().getEoD().setText(bosT.getMaFi().getEstatura().get(i) + "");
			}
		}

		if (arg0.getActionCommand().equals("NOLIKE")) {
			int j =bosT.usuarioRandom();
			if(j==0) {
				vista.getvPri().getPu().getFotoSecreta().setVisible(true);
				vista.getvPri().getPu().getFotoSecreta1().setVisible(false);
				vista.getvPri().getPu().getFotoSecreta2().setVisible(false);
			}else if(j==1) {
				vista.getvPri().getPu().getFotoSecreta1().setVisible(true);
				vista.getvPri().getPu().getFotoSecreta2().setVisible(false);
				vista.getvPri().getPu().getFotoSecreta().setVisible(false);
			}else if(j==2) {
				vista.getvPri().getPu().getFotoSecreta2().setVisible(true);
				vista.getvPri().getPu().getFotoSecreta().setVisible(false);
				vista.getvPri().getPu().getFotoSecreta1().setVisible(false);
			}
			i = bosT.usuarioRandom(bosT.getMaFi().getId().size());
			vista.getvPri().getPu().getNombreCompleto().setText(bosT.getMaFi().getNombre().get(i) + " "+ bosT.getMaFi().getApellido1().get(i) + " " + bosT.getMaFi().getApellido2().get(i));
			vista.getvPri().getPu().getMoney().setText(bosT.getMaFi().getIngresos().get(i) + "");
			vista.getvPri().getPu().getEdadNumero().setText(bosT.getMaFi().getEdad().get(i)+"");
			if (bosT.getMaFi().getSexo().get(i).equals("M")) {
				vista.getvPri().getPu().getGenero().setText("Femenino");
				vista.getvPri().getPu().getEstatura().setVisible(false);
				vista.getvPri().getPu().getDivircios().setVisible(true);
				vista.getvPri().getPu().getEoD().setText(bosT.getMaFi().getDivorcios().get(i));
			} else if (bosT.getMaFi().getSexo().get(i).equals("H")) {
				vista.getvPri().getPu().getGenero().setText("Masculino");
				vista.getvPri().getPu().getEstatura().setVisible(true);
				vista.getvPri().getPu().getDivircios().setVisible(false);
				vista.getvPri().getPu().getEoD().setText(bosT.getMaFi().getEstatura().get(i) + "");
			}
		}
		
		if (arg0.getActionCommand().equals("ORDENAR")) {
			String item = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
			if (item.equals("Nombre")) {
				if(vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info().setText("xd");
					
				}else{
					vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().orden("Nombre", bosT.getMaFi().getId().size(),
					bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
					bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
					bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
					bosT.getMaFi().getIngresos()));
				}
				
			} else if (item.equals("Apellido")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().orden("Apellido", bosT.getMaFi().getId().size(),
				bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
				bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
				bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
				bosT.getMaFi().getIngresos()));
			} else if (item.equals("Edad")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().orden("Edad", bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(),
				bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
				bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
				bosT.getMaFi().getNumeroLikesOtorgados(), bosT.getMaFi().getIngresos()));
			} else if (item.equals("Alias")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().orden("Alias", bosT.getMaFi().getId().size(),
				bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
				bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
				bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
				bosT.getMaFi().getIngresos()));
			} else if (item.equals("N�mero Likes")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().orden("Likes", bosT.getMaFi().getId().size(),
				bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
				bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
				bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
				bosT.getMaFi().getIngresos()));
			} else {
				vista.getvAdm().getPConsul().getT_info().setText("");
			}
		}
		/**
		 * Ascendente
		 */
		if (arg0.getActionCommand().equals("ASCENDENTE")) {
			if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_descendente().setSelected(false);
				String item = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
				if (item.equals("Nombre")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("Apellido")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Apellido", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("Edad")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Edad", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("Alias")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Alias", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("N�mero Likes")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Likes", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else {
					vista.getvAdm().getPConsul().getT_info().setText("");
				}
			} else if (!vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_descendente().setSelected(true);
			}
		}
		/**
		 * Descendente
		 */
		if (arg0.getActionCommand().equals("DESCENDENTE")) {
			if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_ascendente().setSelected(false);
				String item = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
				String item2 = vista.getvAdm().getPConsul().getBox_filtrar().getSelectedItem().toString();
				if (item.equals("Nombre") && item2.equals("Sin Filtro")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("Nombre") && item2.equals("Top 10 M�s Likes")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Apellido", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()) + "Falta el top 10");
				} else if (item.equals("Nombre") && item2.equals("Ingresos >= a 244.85 USD")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("Apellido")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Apellido", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("Edad")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Edad", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("Alias")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Alias", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (item.equals("N�mero Likes")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Likes", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else {
					vista.getvAdm().getPConsul().getT_info().setText("");
				}
			} else if (!vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_ascendente().setSelected(true);
			}
		}
		/**
		 * Filtros: Sin filtros, Top 10 m�s likes, Ingresos >= a 244.85 USD, Genero
		 */
		if (arg0.getActionCommand().equals("FILTRAR")) {
			String item = vista.getvAdm().getPConsul().getBox_filtrar().getSelectedItem().toString();
			String item2 = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
			//Sin filtro
			if (item.equals("Sin Filtro") && item2.equals("Nombre")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().orden("Nombre", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("Sin Filtro") && item2.equals("Apellido")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().orden("Apellido", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("Sin Filtro") && item2.equals("Edad")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().orden("Edad", bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(),
								bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
								bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
								bosT.getMaFi().getNumeroLikesOtorgados(), bosT.getMaFi().getIngresos()));
			} else if (item.equals("Sin Filtro") && item2.equals("Alias")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().orden("Alias", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("Sin Filtro") && item2.equals("N�mero Likes")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().orden("Likes", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
				//Filtro top 10 m�s likes
			} else if (item.equals("Top 10 M�s Likes")) {
				// FALTA CODIGO
				
				//Ingresos Mayores a 244.85
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Nombre")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().filtroIngresos(
						bosT.getMaFi().getId().size(), bosT.getMaFi().getIngresos(), bosT.getMaFi().getNombre()));
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Apellido")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().filtroIngresos(
						bosT.getMaFi().getId().size(), bosT.getMaFi().getIngresos(), bosT.getMaFi().getApellido1()));
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Edad")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().filtroIngresosE(
						bosT.getMaFi().getId().size(), bosT.getMaFi().getIngresos(), bosT.getMaFi().getEdad()));
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Alias")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().filtroIngresos(
						bosT.getMaFi().getId().size(), bosT.getMaFi().getIngresos(), bosT.getMaFi().getUsuario()));
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("N�mero Likes")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().filtroIngresosE(bosT.getMaFi().getId().size(),
								bosT.getMaFi().getIngresos(), bosT.getMaFi().getNumeroLikesRecibidos()));
				//Filtros de genero
			} else if (item.equals("G�nero M") && item2.equals("�Qu� desea buscar?")) {
				vista.getvAdm().getPConsul().getT_info().setText("");
			} else if (item.equals("G�nero M") && item2.equals("Nombre")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().generoM("Nombre", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("G�nero M") && item2.equals("Apellido")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().generoM("Apellido", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("G�nero M") && item2.equals("Edad")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().generoM("Edad", bosT.getMaFi().getId().size(), bosT.getMaFi().getSexo(),
								bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("G�nero M") && item2.equals("Alias")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().generoM("Alias", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("G�nero M") && item2.equals("N�mero Likes")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().generoM("Likes", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
				
			} else if (item.equals("G�nero H") && item2.equals("Nombre")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().generoH("Apellido", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("G�nero H") && item2.equals("Apellido")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().generoH("Apellido", bosT.getMaFi().getId().size(),
								bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
								bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
								bosT.getMaFi().getIngresos()));
			}else if (item.equals("G�nero H") && item2.equals("Edad")) {
				vista.getvAdm().getPConsul().getT_info()
				.setText(bosT.getCrud().generoH("Edad", bosT.getMaFi().getId().size(),
						bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
						bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
						bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
						bosT.getMaFi().getIngresos()));
			}else if (item.equals("G�nero H") && item2.equals("Alias")) {
				vista.getvAdm().getPConsul().getT_info()
				.setText(bosT.getCrud().generoH("Alias", bosT.getMaFi().getId().size(),
						bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
						bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
						bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
						bosT.getMaFi().getIngresos()));
			}else if (item.equals("G�nero H") && item2.equals("N�mero Likes")) {
				vista.getvAdm().getPConsul().getT_info()
				.setText(bosT.getCrud().generoH("Likes", bosT.getMaFi().getId().size(),
						bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
						bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
						bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
						bosT.getMaFi().getIngresos()));
			}
		}
	}
}

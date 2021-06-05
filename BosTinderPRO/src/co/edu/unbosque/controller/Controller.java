package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;

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
		vista.getvReg().getpEdad().getB_validar().addActionListener(this);
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
				i = bosT.usuarioRandom(bosT.getMaFi().getId().size());
				vista.getvPri().getPu().getNombreCompleto().setText(bosT.getMaFi().getNombre().get(i) + " "
						+ bosT.getMaFi().getApellido1().get(i) + " " + bosT.getMaFi().getApellido2().get(i));
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
				vista.mostrarMensaje("Ingrese un usuario y contraseña válidos", "error");
			}
		}

		if (arg0.getActionCommand().equals("REGISTRO")) {
			vista.getvReg().setBounds(0, 0, 300, 300);
			vista.getvReg().remove(vista.getvReg().getpRegistro());
			vista.getvReg().add(vista.getvReg().getpEdad());
			vista.getvReg().getpEdad().getAño().setText("");
			vista.getvReg().getpEdad().getMes().setText("");
			vista.getvReg().getpEdad().getDia().setText("");
			vista.getvIng().setVisible(false);
			vista.getvReg().setVisible(true);
		}

		if (arg0.getActionCommand().equals("VALIDAR")) {
			String año = vista.getvReg().getpEdad().getAño().getText();
			String mes = vista.getvReg().getpEdad().getMes().getText();
			String dia = vista.getvReg().getpEdad().getDia().getText();
			fecha = dia + "/" + mes + "/" + año;
			try {
				if (bosT.getValIn().validadEdad(fecha)) {
					vista.getvReg().setBounds(0, 0, 625, 429);
					vista.getvReg().remove(vista.getvReg().getpEdad());
					vista.getvReg().add(vista.getvReg().getpRegistro());
					vista.getvReg().getpRegistro().setVisible(true);
				} else {
					vista.mostrarMensaje(
							"Debe ser mayor de edad" + "\n" + "para poder usar BosTinder" + "\n" + "Hasta pronto",
							"error");
					vista.getvReg().setVisible(false);
					vista.getvIng().setVisible(true);
				}
			} catch (DateTimeParseException e) {
				vista.mostrarMensaje("Ingrese fecha válida DD/MM/YYYY", "error");
				vista.getvReg().getpEdad().getAño().setText("");
				vista.getvReg().getpEdad().getMes().setText("");
				vista.getvReg().getpEdad().getDia().setText("");
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
				String contraseña = vista.getvReg().getpRegistro().getContraseña().getText();
				String contraseña1 = vista.getvReg().getpRegistro().getConfirmarC().getText();
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

				String validacion = bosT.validacionR(nombre, apellido1, apellido2, user, contraseña, contraseña1,
						correo, correo1, estatura, ingresos);

				if (validacion == "error1") {
					vista.mostrarMensaje("Por favor ingrese su nombre, primer apellido y segundo apellido sin números",
							"error");
				} else if (validacion == "error2") {
					vista.mostrarMensaje("El username ya existe por favor ingrese otro", "error");
				} else if (validacion == "error3") {
					vista.mostrarMensaje("Su contraseña no coincide", "error");
				} else if (validacion == "error4") {
					vista.mostrarMensaje("Su correo no coincide", "error");
				} else if (validacion == "error5") {
					vista.mostrarMensaje("Por favor ingrese un correo válido", "error");
				} else if (validacion == "no") {
					int newId = bosT.getMaFi().getId().size() + 1;
					int edad = bosT.getValIn().getEdad1();
					// bosT.getMail().enviarMail(nombre, user, correo, contraseña);
					bosT.añadirUsuario(newId, nombre, apellido1, apellido2, sex, user, contraseña, correo, fecha, edad,
							ingresos, divorcios, 0, 0, estatura, 0, "Disponible");
					bosT.getMaFi().escribirArchivo();
					vista.getvIng().getpIngreso().getB_registro().setEnabled(false);
					vista.getvReg().setVisible(false);
					vista.getvIng().setVisible(true);
				}
			} catch (NumberFormatException e) {
				vista.mostrarMensaje(
						"Ingrese un número válido.\nSi sus ingresos son en decimales separelos por un punto ej: xx.x\nSu edad debe estar en centímetros sin decimales",
						"error");
			}
		}

		if (arg0.getActionCommand().equals("LIKE")) {
			System.out.println(bosT.getMaFi().getId().size());
			bosT.getMaFi().getNumeroLikesRecibidos().set(i, bosT.getMaFi().getNumeroLikesRecibidos().get(i) + 1);
			bosT.getMaFi().getNumeroLikesOtorgados().set(bosT.getPosicionU(),
					bosT.getMaFi().getNumeroLikesOtorgados().get(bosT.getPosicionU()) + 1);
			bosT.getMaFi().escribirArchivo();
			i = bosT.usuarioRandom(bosT.getMaFi().getId().size());
			vista.getvPri().getPu().getNombreCompleto().setText(bosT.getMaFi().getNombre().get(i) + " "
					+ bosT.getMaFi().getApellido1().get(i) + " " + bosT.getMaFi().getApellido2().get(i));
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
		}

		if (arg0.getActionCommand().equals("NOLIKE")) {
			i = bosT.usuarioRandom(bosT.getMaFi().getId().size());
			vista.getvPri().getPu().getNombreCompleto().setText(bosT.getMaFi().getNombre().get(i) + " "
					+ bosT.getMaFi().getApellido1().get(i) + " " + bosT.getMaFi().getApellido2().get(i));
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

		}

		if (arg0.getActionCommand().equals("ORDENAR")) {
			String item = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
			if (item.equals("Nombre")) {
				vista.getvAdm().getPConsul().getT_info().setText(
						bosT.getCrud().obtenerNombre(bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre()));
			} else if (item.equals("Apellido")) {
				vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().obtenerApellido(
						bosT.getMaFi().getId().size(), bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2()));
			} else if (item.equals("Edad")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().obtenerEdad(bosT.getMaFi().getId().size(), bosT.getMaFi().getEdad()));
			} else if (item.equals("Alias")) {
				vista.getvAdm().getPConsul().getT_info().setText(
						bosT.getCrud().obtenerAlias(bosT.getMaFi().getId().size(), bosT.getMaFi().getUsuario()));
			} else if (item.equals("Número Likes")) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().obtenerNumLikes(bosT.getMaFi().getId().size(),
								bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados()));
			}
		}

		if (arg0.getActionCommand().equals("ASCENDENTE")) {
			if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_descendente().setSelected(false);
			} else if (!vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_descendente().setSelected(true);
			}
		}

		if (arg0.getActionCommand().equals("DESCENDENTE")) {
			if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_ascendente().setSelected(false);
			} else if (!vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_ascendente().setSelected(true);
			}
		}

		if (arg0.getActionCommand().equals("FILTRAR")) {
			String item = vista.getvAdm().getPConsul().getBox_filtrar().getSelectedItem().toString();
			if (item.equals("Sin Filtro")) {

			} else if (item.equals("Top 10 Más Likes")) {

			} else if (item.equals("Ingresos >= a 244.85 USD")) {
				vista.getvAdm().getPConsul().getT_info()
				.setText(bosT.getCrud().filtroIngresos(bosT.getMaFi().getId().size(), bosT.getMaFi().getIngresos(), bosT.getMaFi().getNombre()));
			} else if (item.equals("Género")) {
				vista.getvAdm().getPConsul().getT_info()
				.setText(bosT.getCrud().generoM(bosT.getMaFi().getId().size(), bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre()));
			}
		}
	}

}

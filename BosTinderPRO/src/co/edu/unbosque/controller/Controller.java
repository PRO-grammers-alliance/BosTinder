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
		vista.getvAdm().getpInf().getBox_Edad().addActionListener(this);
		vista.getvAdm().getpInf().getBox_Ingresos().addActionListener(this);
		vista.getvAdm().getpInf().getBox_LikesOt().addActionListener(this);
		vista.getvAdm().getpInf().getBox_LikesRec().addActionListener(this);
		vista.getvAdm().getpInf().getB_GenerarInf().addActionListener(this);
		vista.getvAdm().getpElim().getBtnBuscar().addActionListener(this);
		vista.getvAdm().getpElim().getBtnEliminar().addActionListener(this);
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
				vista.mostrarMensaje("Ingrese un usuario y contraseña válidos", "error");
			}
		}

		if (arg0.getActionCommand().equals("REGISTRO")) {
			vista.getvEdad().getpEdad().getAño().setText("");
			vista.getvEdad().getpEdad().getMes().setText("");
			vista.getvEdad().getpEdad().getDia().setText("");
			vista.getvIng().setVisible(false);
			vista.getvEdad().setVisible(true);
		}

		if (arg0.getActionCommand().equals("VALIDAR")) {
			String año = vista.getvEdad().getpEdad().getAño().getText();
			String mes = vista.getvEdad().getpEdad().getMes().getText();
			String dia = vista.getvEdad().getpEdad().getDia().getText();
			fecha = dia + "/" + mes + "/" + año;
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
				vista.mostrarMensaje("Ingrese fecha válida DD/MM/YYYY", "error");
				vista.getvEdad().getpEdad().getAño().setText("");
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
					vista.getvReg().setVisible(false);
					vista.getvReg().getpRegistro().getNombreU().setText("");
					vista.getvReg().getpRegistro().getApellido1().setText("");
					vista.getvReg().getpRegistro().getApellido2().setText("");
					vista.getvReg().getpRegistro().getCorreoE().setText("");
					vista.getvReg().getpRegistro().getConfirmarCorreo().setText("");
					vista.getvReg().getpRegistro().getAlias().setText("");
					vista.getvReg().getpRegistro().getContraseña().setText("");
					vista.getvReg().getpRegistro().getConfirmarC().setText("");
					vista.getvReg().getpRegistro().getEstatura().setText("");
					vista.getvReg().getpRegistro().getIngresosM().setText("");
					vista.getvIng().setVisible(true);
				}
			} catch (NumberFormatException e) {
				vista.mostrarMensaje(
						"Ingrese un número válido.\nSi sus ingresos son en decimales separelos por un punto ej: xx.x\nSu edad debe estar en centímetros sin decimales",
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
		
		if(arg0.getActionCommand().equals("EDADINFO")) {
			if (vista.getvAdm().getpInf().getBox_Edad().isSelected()) {
				vista.getvAdm().getpInf().getBox_Ingresos().setSelected(false);
				vista.getvAdm().getpInf().getBox_LikesOt().setSelected(false);
				vista.getvAdm().getpInf().getBox_LikesRec().setSelected(false);
			}
		}
		
		if(arg0.getActionCommand().equals("INGRESOSINFO")) {
			if (vista.getvAdm().getpInf().getBox_Ingresos().isSelected()) {
				vista.getvAdm().getpInf().getBox_Edad().setSelected(false);
				vista.getvAdm().getpInf().getBox_LikesOt().setSelected(false);
				vista.getvAdm().getpInf().getBox_LikesRec().setSelected(false);
			}
		}
		
		if(arg0.getActionCommand().equals("LIKESOINFO")) {
			if (vista.getvAdm().getpInf().getBox_LikesOt().isSelected()) {
				vista.getvAdm().getpInf().getBox_Ingresos().setSelected(false);
				vista.getvAdm().getpInf().getBox_Edad().setSelected(false);
				vista.getvAdm().getpInf().getBox_LikesRec().setSelected(false);
			}
		}
		
		if(arg0.getActionCommand().equals("LIKESRINFO")) {
			if (vista.getvAdm().getpInf().getBox_LikesRec().isSelected()) {
				vista.getvAdm().getpInf().getBox_Ingresos().setSelected(false);
				vista.getvAdm().getpInf().getBox_LikesOt().setSelected(false);
				vista.getvAdm().getpInf().getBox_Edad().setSelected(false);
			}
		}
		
		if(arg0.getActionCommand().equals("GENERARPDF")) {
			if (vista.getvAdm().getpInf().getBox_Edad().isSelected()) {
				bosT.getMaFi().generarPDF(bosT.getEstad().media(bosT.getMaFi().getEdad()), bosT.getEstad().modaInt(bosT.getMaFi().getEdad()), bosT.getEstad().mediana(bosT.getMaFi().getEdad()), "Edades", bosT.getEstad().datos(bosT.getEstad().repetidos_Datos(bosT.getMaFi().getEdad())),bosT.getEstad().datosPie(bosT.getEstad().repetidos_Datos(bosT.getMaFi().getEdad()), bosT.getMaFi().getEdad()));
				vista.mostrarMensaje("Pdf generado satisfactoriamente\nPuede encontrarlo en su carpeta Data", "info");
			}else if (vista.getvAdm().getpInf().getBox_Ingresos().isSelected()) {
				bosT.getMaFi().generarPDFDouble(bosT.getEstad().mediaDouble(bosT.getMaFi().getIngresos()), bosT.getEstad().modaDouble(bosT.getMaFi().getIngresos()), bosT.getEstad().mediaDouble(bosT.getMaFi().getIngresos()), "Ingresos", bosT.getEstad().datos(bosT.getEstad().repetidos_DatosDouble(bosT.getMaFi().getIngresos())), bosT.getEstad().datosPieDouble(bosT.getEstad().repetidos_DatosDouble(bosT.getMaFi().getIngresos()), bosT.getMaFi().getIngresos()));
				vista.mostrarMensaje("Pdf generado satisfactoriamente\nPuede encontrarlo en su carpeta Data", "info");
			}else if (vista.getvAdm().getpInf().getBox_LikesOt().isSelected()) {
				bosT.getMaFi().generarPDF(bosT.getEstad().media(bosT.getMaFi().getNumeroLikesOtorgados()), bosT.getEstad().modaInt(bosT.getMaFi().getNumeroLikesOtorgados()), bosT.getEstad().mediana(bosT.getMaFi().getNumeroLikesOtorgados()), "Likes Otorgados", bosT.getEstad().datos(bosT.getEstad().repetidos_Datos(bosT.getMaFi().getNumeroLikesOtorgados())), bosT.getEstad().datosPie(bosT.getEstad().repetidos_Datos(bosT.getMaFi().getNumeroLikesOtorgados()), bosT.getMaFi().getNumeroLikesOtorgados()));
				vista.mostrarMensaje("Pdf generado satisfactoriamente\nPuede encontrarlo en su carpeta Data", "info");
			}else if (vista.getvAdm().getpInf().getBox_LikesRec().isSelected()) {
				bosT.getMaFi().generarPDF(bosT.getEstad().media(bosT.getMaFi().getNumeroLikesRecibidos()), bosT.getEstad().modaInt(bosT.getMaFi().getNumeroLikesRecibidos()), bosT.getEstad().mediana(bosT.getMaFi().getNumeroLikesRecibidos()), "Likes Recividos" , bosT.getEstad().datos(bosT.getEstad().repetidos_Datos(bosT.getMaFi().getNumeroLikesRecibidos())), bosT.getEstad().datosPie(bosT.getEstad().repetidos_Datos(bosT.getMaFi().getNumeroLikesRecibidos()), bosT.getMaFi().getNumeroLikesRecibidos()));
				vista.mostrarMensaje("Pdf generado satisfactoriamente\nPuede encontrarlo en su carpeta Data", "info");
			}else {
				vista.mostrarMensaje("Por favor seleccione una opcion para poder generar el PDF", "error");
			}
		}

		if(arg0.getActionCommand().equals("BUSCAR")) {
			try {
				int pos = Integer.parseInt(vista.getvAdm().getpElim().getCampoTextoId().getText());
				String usuario = bosT.getMaFi().leerUsuario(pos);
				vista.getvAdm().getpElim().getInfoUsuario().setText(usuario);
			}catch(NumberFormatException e) {
				vista.mostrarMensaje("Por favor ingrese unicamente un numero id valido. ", "error");
			}
		}
		
		if(arg0.getActionCommand().equals("ELIMINAR")) {
			vista.mostrarMensaje(bosT.getMaFi().eliminarUsuario(Integer.parseInt(vista.getvAdm().getpElim().getCampoTextoId().getText())), "info");
			bosT.getMaFi().escribirArchivo();
		}
		
		
		if (arg0.getActionCommand().equals("ORDENAR")) {
			String item = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
			vista.getvAdm().getpConsul().getBox_filtrar().setSelectedItem("Sin Filtro");
			if (item.equals("Nombre")) {
				if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}

			} else if (item.equals("Apellido")) {
				if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Apellido", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Apellido", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Edad")) {
				if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Edad", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Edad", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Alias")) {
				if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Alias", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Alias", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Número Likes")) {
				if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Likes", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getNumeroLikesOtorgados(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Likes", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}
			} else {
				vista.getvAdm().getPConsul().getT_info().setText("");
			}
		}
		//Ascendente
		if (arg0.getActionCommand().equals("ASCENDENTE")) {
			if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_descendente().setSelected(false);
				String item = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
				String item2 = vista.getvAdm().getPConsul().getBox_filtrar().getSelectedItem().toString();
				if (item.equals("Nombre") && item2.equals("Sin Filtro")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (item.equals("Nombre") && item2.equals("Top 10 Más Likes")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Apellido", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos())
									+ "Falta el top 10");
				} else if (item.equals("Nombre") && item2.equals("Ingresos >= a 244.85 USD")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}else if(item.equals("Nombre") && item2.equals("Género M")) {
					vista.getvAdm().getPConsul().getT_info()
					.setText(bosT.getCrud().generoM("Nombre", "Ascendente", bosT.getMaFi().getId().size(),
							bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
							bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
							bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
							bosT.getMaFi().getIngresos()));
				}else if(item.equals("Nombre") && item2.equals("Género H")) {
					vista.getvAdm().getPConsul().getT_info()
					.setText(bosT.getCrud().generoH("Nombre", "Ascendente", bosT.getMaFi().getId().size(),
							bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
							bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
							bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
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
				} else if (item.equals("Número Likes")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().ascendente("Likes", bosT.getMaFi().getNombre(),
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
		//Descendente
		if (arg0.getActionCommand().equals("DESCENDENTE")) {
			if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_ascendente().setSelected(false);
				String item = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
				String item2 = vista.getvAdm().getPConsul().getBox_filtrar().getSelectedItem().toString();
				if (item.equals("Nombre") && item2.equals("Sin Filtro")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (item.equals("Nombre") && item2.equals("Top 10 Más Likes")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Apellido", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos())
									+ "Falta el top 10");
				} else if (item.equals("Nombre") && item2.equals("Ingresos >= a 244.85 USD")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Nombre", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}else if(item.equals("Nombre") && item2.equals("Género M")) {
					vista.getvAdm().getPConsul().getT_info()
					.setText(bosT.getCrud().generoM("Nombre", "Descendente", bosT.getMaFi().getId().size(),
							bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
							bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
							bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
							bosT.getMaFi().getIngresos()));
				}else if(item.equals("Nombre") && item2.equals("Género H")) {
					vista.getvAdm().getPConsul().getT_info()
					.setText(bosT.getCrud().generoH("Nombre", "Descendente", bosT.getMaFi().getId().size(),
							bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
							bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
							bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
							bosT.getMaFi().getIngresos()));
				}
				else if (item.equals("Apellido")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Apellido", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (item.equals("Edad")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Edad", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (item.equals("Alias")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Alias", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (item.equals("Número Likes")) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().descendente("Likes", bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else {
					vista.getvAdm().getPConsul().getT_info().setText("");
				}
			} else if (!vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getB_ascendente().setSelected(true);
			}
		}
		//Filtros: Sin filtros, Top 10 más likes, Ingresos >= a 244.85 USD, Genero 
		if (arg0.getActionCommand().equals("FILTRAR")) {
			String item = vista.getvAdm().getPConsul().getBox_filtrar().getSelectedItem().toString();
			String item2 = vista.getvAdm().getPConsul().getBox_ordenar().getSelectedItem().toString();
			// Sin filtro
			if (item.equals("Sin Filtro") && item2.equals("Nombre")
					&& vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().descendente("Nombre", bosT.getMaFi().getNombre(),
								bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
								bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("Sin Filtro") && item2.equals("Apellido")
					&& vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().descendente("Apellido", bosT.getMaFi().getNombre(),
								bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
								bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("Sin Filtro") && item2.equals("Edad")
					&& vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().descendente("Edad", bosT.getMaFi().getNombre(),
								bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
								bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("Sin Filtro") && item2.equals("Alias")
					&& vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().descendente("Alias", bosT.getMaFi().getNombre(),
								bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
								bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
								bosT.getMaFi().getIngresos()));
			} else if (item.equals("Sin Filtro") && item2.equals("Número Likes")
					&& vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
				vista.getvAdm().getPConsul().getT_info()
						.setText(bosT.getCrud().descendente("Alias", bosT.getMaFi().getNombre(),
								bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
								bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
								bosT.getMaFi().getIngresos()));
				// Filtro top 10 más likes
			} else if (item.equals("Top 10 Más Likes")) {
				// FALTA CODIGO

				// Ingresos Mayores a 244.85
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Nombre")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Descendente", "Nombre",
									bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Ascendente", "Nombre",
									bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Apellido")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Descendente", "Apellido",
									bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Ascendente", "Apellido",
									bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Edad")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Descendente", "Edad", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info().setText(bosT.getCrud().filtroIngresos("Ascendente", "Edad",
							bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
							bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
							bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Alias")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Descendente", "Alias",
									bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Ascendente", "Alias", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Ingresos >= a 244.85 USD") && item2.equals("Número Likes")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Descendente", "Likes",
									bosT.getMaFi().getId().size(), bosT.getMaFi().getNombre(),
									bosT.getMaFi().getApellido1(), bosT.getMaFi().getApellido2(),
									bosT.getMaFi().getEdad(), bosT.getMaFi().getUsuario(),
									bosT.getMaFi().getNumeroLikesRecibidos(), bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().filtroIngresos("Ascendente", "Likes", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
				// Filtros de genero
			} else if (item.equals("Género M") && item2.equals("¿Qué desea buscar?")) {
				vista.getvAdm().getPConsul().getT_info().setText("");
			} else if (item.equals("Género M") && item2.equals("Nombre")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Nombre", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Nombre", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Género M") && item2.equals("Apellido")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Apellido", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Apellido", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Género M") && item2.equals("Edad")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Edad", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Edad", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Género M") && item2.equals("Alias")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Alias", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Alias", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Género M") && item2.equals("Número Likes")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Likes", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoM("Likes", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Género H") && item2.equals("Nombre")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Nombre", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Nombre", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Género H") && item2.equals("Apellido")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Apellido", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Apellido", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Género H") && item2.equals("Edad")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Edad", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Edad", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			} else if (item.equals("Género H") && item2.equals("Alias")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Alias", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Alias", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos())); 
				}
			} else if (item.equals("Género H") && item2.equals("Número Likes")) {
				if (vista.getvAdm().getPConsul().getB_descendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Likes", "Descendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				} else if (vista.getvAdm().getPConsul().getB_ascendente().isSelected()) {
					vista.getvAdm().getPConsul().getT_info()
							.setText(bosT.getCrud().generoH("Likes", "Ascendente", bosT.getMaFi().getId().size(),
									bosT.getMaFi().getSexo(), bosT.getMaFi().getNombre(), bosT.getMaFi().getApellido1(),
									bosT.getMaFi().getApellido2(), bosT.getMaFi().getEdad(),
									bosT.getMaFi().getUsuario(), bosT.getMaFi().getNumeroLikesRecibidos(),
									bosT.getMaFi().getIngresos()));
				}
			}
		}
	}
}

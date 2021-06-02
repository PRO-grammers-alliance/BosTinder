package co.edu.unbosque.view;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRegistro extends JPanel {

	private JLabel nombre;
	private JTextField nombreU;
	private JLabel apellidos1;
	private JTextField apellido1;
	private JLabel apellidos2;
	private JTextField apellido2;
	private JLabel textoCorreoE;
	private JTextField correoE;
	private JLabel textoalias;
	private JTextField alias;
	private JLabel textoContraseña;
	private JTextField contraseña;
	private JLabel textoConfirmarC;
	private JTextField confirmarC;
	private JCheckBox sexoH;
	private JCheckBox sexoM;
	private JLabel textoEstatura;
	private JTextField estatura;
	private JLabel textoIngresosM;
	private JTextField ingresosM;
	private JLabel textoDivorcio;
	private JCheckBox divorcioSi;
	private JCheckBox divorcioNo;
	private JButton validarRegistro;

	public PanelRegistro() {
		setLayout(null);
		inicializarComponentes();
	}

	public void inicializarComponentes() {

		nombre = new JLabel("Nombre");
		nombre.setBounds(9, 16, 127, 25);
		add(nombre);
		nombreU = new JTextField();
		nombreU.setBounds(9, 40, 175, 26);
		add(nombreU);

		apellidos1 = new JLabel("Primer Apellido");
		apellidos1.setBounds(194, 16, 127, 25);
		add(apellidos1);
		apellido1 = new JTextField();
		apellido1.setBounds(194, 40, 175, 26);
		add(apellido1);

		apellidos2 = new JLabel("Segundo Apellido");
		apellidos2.setBounds(379, 16, 127, 25);
		add(apellidos2);
		apellido2 = new JTextField();
		apellido2.setBounds(379, 40, 175, 26);
		add(apellido2);

		textoCorreoE = new JLabel("Correo Electronico");
		textoCorreoE.setBounds(9, 67, 139, 25);
		add(textoCorreoE);
		correoE = new JTextField();
		correoE.setBounds(9, 91, 175, 26);
		add(correoE);

		textoalias = new JLabel("Alias");
		textoalias.setBounds(9, 118, 127, 25);
		add(textoalias);
		alias = new JTextField();
		alias.setBounds(9, 142, 175, 26);
		add(alias);

		textoContraseña = new JLabel("Contraseña");
		textoContraseña.setBounds(194, 118, 111, 25);
		add(textoContraseña);
		contraseña = new JTextField();
		contraseña.setBounds(194, 142, 175, 26);
		add(contraseña);

		textoConfirmarC = new JLabel("Confirmar Contraseña");
		textoConfirmarC.setBounds(379, 118, 167, 25);
		add(textoConfirmarC);
		confirmarC = new JTextField();
		confirmarC.setBounds(379, 142, 175, 26);
		add(confirmarC);

		sexoH = new JCheckBox("Hombre");
		sexoH.setActionCommand("HOMBRE");
		sexoH.setBounds(9, 188, 81, 29);
		add(sexoH);

		sexoM = new JCheckBox("Mujer");
		sexoM.setActionCommand("MUJER");
		sexoM.setBounds(106, 188, 61, 29);
		add(sexoM);

		textoEstatura = new JLabel("Estatura");
		textoEstatura.setBounds(41, 224, 127, 25);
		textoEstatura.setVisible(false);
		add(textoEstatura);
		estatura = new JTextField();
		estatura.setBounds(41, 248, 127, 26);
		estatura.setVisible(false);
		add(estatura);

		textoIngresosM = new JLabel("Promedio de Ingresos Mensuales");
		textoIngresosM.setBounds(194, 224, 209, 25);
		add(textoIngresosM);
		ingresosM = new JTextField();
		ingresosM.setBounds(194, 248, 198, 26);
		add(ingresosM);

		textoDivorcio = new JLabel("¿Has tenido Divorcios?");
		textoDivorcio.setBounds(428, 224, 153, 25);
		textoDivorcio.setVisible(false);
		add(textoDivorcio);
		
		divorcioSi = new JCheckBox("Si");
		divorcioSi.setBounds(428, 250, 51, 25);
		divorcioSi.setVisible(false);
		add(divorcioSi);
		
		divorcioNo = new JCheckBox("No");
		divorcioNo.setBounds(479, 250, 51, 25);
		divorcioNo.setVisible(false);
		add(divorcioNo);

		validarRegistro = new JButton("Registrarse");
		validarRegistro.setBounds(211, 307, 174, 26);
		validarRegistro.setActionCommand("VALIDARREGISTRO");
		add(validarRegistro);
	}

	

	public JLabel getNombre() {
		return nombre;
	}

	public void setNombre(JLabel nombre) {
		this.nombre = nombre;
	}

	public JTextField getNombreU() {
		return nombreU;
	}

	public void setNombreU(JTextField nombreU) {
		this.nombreU = nombreU;
	}

	public JLabel getApellidos1() {
		return apellidos1;
	}

	public void setApellidos1(JLabel apellidos1) {
		this.apellidos1 = apellidos1;
	}

	public JTextField getApellido1() {
		return apellido1;
	}

	public void setApellido1(JTextField apellido1) {
		this.apellido1 = apellido1;
	}

	public JLabel getApellidos2() {
		return apellidos2;
	}

	public void setApellidos2(JLabel apellidos2) {
		this.apellidos2 = apellidos2;
	}

	public JTextField getApellido2() {
		return apellido2;
	}

	public void setApellido2(JTextField apellido2) {
		this.apellido2 = apellido2;
	}

	public JLabel getTextoCorreoE() {
		return textoCorreoE;
	}

	public void setTextoCorreoE(JLabel textoCorreoE) {
		this.textoCorreoE = textoCorreoE;
	}

	public JTextField getCorreoE() {
		return correoE;
	}

	public void setCorreoE(JTextField correoE) {
		this.correoE = correoE;
	}

	public JLabel getTextoalias() {
		return textoalias;
	}

	public void setTextoalias(JLabel textoalias) {
		this.textoalias = textoalias;
	}

	public JTextField getAlias() {
		return alias;
	}

	public void setAlias(JTextField alias) {
		this.alias = alias;
	}

	public JLabel getTextoContraseña() {
		return textoContraseña;
	}

	public void setTextoContraseña(JLabel textoContraseña) {
		this.textoContraseña = textoContraseña;
	}

	public JTextField getContraseña() {
		return contraseña;
	}

	public void setContraseña(JTextField contraseña) {
		this.contraseña = contraseña;
	}

	public JLabel getTextoConfirmarC() {
		return textoConfirmarC;
	}

	public void setTextoConfirmarC(JLabel textoConfirmarC) {
		this.textoConfirmarC = textoConfirmarC;
	}

	public JTextField getConfirmarC() {
		return confirmarC;
	}

	public void setConfirmarC(JTextField confirmarC) {
		this.confirmarC = confirmarC;
	}

	public JCheckBox getSexoH() {
		return sexoH;
	}

	public void setSexoH(JCheckBox sexoH) {
		this.sexoH = sexoH;
	}

	public JCheckBox getSexoM() {
		return sexoM;
	}

	public void setSexoM(JCheckBox sexoM) {
		this.sexoM = sexoM;
	}

	public JLabel getTextoEstatura() {
		return textoEstatura;
	}

	public void setTextoEstatura(JLabel textoEstatura) {
		this.textoEstatura = textoEstatura;
	}

	public JTextField getEstatura() {
		return estatura;
	}

	public void setEstatura(JTextField estatura) {
		this.estatura = estatura;
	}

	public JLabel getTextoIngresosM() {
		return textoIngresosM;
	}

	public void setTextoIngresosM(JLabel textoIngresosM) {
		this.textoIngresosM = textoIngresosM;
	}

	public JTextField getIngresosM() {
		return ingresosM;
	}

	public void setIngresosM(JTextField ingresosM) {
		this.ingresosM = ingresosM;
	}

	public JLabel getTextoDivorcio() {
		return textoDivorcio;
	}

	public void setTextoDivorcio(JLabel textoDivorcio) {
		this.textoDivorcio = textoDivorcio;
	}

	public JCheckBox getDivorcioSi() {
		return divorcioSi;
	}

	public void setDivorcioSi(JCheckBox divorcioSi) {
		this.divorcioSi = divorcioSi;
	}

	public JCheckBox getDivorcioNo() {
		return divorcioNo;
	}

	public void setDivorcioNo(JCheckBox divorcioNo) {
		this.divorcioNo = divorcioNo;
	}

	public JButton getValidarRegistro() {
		return validarRegistro;
	}

	public void setValidarRegistro(JButton validarRegistro) {
		this.validarRegistro = validarRegistro;
	}
}

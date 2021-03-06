package co.edu.unbosque.view;


import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Clase de la interfaz grafica que permite el ingreso de la informacion para registrarse.
 * @author Oscar Florez
 *
 */
public class PanelRegistro extends JPanel {

	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel nombre;
	/**
	 * Objeto de tipo JTextField que permite el ingreso para el nombre del usuario.
	 */
	private JTextField nombreU;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel apellidos1;
	/**
	 * Objeto de tipo JTextField que permite el ingreso para el primer apellido del usuario.
	 */
	private JTextField apellido1;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel apellidos2;
	/**
	 * Objeto de tipo JTextField que permite el ingreso para el segundo apellido del usuario.
	 */
	private JTextField apellido2;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel textoCorreoE;
	/**
	 * Objeto de tipo JTextField que permite el ingreso del correo del usuario.
	 */
	private JTextField correoE;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel textoConfirmarCorreo;
	/**
	 * Objeto de tipo JTextField que permite eel ingreso del correo del usuario.
	 */
	private JTextField confirmarCorreo;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel textoalias;
	/**
	 * Objeto de tipo JTextField que permite el ingreso para el username del usuario.
	 */
	private JTextField alias;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel textoContraseña;
	/**
	 * Objeto de tipo JTextField que permite el ingreso para la contraseña del usuario.
	 */
	private JTextField contraseña;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel textoConfirmarC;
	/**
	 * Objeto de tipo JTextField que permite el ingreso para la contraseña del usuario.
	 */
	private JTextField confirmarC;
	
	/**
	 * Objeto de tipo JCheckBox.
	 */
	private JCheckBox sexoH;
	/**
	 * Objeto de tipo JCheckBox.
	 */
	private JCheckBox sexoM;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel textoEstatura;
	/**
	 * Objeto de tipo JTextField que permite el ingreso para la estatura del usuario.
	 */
	private JTextField estatura;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel textoIngresosM;
	/**
	 * Objeto de tipo JTextField que permite digitar los ingresos mensuales del usuario.
	 */
	private JTextField ingresosM;
	
	/**
	 * Objeto de tipo JLabel.
	 */
	private JLabel textoDivorcio;
	/**
	 * Objeto de tipo JCheckBox.
	 */
	private JCheckBox divorcioSi;
	/**
	 * Objeto de tipo JCheckBox.
	 */
	private JCheckBox divorcioNo;
	/**
	 * Objeto de tipo JButton.
	 */
	private JButton validarRegistro;

	
	/**
	 * Método constructor.
	 */
	public PanelRegistro() {
		setLayout(null);
		inicializarComponentes();
	}

	/**
	 * Método que inicializa las componentes del panel.
	 */
	public void inicializarComponentes() {

		nombre = new JLabel("Nombre");
		nombre.setBounds(9, 16, 127, 25);
		nombre.setFont(new Font(getName(), Font.BOLD, 14));
		add(nombre);
		nombreU = new JTextField();
		nombreU.setBounds(9, 40, 175, 26);
		add(nombreU);

		apellidos1 = new JLabel("Primer Apellido");
		apellidos1.setBounds(194, 16, 127, 25);
		apellidos1.setFont(new Font(getName(), Font.BOLD, 14));
		add(apellidos1);
		apellido1 = new JTextField();
		apellido1.setBounds(194, 40, 175, 26);
		add(apellido1);

		apellidos2 = new JLabel("Segundo Apellido");
		apellidos2.setBounds(379, 16, 127, 25);
		apellidos2.setFont(new Font(getName(), Font.BOLD, 14));
		add(apellidos2);
		apellido2 = new JTextField();
		apellido2.setBounds(379, 40, 175, 26);
		add(apellido2);

		textoCorreoE = new JLabel("Correo Electronico");
		textoCorreoE.setBounds(9, 67, 139, 25);
		textoCorreoE.setFont(new Font(getName(), Font.BOLD, 14));
		add(textoCorreoE);
		correoE = new JTextField();
		correoE.setBounds(9, 91, 175, 26);
		add(correoE);
		
		textoConfirmarCorreo = new JLabel("Confirmar Correo Electronico");
		textoConfirmarCorreo.setFont(new Font(getName(), Font.BOLD, 14));
		textoConfirmarCorreo.setBounds(194, 67, 220, 24);
		add(textoConfirmarCorreo);
		confirmarCorreo = new JTextField();
		confirmarCorreo.setBounds(194, 91, 175, 27);
		add(confirmarCorreo);

		textoalias = new JLabel("Alias");
		textoalias.setFont(new Font(getName(), Font.BOLD, 14));
		textoalias.setBounds(9, 118, 127, 25);
		add(textoalias);
		alias = new JTextField();
		alias.setBounds(9, 142, 175, 26);
		add(alias);

		textoContraseña = new JLabel("Contraseña");
		textoContraseña.setBounds(194, 118, 111, 25);
		textoContraseña.setFont(new Font(getName(), Font.BOLD, 14));
		add(textoContraseña);
		contraseña = new JTextField();
		contraseña.setBounds(194, 142, 175, 26);
		add(contraseña);

		textoConfirmarC = new JLabel("Confirmar Contraseña");
		textoConfirmarC.setBounds(379, 118, 167, 25);
		textoConfirmarC.setFont(new Font(getName(), Font.BOLD, 14));
		add(textoConfirmarC);
		confirmarC = new JTextField();
		confirmarC.setBounds(379, 142, 175, 26);
		add(confirmarC);

		sexoH = new JCheckBox("Hombre");
		sexoH.setFont(new Font(getName(), Font.BOLD, 14));
		sexoH.setActionCommand("HOMBRE");
		sexoH.setBounds(9, 188, 81, 29);
		add(sexoH);

		sexoM = new JCheckBox("Mujer");
		sexoM.setFont(new Font(getName(), Font.BOLD, 14));
		sexoM.setActionCommand("MUJER");
		sexoM.setBounds(110, 188, 80, 29);
		add(sexoM);

		textoEstatura = new JLabel("Estatura (En cm)");
		textoEstatura.setFont(new Font(getName(), Font.BOLD, 14));
		textoEstatura.setBounds(41, 224, 127, 25);
		textoEstatura.setVisible(false);
		add(textoEstatura);
		estatura = new JTextField();
		estatura.setBounds(41, 248, 127, 26);
		estatura.setVisible(false);
		add(estatura);

		textoIngresosM = new JLabel("Promedio de Ingresos Mensuales");
		textoIngresosM.setFont(new Font(getName(), Font.BOLD, 14));
		textoIngresosM.setBounds(194, 224, 250, 25);
		textoIngresosM.setVisible(false);
		add(textoIngresosM);
		ingresosM = new JTextField();
		ingresosM.setBounds(194, 248, 198, 26);
		ingresosM.setVisible(false);
		add(ingresosM);

		textoDivorcio = new JLabel("¿Ha tenido Divorcios?");
		textoDivorcio.setFont(new Font(getName(), Font.BOLD, 14));
		textoDivorcio.setBounds(410, 224, 160, 25);
		textoDivorcio.setVisible(false);
		add(textoDivorcio);
		
		divorcioSi = new JCheckBox("Si");
		divorcioSi.setFont(new Font(getName(), Font.BOLD, 14));
		divorcioSi.setBounds(428, 250, 51, 25);
		divorcioSi.setActionCommand("DVSI");
		divorcioSi.setVisible(false);
		add(divorcioSi);
		
		divorcioNo = new JCheckBox("No");
		divorcioNo.setFont(new Font(getName(), Font.BOLD, 14));
		divorcioNo.setBounds(479, 250, 51, 25);
		divorcioNo.setActionCommand("DVNO");
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

	public JLabel getTextoConfirmarCorreo() {
		return textoConfirmarCorreo;
	}

	public void setTextoConfirmarCorreo(JLabel textoConfirmarCorreo) {
		this.textoConfirmarCorreo = textoConfirmarCorreo;
	}

	public JTextField getConfirmarCorreo() {
		return confirmarCorreo;
	}

	public void setConfirmarCorreo(JTextField confirmarCorreo) {
		this.confirmarCorreo = confirmarCorreo;
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

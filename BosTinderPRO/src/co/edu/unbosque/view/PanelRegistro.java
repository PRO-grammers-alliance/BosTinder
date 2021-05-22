package co.edu.unbosque.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelRegistro extends JPanel {

	private JButton b_validar;
	private JLabel instruccion1;
	private JLabel instruccion2;
	private JLabel separar;
	private JLabel separar2;
	private JTextField dia;
	private JTextField mes;
	private JTextField a�o;

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
	private JLabel textoContrase�a;
	private JTextField contrase�a;
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
		instruccion1 = new JLabel("Ingrese su fecha de nacimiento");
		instruccion1.setFont(new Font(getName(), Font.BOLD, 14));
		instruccion1.setBounds(20, 10, 100, 20);
		add(instruccion1);

		instruccion2 = new JLabel("DD   /  MM   / AAAA");
		instruccion2.setFont(new Font(getName(), Font.BOLD, 14));
		instruccion2.setBounds(20, 10, 100, 20);
		add(instruccion2);

		separar = new JLabel("/");
		separar.setFont(new Font(getName(), Font.BOLD, 14));
		separar.setBounds(30, 40, 100, 20);
		add(separar);

		separar2 = new JLabel("/");
		separar2.setFont(new Font(getName(), Font.BOLD, 14));
		separar2.setBounds(40, 40, 100, 20);
		add(separar2);

		b_validar = new JButton("Validar Edad");
		b_validar.setFont(new Font(getName(), Font.BOLD, 14));
		b_validar.setActionCommand("VALIDAR");
		b_validar.setBounds(70, 140, 100, 30);
		add(b_validar);

		dia = new JTextField();
		dia.setBounds(25, 40, 80, 25);
		add(dia);

		mes = new JTextField();
		mes.setBounds(35, 40, 80, 25);
		add(mes);

		a�o = new JTextField();
		a�o.setBounds(45, 40, 80, 25);
		add(a�o);

		nombre = new JLabel("Nombre");
		nombre.setBounds(1038, 45, 127, 25);
		add(nombre);
		nombreU = new JTextField();
		nombreU.setBounds(1038, 68, 175, 26);
		add(nombre);

		apellidos1 = new JLabel("Primer Apellido");
		apellidos1.setBounds(1221, 45, 127, 25);
		add(apellidos1);
		apellido1 = new JTextField();
		apellido1.setBounds(1221, 68, 175, 26);
		add(apellido1);

		apellidos2 = new JLabel("Segundo Apellido");
		apellidos2.setBounds(1402, 45, 127, 25);
		add(apellidos2);
		apellido2 = new JTextField();
		apellido2.setBounds(1402, 68, 175, 26);
		add(apellido2);

		textoCorreoE = new JLabel("Correo Electronico");
		textoCorreoE.setBounds(1038, 98, 139, 25);
		add(textoCorreoE);
		correoE = new JTextField();
		correoE.setBounds(1038, 121, 175, 26);
		add(correoE);

		textoalias = new JLabel("Alias");
		textoalias.setBounds(1038, 149, 127, 25);
		add(textoalias);
		alias = new JTextField();
		alias.setBounds(1038, 173, 175, 26);
		add(alias);

		textoContrase�a = new JLabel("Contrase�a");
		textoContrase�a.setBounds(1221, 150, 111, 25);
		add(textoContrase�a);
		contrase�a = new JTextField();
		contrase�a.setBounds(1221, 172, 175, 26);
		add(contrase�a);

		textoConfirmarC = new JLabel("Confirmar Contrase�a");
		textoConfirmarC.setBounds(1402, 149, 167, 25);
		add(textoConfirmarC);
		confirmarC = new JTextField();
		confirmarC.setBounds(1402, 172, 175, 26);
		add(confirmarC);

		sexoH = new JCheckBox("Hombre");
		sexoH.setBounds(1050, 226, 81, 29);
		add(sexoH);

		sexoM = new JCheckBox("Mujer");
		sexoM.setBounds(1131, 226, 61, 29);
		add(sexoM);

		textoEstatura = new JLabel("Estatura");
		textoEstatura.setBounds(1050, 266, 127, 25);
		add(textoEstatura);
		estatura = new JTextField();
		estatura.setBounds(1050, 292, 127, 26);
		add(estatura);

		textoIngresosM = new JLabel("Promedio de Ingresos Mensuales");
		textoIngresosM.setBounds(1216, 266, 209, 25);
		add(textoIngresosM);
		ingresosM = new JTextField();
		ingresosM.setBounds(1216, 292, 198, 26);
		add(ingresosM);

		textoDivorcio = new JLabel("�Has tenido Divorcios?");
		textoDivorcio.setBounds(1441, 266, 153, 25);
		add(textoDivorcio);
		divorcioSi = new JCheckBox("Si");
		divorcioSi.setBounds(1444, 292, 51, 25);
		add(divorcioSi);
		divorcioNo = new JCheckBox("No");
		divorcioNo.setBounds(1496, 292, 51, 25);
		add(divorcioNo);

		validarRegistro = new JButton("Registrarse");
		validarRegistro.setBounds(1240, 348, 174, 26);
		validarRegistro.setActionCommand("VALIDARREGISTRO");
		add(validarRegistro);
	}

	public JButton getB_validar() {
		return b_validar;
	}

	public void setB_validar(JButton b_validar) {
		this.b_validar = b_validar;
	}

	public JLabel getInstruccion1() {
		return instruccion1;
	}

	public void setInstruccion1(JLabel instruccion1) {
		this.instruccion1 = instruccion1;
	}

	public JLabel getInstruccion2() {
		return instruccion2;
	}

	public void setInstruccion2(JLabel instruccion2) {
		this.instruccion2 = instruccion2;
	}

	public JLabel getSeparar() {
		return separar;
	}

	public void setSeparar(JLabel separar) {
		this.separar = separar;
	}

	public JLabel getSeparar2() {
		return separar2;
	}

	public void setSeparar2(JLabel separar2) {
		this.separar2 = separar2;
	}

	public JTextField getDia() {
		return dia;
	}

	public void setDia(JTextField dia) {
		this.dia = dia;
	}

	public JTextField getMes() {
		return mes;
	}

	public void setMes(JTextField mes) {
		this.mes = mes;
	}

	public JTextField getA�o() {
		return a�o;
	}

	public void setA�o(JTextField a�o) {
		this.a�o = a�o;
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

	public JLabel getTextoContrase�a() {
		return textoContrase�a;
	}

	public void setTextoContrase�a(JLabel textoContrase�a) {
		this.textoContrase�a = textoContrase�a;
	}

	public JTextField getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(JTextField contrase�a) {
		this.contrase�a = contrase�a;
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

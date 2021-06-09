package co.edu.unbosque.view;


import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * Clase Panel Admin Eliminar
 * 
 * Clase de la vista que cuenta con 2 metodos, el constructor y otro de tipo void.
 * 
 * @author Felipe Segura
 * @author David Real
 * @author Oscar Florez
 * @author Santiago Zamora
 *
 */

public class PanelAdmEliminar extends JPanel{
	/**
	 * Objeto de JPanel 
	 */
	private JPanel panelInfo;
	/**
	 * Objeto de JLabel 
	 */
	private JLabel textoEliminar;
	/**
	 * Objeto de JTextField 
	 */
	private JTextField campoTextoId;
	/**
	 * Objeto de JButton 
	 */
	private JButton btnBuscar;
	/**
	 * Objeto de JButton 
	 */
	private JButton btnEliminar;
	/**
	 * Objeto de JTextArea
	 */
	private JTextArea infoUsuario;
	/**
	 * Objeto de JScrollPane
	 */
	private JScrollPane sp;
	
	/**
	 * M�todo constructor de la clase
	 */
	public PanelAdmEliminar() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		inicializarComponentes();
	}
	
	/**
	 * M�todo que inicializa los componentes del Panel
	 */
	public void inicializarComponentes() {
		textoEliminar = new JLabel("ID Usuario a eliminar");
		textoEliminar.setBounds(267, 34, 127, 21);
		add(textoEliminar);
		
		campoTextoId = new JTextField();
		campoTextoId.setBounds(291, 62, 79, 27);
		add(campoTextoId);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(111, 126, 100, 27);
		btnBuscar.setActionCommand("BUSCAR");
		add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(445, 126, 100, 27);
		btnEliminar.setActionCommand("ELIMINAR");
		btnEliminar.setEnabled(false);
		add(btnEliminar);
		
		infoUsuario = new JTextArea();
		infoUsuario.setLineWrap(false);
		infoUsuario.setEditable(false);
		
		sp = new JScrollPane(infoUsuario, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setBounds(0, 0, 644, 304);
		
		panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBounds(16, 180, 644, 304);
		panelInfo.add(sp);
		add(panelInfo);
	}

	public JPanel getPanelInfo() {
		return panelInfo;
	}

	public void setPanelInfo(JPanel panelInfo) {
		this.panelInfo = panelInfo;
	}

	public JLabel getTextoEliminar() {
		return textoEliminar;
	}

	public void setTextoEliminar(JLabel textoEliminar) {
		this.textoEliminar = textoEliminar;
	}

	public JTextField getCampoTextoId() {
		return campoTextoId;
	}

	public void setCampoTextoId(JTextField campoTextoId) {
		this.campoTextoId = campoTextoId;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JTextArea getInfoUsuario() {
		return infoUsuario;
	}

	public void setInfoUsuario(JTextArea infoUsuario) {
		this.infoUsuario = infoUsuario;
	}

	public JScrollPane getSp() {
		return sp;
	}

	public void setSp(JScrollPane sp) {
		this.sp = sp;
	}
	
}

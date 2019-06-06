package Pantallas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JInternalFrame.JDesktopIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import com.toedter.calendar.JCalendar;

import MetodosAhorradores.MetodosAhorradores;

public class VentanaPrincipal extends JFrame implements ActionListener, KeyListener {
	
	MetodosAhorradores obj = new MetodosAhorradores();
	JMenu menuHuesped, menuHabitaciones, menuEmpleados, menuServicios;
	JMenuBar menuBar;
	JMenuItem altaHuesped, bajaHuesped, cambioHuesped, consultaHuesped;
	JButton btnAdd, btnDel, btnCam, btnCon;
	JInternalFrame iFAltas, iFBajas, iFCambios, iFConsultas;
	
	// CAMPOS DE LOS INTERNALS FRAMES
	JCalendar calAltas;
	JTextField idHue, nombre, apeP, apeM, tel;
	JTextField idB, nomB, apePB, apeMB, telB, fecB;
	JTextField idM, nomM, apePM, apeMM, telM, fecM;
	JTextField idC, nomC, apePC, apeMC, telC, fecC;
	JPanel pAltas1, pAltas2, pAltas3;
	JPanel pBajas1, pBajas2, pBajas3, pBajas4;
	JPanel pMod1, pMod2, pMod3, pMod4;
	JPanel pCon1, pCon2, pCon3, pCon4;
	JRadioButton rTodos, rID, rNombre, rApeP, rApeM, rTelefono, rFecha;
	JTable tablaAltas, tablaBajas, tablaCambios, tablaConsultas;
	JButton añadir, clear1, buscarB, eliminar, clear2, buscarM, clear3, modificar, clear4, consultar;
	
	// Letras
	Font letra1 = new Font("Segoe Script", Font.BOLD, 25);
	Font letra2 = new Font("Times New Roman", Font.BOLD, 14);
	Font letra3 = new Font("Aial", Font.PLAIN, 12);
	
	public VentanaPrincipal() {
		getContentPane().setLayout(new BorderLayout());
		setTitle("Tablas");
		setSize(800, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		
		menuBar = new JMenuBar();
			menuHuesped = new JMenu("Huéspedes");
				altaHuesped = new JMenuItem("Altas");
				altaHuesped.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.ALT_MASK));
				altaHuesped.addActionListener(this);
				menuHuesped.add(altaHuesped);
				
				bajaHuesped = new JMenuItem("Bajas");
				bajaHuesped.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.ALT_MASK));
				bajaHuesped.addActionListener(this);
				menuHuesped.add(bajaHuesped);
				
				cambioHuesped = new JMenuItem("Cambios");
				cambioHuesped.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.ALT_MASK));
				cambioHuesped.addActionListener(this);
				menuHuesped.add(cambioHuesped);
				
				consultaHuesped = new JMenuItem("Buscar");
				consultaHuesped.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.ALT_MASK));
				consultaHuesped.addActionListener(this);
				menuHuesped.add(consultaHuesped);
		menuBar.add(menuHuesped);		
			menuHabitaciones = new JMenu("Habitaciones");
		menuBar.add(menuHabitaciones);
			menuEmpleados = new JMenu("Empleados");
		menuBar.add(menuEmpleados);
			menuServicios = new JMenu("Otros Servicios");
		menuBar.add(menuServicios);
		setJMenuBar(menuBar);
		
		btnAdd = new JButton(obj.iconos("Iconos/Add.png", 18));
		btnAdd.addActionListener(this);
		btnDel = new JButton(obj.iconos("Iconos/Delete.png", 18));
		btnDel.addActionListener(this);
		btnCam = new JButton(obj.iconos("Iconos/Modificar.png", 18));
		btnCam.addActionListener(this);
		btnCon = new JButton(obj.iconos("Iconos/Buscar.png", 18));
		btnCon.addActionListener(this);
		
		JToolBar toolBar = new JToolBar();
			toolBar.add(btnAdd);
			toolBar.add(btnDel);
			toolBar.add(btnCam);
			toolBar.add(btnCon);
		add(toolBar, BorderLayout.PAGE_START);
		
		JDesktopPane desktopPane = new JDesktopPane();
		
			iFAltas = new JInternalFrame("Altas Huéspedes", false, true, false);
			iFAltas.getContentPane().setLayout(null);
			iFAltas.setVisible(false);
			iFAltas.setLocation(new Point());
			iFAltas.setDefaultCloseOperation(HIDE_ON_CLOSE);
			iFAltas.setSize(700, 600);
			Dimension desktopSize = getSize();
	        Dimension FrameSize = iFAltas.getSize();
	        int x = (desktopSize.width - FrameSize.width)/2;
	        int y = (desktopSize.height- FrameSize.height)/2;
	        iFAltas.setLocation(x, y-45);
	        desktopPane.add(iFAltas);
	        
	        pAltas1 = new JPanel();
		        pAltas1.setLayout(null);
				pAltas1.setBackground(new Color(58, 228, 53));
				pAltas1.setBounds(0, 0, 700, 70);
				
				JLabel label1 = new JLabel("ALTAS HUÉSPED");
				obj.agregarEtiqueta(label1, 20, 20, 500, 40, pAltas1, letra1, Color.WHITE);
	        iFAltas.add(pAltas1);
	        
	        pAltas2 = new JPanel();
	        	pAltas2.setLayout(null);
	        	//pAltas2.setBackground(Color.BLUE);
	        	pAltas2.setBounds(0, 70, 700, 330);
	        	
	        	JLabel lblID = new JLabel("ID HUÉSPED: ");
	        	obj.agregarEtiqueta(lblID, 50, 30, 300, 30, pAltas2, letra2, Color.BLACK);
	        	
	        	idHue = new JTextField();
	        	idHue.addKeyListener(this);
	        	obj.añadirAPanel(idHue, 210, 30, 170, 30, null, pAltas2);
	        	
	        	JLabel lblNombre = new JLabel("NOMBRE: ");
	        	obj.agregarEtiqueta(lblNombre, 50, 80, 300, 30, pAltas2, letra2, Color.BLACK);
	        	
	        	nombre = new JTextField();
	        	nombre.addKeyListener(this);
	        	obj.añadirAPanel(nombre, 210, 80, 170, 30, null, pAltas2);
	        	
	        	JLabel lblApeP = new JLabel("APELLIDO PATERNO: ");
	        	obj.agregarEtiqueta(lblApeP, 50, 130, 300, 30, pAltas2, letra2, Color.BLACK);
	        	
	        	apeP = new JTextField();
	        	apeP.addKeyListener(this);
	        	obj.añadirAPanel(apeP, 210, 130, 170, 30, null, pAltas2);
	        	
	        	JLabel lblApeM = new JLabel("APELLIDO MATERNO: ");
	        	obj.agregarEtiqueta(lblApeM, 50, 180, 300, 30, pAltas2, letra2, Color.BLACK);
	        	
	        	apeM = new JTextField();
	        	apeM.addKeyListener(this);
	        	obj.añadirAPanel(apeM, 210, 180, 170, 30, null, pAltas2);
	        	
	        	JLabel lblTel = new JLabel("TELÉFONO: ");
	        	obj.agregarEtiqueta(lblTel, 50, 230, 300, 30, pAltas2, letra2, Color.BLACK);
	        	
	        	tel = new JTextField();
	        	tel.addKeyListener(this);
	        	obj.añadirAPanel(tel, 210, 230, 170, 30, null, pAltas2);
	        	
	        	JLabel lblFecha = new JLabel("FECHA NACIMIENTO: ");
	        	obj.agregarEtiqueta(lblFecha, 420, 30, 300, 30, pAltas2, letra2, Color.BLACK);
	        	
	        	calAltas = new JCalendar();
	        	calAltas.setWeekOfYearVisible(false);
	        	calAltas.setMaxDayCharacters(1);
	        	obj.añadirAPanel(calAltas, 420, 70, 200, 170, null, pAltas2);
	        	
	        	añadir = new JButton("Añadir");
	        	añadir.addActionListener(this);
	        	obj.añadirAPanel(añadir, 150, 290, 150, 25, letra2, pAltas2);
	        	
	        	clear1 = new JButton("Limpiar");
	        	clear1.addActionListener(this);
	        	obj.añadirAPanel(clear1, 400, 290, 150, 25, letra2, pAltas2);
	        iFAltas.add(pAltas2);
	        
	        pAltas3 = new JPanel();
	        	pAltas3.setLayout(new BorderLayout());
	        	pAltas3.setBounds(20, 420, 650, 120);
	        	
	        	tablaAltas = new JTable(6, 6);
				obj.crearTabla(pAltas3, tablaAltas);		
	        iFAltas.add(pAltas3);
	        
	        // ==========================================================================================================
	        
	        iFBajas = new JInternalFrame("Bajas Huéspedes", false, true, false);
	        iFBajas.getContentPane().setLayout(null);
	        iFBajas.setSize(700, 600);
	        iFBajas.setDefaultCloseOperation(HIDE_ON_CLOSE);
	        iFBajas.setVisible(false);
	        iFBajas.setLocation(x, y-45);
	        desktopPane.add(iFBajas);
			
			pBajas1 = new JPanel();
				pBajas1.setLayout(null);
				pBajas1.setBackground(new Color(249, 22, 22));
				pBajas1.setBounds(0, 0, 700, 70);
				
				JLabel labelBajas1 = new JLabel("BAJAS HUÉSPED");
				obj.agregarEtiqueta(labelBajas1, 20, 20, 500, 40, pBajas1, letra1, Color.WHITE);								
			iFBajas.add(pBajas1);
			
			pBajas2 = new JPanel();
				pBajas2.setLayout(null);
				pBajas2.setBounds(45, 80, 600, 70);
				pBajas2.setBorder(new EtchedBorder());
								
				JLabel idHuesped = new JLabel("ID HUESPED: ");
				obj.agregarEtiqueta(idHuesped, 50, 22, 300, 30, pBajas2, letra2, null);
				
				idB = new JTextField();
				idB.addKeyListener(this);
				obj.añadirAPanel(idB, 150, 25, 170, 25, null, pBajas2);
								
				buscarB = new JButton(obj.iconos("Iconos/Search.png", 40) );
				buscarB.addActionListener(this);
				obj.añadirAPanel(buscarB, 350, 15, 40, 40, null, pBajas2);
				
				clear2 = new JButton("Limpiar");
				clear2.addActionListener(this);
				obj.añadirAPanel(clear2, 430, 5, 100, 25, letra2, pBajas2);
				
				eliminar = new JButton("Eliminar");
				eliminar.addActionListener(this);
				obj.añadirAPanel(eliminar, 430, 40, 100, 25, letra2, pBajas2);
			iFBajas.add(pBajas2);
				
			pBajas3 = new JPanel();
				pBajas3.setLayout(null);
				pBajas3.setBounds(0, 150, 700, 220);
						
				JLabel nombre = new JLabel("NOMBRE: ");
				obj.añadirAPanel(nombre, 80, 20, 300, 30, letra2, pBajas3);
				
				nomB = new JTextField();
				nomB.setEditable(false);
				obj.añadirAPanel(nomB, 190, 22, 250, 25, null, pBajas3);
								
				JLabel apellidoP = new JLabel("APELLIDO PATERNO: ");
				obj.añadirAPanel(apellidoP, 80, 60, 300, 30, letra2, pBajas3);
								
				apePB = new JTextField();
				apePB.setEditable(false);
				obj.añadirAPanel(apePB, 260, 62, 180, 25, null, pBajas3);
				
				JLabel apellidoM = new JLabel("APELLIDO MATERNO: ");
				obj.añadirAPanel(apellidoM, 80, 100, 300, 30, letra2, pBajas3);
				
				apeMB = new JTextField();
				apeMB.setEditable(false);
				obj.añadirAPanel(apeMB, 260, 102, 180, 25, null, pBajas3);
				
				JLabel fecNac = new JLabel("FECHA NACIMIENTO: ");
				obj.añadirAPanel(fecNac, 80, 140, 300, 30, letra2, pBajas3);
				
				fecB = new JTextField();
				fecB.setEditable(false);
				obj.añadirAPanel(fecB, 260, 142, 180, 25, null, pBajas3);
								
				JLabel telefono = new JLabel("TElÉFONO: ");
				obj.añadirAPanel(telefono, 80, 180, 300, 30, letra2, pBajas3);
				
				telB = new JTextField();
				telB.setEditable(false);
				obj.añadirAPanel(telB, 260, 182, 180, 25, null, pBajas3);	
			iFBajas.add(pBajas3);
			
			pBajas4 = new JPanel();
				pBajas4.setLayout(new BorderLayout());
				pBajas4.setBounds(20, 400, 650, 120);
				
				tablaBajas = new JTable(6,6);
				obj.crearTabla(pBajas4, tablaBajas);
			iFBajas.add(pBajas4);
			
	        // ==========================================================================================================
			
			iFCambios = new JInternalFrame("Cambios Huéspedes", false, true, false);
			iFCambios.getContentPane().setLayout(null);
			iFCambios.setSize(700, 600);
			iFCambios.setDefaultCloseOperation(HIDE_ON_CLOSE);
			iFCambios.setVisible(false);
			iFCambios.setLocation(x, y-45);
	        desktopPane.add(iFCambios);
			
			pMod1 = new JPanel();
				pMod1.setLayout(null);
				pMod1.setBackground(new Color(255, 128, 0));
				pMod1.setBounds(0, 0, 700, 70);
				
				JLabel labelCambios = new JLabel("CAMBIOS HUÉSPED");
				obj.agregarEtiqueta(labelCambios, 20, 20, 500, 40, pMod1, letra1, Color.WHITE);								
			iFCambios.add(pMod1);
			
			pMod2 = new JPanel();
				pMod2.setLayout(null);
				pMod2.setBounds(45, 80, 600, 70);
				pMod2.setBorder(new EtchedBorder());
								
				JLabel idHuespedM = new JLabel("ID HUESPED: ");
				obj.agregarEtiqueta(idHuespedM, 50, 22, 300, 30, pMod2, letra2, null);
				
				idM = new JTextField();
				idM.addKeyListener(this);
				obj.añadirAPanel(idM, 150, 25, 170, 25, null, pMod2);
								
				buscarM = new JButton(obj.iconos("Iconos/Search.png", 40) );
				buscarM.addActionListener(this);
				obj.añadirAPanel(buscarM, 350, 15, 40, 40, null, pMod2);
				
				clear3 = new JButton("Limpiar");
				clear3.addActionListener(this);
				obj.añadirAPanel(clear3, 430, 5, 100, 25, letra2, pMod2);
				
				modificar = new JButton("Modificar");
				modificar.addActionListener(this);
				obj.añadirAPanel(modificar, 430, 40, 100, 25, letra2, pMod2);
			iFCambios.add(pMod2);
				
			pMod3 = new JPanel();
				pMod3.setLayout(null);
				pMod3.setBounds(0, 150, 700, 220);
						
				JLabel nombreM = new JLabel("NOMBRE: ");
				obj.añadirAPanel(nombreM, 80, 20, 300, 30, letra2, pMod3);
				
				nomM = new JTextField();
				nomM.addKeyListener(this);
				obj.añadirAPanel(nomM, 190, 22, 250, 25, null, pMod3);
								
				JLabel apellidoPM = new JLabel("APELLIDO PATERNO: ");
				obj.añadirAPanel(apellidoPM, 80, 60, 300, 30, letra2, pMod3);
								
				apePM = new JTextField();
				apePM.addKeyListener(this);
				obj.añadirAPanel(apePM, 260, 62, 180, 25, null, pMod3);
				
				JLabel apellidoMM = new JLabel("APELLIDO MATERNO: ");
				obj.añadirAPanel(apellidoMM, 80, 100, 300, 30, letra2, pMod3);
				
				apeMM = new JTextField();
				apeMM.addKeyListener(this);
				obj.añadirAPanel(apeMM, 260, 102, 180, 25, null, pMod3);
				
				JLabel fecNacM = new JLabel("FECHA NACIMIENTO: ");
				obj.añadirAPanel(fecNacM, 80, 140, 300, 30, letra2, pMod3);
				
				fecM = new JTextField();
				fecM.addKeyListener(this);
				obj.añadirAPanel(fecM, 260, 142, 180, 25, null, pMod3);
								
				JLabel telefonoM = new JLabel("TElÉFONO: ");
				obj.añadirAPanel(telefonoM, 80, 180, 300, 30, letra2, pMod3);
				
				telM = new JTextField();
				telM.addKeyListener(this);
				obj.añadirAPanel(telM, 260, 182, 180, 25, null, pMod3);	
			iFCambios.add(pMod3);
			
			pMod4 = new JPanel();
				pMod4.setLayout(new BorderLayout());
				pMod4.setBounds(20, 400, 650, 120);
				
				tablaCambios = new JTable(6,6);
				obj.crearTabla(pMod4, tablaCambios);
			iFCambios.add(pMod4);
			
			// ==========================================================================================================
			
			iFConsultas = new JInternalFrame("Consultas Alumnos", false, true, false);
			iFConsultas.getContentPane().setLayout(null);
			iFConsultas.setSize(700, 600);
			iFConsultas.setDefaultCloseOperation(HIDE_ON_CLOSE);
			iFConsultas.setVisible(false);
			iFConsultas.setLocation(x, y-45);
			desktopPane.add(iFConsultas);
			
			pCon1 = new JPanel();
				pCon1.setLayout(null);
				pCon1.setBackground(new Color(24, 71, 235));
				pCon1.setBounds(0, 0, 700, 70);
				
				JLabel labelConsultas = new JLabel("CONSULTAS HUÉSPED");
				obj.agregarEtiqueta(labelConsultas, 20, 20, 500, 40, pCon1, letra1, Color.WHITE);								
			iFConsultas.add(pCon1);
			
			pCon2 = new JPanel();
				pCon2.setLayout(null);
				pCon2.setBounds(10, 90, 670, 300);
				pCon2.setBorder(new TitledBorder(new EtchedBorder(), "Selecciona criterio de búsqueda: "));
				
				ButtonGroup bg = new ButtonGroup();
								
				rTodos = new JRadioButton("TODOS");
				rTodos.addActionListener(this);
				obj.agregarRadioButton(rTodos, 20, 40, 70, 30, pCon2, letra3);
				
				rNombre = new JRadioButton("NOMBRE");
				rNombre.addActionListener(this);
				obj.agregarRadioButton(rNombre, 120, 40, 120, 30, pCon2, letra3);
				
				rApeP = new JRadioButton("APELLIDO PATERNO");
				rApeP.addActionListener(this);
				obj.agregarRadioButton(rApeP, 120, 90, 150, 30, pCon2, letra3);
				
				rApeM = new JRadioButton("APELLIDO MATERNO");
				rApeM.addActionListener(this);
				obj.agregarRadioButton(rApeM, 120, 140, 150, 30, pCon2, letra3);
				
				rTelefono = new JRadioButton("TELÉFONO");
				rTelefono.addActionListener(this);
				obj.agregarRadioButton(rTelefono, 120, 190, 120, 30, pCon2, letra3);
				
				rFecha = new JRadioButton("FECHA NACIMIENTO");
				rFecha.addActionListener(this);
				obj.agregarRadioButton(rFecha, 120, 240, 150, 30, pCon2, letra3);
				
				bg.add(rTodos);
				bg.add(rNombre);
				bg.add(rApeP);
				bg.add(rApeM);
				bg.add(rTelefono);
				bg.add(rFecha);
				
				nomC = new JTextField();
				nomC.setEnabled(false);
				nomC.addKeyListener(this);
				obj.añadirAPanel(nomC, 270, 40, 180, 30, null, pCon2);
				
				apePC = new JTextField();
				apePC.setEnabled(false);
				apePC.addKeyListener(this);
				obj.añadirAPanel(apePC, 270, 90, 180, 30, null, pCon2);
				
				apeMC = new JTextField();
				apeMC.setEnabled(false);
				apeMC.addKeyListener(this);
				obj.añadirAPanel(apeMC, 270, 140, 180, 30, null, pCon2);
				
				telC = new JTextField();
				telC.setEnabled(false);
				telC.addKeyListener(this);
				obj.añadirAPanel(telC, 270, 190, 180, 30, null, pCon2);
				
				fecC = new JTextField();
				fecC.setEnabled(false);
				fecC.addKeyListener(this);
				obj.añadirAPanel(fecC, 270, 240, 180, 30, null, pCon2);
				
				consultar = new JButton(obj.iconos("Iconos/Search.png", 40));
				consultar.addActionListener(this);
				obj.añadirAPanel(consultar, 500, 60, 100, 45, null, pCon2);
			
				clear4 = new JButton("Limpiar");
				clear4.addActionListener(this);
				obj.añadirAPanel(clear4, 500, 145, 100, 25, null, pCon2);
			iFConsultas.add(pCon2);
			
			pCon3 = new JPanel();
				pCon3.setLayout(new BorderLayout());
				pCon3.setBounds(20, 400, 650, 120);
				
				tablaConsultas = new JTable(6,6);
				obj.crearTabla(pCon3, tablaConsultas);
			iFConsultas.add(pCon3);
			
			// ==========================================================================================================
			
	     add(desktopPane, BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(btnAdd) || e.getSource().equals(altaHuesped)) {
			iFAltas.setVisible(true);
			iFBajas.setVisible(false);
			iFCambios.setVisible(false);
			iFConsultas.setVisible(false);
		} else if(e.getSource().equals(btnDel) || e.getSource().equals(bajaHuesped)) {
			iFAltas.setVisible(false);
			iFBajas.setVisible(true);
			iFCambios.setVisible(false);
			iFConsultas.setVisible(false);
		} else if(e.getSource().equals(btnCam) || e.getSource().equals(cambioHuesped)) {
			iFAltas.setVisible(false);
			iFBajas.setVisible(false);
			iFCambios.setVisible(true);
			iFConsultas.setVisible(false);
		} else if(e.getSource().equals(btnCon) || e.getSource().equals(consultaHuesped)) {
			iFAltas.setVisible(false);
			iFBajas.setVisible(false);
			iFCambios.setVisible(false);
			iFConsultas.setVisible(true);
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		char var = e.getKeyChar();
		if(e.getSource().equals(nombre) || e.getSource().equals(nomM) || e.getSource().equals(nomC) || e.getSource().equals(apeP) || e.getSource().equals(apePM) || e.getSource().equals(apePC) || e.getSource().equals(apeM) || e.getSource().equals(apeMM) || e.getSource().equals(apeMC) ) {
			if(Character.isLetter(var) || var == KeyEvent.VK_BACK_SPACE || var == KeyEvent.VK_ENTER || e.getKeyCode() == 16 || Character.isWhitespace(var)) {
				
			} else {
				getToolkit().beep();
				JOptionPane.showMessageDialog(rootPane, "Solo puedes ingresar letras", "Error", JOptionPane.WARNING_MESSAGE);
				obj.restablecerComponentes((JComponent)e.getComponent());
			}
		}
		
		if(e.getSource().equals(idHue) || e.getSource().equals(idB) || e.getSource().equals(idM) || e.getSource().equals(tel) || e.getSource().equals(telM) || e.getSource().equals(telC)) {
			if(Character.isDigit(var) || var == KeyEvent.VK_BACK_SPACE || var == KeyEvent.VK_ENTER) {
				
			} else {
				getToolkit().beep();
				JOptionPane.showMessageDialog(rootPane, "Solo puedes ingresar números", "Error", JOptionPane.WARNING_MESSAGE);
				obj.restablecerComponentes((JComponent)e.getComponent());
			}
		}
	}

	
	
}

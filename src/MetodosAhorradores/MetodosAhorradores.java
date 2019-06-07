package MetodosAhorradores;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import Controlador.HuespedDAO;
import Modelo.Huesped;
import Pantallas.ResultSetTableModel;

public class MetodosAhorradores {

	DefaultTableModel modelo;
	
	public void acomodarComponentes(JComponent componente, int x, int y, int width, int height, Font letra) {
		componente.setBounds(x, y, width, height);
		componente.setFont(letra);
		componente.setForeground(Color.BLACK);
	}
	
	public void añadirAPanel(JComponent componente, int x, int y, int width, int height, Font letra, JPanel panel) {
		componente.setBounds(x, y, width, height);
		componente.setFont(letra);
		panel.add(componente);
	}
	
	public void restablecerComponentes(JComponent...componentes) {
		for(JComponent c : componentes){
			if(c instanceof JTextField)
				((JTextField) c).setText("");
			
			if(c instanceof JComboBox)
				((JComboBox) c).setSelectedIndex(0);
		
			if(c instanceof JPasswordField)
				((JPasswordField) c).setText("");
		
		}	
	}
	
	public ImageIcon iconos(String ruta, int tam) {
		ImageIcon imag = new ImageIcon(ruta);
		ImageIcon img = new ImageIcon(imag.getImage().getScaledInstance(tam, tam, Image.SCALE_DEFAULT));
		return img;
	}

	public void agregarEtiqueta(JLabel componente, int x, int y, int width, int height, JPanel panel, Font letra, Color color) {
		añadirAPanel(componente, x, y, width, height, letra, panel);
		componente.setForeground(color);
	}

	public void crearTabla(JPanel panel, JTable table) {
		
		modelo = (DefaultTableModel) table.getModel();
	
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        TableColumnModel columnModel = table.getColumnModel();

        for(int i=0; i<table.getColumnCount(); i++) {
        	columnModel.getColumn(i).setPreferredWidth(50);
        }
	    		        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
                
        for(int i=0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(tcr);
		}
       
        JScrollPane scroll = new JScrollPane(table);
		panel.add(scroll, BorderLayout.CENTER);		
		
	}
	
	public void agregarRadioButton(JRadioButton r, int x, int y, int width, int height, JPanel panel, Font letra ) {
		r.setFont(letra);
		añadirAPanel(r, x, y, width, height, null, panel);
	}

	public void habilitarRadioButtons(JTextField f1, JTextField f2, JTextField f3, JTextField f4, JTextField t1) {
		f1.setEnabled(false);
		f2.setEnabled(false);
		f3.setEnabled(false);
		f4.setEnabled(false);
		t1.setEnabled(true);
	}
	
	public void actualizarTablaConsultas(JTable tabla, String consulta) {
		
		String controlador = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost/BD_HUESPED?useTimezone=true&serverTimezone=UTC";
		ResultSetTableModel modeloDatos = null;
		
		try {
			modeloDatos=new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		tabla.setModel(modeloDatos);
	}
	
	public void actualizarTablas(JTable tabla ) {
		
		String controlador = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost/BD_HUESPED?useTimezone=true&serverTimezone=UTC";
		String consulta = "SELECT * FROM Huesped";
		ResultSetTableModel modeloDatos = null;
		
		try {
			modeloDatos=new ResultSetTableModel(controlador, url, consulta);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		tabla.setModel(modeloDatos);
	}

	public void llenarCampos(JTextField nombre, JTextField apeP, JTextField apeM, JTextField fecNac, JTextField telefono, String idHuesped) {
		HuespedDAO hdao = new HuespedDAO();
		Huesped h1 = hdao.buscarHuesped(idHuesped, "ID_Huesped");
		nombre.setText(h1.getNombre());
		apeP.setText(h1.getApellidoP());
		apeM.setText(h1.getApellidoM());
		fecNac.setText(h1.getFechaNac());
		telefono.setText(h1.getTelefono());
	}

	


}

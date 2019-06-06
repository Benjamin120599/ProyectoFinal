package Pantallas;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Inicio {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//new Login();
				new VentanaPrincipal(); 
			}
		});
	}
}

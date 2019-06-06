package Pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MetodosAhorradores.MetodosAhorradores;

public class Login extends JFrame implements KeyListener {
	
	MetodosAhorradores comp = new MetodosAhorradores();
	JTextField usuario;
	JPasswordField contrase�a;
	JButton login;
	
	public Login() {
		
		getContentPane().setLayout(null);
		setTitle("Login");
		setSize(310, 160);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		Font letra1 = new Font("Times New Roman", Font.ITALIC, 14);
		
		JLabel lblUser = new JLabel("Usuario: ");
		comp.acomodarComponentes(lblUser, 30, 20, 100, 25, letra1);
		add(lblUser);
		
		usuario = new JTextField();
		usuario.addKeyListener(this);
		comp.acomodarComponentes(usuario, 120, 20, 150, 25, letra1);
		add(usuario);
		
		JLabel lblPass = new JLabel("Contrase�a: ");
		comp.acomodarComponentes(lblPass, 30, 60, 100, 25, letra1);
		add(lblPass);
		
		contrase�a = new JPasswordField();
		contrase�a.addKeyListener(this);
		comp.acomodarComponentes(contrase�a, 120, 60, 150, 25, letra1);
		add(contrase�a);
		
		login = new JButton("Login");
		comp.acomodarComponentes(login, 100, 100, 100, 25, letra1);
		login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(usuario.getText().equals("") || contrase�a.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "A�n hay casillas vac�as.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				} else {
					if(usuario.getText().equals("admin")) {
						
						char[] pass = contrase�a.getPassword();
						String password ="";
						for(int i=0; i < pass.length; i++) {
							password = password+pass[i];
						}
						
						if(password.equals("pass")) {
							new VentanaPrincipal();
							dispose();
						} else {
							JOptionPane.showMessageDialog(rootPane, "Contrase�a incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(rootPane, "Usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		add(login);
		
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
		if(e.getSource().equals(usuario)) {
			if(Character.isLetter(var) || var == KeyEvent.VK_BACK_SPACE || var == KeyEvent.VK_ENTER ) {
				
			} else {
				getToolkit().beep();
				JOptionPane.showMessageDialog(rootPane, "Solo puedes ingresar letras", "Error", JOptionPane.WARNING_MESSAGE);
				comp.restablecerComponentes(usuario, contrase�a);
			}
		} else if(e.getSource().equals(contrase�a)) {
			
			if(Character.isLetterOrDigit(var) || var == KeyEvent.VK_BACK_SPACE || var == KeyEvent.VK_ENTER) {
				
			} else {
				getToolkit().beep();
				JOptionPane.showMessageDialog(rootPane, "Solo puedes ingresar letras o n�meros", "Error", JOptionPane.WARNING_MESSAGE);
				comp.restablecerComponentes(usuario, contrase�a);
			}
		}
	}


}

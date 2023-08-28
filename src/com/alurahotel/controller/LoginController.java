package com.alurahotel.controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.aluraholel.modelo.Usuarios;
import com.alurahotel.dao.LoginDAO;
import com.alurahotel.dao.ReservasDAO;
import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.views.MenuUsuario;

public class LoginController {
	
	private LoginDAO loginDAO;
	
	public LoginController() {
		this.loginDAO = new LoginDAO(new ConnectionFactory().recuperaConexion());
	}
	public boolean login(String usuario, String contrasena) {
		
		return loginDAO.loginIn(usuario, contrasena);
		
	}
	
	

}

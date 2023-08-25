package com.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.aluraholel.modelo.*;
import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.views.MenuUsuario;
public class LoginDAO {
	
	final private Connection con;
	
	public LoginDAO(Connection con) {
		this.con = con;
	}
	
	public List<Usuarios> loginIn(String usuario,String pass) {		 
		List<Usuarios> usuarios = new ArrayList<>();
		
		try {
			PreparedStatement pstm = con.prepareStatement("SELECT USER_NAME, CONTRASEÑA FROM USUARIOS WHERE "
					+ "USER_NAME = ? " 
					+ "AND CONTRASEÑA = ?");
			
			pstm.setString(1, usuario);
			pstm.setString(2, pass);
			pstm.execute();
			
			ResultSet resultSet = pstm.getResultSet();

			if (resultSet.next()) {
//				String user= resultSet.getString("USER_NAME");
//				String contra = resultSet.getString("CONTRASEÑA");
				
				var validacion = new Usuarios(resultSet.getString("USER_NAME"), resultSet.getString("CONTRASEÑA"));
				
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return usuarios;
		
	}
	

}

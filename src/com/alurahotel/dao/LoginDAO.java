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

	public boolean loginIn(String usuario, String contrasena) {
		
		try {
			PreparedStatement pstm = con.prepareStatement(
					"SELECT NOMBRE_USUARIO, CONTRASENA FROM USUARIOS WHERE " + "NOMBRE_USUARIO = ? " + "AND CONTRASENA = ?");
			try (pstm) {
				pstm.setString(1, usuario);
				pstm.setString(2, contrasena);
				pstm.execute();

				ResultSet resultSet = pstm.getResultSet();
				
				try (resultSet) {
					
					return resultSet.next();

				}
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
			return false;
			
		}

	}

}

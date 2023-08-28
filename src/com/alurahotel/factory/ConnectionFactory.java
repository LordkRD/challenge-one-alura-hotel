package com.alurahotel.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import javax.swing.JOptionPane;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	private DataSource dataSource;
	
	public ConnectionFactory() {
		var pooledDataSource = new ComboPooledDataSource();
		pooledDataSource.setJdbcUrl("jdbc:mysql://localhost/alura_hotel?useTimeZone=true&serverTimeZone=UTC");
		pooledDataSource.setUser("root");
		pooledDataSource.setPassword("root123");
		pooledDataSource.setMaxPoolSize(10);
		
		this.dataSource = pooledDataSource;
		
	}
	
	public Connection recuperaConexion(){
	
		try {
			return this.dataSource.getConnection();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			
			throw new RuntimeException(e);
			
		}
	}

}

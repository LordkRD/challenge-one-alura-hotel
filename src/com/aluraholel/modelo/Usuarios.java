package com.aluraholel.modelo;

public class Usuarios {
	
	private String usuario;
	private String contraseña;
	
	public Usuarios(String usuario,String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
	}

	public Usuarios() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public String getContreseña() {
		return contraseña;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
		
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
		
	}
	
	
	
	

}

package com.aluraholel.modelo;

import javax.annotation.processing.SupportedSourceVersion;

import com.alurahotel.dao.ReservasDAO;

public class Reservas {
	
	private Integer id;
	private String fechaEntrada;
	private String fechaSalida;
	private Float valor;
	private String formaPago;
	
	public Reservas(Integer id, String fechaEntrada, String fechaSalida, Float valor, String formaPago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
		
	}
	
	public Reservas(String fechaEntrada, String fechaSalida, Float valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	
	public Reservas(Integer id) {
		this.id = id;
	}

	public Reservas() {
		super();
	}

	public Integer getId() {
		return id;
		
	}
	
	public boolean bId(Integer id) {
		this.id = id;
		return true;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	@Override
	public String toString() {
		
		return this.getId().toString();
	}


	
}

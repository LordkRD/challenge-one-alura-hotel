package com.aluraholel.modelo;

import java.util.Date;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;

public class Valor {
	
	private float valor;
	private int fEntrada;
	private int fSalida;
	
	public Valor(float valor) {
		
		this.valor = valor;
				
	}
	
	public Valor(int fEntrada, int fSalida) {
		
		this.fEntrada = fEntrada;
		this.fSalida = fSalida;
				
	}
	
	public Valor() {
		
	}
	
	public float calcular() {
		double precio = 5144.25;
		System.out.println(fSalida + " y " + fEntrada);
		int cantidadDia = getfSalida() - getfEntrada();
		
		if (cantidadDia != 0) {
			float valorRotal = (float) (cantidadDia * precio);
			setValor(valorRotal);
			return valorRotal;
			
		}else {
			
			setValor((float) precio);
			return (float) precio;
		}
			
		
		
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public float getValor() {
		return valor;
	}

	public int getfEntrada() {
		return fEntrada;
	}

	public void setfEntrada(int fEntrada) {
		this.fEntrada = fEntrada;
	}

	public int getfSalida() {
		return fSalida;
	}

	public void setfSalida(int fSalida) {
		this.fSalida = fSalida;
	}

	
	
}

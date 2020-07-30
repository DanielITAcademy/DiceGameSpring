package com.ITAcademy.dto;

public class Dice {
	private int roll;
	
	// Constructor 
	
	public Dice() {
		this.roll = (int) (Math.random() * 6 )+1;
	}
	
	//Getters y setters
	
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	//impresión de datos por consola
	@Override
	public String toString() {
		return "Dice [roll=" + roll + "]";
	}
	
}



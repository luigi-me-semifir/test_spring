package com.example.demo.calculatrice;

import org.springframework.stereotype.Service;

@Service
public class CalculatriceService {
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public int sous(int a, int b) {
		return a - b;
	}
	
	public int mult(int a, int b) {
		return a * b;
	}
	
	public int div(int a, int b) {
		return a / b;
	}
	
	public int modulo(int a, int b) {
		return a % b;
	}
	
	public int calcul(Calculatrice calculatrice) {
		int resultat = 0;
		switch(calculatrice.getOperation()) {
		case "+":
			resultat = add(calculatrice.getNombre1(),calculatrice.getNombre2());
			break;
		case "-":
			resultat = sous(calculatrice.getNombre1(),calculatrice.getNombre2());
			break;
		case "*":
			resultat = mult(calculatrice.getNombre1(),calculatrice.getNombre2());
			break;
		case "/":
			resultat = div(calculatrice.getNombre1(),calculatrice.getNombre2());
			break;
		case "%":
			resultat = modulo(calculatrice.getNombre1(),calculatrice.getNombre2());
			break;
		}
		return resultat;
	}

}

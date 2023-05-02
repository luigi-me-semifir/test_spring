package com.example.demo.calculatrice;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
@Getter
@Setter
public class Calculatrice {
	private String operation;
	private int nombre1;
	private int nombre2;
	
}

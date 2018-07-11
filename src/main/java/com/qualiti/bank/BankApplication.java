package com.qualiti.bank;

import java.awt.EventQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.qualiti.bank.fachada.IFachada;

@SpringBootApplication
public class BankApplication {
	
	@Autowired
	private static IFachada fachada;

	public static void main(String[] args) {
		
	}
}

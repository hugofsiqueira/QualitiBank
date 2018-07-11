package com.qualiti.bank.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue(value="CLIENTE")
public class Cliente extends Pessoa {
	
	@Enumerated(EnumType.STRING)
	private TipoCliente tipo;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}
	
	public Cliente(String cpf) {
		super(cpf);
	}

	public TipoCliente getTipo() {
		return tipo;
	}
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}
}

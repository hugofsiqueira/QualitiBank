package com.qualiti.bank.model;


public class Cliente extends Pessoa {
	
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

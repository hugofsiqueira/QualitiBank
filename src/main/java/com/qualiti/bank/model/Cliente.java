package com.qualiti.bank.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="CLIENTE")
@Getter
@Setter
public class Cliente extends Pessoa {
	
	@Enumerated(EnumType.STRING)
	private TipoCliente tipo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="cliente")
	private Set<Conta> listaContas;
	
	
	public Cliente() {}
	
	public Cliente(String nome, String cpf) {
		setNome(nome);
		setCpf(cpf);
	}
	
	public Cliente(String cpf) {
		super(cpf);
	}
}

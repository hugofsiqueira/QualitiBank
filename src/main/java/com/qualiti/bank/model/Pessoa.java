package com.qualiti.bank.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pessoa extends BancoEntity<String>{
	
	protected String nome;
	private TipoPessoa tipoPessoa;
	private String cpf;
	private String login;
	private String senha;
	private Endereco endereco;
	private BigDecimal salario;
	

	public static void main(String[] args) {
		Pessoa pessoa = new Pessoa();
		List<String> teste = new ArrayList<>();
		List<Object> teste2 = new ArrayList<>();
	}
	
	public Pessoa(String cpf) {
		this.cpf = cpf;
	}
	
	public Pessoa() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String getChave() {
		return cpf;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	

}

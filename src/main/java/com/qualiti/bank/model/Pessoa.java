package com.qualiti.bank.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipopessoa", discriminatorType=DiscriminatorType.STRING)
@Getter
@Setter
@EqualsAndHashCode(of= {"cpf"}, callSuper=false)
public class Pessoa extends BancoEntity<String>{
	
	protected String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipopessoa", updatable=false, insertable=false)
	private TipoPessoa tipoPessoa;
	
	@Id
	private String cpf;
	
	private String login;
	private String senha;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="cpf")
	private Endereco endereco;
	
	private BigDecimal salario;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
//	@Transient
//	private String teste;
	
	
	public Pessoa(String cpf) {
		this.cpf = cpf;
	}
	
	public Pessoa() {}

	@Override
	public String getChave() {
		return cpf;
	}
	

}

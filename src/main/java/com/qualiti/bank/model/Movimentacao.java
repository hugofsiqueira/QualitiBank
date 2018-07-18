package com.qualiti.bank.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "movimentacao")
public class Movimentacao extends BancoEntity<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idMovimentacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipo;
	
	@ManyToOne
	@MapsId("userDetail")
	@JoinColumn(name="contageradora")
	private Conta contaGeradora;
	
	private double valor;
	private String contaDestino;
	

	@Override
	public Long getChave() {
		return idMovimentacao;
	}
	
	
}

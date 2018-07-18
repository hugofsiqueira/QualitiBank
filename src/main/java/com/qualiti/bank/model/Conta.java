package com.qualiti.bank.model;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.qualiti.bank.exceptions.BancoException;


@Entity
@Table(name = "conta")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="CORRENTE")
public class Conta extends BancoEntity<ContaId>{
	
	@EmbeddedId
	@AttributeOverrides( { 

		@AttributeOverride(name = "agencia", column =
				@Column(name = "agencia", nullable = false)),
		
		@AttributeOverride(name = "numero", column =
				@Column(name = "numero", nullable = false))
		
		})
	private ContaId contaId;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "agencia", nullable = false, insertable = false, updatable = false)
	private Agencia agencia;
	
	private BigDecimal saldo;
	
	@Enumerated(EnumType.STRING)
	@Column(insertable = false, updatable = false)
	private TipoConta tipo;
	
	@ManyToOne
	@JoinColumn(name="cliente")
	private Cliente cliente;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="contaGeradora", 
												cascade=CascadeType.ALL)
	private Set<Movimentacao> movimentacoes;
	
	
	public Conta() {
		saldo = new BigDecimal(0);
		saldo.setScale(2);
	}
	
	public void creditar(BigDecimal valor) {
		saldo = saldo.add(valor);
	}
	
	public void debitar(BigDecimal valor) 
			throws BancoException {
		if(getSaldo().compareTo(valor) >= 0) {
			saldo = saldo.subtract(valor);
		}else {
			throw new 
			BancoException("Saldo insuficiente");
		}	
	}
	
	public void transferir(Conta contaDestino, 
			BigDecimal valor) 
			throws BancoException {
		
		debitar(valor);
		contaDestino.creditar(valor);
	}
	
	@Override
	public String toString() {
		return "Conta [contaId=" + contaId + ", saldo=" + saldo + ", tipo=" + tipo + ", cliente=" + cliente + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contaId == null) ? 0 : contaId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (contaId == null) {
			if (other.contaId != null)
				return false;
		} else if (!contaId.equals(other.contaId))
			return false;
		return true;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public TipoConta getTipo() {
		return tipo;
	}
	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ContaId getContaId() {
		return contaId;
	}

	public void setContaId(ContaId contaId) {
		this.contaId = contaId;
	}

	@Override
	public ContaId getChave() {
		return contaId;
	}

}

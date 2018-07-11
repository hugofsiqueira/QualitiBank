package com.qualiti.bank.model;

import java.math.BigDecimal;

import com.qualiti.bank.exceptions.BancoException;



public class Conta extends BancoEntity<ContaId>{
	
	private ContaId contaId;
	private BigDecimal saldo;
	private TipoConta tipo;
	private Cliente cliente;
	
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

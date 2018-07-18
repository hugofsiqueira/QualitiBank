package com.qualiti.bank.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContaId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3875856927737658486L;
	
	private String numero;
	private String agencia;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		ContaId other = (ContaId) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ContaId [numero=" + numero + ", agencia=" + agencia + "]";
	}
	
}

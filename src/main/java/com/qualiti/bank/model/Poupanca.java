package com.qualiti.bank.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="POUPANCA")
public class Poupanca extends Conta {
	
	
	public void renderJuros(double taxa) {
		BigDecimal juros = getSaldo().multiply(new BigDecimal(taxa));
		BigDecimal saldoAtualizado = getSaldo().add(juros);
		setSaldo(saldoAtualizado);
	}

}

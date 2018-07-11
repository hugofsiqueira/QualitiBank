package com.qualiti.bank.model;

import java.math.BigDecimal;

public class Poupanca extends Conta {
	
	
	public void renderJuros(double taxa) {
		BigDecimal juros = getSaldo().multiply(new BigDecimal(taxa));
		BigDecimal saldoAtualizado = getSaldo().add(juros);
		setSaldo(saldoAtualizado);
	}

}

package com.qualiti.bank.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="BONUS")
public class ContaBonus extends Conta {
	
	public static final BigDecimal TAXA = new BigDecimal(0.1);
	
	private BigDecimal bonus;
	
	public ContaBonus() {
		bonus = BigDecimal.ZERO;
	}
	
	public void renderBonus() {
		BigDecimal saldoAtual = getSaldo();
		BigDecimal saldoFinal = saldoAtual.add(bonus);
		bonus = BigDecimal.ZERO;
		setSaldo(saldoFinal);
	}
	
	@Override
	public void creditar(BigDecimal valor) {
		BigDecimal valorBonus = valor.multiply(TAXA);
		bonus = bonus.add(valorBonus);

		super.creditar(valor);
	}

	public BigDecimal getBonus() {
		return bonus;
	}

	public void setBonus(BigDecimal bonus) {
		this.bonus = bonus;
	}

}

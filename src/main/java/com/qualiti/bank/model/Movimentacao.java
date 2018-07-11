package com.qualiti.bank.model;

import java.util.Date;

public class Movimentacao extends BancoEntity<Long> {

	private Long idMovimentacao;
	private Date data;
	

	@Override
	public Long getChave() {
		return idMovimentacao;
	}

	public Long getIdMovimentacao() {
		return idMovimentacao;
	}

	public void setIdMovimentacao(Long idMovimentacao) {
		this.idMovimentacao = idMovimentacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
}

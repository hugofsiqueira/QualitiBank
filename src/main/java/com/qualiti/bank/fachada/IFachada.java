package com.qualiti.bank.fachada;

import java.math.BigDecimal;
import java.util.List;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Agencia;
import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.model.Conta;
import com.qualiti.bank.model.ContaId;

public interface IFachada {
	
	void cadastrarCliente(Cliente cliente) throws BancoException;
	Cliente procurarCliente(String cpf) throws BancoException;
	void removerCliente(String cpf) throws BancoException;
	void atualizarCliente(Cliente cliente) throws BancoException;
	
	String nomesClienteOrdemAlfabetica();
	
	
	
	void cadastrarConta(Conta conta) throws BancoException;
	Conta procurarConta(ContaId contaId) throws BancoException;
	void removerConta(ContaId contaId) throws BancoException;
	void atualizarConta(Conta conta) throws BancoException;
	void renderJurosPoupancas(double taxa) throws BancoException;
	
	Cliente recuperarClienteVip();
	Conta[] recuperarContasSaldoMenor
							(BigDecimal valor) throws BancoException;
	
	List<Agencia> buscarAgencias();
	
	void realizarCredito(Conta conta, double valor) throws BancoException;

}

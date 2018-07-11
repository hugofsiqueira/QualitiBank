package com.qualiti.bank.fachada;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Cliente;

public interface IFachada {
	
	void cadastrarCliente(Cliente cliente) throws BancoException;
	Cliente procurarCliente(String cpf) throws BancoException;
	void removerCliente(String cpf) throws BancoException;
	void atualizarCliente(Cliente cliente) throws BancoException;
	
	String nomesClienteOrdemAlfabetica();

}

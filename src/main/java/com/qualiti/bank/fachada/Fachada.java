package com.qualiti.bank.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.service.cliente.IClienteBO;

@Controller
public class Fachada implements IFachada {
	
	
	@Autowired
	private IClienteBO serviceCliente;
	
	
	
	@Override
	public void cadastrarCliente(Cliente cliente) throws BancoException {
		serviceCliente.cadastrar(cliente);
	}

	@Override
	public Cliente procurarCliente(String cpf) throws BancoException {
		return serviceCliente.procurar(cpf);
	}

	@Override
	public void removerCliente(String cpf) throws BancoException {
		serviceCliente.remover(cpf);
	}

	@Override
	public void atualizarCliente(Cliente cliente) throws BancoException {
		serviceCliente.atualizar(cliente);
	}

	@Override
	public String nomesClienteOrdemAlfabetica() {
		return serviceCliente.nomesClienteOrdemAlfabetica();
	}

}

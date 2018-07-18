package com.qualiti.bank.fachada;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Agencia;
import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.model.Conta;
import com.qualiti.bank.model.ContaId;
import com.qualiti.bank.service.agencia.IAgenciaBO;
import com.qualiti.bank.service.cliente.IClienteBO;
import com.qualiti.bank.service.conta.IContaBO;

@Controller
public class Fachada implements IFachada {
	
	
	@Autowired
	private IClienteBO serviceCliente;
	
	@Autowired
	private IContaBO serviceConta;
	
	@Autowired
	private IAgenciaBO serviceAgencia;
	
	
	
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

	@Override
	public void cadastrarConta(Conta conta) throws BancoException {
		serviceConta.cadastrar(conta);
	}

	@Override
	public Conta procurarConta(ContaId contaId) throws BancoException {
		return serviceConta.
				procurar(contaId);
	}

	@Override
	public void removerConta(ContaId contaId) throws BancoException {
		serviceConta.remover(contaId);
	}

	@Override
	public void atualizarConta(Conta conta) throws BancoException {
		serviceConta.atualizar(conta);
	}

	@Override
	public void renderJurosPoupancas(double taxa) throws BancoException {
		serviceConta.renderJurosPoupancas(taxa);
	}

	@Override
	public Cliente recuperarClienteVip() {
		return serviceConta.recuperarClienteVip();
	}

	@Override
	public Conta[] recuperarContasSaldoMenor
								(BigDecimal valor) throws BancoException {
		
		return serviceConta.
				recuperarContasSaldoMenor(valor);
	}

	@Override
	public List<Agencia> buscarAgencias() {
		return serviceAgencia.buscarAgencias();
	}

	@Override
	public void realizarCredito(Conta conta, double valor) throws BancoException {
		serviceConta.realizarCredito(conta, valor);
	}

	

}

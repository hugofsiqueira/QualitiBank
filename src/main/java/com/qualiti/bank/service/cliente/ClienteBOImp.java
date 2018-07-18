package com.qualiti.bank.service.cliente;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qualiti.bank.dao.cliente.ClienteDAO;
import com.qualiti.bank.exceptions.BancoException;
import com.qualiti.bank.model.Cliente;

@Service
public class ClienteBOImp implements IClienteBO {
	
	@Autowired
	private ClienteDAO repositorio;
	

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void cadastrar(Cliente cliente)
				throws BancoException {
		if(cliente == null) {
			throw new 
				BancoException("Cliente invalido");
		}
		
		if(cliente.getCpf() == null || 
				cliente.getCpf().trim().isEmpty()) {
			throw new 
				BancoException("CPF invalido");
		}
		
		Cliente c = procurar(cliente.getCpf());
		
		if(c == null) {
			repositorio.save(cliente);
		}else {
			throw new 
			    BancoException("CPF já cadastrado");
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente procurar(String cpf) 
			throws BancoException {
		if(cpf == null || 
				cpf.trim().isEmpty()) {
			throw new 
			      BancoException("CPF invalido");
		}
		
		Optional<Cliente> response = repositorio.findById(cpf);
		if(response.isPresent()) {
			return response.get();
		}
		
		return null;
	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void remover(String cpf) 
			throws BancoException {
		if(cpf == null || 
				cpf.trim().isEmpty()) {
			throw new 
				BancoException("CPF invalido");
		}
		
		Cliente c = procurar(cpf);
		
		if(c != null) {
			repositorio.delete(c);
			//repositorio.deleteById(cpf);
		}else {
			throw new 
			BancoException("Cliente não cadastrado");
		}
		
	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void atualizar(Cliente cliente) 
			throws BancoException{
		if(cliente == null) {
			throw new 
			BancoException("Cliente invalido");
		}
		
		if(cliente.getCpf() == null || 
				cliente.getCpf().trim().isEmpty()) {
			throw new 
			BancoException("CPF invalido");
		}
		
		Cliente c = procurar(
				cliente.getCpf());
		
		if(c != null) {
			repositorio.save(cliente);
		}else {
			throw new 
			BancoException("Cliente não cadastrado");
		}
	}

	@Override
	@Transactional(readOnly=true)
	public String nomesClienteOrdemAlfabetica() {
		return repositorio.
				nomesClienteOrdemAlfabetica();
	}


	@Override
	@Transactional(readOnly=true)
	public boolean existe(String cpf) throws BancoException {
		if(cpf == null || 
				cpf.trim().isEmpty()) {
			throw new 
				BancoException("CPF invalido");
		}
		return repositorio.existsById(cpf);
	}

}

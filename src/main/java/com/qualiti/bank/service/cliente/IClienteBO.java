package com.qualiti.bank.service.cliente;

import com.qualiti.bank.model.Cliente;
import com.qualiti.bank.service.generic.IGenericBO;

public interface IClienteBO extends IGenericBO<Cliente, String>{
	
	String nomesClienteOrdemAlfabetica();

}

package com.qualiti.bank.service.generic;

import com.qualiti.bank.exceptions.BancoException;

public interface IGenericBO<T, TiD> {
	
	void cadastrar(T entity) throws BancoException;
	T procurar(TiD chave) throws BancoException;
	void remover(TiD chave) throws BancoException;
	void atualizar(T entity) throws BancoException;
	boolean existe(TiD chave) throws BancoException;

}

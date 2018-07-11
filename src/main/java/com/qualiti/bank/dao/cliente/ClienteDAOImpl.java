package com.qualiti.bank.dao.cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


@Repository
public class ClienteDAOImpl implements ClienteDAOCustom {
	
    @PersistenceContext
    private EntityManager entityManager;


	@Override
	public String nomesClienteOrdemAlfabetica() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.qualiti.bank.dao.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qualiti.bank.model.Cliente;


@Repository
public interface ClienteDAO extends JpaRepository<Cliente, String>, 
														ClienteDAOCustom{
	
	

}

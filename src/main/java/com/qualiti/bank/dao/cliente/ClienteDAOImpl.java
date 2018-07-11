package com.qualiti.bank.dao.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;

import com.qualiti.bank.model.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAOCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String nomesClienteOrdemAlfabetica() {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

	    CriteriaQuery<Cliente> q = cb.createQuery(Cliente.class);
	    
	    Root<Cliente> c = q.from(Cliente.class);
	    
	    q.select(c).orderBy(cb.asc(c.get("nome")));
	    
	    TypedQuery<Cliente> query = entityManager.createQuery(q);
	    
	    List<Cliente> clientes = query.getResultList();
	    
	    String nomes = "";
	    
	    for(Cliente cliente : clientes) {
	    	nomes = nomes + cliente.getNome()+"\n";
	    }
		
		return nomes;
	}

}

package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class FascturaRepoImpl implements IFacturaRepo{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.manager.persist(factura);
	}

}

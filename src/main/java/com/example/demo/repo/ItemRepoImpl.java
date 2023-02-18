package com.example.demo.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Item;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ItemRepoImpl implements IItemRepo {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void insertar(Item item) {
		// TODO Auto-generated method stub
		this.manager.persist(item);
	}

	@Override
	public Item buscarCodBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = this.manager.getCriteriaBuilder();
		CriteriaQuery<Item> query = builder.createQuery(Item.class);
		Root<Item> root = query.from(Item.class);
		Predicate condicion1 = builder.equal(root.get("codigoBarras"), codigoBarras);
		query.select(root).where(condicion1);
		TypedQuery<Item> mySQL = this.manager.createQuery(query);
		
		try {
			return mySQL.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No se encontro el producto");
			return null;
		}
	}

	@Override
	public Integer actualizarStock(String codigoBarras, Integer Stock) {
		// TODO Auto-generated method stub

		Query query = this.manager.createNamedQuery("item.actualizarStock");
		query.setParameter("datoStock", Stock);
		query.setParameter("datoCodBarras", codigoBarras);

		return query.executeUpdate();
	}

}

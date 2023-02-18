package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Item;
import com.example.demo.repo.IItemRepo;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	private IItemRepo itemRepo;

	@Override
	public void ingresar(Item item) {
		// TODO Auto-generated method stub
		Item item2 = this.itemRepo.buscarCodBarras(item.getCodigoBarras());
		if(item2 == null) {
			this.itemRepo.insertar(item);
		}else {
			Integer stockActual = item.getStock() + item2.getStock();
			this.itemRepo.actualizarStock(item.getCodigoBarras(), stockActual);
		}
		
	}

	@Override
	public Integer consultarStock(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.itemRepo.buscarCodBarras(codigoBarras).getStock();
	}

	@Override
	public Item consultarItem(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.itemRepo.buscarCodBarras(codigoBarras);
	}

}

package com.example.demo.service;

import com.example.demo.modelo.Item;

public interface IItemService {
	
	public void ingresar(Item item);
	public Integer consultarStock(String codigoBarras);
	public Item consultarItem(String codigoBarras);

}

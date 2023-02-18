package com.example.demo.repo;

import com.example.demo.modelo.Item;

public interface IItemRepo {
	
	public void insertar(Item item);
	public Item buscarCodBarras(String codigoBarras);
	public Integer actualizarStock (String codigoBarras, Integer Stock);

}

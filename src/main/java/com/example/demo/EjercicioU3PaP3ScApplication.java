package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Item;
import com.example.demo.modelo.DTO.ItemDTO;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IItemService;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@SpringBootApplication
public class EjercicioU3PaP3ScApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(EjercicioU3PaP3ScApplication.class, args);
	}

	
	@Autowired 
	private IItemService itemService;
	@Autowired 
	private IFacturaService facturaService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//PARTE 1
		Item item = new Item();
		item.setCodigoBarras("123");
		item.setNombre("GalletaOreo");
		item.setPrecio(new BigDecimal(0.50));
		item.setStock(50);
		item.setTipo("Galleta");
		
		Item item2 = new Item();
		item2.setCodigoBarras("123");
		item2.setNombre("GalletaOreo");
		item2.setPrecio(new BigDecimal(0.50));
		item2.setStock(10);
		item2.setTipo("Galleta");
		
		Item item3 = new Item();
		item3.setCodigoBarras("234");
		item3.setNombre("CocaCola");
		item3.setPrecio(new BigDecimal(1));
		item3.setStock(20);
		item3.setTipo("Gaseosa");
		
		Item item4 = new Item();
		item4.setCodigoBarras("345");
		item4.setNombre("LaVaquita");
		item4.setPrecio(new BigDecimal(1.25));
		item4.setStock(10);
		item4.setTipo("Leche");
		
		this.itemService.ingresar(item);
		this.itemService.ingresar(item2);
		this.itemService.ingresar(item3);
		this.itemService.ingresar(item4);
		
		//Parte 2
		
		ItemDTO producto = new ItemDTO();
		producto.setCantidad(30);
		producto.setCodigoBarras("123");
		
		ItemDTO producto2 = new ItemDTO();
		producto2.setCantidad(30);
		producto2.setCodigoBarras("123");
		
		ItemDTO producto3 = new ItemDTO();
		producto3.setCantidad(30);
		producto3.setCodigoBarras("123");
		
		List<ItemDTO> productos = new ArrayList<>();
		productos.add(producto);
		productos.add(producto2);
		productos.add(producto3);
		
		this.facturaService.Realizar(productos, "123454678", "a2345");
		
		
		
		//PARTE 3
		System.out.println(this.itemService.consultarItem("345")); 
		
	}

}

package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Detalle;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Item;
import com.example.demo.modelo.DTO.ItemDTO;
import com.example.demo.repo.IFacturaRepo;
import com.example.demo.repo.IItemRepo;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IItemRepo itemRepo;
	@Autowired
	private IFacturaRepo facturaRepo;

	@Override
	public void Realizar(List<ItemDTO> productos, String cedulaCliente, String numeroVenta) {
		// TODO Auto-generated method stub
		Factura factura = new Factura();
		
		
		factura.setCedula(cedulaCliente);
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroVenta);
		List<Detalle> detalles=null;
		
		BigDecimal total = new BigDecimal(0);
		
		productos.forEach(a->{
			Item item = this.itemRepo.buscarCodBarras(a.getCodigoBarras());
			Detalle detalle = new Detalle();
			detalle.setCantidad(a.getCantidad());
			detalle.setFactura(factura);
			detalle.setItem(item);
			detalle.setPrecioU(item.getPrecio());
			detalle.setSubTotal(detalle.getPrecioU().multiply(new BigDecimal(detalle.getCantidad())));
			detalles.add(detalle);
			total.add(detalle.getSubTotal());
		});
		
		
		factura.setTotal(total);
		
		this.facturaRepo.insertar(factura);
	}

}

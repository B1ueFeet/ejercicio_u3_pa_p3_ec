package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle")
public class Detalle {
	
	@Id
	@SequenceGenerator(name = "seq_deta", sequenceName = "seq_deta", allocationSize = 1)
	@GeneratedValue(generator = "seq_deta", strategy = GenerationType.SEQUENCE)
	@Column(name = "deta_id")
	private Integer id;
	@Column(name = "deta_cantidad")
	private Integer cantidad;
	@Column(name = "deta_precio_unitario")
	private BigDecimal precioU;
	@Column(name = "deta_total")
	private BigDecimal subTotal;
	
	
	//RELACION
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "deta_id_factura")
	private Factura factura;
	
	@ManyToOne 
	@JoinColumn(name = "deta_id_item")
	private Item item;
	//GETTER & SETTER
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecioU() {
		return precioU;
	}
	public void setPrecioU(BigDecimal precioU) {
		this.precioU = precioU;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	
	
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	// TO STRING
	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", precioU=" + precioU + ", subTotal=" + subTotal + "]";
	}
	
	

}

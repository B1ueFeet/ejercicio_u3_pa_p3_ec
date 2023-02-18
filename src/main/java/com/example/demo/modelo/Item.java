package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@NamedQueries({
		@NamedQuery(name = "item.actualizarStock", query = "UPDATE Item i set i.stock = :datoStock where i.codigoBarras = :datoCodBarras") })
@Table(name = "item")
public class Item {

	@Id
	@SequenceGenerator(name = "seq_item", sequenceName = "seq_item", allocationSize = 1)
	@GeneratedValue(generator = "seq_item", strategy = GenerationType.SEQUENCE)
	@Column(name = "item_id")
	private Integer id;
	@Column(name = "item_codigo_barras")
	private String codigoBarras;
	@Column(name = "item_nombre")
	private String nombre;
	@Column(name = "item_tipo")
	private String tipo;
	@Column(name = "item_stock")
	private Integer stock;
	@Column(name = "item_precio")
	private BigDecimal precio;

	// RELACION
	@OneToMany(mappedBy = "item")
	private List<Detalle> detalles;

	// GETTER & SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	
	

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Item [id=" + id + ", codigoBarras=" + codigoBarras + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", stock=" + stock + ", precio=" + precio + "]";
	}

}

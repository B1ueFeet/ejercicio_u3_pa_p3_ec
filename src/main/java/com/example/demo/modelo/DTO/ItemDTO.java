package com.example.demo.modelo.DTO;

public class ItemDTO {
	private String codigoBarras;
	private Integer cantidad;
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
		return "ItemDTO [codigoBarras=" + codigoBarras + ", cantidad=" + cantidad + "]";
	}

	
}

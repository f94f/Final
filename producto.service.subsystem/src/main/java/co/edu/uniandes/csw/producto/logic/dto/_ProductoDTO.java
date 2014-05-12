
package co.edu.uniandes.csw.producto.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _ProductoDTO {

	private Long id;
	private String name;
	private String tipo;
	private Boolean esPerecedero;
	private Double precioPromedio;
	private Double tiempoPromedio;
	private Double cantidadPromedio;
	private Double minimoNivelInventario;

	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	public String getTipo() {
		return tipo;
	}
 
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Boolean getEsPerecedero() {
		return esPerecedero;
	}
 
	public void setEsPerecedero(Boolean esperecedero) {
		this.esPerecedero = esperecedero;
	}
	public Double getPrecioPromedio() {
		return precioPromedio;
	}
 
	public void setPrecioPromedio(Double preciopromedio) {
		this.precioPromedio = preciopromedio;
	}
	public Double getTiempoPromedio() {
		return tiempoPromedio;
	}
 
	public void setTiempoPromedio(Double tiempopromedio) {
		this.tiempoPromedio = tiempopromedio;
	}
	public Double getCantidadPromedio() {
		return cantidadPromedio;
	}
 
	public void setCantidadPromedio(Double cantidadpromedio) {
		this.cantidadPromedio = cantidadpromedio;
	}
	public Double getMinimoNivelInventario() {
		return minimoNivelInventario;
	}
 
	public void setMinimoNivelInventario(Double minimonivelinventario) {
		this.minimoNivelInventario = minimonivelinventario;
	}
	
}
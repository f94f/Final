
package co.edu.uniandes.csw.item.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _ItemDTO {

	private Long id;
	private String name;
	private Date fechaCaducidad;
	private Boolean reservado;
	private String motivoIngreso;
	private String motivoSalid;
	private Boolean enBodega;

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
	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}
 
	public void setFechaCaducidad(Date fechacaducidad) {
		this.fechaCaducidad = fechacaducidad;
	}
	public Boolean getReservado() {
		return reservado;
	}
 
	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}
	public String getMotivoIngreso() {
		return motivoIngreso;
	}
 
	public void setMotivoIngreso(String motivoingreso) {
		this.motivoIngreso = motivoingreso;
	}
	public String getMotivoSalid() {
		return motivoSalid;
	}
 
	public void setMotivoSalid(String motivosalid) {
		this.motivoSalid = motivosalid;
	}
	public Boolean getEnBodega() {
		return enBodega;
	}
 
	public void setEnBodega(Boolean enbodega) {
		this.enBodega = enbodega;
	}
	
}

package co.edu.uniandes.csw.item.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _ItemEntity {

	@Id
	@GeneratedValue(generator = "Item")
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date fechaCaducidad;
	private Boolean reservado;
	private String motivoIngreso;
	private String motivoSalid;
	private Boolean enBodega;

	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public Date getFechaCaducidad(){
		return fechaCaducidad;
	}
	
	public void setFechaCaducidad(Date fechaCaducidad){
		this.fechaCaducidad = fechaCaducidad;
	}
	public Boolean getReservado(){
		return reservado;
	}
	
	public void setReservado(Boolean reservado){
		this.reservado = reservado;
	}
	public String getMotivoIngreso(){
		return motivoIngreso;
	}
	
	public void setMotivoIngreso(String motivoIngreso){
		this.motivoIngreso = motivoIngreso;
	}
	public String getMotivoSalid(){
		return motivoSalid;
	}
	
	public void setMotivoSalid(String motivoSalid){
		this.motivoSalid = motivoSalid;
	}
	public Boolean getEnBodega(){
		return enBodega;
	}
	
	public void setEnBodega(Boolean enBodega){
		this.enBodega = enBodega;
	}
}
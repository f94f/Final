
package co.edu.uniandes.csw.ordenreaprovicionamiento.persistence.entity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class _OrdenReaprovicionamientoEntity {

	@Id
	@GeneratedValue(generator = "OrdenReaprovicionamiento")
	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private Integer cantidad;

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
	public Date getFecha(){
		return fecha;
	}
	
	public void setFecha(Date fecha){
		this.fecha = fecha;
	}
	public Integer getCantidad(){
		return cantidad;
	}
	
	public void setCantidad(Integer cantidad){
		this.cantidad = cantidad;
	}
}
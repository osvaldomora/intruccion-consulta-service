package mx.santander.fiduciario.instruccionconsulta.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.validation.constraints.NotNull;

/**
 * @author David Gonzalez - (Arquetipo creado por Santander Tecnologia Mexico)
 * 
 * Clase para el modelado del objeto de negocio a tratar por el servicio
 */
@Entity
@Table(name = "instruccionConsulta")
public class InstruccionConsulta implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@JsonIgnore
	@Column(name="id",updatable=false,nullable=false)
	@GeneratedValue(generator = "seq_instruccionConsulta", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_instruccionConsulta", sequenceName = "seq.seq_instruccionConsulta", allocationSize=1)
	private Long id;
	
	@NotNull
	private String nombre;
	

	public InstruccionConsulta(){
	}

	/**
	 * Constructor que recibe el objeto
	 * @param instruccionconsulta - El objeto de entidad
	 */
	public InstruccionConsulta(InstruccionConsulta instruccionconsulta){
		this.id = instruccionconsulta.getId();
		this.nombre = instruccionconsulta.getNombre();
	}
	
	/**
	 * Constructor que recibe los valores por separados
	 * @param id - El id de la entidad
	 * @param nombre - El nombre de la entidad
	 */
	public InstruccionConsulta(Long id, String nombre){
		this.id = id;
		this.nombre = nombre;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	@Override
	public String toString() {
		return "InstruccionConsulta [id=" + id + ", nombre=" + nombre + "]";
	}

}
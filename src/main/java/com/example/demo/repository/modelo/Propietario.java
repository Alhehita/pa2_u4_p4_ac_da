package com.example.demo.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="propietario_web")
@Entity
public class Propietario {

	@Id
	@SequenceGenerator(name = "seq_propietario_web",sequenceName = "seq_propietario_web",allocationSize = 1)
	@GeneratedValue(generator = "seq_propietario_web",strategy = GenerationType.SEQUENCE)
	@Column(name = "prop_id")
	private Integer id;

	@Column(name = "prop_nombre")
	private String nombre;

	@Column(name = "prop_apellido")
	private String apellido;

	@Column(name = "prop_cedula")
	private String cedula;

	//GET y SET

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + "]";
	}
	
	
}

package com.dawes.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Rol implements Serializable {
	
	//Codifica el id para mayor seguridad
	private static final long serialVersionUID = -9017298984002386783L;

	@Id
	//Para que utilice el autoincremento de mysql
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
}

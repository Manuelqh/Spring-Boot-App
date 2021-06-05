package com.dawes.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -5755226138612703743L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;
	
	@Column 
	@NotBlank //Que no sea nulo y que no este vacio
	@Size(min=5,max=8,message="No se cumple las reglas del tamano")
	private String nombre;
	
	@Column 
	@NotBlank
	private String apellidos;
	
	@Column(unique = true)
	@NotBlank
	private String email;
	
	@Column(unique = true)
	@NotBlank
	private String username;
	
	@Column
	@NotBlank
	private String password;
	
	//No aparece en la BD, la omite
	@Transient 
	@NotBlank
	private String confirmarPassword;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="usuario_roles"
		,joinColumns=@JoinColumn(name="usuario_id")
		,inverseJoinColumns=@JoinColumn(name="rol_id"))
	//Con el set obligamos a qeu no se repita ningun valor
	private Set<Rol> roles;
	
	public Usuario(Long id) {
		this.id = id;
	}    
}

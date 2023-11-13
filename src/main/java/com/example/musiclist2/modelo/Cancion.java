package com.example.musiclist2.modelo;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Cancion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombreCancion;

	private String autor;

	@ManyToOne
	@JoinColumn (name="id_usuarioadmin")
	private UsuarioAdmin usuarioAdmin;

	@ManyToOne
	@JsonBackReference
	@JoinColumn (name="id_genero")
	private Genero genero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCancion() {
		return nombreCancion;
	}

	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public UsuarioAdmin getUsuarioAdmin() {
		return usuarioAdmin;
	}

	public void setUsuarioAdmin(UsuarioAdmin usuarioAdmin) {
		this.usuarioAdmin = usuarioAdmin;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}

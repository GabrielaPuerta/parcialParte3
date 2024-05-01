package com.puerta.common.usuario.models.entity;

import jakarta.persistence.*;

import com.puerta.common.usuario.models.entity.Alumno;

import java.util.*;



@Entity
@Table
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(fetch = FetchType.LAZY)
    private List<Alumno> listarAlumno;
    
    public Curso() {
    	this.listarAlumno = new ArrayList<>();
    }
    
    public List<Alumno> getListarAlumno() {
		return listarAlumno;
	}

	public void setListarAlumno(List<Alumno> listarAlumno) {
		this.listarAlumno = listarAlumno;
	}
	public void addAlumnos(Alumno alumno) {
		this.listarAlumno.add(alumno);
	}
	public void removeAlumnos(List<Alumno> alumnos) {
		this.listarAlumno.remove(alumnos);
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	private String nombre;
    private String apellido;
    private String email;
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }
}

package isi.dan.practicas.practica1.model;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
  private Integer id;
  private String nombre;
  private Integer legajo;
  private List<Curso> cursosInscriptos;
  
  public Alumno(Integer id, String nombre, Integer legajo, List<Curso> cursosInscriptos) {
    this.id = id;
    this.nombre = nombre;
    this.legajo = legajo;
    this.cursosInscriptos = cursosInscriptos;
  } 

  public Alumno(Integer id, String nombre, Integer legajo) {
    this.id = id;
    this.nombre = nombre;
    this.legajo = legajo;
    this.cursosInscriptos = new ArrayList<Curso>();
  }

  public void agregarACurso(Curso curso) {
    this.cursosInscriptos.add(curso);
  }

  public void removerCurso(Curso curso){
    this.cursosInscriptos.remove(curso);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Alumno other = (Alumno) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  public Integer getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public Integer getLegajo() {
    return legajo;
  }

  public List<Curso> getCursosInscriptos() {
    return cursosInscriptos;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setLegajo(Integer legajo) {
    this.legajo = legajo;
  }

  public void setCursosInscriptos(List<Curso> cursosInscriptos) {
    this.cursosInscriptos = cursosInscriptos;
  }
}

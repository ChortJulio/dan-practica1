package isi.dan.practicas.practica1.model;

import java.util.ArrayList;
import java.util.List;

import isi.dan.practicas.practica1.exception.CupoExcedidoException;
import isi.dan.practicas.practica1.exception.DocenteExcedidoException;

public class Curso {
  private Integer id;
  private String nombre;
  private Integer creditos;
  private Integer cupo;
  private Docente docenteAsignado;
  private List<Alumno> listaInscriptos;
  
  public Curso(Integer id, String nombre, Integer creditos, Integer cupo, Docente docenteAsignado,
      List<Alumno> listaInscriptos) {
    this.id = id;
    this.nombre = nombre;
    this.creditos = creditos;
    this.cupo = cupo;
    this.docenteAsignado = docenteAsignado;
    this.listaInscriptos = listaInscriptos;
  }
  
  public Curso(String nombre, Integer creditos, Integer cupo) {
    this.nombre = nombre;
    this.creditos = creditos;
    this.cupo = cupo;
    this.docenteAsignado = null;
    this.listaInscriptos = new ArrayList<Alumno>();
  }

  public Curso(){
    
  }

  public void asignarDocente(Docente docente) throws DocenteExcedidoException{

    if(docente.getCantidadCursosDictados() >= 3){
      throw new  DocenteExcedidoException();
    }
    docente.agregarCurso(this);
    this.docenteAsignado = docente;
  }

  public void inscribirAlumno(Alumno alumno) throws CupoExcedidoException {

    if(this.listaInscriptos.size() >= this.cupo){
      throw new CupoExcedidoException();
    }
    alumno.agregarACurso(this);
    this.listaInscriptos.add(alumno);
  }

  public void removerAlumno(Alumno alumno){
    this.listaInscriptos.remove(alumno);
  }

  public void removerDocente(){
    this.docenteAsignado = null;
  }

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

  public Integer getCreditos() {
    return creditos;
  }

  public void setCreditos(Integer creditos) {
    this.creditos = creditos;
  }

  public Integer getCupo() {
    return cupo;
  }

  public void setCupo(Integer cupo) {
    this.cupo = cupo;
  }

  public Docente getDocenteAsignado() {
    return docenteAsignado;
  }

  public void setDocenteAsignado(Docente docenteAsignado) {
    this.docenteAsignado = docenteAsignado;
  }

  public List<Alumno> getListaInscriptos() {
    return listaInscriptos;
  }

  public void setListaInscriptos(List<Alumno> listaInscriptos) {
    this.listaInscriptos = listaInscriptos;
  }

}

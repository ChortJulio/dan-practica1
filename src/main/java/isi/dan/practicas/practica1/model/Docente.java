package isi.dan.practicas.practica1.model;

import java.util.ArrayList;
import java.util.List;

public class Docente {
  private Integer id;
  private String nombre;
  private Double salario;
  private List<Curso> cursosDictados;
  
  public Docente(Integer id, String nombre, Double salario, List<Curso> cursosDictados) {
    this.id = id;
    this.nombre = nombre;
    this.salario = salario;
    this.cursosDictados = cursosDictados;
  }

  public Docente(Integer id, String nombre, Double salario) {
    this.id = id;
    this.nombre = nombre;
    this.salario = salario;
    this.cursosDictados = new ArrayList<Curso>();
  }

  public void agregarCurso(Curso curso) {
    this.cursosDictados.add(curso);
  }

  public void removerCurso(Curso curso){
    this.cursosDictados.remove(curso);
  }

  public Integer getCantidadCursosDictados() {
    return this.cursosDictados.size();
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

  public Double getSalario() {
    return salario;
  }

  public void setSalario(Double salario) {
    this.salario = salario;
  }

  public List<Curso> getCursosDictados() {
    return cursosDictados;
  }

  public void setCursosDictados(List<Curso> cursosDictados) {
    this.cursosDictados = cursosDictados;
  }
}

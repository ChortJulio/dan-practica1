package isi.dan.practicas.practica1.exception;

public class RecursoNoEncontrado extends Exception{
  public RecursoNoEncontrado(String recurso, Integer id){
    super("No existe el identificador "+id.toString()+" del modelo "+recurso);
  }
}

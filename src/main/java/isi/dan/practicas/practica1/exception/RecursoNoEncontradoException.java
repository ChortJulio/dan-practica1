package isi.dan.practicas.practica1.exception;

public class RecursoNoEncontradoException extends Exception{
  public RecursoNoEncontradoException(String recurso, Integer id){
    super("No existe el identificador "+id.toString()+" del modelo "+recurso);
  }
}

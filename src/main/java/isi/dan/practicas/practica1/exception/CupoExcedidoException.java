package isi.dan.practicas.practica1.exception;

public class CupoExcedidoException extends Exception{
  public CupoExcedidoException(){
    super("el curso alcanzo el cupo maximo para alumnos inscriptos");
  }
}

package isi.dan.practicas.practica1.exception;

public class DocenteExcedidoException extends Exception{
  public DocenteExcedidoException(){
    super("El docente ya tiene 3 cursos asignados y no puede asignar mas.");
  }
}

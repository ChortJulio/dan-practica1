package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;

import isi.dan.practicas.practica1.exception.CupoExcedidoException;
import isi.dan.practicas.practica1.exception.DocenteExcedidoException;
import isi.dan.practicas.practica1.exception.RecursoNoEncontradoException;
import isi.dan.practicas.practica1.model.Alumno;
import isi.dan.practicas.practica1.model.Curso;
import isi.dan.practicas.practica1.model.Docente;

public interface CursoService {
    
    public Curso guardarCurso(Curso curso) throws RecursoNoEncontradoException;
    public Optional<Curso> buscarCursoPorId(Integer id) throws RecursoNoEncontradoException;
    public List<Curso> listarCursos();
    public void bajaCurso(Integer id) throws RecursoNoEncontradoException;
    public void asignarDocente(Docente docente) throws RecursoNoEncontradoException, DocenteExcedidoException;
    public void inscribirAlumno(Alumno alumno) throws RecursoNoEncontradoException, CupoExcedidoException;
}

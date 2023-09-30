package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Alumno;
import isi.dan.practicas.practica1.model.Curso;
import isi.dan.practicas.practica1.model.Docente;

public interface CursoService {
    
    public Curso guardarCurso(Curso a) throws RecursoNoEncontrado;
    public Optional<Curso> buscarCursoPorId(Integer id) throws RecursoNoEncontrado;
    public List<Curso> listarCursos();
    public void bajaCurso(Integer id) throws RecursoNoEncontrado;
    public void asignarDocente(Docente d);
    public void inscribirAlumno(Alumno a);
}

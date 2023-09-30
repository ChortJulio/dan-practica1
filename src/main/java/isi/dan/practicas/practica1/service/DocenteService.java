package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;

import isi.dan.practicas.practica1.exception.RecursoNoEncontradoException;
import isi.dan.practicas.practica1.model.Curso;
import isi.dan.practicas.practica1.model.Docente;

public interface DocenteService {
    
    public Docente guardarDocente(Docente docente) throws RecursoNoEncontradoException;
    public Optional<Docente> buscarDocentePorId(Integer id) throws RecursoNoEncontradoException;
    public List<Docente> listarDocentes();
    public void bajaDocente(Integer id) throws RecursoNoEncontradoException;
    public void agregarCurso(Docente docente, Curso curso) throws RecursoNoEncontradoException;
    // public void removerCurso(Docente docente, Curso curso) throws RecursoNoEncontradoException;
    public Integer getCantidadCursosDictados(Docente docente) throws RecursoNoEncontradoException;
}

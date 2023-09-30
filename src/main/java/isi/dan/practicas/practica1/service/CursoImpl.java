package isi.dan.practicas.practica1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isi.dan.practicas.practica1.exception.RecursoNoEncontradoException;
import isi.dan.practicas.practica1.model.Alumno;
import isi.dan.practicas.practica1.model.Curso;
import isi.dan.practicas.practica1.model.Docente;

@Service
public class CursoImpl implements CursoService{

    @Autowired
    private DocenteService docenteService;
    @Autowired
    private AlumnoService alumnoService;

    private static Integer id = 1;
    
    private List<Curso> listaCursos = new ArrayList<Curso>();;

    @Override
    public Curso guardarCurso(Curso c) throws RecursoNoEncontradoException{
        if(c.getId() == null){
            c.setId(id);
            id++;
            this.listaCursos.add(c);
        }
        else {
            if(this.listaCursos.contains(c)){
                this.listaCursos.set(this.listaCursos.indexOf(c), c);
            }
            else {
                throw new RecursoNoEncontradoException("Curso", c.getId());
            }
        }
        return c;
    }

    @Override
    public Optional<Curso> buscarCursoPorId(Integer id) throws RecursoNoEncontradoException{
        if(this.existeEnLista(id)){
            return this.listaCursos.stream().filter(c -> c.getId().equals(id)).findFirst();
        }
        else {
            throw new RecursoNoEncontradoException("Curso", id);
        }
    }

    @Override
    public List<Curso> listarCursos() {
        return this.listaCursos;
    }

    @Override
    public void bajaCurso(Integer id) throws RecursoNoEncontradoException{
        if(this.existeEnLista(id)){
            Curso curso = this.listaCursos.stream().filter(c -> c.getId().equals(id)).findFirst().get();
            curso.getDocenteAsignado().removerCurso(curso);
            curso.getListaInscriptos().stream().forEach(a -> a.removerCurso(curso));
            this.listaCursos.remove(curso);
        }
        else {
            throw new RecursoNoEncontradoException("Curso", id);
        }
    }

    @Override
    public void asignarDocente(Docente d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarDocente'");
    }

    @Override
    public void inscribirAlumno(Alumno a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inscribirAlumno'");
    }
    
    private boolean existeEnLista(Integer id) {
        boolean veredicto = false;
        for(int i = 0; i < this.listaCursos.size(); i++){
            if(this.listaCursos.get(i).getId() == id){
                veredicto = true;
            }
        }
        return veredicto;
    }
}

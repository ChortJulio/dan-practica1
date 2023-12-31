package isi.dan.practicas.practica1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import isi.dan.practicas.practica1.exception.RecursoNoEncontradoException;
import isi.dan.practicas.practica1.model.Alumno;

@Service
public class AlumnoImpl implements AlumnoService{

    private static Integer id = 1;
    
    private List<Alumno> listaAlumnos = new ArrayList<Alumno>();

    @Override
    public Alumno guardarAlumno(Alumno a) throws RecursoNoEncontradoException{
        if(a.getId() != null){
            a.setId(id);
            AlumnoImpl.id++;
            this.listaAlumnos.add(a);
        }
        else {
            if(this.listaAlumnos.contains(a)){
                this.listaAlumnos.set(this.listaAlumnos.indexOf(a), a);
            }
            else {
                throw new RecursoNoEncontradoException("Alumno", a.getId());
            }
        }
        return a;
    }

    @Override
    public Optional<Alumno> buscarAlumnoPorId(Integer id) throws RecursoNoEncontradoException{
        if(this.existeEnLista(id)){
            return this.listaAlumnos.stream().filter(c -> c.getId().equals(id)).findFirst();
        }
        else {
            throw new RecursoNoEncontradoException("Alumno", id);
        }
    }

    @Override
    public List<Alumno> listarAlumnos() {
        return this.listaAlumnos;
    }

    @Override
    public void bajaAlumno(Integer id) throws RecursoNoEncontradoException{
        if(this.existeEnLista(id)){
            Alumno alumno = this.listaAlumnos.stream().filter(c -> c.getId().equals(id)).findFirst().get();
            alumno.getCursosInscriptos().stream().forEach(c -> c.removerAlumno(alumno));
            this.listaAlumnos.remove(alumno);
        }
        else {
            throw new RecursoNoEncontradoException("Alumno", id);
        }
    }
    private boolean existeEnLista(Integer id) {
        boolean veredicto = false;
        for(int i = 0; i < this.listaAlumnos.size(); i++){
            if(this.listaAlumnos.get(i).getId() == id){
                veredicto = true;
            }
        }
        return veredicto;
    }
}

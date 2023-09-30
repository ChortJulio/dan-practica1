package isi.dan.practicas.practica1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import isi.dan.practicas.practica1.exception.RecursoNoEncontradoException;
import isi.dan.practicas.practica1.model.Curso;
import isi.dan.practicas.practica1.model.Docente;

@Service
public class DocenteImpl implements DocenteService{

    private static Integer id = 1;
    
    private List<Docente> listaDocentes = new ArrayList<Docente>();;

    @Override
    public Docente guardarDocente(Docente d) throws RecursoNoEncontradoException{
        if(d.getId() != null){
            d.setId(id);
            id++;
            this.listaDocentes.add(d);
        }
        else {
            if(this.listaDocentes.contains(d)){
                this.listaDocentes.set(this.listaDocentes.indexOf(d), d);
            }
            else {
                throw new RecursoNoEncontradoException("Docente", d.getId());
            }
        }
        return d;
    }

    @Override
    public Optional<Docente> buscarDocentePorId(Integer id) throws RecursoNoEncontradoException{
        if(this.existeEnLista(id)){
            return this.listaDocentes.stream().filter(c -> c.getId().equals(id)).findFirst();
        }
        else {
            throw new RecursoNoEncontradoException("Docente", id);
        }
    }

    @Override
    public List<Docente> listarDocentes() {
        return this.listaDocentes;
    }

    @Override
    public void bajaDocente(Integer id) throws RecursoNoEncontradoException{
        if(this.existeEnLista(id)){
            Docente docente = this.listaDocentes.stream().filter(c -> c.getId().equals(id)).findFirst().get();
            docente.getCursosDictados().stream().forEach(c -> c.removerDocente());
            this.listaDocentes.remove(docente);
        }
        else {
            throw new RecursoNoEncontradoException("Docente", id);
        }
    }
    
    private boolean existeEnLista(Integer id) {
        boolean veredicto = false;
        for(int i = 0; i < this.listaDocentes.size(); i++){
            if(this.listaDocentes.get(i).getId() == id){
                veredicto = true;
            }
        }
        return veredicto;
    }

    @Override
    public void agregarCurso(Docente docente, Curso curso) throws RecursoNoEncontradoException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarCurso'");
    }

    @Override
    public Integer getCantidadCursosDictados(Docente docente) throws RecursoNoEncontradoException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCantidadCursosDictados'");
    }
}

package isi.dan.practicas.practica1.service;

import java.util.List;
import java.util.Optional;

import isi.dan.practicas.practica1.exception.RecursoNoEncontrado;
import isi.dan.practicas.practica1.model.Docente;

public class DocenteImpl implements DocenteService{

    private static Integer id;
    
    private List<Docente> listaDocentes;

    @Override
    public Docente guardarDocente(Docente d) throws RecursoNoEncontrado{
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
                throw new RecursoNoEncontrado("Docente", d.getId());
            }
        }
        return d;
    }

    @Override
    public Optional<Docente> buscarDocentePorId(Integer id) throws RecursoNoEncontrado{
        if(this.existeEnLista(id)){
            return this.listaDocentes.stream().filter(c -> c.getId().equals(id)).findFirst();
        }
        else {
            throw new RecursoNoEncontrado("Docente", id);
        }
    }

    @Override
    public List<Docente> listarDocentes() {
        return this.listaDocentes;
    }

    @Override
    public void bajaDocente(Integer id) throws RecursoNoEncontrado{
        if(this.existeEnLista(id)){
            Docente docente = this.listaDocentes.stream().filter(c -> c.getId().equals(id)).findFirst().get();
            docente.getCursosDictados().stream().forEach(c -> c.removerDocente());
            this.listaDocentes.remove(docente);
        }
        else {
            throw new RecursoNoEncontrado("Docente", id);
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
}

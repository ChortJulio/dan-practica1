package isi.dan.practicas.practica1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isi.dan.practicas.practica1.exception.RecursoNoEncontradoException;
import isi.dan.practicas.practica1.model.Curso;
import isi.dan.practicas.practica1.service.CursoService;

@RestController
@RequestMapping("/api/curso")
public class CursoRest {
    
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listarCursos(){
        return ResponseEntity.ok().body(this.cursoService.listarCursos());
    }

    @PostMapping
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso curso){
        Curso cursoADevolver = null;
        try {
            cursoADevolver = this.cursoService.guardarCurso(curso);
            return ResponseEntity.ok().body(cursoADevolver);
        } catch (RecursoNoEncontradoException e) {
            // TODO: handle exception
        }
        return ResponseEntity.badRequest().build(); //TODO: Mejorar
    }
}

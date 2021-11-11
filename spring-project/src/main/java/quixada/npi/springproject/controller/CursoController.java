package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping("")
    public ResponseEntity<Curso> save (@RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.save(curso));
    }
}

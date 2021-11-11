package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.save(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> findAll(){
        return ResponseEntity.ok(cursoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        cursoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> update(@PathVariable Integer id, @RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.update(curso, id));
    }
}

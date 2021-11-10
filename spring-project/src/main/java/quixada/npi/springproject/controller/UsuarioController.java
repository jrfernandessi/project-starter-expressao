package quixada.npi.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<List<Usuario>> find(@PathVariable Integer id) {
        // Busca usuário pelo id e retornar usuário...
        return ResponseEntity.ok().build();
    }

    @PostMapping("")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        // Cadastrar usuário e retornar usuário cadastrado...
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        usuarioService.delete(id);
        return ResponseEntity.ok().build();
    }

    // @PutMapping("{id}")
    /*public ResponseEntity<Usuario> update(@RequestBody Usuario usuario) {

    }*/



}

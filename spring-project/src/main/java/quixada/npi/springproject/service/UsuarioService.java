package quixada.npi.springproject.service;


import javassist.NotFoundException;
import quixada.npi.springproject.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario findByEmail(String email);

    List<Usuario> findAll();

    Usuario save (Usuario usuario);

    void delete(Integer id);
}

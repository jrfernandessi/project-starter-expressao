package quixada.npi.springproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import quixada.npi.springproject.exception.DataIntegrityException;
import quixada.npi.springproject.model.Usuario;
import quixada.npi.springproject.repository.UsuarioRepository;
import quixada.npi.springproject.service.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario){
        if(findByEmail(usuario.getEmail())==null){
            usuario.setPassword(encoder.encode(usuario.getPassword()));
            return usuarioRepository.save(usuario);
        }else{
            throw new DataIntegrityException("E-mail já cadastrado");
        }
    }

}

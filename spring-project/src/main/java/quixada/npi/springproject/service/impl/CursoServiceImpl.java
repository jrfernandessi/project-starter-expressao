package quixada.npi.springproject.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quixada.npi.springproject.exception.DataIntegrityException;
import quixada.npi.springproject.exception.NotFoundException;
import quixada.npi.springproject.model.Curso;
import quixada.npi.springproject.repository.CursoRepository;
import quixada.npi.springproject.service.CursoService;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso){
        if(cursoRepository.findByNome(curso.getNome()).isEmpty())
            return cursoRepository.save(curso);
        else
            throw new DataIntegrityException("Nome do curso já existe");
    }

    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public void delete(Integer id){
        Curso curso = cursoRepository.findById(id).orElse(null);
        if(curso != null){
            cursoRepository.delete(curso);
        }else{
            throw new NotFoundException("Curso não existe");
        }
    }

    @Override
    public Curso update(Curso curso, Integer id) {
        Curso c = cursoRepository.findById(id).orElse(null);
        if(c!=null){
            curso.setId(id);
            return cursoRepository.save(curso);
        }
        else{
            throw new NotFoundException("Curso não existe");
        }
    }
}

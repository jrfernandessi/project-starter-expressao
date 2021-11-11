package quixada.npi.springproject.service;

import quixada.npi.springproject.model.Curso;

import java.util.List;

public interface CursoService {

    Curso save(Curso curso);

    List<Curso> findAll();

    void delete(Integer id);

    Curso update(Curso curso, Integer id);
}

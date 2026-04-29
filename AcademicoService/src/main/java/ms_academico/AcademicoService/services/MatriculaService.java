package ms_academico.academicoservice.services;

import ms_academico.academicoservice.model.Matricula;

import java.util.List;

public interface MatriculaService {
    List<Matricula> listarMatriculas();
    Matricula buscarMatriculaPorId(Long id);
    Matricula crearMatricula(Matricula matricula);
    Matricula actualizarMatricula(Matricula matricula, Long id);
    void eliminarMatricula(Long id);
}

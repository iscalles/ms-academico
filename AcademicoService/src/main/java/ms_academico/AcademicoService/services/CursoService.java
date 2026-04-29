package ms_academico.AcademicoService.services;

import ms_academico.AcademicoService.model.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listarCursos();
    Curso buscarCursoPorId(Long id);
    Curso crearCurso(Curso curso);
    Curso actualizarCurso(Curso curso, Long id);
    void eliminarCurso(Long id);
}

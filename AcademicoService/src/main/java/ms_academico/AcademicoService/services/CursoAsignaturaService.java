package ms_academico.AcademicoService.services;

import ms_academico.AcademicoService.model.CursoAsignatura;

import java.util.List;

public interface CursoAsignaturaService {
    List<CursoAsignatura> listarCursoAsignatura();
    CursoAsignatura buscarCursoAsignaturaPorId(Long id);
    CursoAsignatura crearCursoAsignatura(CursoAsignatura cursoAsignatura);
    CursoAsignatura actualizarCursoAsignatura(CursoAsignatura cursoAsignatura, Long id);
    void eliminarCursoAsignatura(Long id);
}

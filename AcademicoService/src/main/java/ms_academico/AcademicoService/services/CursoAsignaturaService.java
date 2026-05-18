package ms_academico.academicoservice.services;

import ms_academico.academicoservice.dto.CursoAsignaturaRequestDTO;
import ms_academico.academicoservice.dto.CursoAsignaturaResponseDTO;

import java.util.List;

public interface CursoAsignaturaService {
    List<CursoAsignaturaResponseDTO> listarCursoAsignatura();
    CursoAsignaturaResponseDTO buscarCursoAsignaturaPorId(Long id);
    CursoAsignaturaResponseDTO crearCursoAsignatura(CursoAsignaturaRequestDTO dto);
    CursoAsignaturaResponseDTO actualizarCursoAsignatura(CursoAsignaturaRequestDTO dto, Long id);
    void eliminarCursoAsignatura(Long id);
}

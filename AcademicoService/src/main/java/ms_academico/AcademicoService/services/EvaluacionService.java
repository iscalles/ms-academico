package ms_academico.academicoservice.services;

import ms_academico.academicoservice.dto.EvaluacionRequestDTO;
import ms_academico.academicoservice.dto.EvaluacionResponseDTO;

import java.util.List;

public interface EvaluacionService {
    List<EvaluacionResponseDTO> listarEvaluacion();
    List<EvaluacionResponseDTO> listarEvaluacionesPorCursoAsignatura(Long idCursoAsignatura);
    EvaluacionResponseDTO buscarEvaluacionPorId(Long id);
    EvaluacionResponseDTO crearEvaluacion(EvaluacionRequestDTO dto);
    EvaluacionResponseDTO actualizarEvaluacion(EvaluacionRequestDTO dto, Long id);
    void eliminarEvaluacion(Long id);
}

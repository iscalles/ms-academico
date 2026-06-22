package ms_academico.academicoservice.services;

import ms_academico.academicoservice.dto.CalificacionLoteRequestDTO;
import ms_academico.academicoservice.dto.CalificacionRequestDTO;
import ms_academico.academicoservice.dto.CalificacionResponseDTO;

import java.util.List;

public interface CalificacionService {
    List<CalificacionResponseDTO> listarCalificaciones();
    CalificacionResponseDTO buscarCalificacionPorId(Long id);
    List<CalificacionResponseDTO> buscarCalificacionesPorEvaluacion(Long evaluacionId);
    List<CalificacionResponseDTO> buscarCalificacionesPorAlumno(Long matriculaId);
    CalificacionResponseDTO crearCalificacion(CalificacionRequestDTO dto);
    CalificacionResponseDTO actualizarCalificacion(CalificacionRequestDTO dto, Long id);
    void eliminarCalificacion(Long id);
    List<CalificacionResponseDTO> registrarCalificacionesLote(CalificacionLoteRequestDTO dto);
}

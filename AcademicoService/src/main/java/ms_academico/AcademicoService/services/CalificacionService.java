package ms_academico.academicoservice.services;

import ms_academico.academicoservice.model.Calificacion;

import java.util.List;

public interface CalificacionService {
    List<Calificacion> listarCalificaciones();
    Calificacion buscarCalificacionPorId(Long id);
    List<Calificacion> buscarCalificacionesPorEvaluacion(Long evaluacionId);
    List<Calificacion> buscarCalificacionesPorAlumno(Long matriculaId);
    Calificacion crearCalificacion(Calificacion calificacion);
    Calificacion actualizarCalificacion(Calificacion calificacion, Long id);
    void eliminarCalificacion(Long id);
}

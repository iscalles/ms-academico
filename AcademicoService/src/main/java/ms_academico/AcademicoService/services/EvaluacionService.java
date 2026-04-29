package ms_academico.academicoservice.services;

import ms_academico.academicoservice.model.Evaluacion;

import java.util.List;

public interface EvaluacionService {
    List<Evaluacion> listarEvaluacion();
    Evaluacion buscarEvaluacionPorId(Long id);
    Evaluacion crearEvaluacion(Evaluacion evaluacion);
    Evaluacion actualizarEvaluacion(Evaluacion evaluacion, Long id);
    void eliminarEvaluacion(Long id);
}

package ms_academico.AcademicoService.services.impl;


import ms_academico.AcademicoService.model.Evaluacion;
import ms_academico.AcademicoService.repository.EvaluacionRepository;
import ms_academico.AcademicoService.services.EvaluacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;

    public EvaluacionServiceImpl(EvaluacionRepository evaluacionRepository){
        this.evaluacionRepository = evaluacionRepository;
    }

    @Override
    public List<Evaluacion> listarEvaluacion() {
        return evaluacionRepository.findAll();
    }

    @Override
    public Evaluacion buscarEvaluacionPorId(Long id) {
        return evaluacionRepository.findById(id).orElse(null);
    }

    @Override
    public Evaluacion crearEvaluacion(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    @Override
    public Evaluacion actualizarEvaluacion(Evaluacion evaluacion, Long id) {
        Evaluacion evaluacionExistente = evaluacionRepository.findById(id).orElse(null);
        if (evaluacionExistente != null) {
            evaluacionExistente.setNombreEvaluacion(evaluacion.getNombreEvaluacion());
            evaluacionExistente.setFechaEvaluacion(evaluacion.getFechaEvaluacion());
            return evaluacionRepository.save(evaluacionExistente);
        } else {
            throw new RuntimeException("Evaluacion no encontrada con id: " + id);
        }
    }

    @Override
    public void eliminarEvaluacion(Long id) {
        Evaluacion evaluacionExistente = evaluacionRepository.findById(id).orElse(null);
        if (evaluacionExistente != null){
            evaluacionRepository.delete(evaluacionExistente);
        }else{
            throw new RuntimeException("Evaluacion no encontrada con id: " + id);
        }
    }
}

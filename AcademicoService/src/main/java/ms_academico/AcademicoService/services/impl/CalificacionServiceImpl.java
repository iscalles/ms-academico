package ms_academico.academicoservice.services.impl;

import ms_academico.academicoservice.model.Calificacion;
import ms_academico.academicoservice.repository.CalificacionRepository;
import ms_academico.academicoservice.services.CalificacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionServiceImpl implements CalificacionService {
    private CalificacionRepository calificacionRepository;

    public CalificacionServiceImpl(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public List<Calificacion> listarCalificaciones() {
        return calificacionRepository.findAll();
    }

    @Override
    public Calificacion buscarCalificacionPorId(Long id) {
        return calificacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Calificacion> buscarCalificacionesPorEvaluacion(Long evaluacionId) {
        return calificacionRepository.findAllByEvaluacionIdEvaluacion(evaluacionId);
    }

    @Override
    public List<Calificacion> buscarCalificacionesPorAlumno(Long matriculaId) {
        return calificacionRepository.findAllByMatriculaIdMatricula(matriculaId);
    }

    @Override
    public Calificacion crearCalificacion(Calificacion calificacion) {
        return calificacionRepository.save(calificacion);
    }

    @Override
    public Calificacion actualizarCalificacion(Calificacion calificacion, Long id) {
        Calificacion calificacionExistente = calificacionRepository.findById(id).orElse(null);
        if (calificacionExistente != null) {
            calificacionExistente.setNotaCalificacion(calificacion.getNotaCalificacion());
            calificacionExistente.setMatriculaIdMatricula(calificacion.getMatriculaIdMatricula());
            calificacionExistente.setEvaluacionIdEvaluacion(calificacion.getEvaluacionIdEvaluacion());
            calificacionExistente.setCreadoPorRut(calificacion.getCreadoPorRut());
            calificacionExistente.setUltimaModificacion(calificacion.getUltimaModificacion());
            calificacionExistente.setModificadoPorRut(calificacion.getModificadoPorRut());
            return calificacionRepository.save(calificacionExistente);
        } else {
            throw new RuntimeException("Calificacion no encontrada con id: " + id);
        }
    }

    @Override
    public void eliminarCalificacion(Long id) {
        Calificacion calificacionExistente = calificacionRepository.findById(id).orElse(null);
        if (calificacionExistente != null) {
            calificacionRepository.delete(calificacionExistente);
        } else {
            throw new RuntimeException("Calificacion no encontrada con id: " + id);
        }
    }
}

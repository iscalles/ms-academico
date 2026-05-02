package ms_academico.academicoservice.repository;

import ms_academico.academicoservice.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
    List<Calificacion> findAllByEvaluacionIdEvaluacion(Long evaluacionId);
    List<Calificacion> findAllByMatriculaIdMatricula(Long matriculaId);
}

package ms_academico.academicoservice.repository;

import ms_academico.academicoservice.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluacionRepository extends JpaRepository<Evaluacion,Long> {
    List<Evaluacion> findAllByCursoAsignatura_Id(Long idCursoAsignatura);
}

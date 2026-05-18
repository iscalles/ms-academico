package ms_academico.academicoservice.repository;

import ms_academico.academicoservice.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluacionRepository extends JpaRepository<Evaluacion,Long> {
}

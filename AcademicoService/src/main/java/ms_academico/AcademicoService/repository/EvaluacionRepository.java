package ms_academico.AcademicoService.repository;

import ms_academico.AcademicoService.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluacionRepository extends JpaRepository<Evaluacion,Long> {
}

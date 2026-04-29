package ms_academico.AcademicoService.repository;

import ms_academico.AcademicoService.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}

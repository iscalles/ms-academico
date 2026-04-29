package ms_academico.AcademicoService.repository;

import ms_academico.AcademicoService.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}

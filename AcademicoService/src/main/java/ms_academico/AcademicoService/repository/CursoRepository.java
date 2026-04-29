package ms_academico.academicoservice.repository;

import ms_academico.academicoservice.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}

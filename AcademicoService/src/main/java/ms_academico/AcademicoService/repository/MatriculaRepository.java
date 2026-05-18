package ms_academico.academicoservice.repository;

import ms_academico.academicoservice.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}

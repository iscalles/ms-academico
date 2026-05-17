package ms_academico.academicoservice.repository;

import ms_academico.academicoservice.model.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {

    @Query("SELECT c FROM Calificacion c WHERE c.evaluacionIdEvaluacion.id_evaluacion = :evaluacionId")
    List<Calificacion> findAllByEvaluacionIdEvaluacion(@Param("evaluacionId") Long evaluacionId);

    @Query("SELECT c FROM Calificacion c WHERE c.matriculaIdMatricula.id_matricula = :matriculaId")
    List<Calificacion> findAllByMatriculaIdMatricula(@Param("matriculaId") Long matriculaId);
}

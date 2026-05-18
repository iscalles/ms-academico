package ms_academico.academicoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class EvaluacionResponseDTO {

    private Long idEvaluacion;
    private String nombreEvaluacion;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaEvaluacion;

    // Datos de la curso-asignatura a la que pertenece (aplanados)
    private Long idCursoAsignatura;
    private Long idAsignatura;
    private String nombreAsignatura;
    private Long idCurso;
    private String gradoCurso;
    private String seccionCurso;

    public EvaluacionResponseDTO() {}

    public Long getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getNombreEvaluacion() {
        return nombreEvaluacion;
    }

    public void setNombreEvaluacion(String nombreEvaluacion) {
        this.nombreEvaluacion = nombreEvaluacion;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Long getIdCursoAsignatura() {
        return idCursoAsignatura;
    }

    public void setIdCursoAsignatura(Long idCursoAsignatura) {
        this.idCursoAsignatura = idCursoAsignatura;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getGradoCurso() {
        return gradoCurso;
    }

    public void setGradoCurso(String gradoCurso) {
        this.gradoCurso = gradoCurso;
    }

    public String getSeccionCurso() {
        return seccionCurso;
    }

    public void setSeccionCurso(String seccionCurso) {
        this.seccionCurso = seccionCurso;
    }
}

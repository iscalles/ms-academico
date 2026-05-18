package ms_academico.academicoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class EvaluacionRequestDTO {

    private String nombreEvaluacion;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaEvaluacion;

    private Long idCursoAsignatura;

    public EvaluacionRequestDTO() {}

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
}

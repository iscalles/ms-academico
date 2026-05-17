package ms_academico.academicoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CursoAsignaturaResponseDTO {

    private Long idCursoAsignatura;
    private Long docenteIdUsuario;

    private Long idCurso;
    private String gradoCurso;
    private String seccionCurso;
    private Long anioCurso;

    private Long idAsignatura;
    private String nombreAsignatura;

    private Long idEvaluacion;
    private String nombreEvaluacion;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaEvaluacion;

    public CursoAsignaturaResponseDTO() {}

    public Long getIdCursoAsignatura() {
        return idCursoAsignatura;
    }

    public void setIdCursoAsignatura(Long idCursoAsignatura) {
        this.idCursoAsignatura = idCursoAsignatura;
    }

    public Long getDocenteIdUsuario() {
        return docenteIdUsuario;
    }

    public void setDocenteIdUsuario(Long docenteIdUsuario) {
        this.docenteIdUsuario = docenteIdUsuario;
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

    public Long getAnioCurso() {
        return anioCurso;
    }

    public void setAnioCurso(Long anioCurso) {
        this.anioCurso = anioCurso;
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
}

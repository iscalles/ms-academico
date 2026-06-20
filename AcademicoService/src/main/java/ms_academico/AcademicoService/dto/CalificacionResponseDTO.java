package ms_academico.academicoservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CalificacionResponseDTO {

    private Long idCalificacion;
    private Double notaCalificacion;

    // Datos de la matrícula (aplanados)
    private Long idMatricula;
    private Long estudianteIdUsuario;

    // Datos de la evaluación (aplanados)
    private Long idEvaluacion;
    private String nombreEvaluacion;
    private String nombreAsignatura;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechaEvaluacion;

    // Auditoría
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "America/Santiago")
    private LocalDateTime fechaRegistro;

    private Long creadoPorIdUsuario;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "America/Santiago")
    private LocalDateTime ultimaModificacion;

    private Long modificadoPorIdUsuario;

    public CalificacionResponseDTO() {}

    public Long getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(Long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public Double getNotaCalificacion() {
        return notaCalificacion;
    }

    public void setNotaCalificacion(Double notaCalificacion) {
        this.notaCalificacion = notaCalificacion;
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Long getEstudianteIdUsuario() {
        return estudianteIdUsuario;
    }

    public void setEstudianteIdUsuario(Long estudianteIdUsuario) {
        this.estudianteIdUsuario = estudianteIdUsuario;
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

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Long getCreadoPorIdUsuario() {
        return creadoPorIdUsuario;
    }

    public void setCreadoPorIdUsuario(Long creadoPorIdUsuario) {
        this.creadoPorIdUsuario = creadoPorIdUsuario;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public Long getModificadoPorIdUsuario() {
        return modificadoPorIdUsuario;
    }

    public void setModificadoPorIdUsuario(Long modificadoPorIdUsuario) {
        this.modificadoPorIdUsuario = modificadoPorIdUsuario;
    }
}

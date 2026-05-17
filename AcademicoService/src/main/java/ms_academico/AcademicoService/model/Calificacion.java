package ms_academico.academicoservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calificacion_seq")
    @SequenceGenerator(name = "calificacion_seq", sequenceName = "seq_calificacion", allocationSize = 1)
    private Long id_calificacion;

    @Column(name = "NOTA_CALIFICACION")
    private Double notaCalificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATRICULA_ID_MATRICULA")
    private Matricula matriculaIdMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVALUACION_ID_EVALUACION")
    private Evaluacion evaluacionIdEvaluacion;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm",timezone = "America/Santiago")
    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;

    @Column(name = "CREADO_POR_ID_USUARIO", nullable = false)
    private Long creadoPorIdUsuario;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm",timezone = "America/Santiago")
    @Column(name = "ULTIMA_MODIFICACION")
    private LocalDateTime ultimaModificacion;

    @Column(name = "MODIFICADO_POR_ID_USUARIO")
    private Long modificadoPorIdUsuario;
    
    public Calificacion() {
        
    }

    public Calificacion(Long id_calificacion, Double notaCalificacion, Matricula matriculaIdMatricula, Evaluacion evaluacionIdEvaluacion, LocalDateTime fechaRegistro, Long creadoPorIdUsuario, LocalDateTime ultimaModificacion, Long modificadoPorIdUsuario) {
        this.id_calificacion = id_calificacion;
        this.notaCalificacion = notaCalificacion;
        this.matriculaIdMatricula = matriculaIdMatricula;
        this.evaluacionIdEvaluacion = evaluacionIdEvaluacion;
        this.fechaRegistro = fechaRegistro;
        this.creadoPorIdUsuario = creadoPorIdUsuario;
        this.ultimaModificacion = ultimaModificacion;
        this.modificadoPorIdUsuario = modificadoPorIdUsuario;
    }

    public Long getModificadoPorIdUsuario() {
        return modificadoPorIdUsuario;
    }

    public void setModificadoPorIdUsuario(Long modificadoPorIdUsuario) {
        this.modificadoPorIdUsuario = modificadoPorIdUsuario;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public Long getCreadoPorIdUsuario() {
        return creadoPorIdUsuario;
    }

    public void setCreadoPorIdUsuario(Long creadoPorIdUsuario) {
        this.creadoPorIdUsuario = creadoPorIdUsuario;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Evaluacion getEvaluacionIdEvaluacion() {
        return evaluacionIdEvaluacion;
    }

    public void setEvaluacionIdEvaluacion(Evaluacion evaluacionIdEvaluacion) {
        this.evaluacionIdEvaluacion = evaluacionIdEvaluacion;
    }

    public Matricula getMatriculaIdMatricula() {
        return matriculaIdMatricula;
    }

    public void setMatriculaIdMatricula(Matricula matriculaIdMatricula) {
        this.matriculaIdMatricula = matriculaIdMatricula;
    }

    public Double getNotaCalificacion() {
        return notaCalificacion;
    }

    public void setNotaCalificacion(Double notaCalificacion) {
        this.notaCalificacion = notaCalificacion;
    }

    public Long getId() {
        return id_calificacion;
    }

    public void setId(Long id) {
        this.id_calificacion = id;
    }
}

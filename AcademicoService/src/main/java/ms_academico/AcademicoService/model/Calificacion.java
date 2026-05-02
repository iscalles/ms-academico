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

    @Column(name = "CREADO_POR_RUT", nullable = false, length = 12)
    private String creadoPorRut;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm",timezone = "America/Santiago")
    @Column(name = "ULTIMA_MODIFICACION")
    private LocalDateTime ultimaModificacion;

    @Column(name = "MODIFICADO_POR_RUT", length = 12)
    private String modificadoPorRut;
    
    public Calificacion() {
        
    }

    public Calificacion(Long id_calificacion, Double notaCalificacion, Matricula matriculaIdMatricula, Evaluacion evaluacionIdEvaluacion, LocalDateTime fechaRegistro, String creadoPorRut, LocalDateTime ultimaModificacion, String modificadoPorRut) {
        this.id_calificacion = id_calificacion;
        this.notaCalificacion = notaCalificacion;
        this.matriculaIdMatricula = matriculaIdMatricula;
        this.evaluacionIdEvaluacion = evaluacionIdEvaluacion;
        this.fechaRegistro = fechaRegistro;
        this.creadoPorRut = creadoPorRut;
        this.ultimaModificacion = ultimaModificacion;
        this.modificadoPorRut = modificadoPorRut;
    }

    public String getModificadoPorRut() {
        return modificadoPorRut;
    }

    public void setModificadoPorRut(String modificadoPorRut) {
        this.modificadoPorRut = modificadoPorRut;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    public void setUltimaModificacion(LocalDateTime ultimaModificacion) {
        this.ultimaModificacion = ultimaModificacion;
    }

    public String getCreadoPorRut() {
        return creadoPorRut;
    }

    public void setCreadoPorRut(String creadoPorRut) {
        this.creadoPorRut = creadoPorRut;
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

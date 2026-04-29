package ms_academico.academicoservice.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Evaluacion {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluacion_seq")
    @SequenceGenerator(name = "evaluacion_seq", sequenceName = "seq_evaluacion", allocationSize = 1)
    private Long id_evaluacion;

    @Column(name = "nombre_evaluacion")
    private String nombreEvaluacion;

    @Column(name = "fecha_evaluacion")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate fechaEvaluacion;

    public Evaluacion() {

    }

    public Evaluacion(Long id_evaluacion, String nombreEvaluacion, LocalDate fechaEvaluacion) {
        this.id_evaluacion = id_evaluacion;
        this.nombreEvaluacion = nombreEvaluacion;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Long getId_evaluacion() {
        return id_evaluacion;
    }

    public void setId_evaluacion(Long id_evaluacion) {
        this.id_evaluacion = id_evaluacion;
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


package ms_academico.academicoservice.model;


import jakarta.persistence.*;
import org.hibernate.annotations.*;

@Entity
public class CursoAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_asignatura_seq")
    @SequenceGenerator(name = "curso_asignatura_seq", sequenceName = "seq_curso_asignatura", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CURSO", nullable = false)
    private Curso idCurso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ASIGNATURA", nullable = false)
    private Asignatura idAsignatura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_EVALUACION", nullable = false)
    private Evaluacion idEvaluacion;

    @Column(name = "DOCENTE_USUARIO_RUT_DOCENTE", nullable = false, length = 12)
    private String docenteUsuarioRutDocente;

    public String getDocenteUsuarioRutDocente() {
        return docenteUsuarioRutDocente;
    }

    public void setDocenteUsuarioRutDocente(String docenteUsuarioRutDocente) {
        this.docenteUsuarioRutDocente = docenteUsuarioRutDocente;
    }

    public Evaluacion getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Evaluacion idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

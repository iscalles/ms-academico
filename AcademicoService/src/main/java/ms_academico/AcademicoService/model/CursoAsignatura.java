package ms_academico.academicoservice.model;


import jakarta.persistence.*;

@Entity
public class CursoAsignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_asignatura_seq")
    @SequenceGenerator(name = "curso_asignatura_seq", sequenceName = "seq_curso_asignatura", allocationSize = 1)
    private Long id_curso_asignatura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_CURSO", nullable = false)
    private Curso idCurso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_ASIGNATURA", nullable = false)
    private Asignatura idAsignatura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_EVALUACION", nullable = false)
    private Evaluacion idEvaluacion;

    @Column(name = "DOCENTE_ID_USUARIO", nullable = false)
    private Long docenteIdUsuario;

    public Long getDocenteIdUsuario() {
        return docenteIdUsuario;
    }

    public void setDocenteIdUsuario(Long docenteIdUsuario) {
        this.docenteIdUsuario = docenteIdUsuario;
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
        return id_curso_asignatura;
    }

    public void setId(Long id) {
        this.id_curso_asignatura = id;
    }
}

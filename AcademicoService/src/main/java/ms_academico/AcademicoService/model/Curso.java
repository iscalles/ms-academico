package ms_academico.academicoservice.model;


import jakarta.persistence.*;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
    @SequenceGenerator(name = "curso_seq", sequenceName = "seq_curso", allocationSize = 1)
    private Long id;

    @Column(name = "GRADO_CURSO", length = 10)
    private String gradoCurso;

    @Column(name = "SECCION_CURSO", length = 10)
    private String seccionCurso;

    @Column(name = "ANIO_CURSO")
    private Long anioCurso;

    public Long getAnioCurso() {
        return anioCurso;
    }

    public Curso(){

    }

    public Curso(Long id, String gradoCurso, String seccionCurso, Long anioCurso) {
        this.id = id;
        this.gradoCurso = gradoCurso;
        this.seccionCurso = seccionCurso;
        this.anioCurso = anioCurso;
    }

    public void setAnioCurso(Long anioCurso) {
        this.anioCurso = anioCurso;
    }

    public String getSeccionCurso() {
        return seccionCurso;
    }

    public void setSeccionCurso(String seccionCurso) {
        this.seccionCurso = seccionCurso;
    }

    public String getGradoCurso() {
        return gradoCurso;
    }

    public void setGradoCurso(String gradoCurso) {
        this.gradoCurso = gradoCurso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

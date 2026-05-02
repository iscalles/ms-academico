package ms_academico.academicoservice.model;


import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_seq")
    @SequenceGenerator(name = "matricula_seq", sequenceName = "seq_matricula", allocationSize = 1)
    private Long id_matricula;

    @Column(name = "ANIO_ACADEMICO_MATRICULA")
    private Long anioAcademicoMatricula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURSO_ID_CURSO")
    private Curso cursoIdCurso;

    @Column(name = "ESTUDIANTE_USUARIO_RUT_USUARIO", length = 12)
    private String estudianteUsuarioRutUsuario;

    public Matricula() {

    }

    public Matricula(Long id, Long anioAcademicoMatricula, Curso cursoIdCurso, String estudianteUsuarioRutUsuario) {
        this.id_matricula = id;
        this.anioAcademicoMatricula = anioAcademicoMatricula;
        this.cursoIdCurso = cursoIdCurso;
        this.estudianteUsuarioRutUsuario = estudianteUsuarioRutUsuario;
    }

    public String getEstudianteUsuarioRutUsuario() {
        return estudianteUsuarioRutUsuario;
    }

    public void setEstudianteUsuarioRutUsuario(String estudianteUsuarioRutUsuario) {
        this.estudianteUsuarioRutUsuario = estudianteUsuarioRutUsuario;
    }

    public Curso getCursoIdCurso() {
        return cursoIdCurso;
    }

    public void setCursoIdCurso(Curso cursoIdCurso) {
        this.cursoIdCurso = cursoIdCurso;
    }

    public Long getAnioAcademicoMatricula() {
        return anioAcademicoMatricula;
    }

    public void setAnioAcademicoMatricula(Long anioAcademicoMatricula) {
        this.anioAcademicoMatricula = anioAcademicoMatricula;
    }

    public Long getId() {
        return id_matricula;
    }

    public void setId(Long id) {
        this.id_matricula = id;
    }
}

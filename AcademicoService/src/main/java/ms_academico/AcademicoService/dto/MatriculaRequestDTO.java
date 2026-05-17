package ms_academico.academicoservice.dto;

public class MatriculaRequestDTO {

    private Long anioAcademicoMatricula;
    private Long idCurso;
    private Long estudianteIdUsuario;

    public MatriculaRequestDTO() {}

    public Long getAnioAcademicoMatricula() {
        return anioAcademicoMatricula;
    }

    public void setAnioAcademicoMatricula(Long anioAcademicoMatricula) {
        this.anioAcademicoMatricula = anioAcademicoMatricula;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getEstudianteIdUsuario() {
        return estudianteIdUsuario;
    }

    public void setEstudianteIdUsuario(Long estudianteIdUsuario) {
        this.estudianteIdUsuario = estudianteIdUsuario;
    }
}

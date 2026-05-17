package ms_academico.academicoservice.dto;

public class MatriculaResponseDTO {

    private Long idMatricula;
    private Long anioAcademicoMatricula;
    private Long estudianteIdUsuario;

    private Long idCurso;
    private String gradoCurso;
    private String seccionCurso;
    private Long anioCurso;

    public MatriculaResponseDTO() {}

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Long getAnioAcademicoMatricula() {
        return anioAcademicoMatricula;
    }

    public void setAnioAcademicoMatricula(Long anioAcademicoMatricula) {
        this.anioAcademicoMatricula = anioAcademicoMatricula;
    }

    public Long getEstudianteIdUsuario() {
        return estudianteIdUsuario;
    }

    public void setEstudianteIdUsuario(Long estudianteIdUsuario) {
        this.estudianteIdUsuario = estudianteIdUsuario;
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
}

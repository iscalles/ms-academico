package ms_academico.academicoservice.dto;

public class CursoAsignaturaResponseDTO {

    private Long idCursoAsignatura;
    private Long docenteIdUsuario;
    private String nombreDocente;

    private Long idCurso;
    private String gradoCurso;
    private String seccionCurso;
    private Long anioCurso;

    private Long idAsignatura;
    private String nombreAsignatura;

    public CursoAsignaturaResponseDTO() {}

    public Long getIdCursoAsignatura() {
        return idCursoAsignatura;
    }

    public void setIdCursoAsignatura(Long idCursoAsignatura) {
        this.idCursoAsignatura = idCursoAsignatura;
    }

    public Long getDocenteIdUsuario() {
        return docenteIdUsuario;
    }

    public void setDocenteIdUsuario(Long docenteIdUsuario) {
        this.docenteIdUsuario = docenteIdUsuario;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
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

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }
}

package ms_academico.academicoservice.dto;

public class CursoAsignaturaRequestDTO {

    private Long idCurso;
    private Long idAsignatura;
    private Long docenteIdUsuario;

    public CursoAsignaturaRequestDTO() {}

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Long getDocenteIdUsuario() {
        return docenteIdUsuario;
    }

    public void setDocenteIdUsuario(Long docenteIdUsuario) {
        this.docenteIdUsuario = docenteIdUsuario;
    }
}

package ms_academico.academicoservice.dto;

public class CalificacionRequestDTO {

    private Double notaCalificacion;
    private Long idMatricula;
    private Long idEvaluacion;
    private Long creadoPorIdUsuario;

    public CalificacionRequestDTO() {}

    public Double getNotaCalificacion() {
        return notaCalificacion;
    }

    public void setNotaCalificacion(Double notaCalificacion) {
        this.notaCalificacion = notaCalificacion;
    }

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Long getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Long idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Long getCreadoPorIdUsuario() {
        return creadoPorIdUsuario;
    }

    public void setCreadoPorIdUsuario(Long creadoPorIdUsuario) {
        this.creadoPorIdUsuario = creadoPorIdUsuario;
    }
}

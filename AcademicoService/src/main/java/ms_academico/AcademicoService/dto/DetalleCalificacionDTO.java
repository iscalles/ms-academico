package ms_academico.academicoservice.dto;

public class DetalleCalificacionDTO {

    private Long idMatricula;
    private Double notaCalificacion;

    public DetalleCalificacionDTO() {}

    public Long getIdMatricula() { return idMatricula; }
    public void setIdMatricula(Long idMatricula) { this.idMatricula = idMatricula; }

    public Double getNotaCalificacion() { return notaCalificacion; }
    public void setNotaCalificacion(Double notaCalificacion) { this.notaCalificacion = notaCalificacion; }
}

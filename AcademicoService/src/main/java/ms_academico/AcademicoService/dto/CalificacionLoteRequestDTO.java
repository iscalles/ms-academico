package ms_academico.academicoservice.dto;

import java.util.List;

public class CalificacionLoteRequestDTO {

    private Long idEvaluacion;
    private Long creadoPorIdUsuario;
    private List<DetalleCalificacionDTO> detalles;

    public CalificacionLoteRequestDTO() {}

    public Long getIdEvaluacion() { return idEvaluacion; }
    public void setIdEvaluacion(Long idEvaluacion) { this.idEvaluacion = idEvaluacion; }

    public Long getCreadoPorIdUsuario() { return creadoPorIdUsuario; }
    public void setCreadoPorIdUsuario(Long creadoPorIdUsuario) { this.creadoPorIdUsuario = creadoPorIdUsuario; }

    public List<DetalleCalificacionDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleCalificacionDTO> detalles) { this.detalles = detalles; }
}

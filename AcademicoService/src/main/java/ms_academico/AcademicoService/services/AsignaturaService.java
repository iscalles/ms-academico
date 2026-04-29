package ms_academico.AcademicoService.services;

import ms_academico.AcademicoService.model.Asignatura;
import java.util.List;

public interface AsignaturaService {
    List<Asignatura> listarAsignatura();
    Asignatura buscarAsignaturaPorId(Long id);
    Asignatura crearAsignatura(Asignatura asignatura);
    Asignatura actualizarAsignatura(Asignatura asignatura, Long id);
    void eliminarAsignatura(Long id);
}

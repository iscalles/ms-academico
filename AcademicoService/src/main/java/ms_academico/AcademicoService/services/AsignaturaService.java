package ms_academico.academicoservice.services;

import ms_academico.academicoservice.model.Asignatura;
import java.util.List;

public interface AsignaturaService {
    List<Asignatura> listarAsignatura();
    Asignatura buscarAsignaturaPorId(Long id);
    Asignatura crearAsignatura(Asignatura asignatura);
    Asignatura actualizarAsignatura(Asignatura asignatura, Long id);
    void eliminarAsignatura(Long id);
}

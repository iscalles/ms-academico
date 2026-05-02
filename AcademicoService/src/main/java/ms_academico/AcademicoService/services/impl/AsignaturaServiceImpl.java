package ms_academico.academicoservice.services.impl;

import ms_academico.academicoservice.model.Asignatura;
import ms_academico.academicoservice.repository.AsignaturaRepository;
import ms_academico.academicoservice.services.AsignaturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {
    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepository) {
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    public List<Asignatura> listarAsignatura() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura buscarAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    @Override
    public Asignatura crearAsignatura(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura actualizarAsignatura(Asignatura asignatura, Long id) {
        Asignatura asignaturaExistente = asignaturaRepository.findById(id).orElse(null);
        if (asignaturaExistente != null) {
            asignaturaExistente.setNombreAsignatura(asignatura.getNombreAsignatura());
            return asignaturaRepository.save(asignaturaExistente);
        } else {
            throw new RuntimeException("Asignatura no encontrada con id: " + id);
        }
    }

    @Override
    public void eliminarAsignatura(Long id) {
        Asignatura asignaturaExistente = asignaturaRepository.findById(id).orElse(null);
        if (asignaturaExistente != null) {
            asignaturaRepository.delete(asignaturaExistente);
        } else {
            throw new RuntimeException("Asignatura no encontrada con id: " + id);
        }
    }
}

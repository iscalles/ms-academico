package ms_academico.AcademicoService.services.impl;

import ms_academico.AcademicoService.model.CursoAsignatura;
import ms_academico.AcademicoService.repository.CursoAsignaturaRepository;
import ms_academico.AcademicoService.services.CursoAsignaturaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoAsignaturaServiceImpl implements CursoAsignaturaService {
    private final CursoAsignaturaRepository cursoAsignaturaRepository;

    public CursoAsignaturaServiceImpl(CursoAsignaturaRepository cursoAsignaturaRepository) {
        this.cursoAsignaturaRepository = cursoAsignaturaRepository;
    }


    @Override
    public List<CursoAsignatura> listarCursoAsignatura() {
        return cursoAsignaturaRepository.findAll();
    }

    @Override
    public CursoAsignatura buscarCursoAsignaturaPorId(Long id) {
        return cursoAsignaturaRepository.findById(id).orElse(null);
    }

    @Override
    public CursoAsignatura crearCursoAsignatura(CursoAsignatura cursoAsignatura) {
        return cursoAsignaturaRepository.save(cursoAsignatura);
    }

    @Override
    public CursoAsignatura actualizarCursoAsignatura(CursoAsignatura cursoAsignatura, Long id) {
        CursoAsignatura cursoAsignaturaExistente = cursoAsignaturaRepository.findById(id).orElse(null);
        if (cursoAsignaturaExistente != null) {
            cursoAsignaturaExistente.setIdAsignatura (cursoAsignatura.getIdAsignatura());
            cursoAsignaturaExistente.setIdCurso(cursoAsignatura.getIdCurso());
            cursoAsignaturaExistente.setIdEvaluacion(cursoAsignatura.getIdEvaluacion());
            cursoAsignaturaExistente.setDocenteUsuarioRutDocente(cursoAsignatura.getDocenteUsuarioRutDocente());
            return cursoAsignaturaRepository.save(cursoAsignaturaExistente);
        } else {
            throw new RuntimeException("CursoAsignatura no encontrada con id: " + id);
        }
    }

    @Override
    public void eliminarCursoAsignatura(Long id) {
            CursoAsignatura cursoAsignaturaExistente = cursoAsignaturaRepository.findById(id).orElse(null);
        if (cursoAsignaturaExistente != null) {
            cursoAsignaturaRepository.delete(cursoAsignaturaExistente);
        } else {
            throw new RuntimeException("CursoAsignatura no encontrada con id: " + id);
        }

    }
}

package ms_academico.AcademicoService.services.impl;

import ms_academico.AcademicoService.model.Curso;
import ms_academico.AcademicoService.repository.CursoRepository;
import ms_academico.AcademicoService.services.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso buscarCursoPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Curso actualizarCurso(Curso curso, Long id) {
        Curso cursoExistente = cursoRepository.findById(id).orElse(null);
        if (cursoExistente != null) {
            cursoExistente.setAnioCurso(curso.getAnioCurso());
            cursoExistente.setSeccionCurso(curso.getSeccionCurso());
            cursoExistente.setGradoCurso(curso.getGradoCurso());
            return cursoRepository.save(cursoExistente);
        } else {
            throw new RuntimeException("Curso no encontrado con id: " + id);
        }
    }

    @Override
    public void eliminarCurso(Long id) {
        Curso cursoExistente = cursoRepository.findById(id).orElse(null);
        if (cursoExistente != null) {
            cursoRepository.delete(cursoExistente);
        } else {
            throw new RuntimeException("Curso no encontrado con id: " + id);
        }
    }
}

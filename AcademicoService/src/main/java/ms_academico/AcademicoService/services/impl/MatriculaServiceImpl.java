package ms_academico.academicoservice.services.impl;

import ms_academico.academicoservice.model.Matricula;
import ms_academico.academicoservice.repository.MatriculaRepository;
import ms_academico.academicoservice.services.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository) {
        this.matriculaRepository = matriculaRepository;
    }

    @Override
    public List<Matricula> listarMatriculas() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula buscarMatriculaPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public Matricula crearMatricula(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula actualizarMatricula(Matricula matricula, Long id) {
        Matricula matriculaExistente = matriculaRepository.findById(id).orElse(null);
        if (matriculaExistente != null) {
            matriculaExistente.setAnioAcademicoMatricula(matricula.getAnioAcademicoMatricula());
            matriculaExistente.setCursoIdCurso(matricula.getCursoIdCurso());
            matriculaExistente.setEstudianteUsuarioRutUsuario(matricula.getEstudianteUsuarioRutUsuario());
            return matriculaRepository.save(matriculaExistente);
        } else {
            throw new RuntimeException("Matricula no encontrada con id: " + id);
        }
    }

    @Override
    public void eliminarMatricula(Long id) {
        Matricula matriculaExistente = matriculaRepository.findById(id).orElse(null);
        if (matriculaExistente != null) {
            matriculaRepository.delete(matriculaExistente);
        } else {
            throw new RuntimeException("Matricula no encontrada con id: " + id);
        }
    }
}

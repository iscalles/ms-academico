package ms_academico.academicoservice.services.impl;

import ms_academico.academicoservice.dto.MatriculaRequestDTO;
import ms_academico.academicoservice.dto.MatriculaResponseDTO;
import ms_academico.academicoservice.model.Curso;
import ms_academico.academicoservice.model.Matricula;
import ms_academico.academicoservice.repository.CursoRepository;
import ms_academico.academicoservice.repository.MatriculaRepository;
import ms_academico.academicoservice.services.MatriculaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final CursoRepository cursoRepository;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository,
                                CursoRepository cursoRepository) {
        this.matriculaRepository = matriculaRepository;
        this.cursoRepository = cursoRepository;
    }

    // Entidad → DTO de salida: aplana los datos del Curso
    private MatriculaResponseDTO toResponseDTO(Matricula m) {
        MatriculaResponseDTO dto = new MatriculaResponseDTO();
        dto.setIdMatricula(m.getId());
        dto.setAnioAcademicoMatricula(m.getAnioAcademicoMatricula());
        dto.setEstudianteIdUsuario(m.getEstudianteIdUsuario());

        if (m.getCursoIdCurso() != null) {
            dto.setIdCurso(m.getCursoIdCurso().getId());
            dto.setGradoCurso(m.getCursoIdCurso().getGradoCurso());
            dto.setSeccionCurso(m.getCursoIdCurso().getSeccionCurso());
            dto.setAnioCurso(m.getCursoIdCurso().getAnioCurso());
        }

        return dto;
    }

    // DTO de entrada → Entidad: busca el Curso en BD y construye la Matricula
    private Matricula toEntity(MatriculaRequestDTO dto) {
        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + dto.getIdCurso()));

        Matricula matricula = new Matricula();
        matricula.setAnioAcademicoMatricula(dto.getAnioAcademicoMatricula());
        matricula.setCursoIdCurso(curso);
        matricula.setEstudianteIdUsuario(dto.getEstudianteIdUsuario());
        return matricula;
    }

    @Override
    public List<MatriculaResponseDTO> listarMatriculas() {
        return matriculaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MatriculaResponseDTO buscarMatriculaPorId(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada con id: " + id));
        return toResponseDTO(matricula);
    }

    @Override
    public MatriculaResponseDTO crearMatricula(MatriculaRequestDTO dto) {
        Matricula matricula = toEntity(dto);
        return toResponseDTO(matriculaRepository.save(matricula));
    }

    @Override
    public MatriculaResponseDTO actualizarMatricula(MatriculaRequestDTO dto, Long id) {
        Matricula existente = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada con id: " + id));

        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + dto.getIdCurso()));

        existente.setAnioAcademicoMatricula(dto.getAnioAcademicoMatricula());
        existente.setCursoIdCurso(curso);
        existente.setEstudianteIdUsuario(dto.getEstudianteIdUsuario());

        return toResponseDTO(matriculaRepository.save(existente));
    }

    @Override
    public void eliminarMatricula(Long id) {
        Matricula existente = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada con id: " + id));
        matriculaRepository.delete(existente);
    }
}

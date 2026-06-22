package ms_academico.academicoservice.services.impl;

import ms_academico.academicoservice.client.UsuarioClient;
import ms_academico.academicoservice.client.UsuarioDTOInternal;
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
    private final UsuarioClient usuarioClient;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository,
                                CursoRepository cursoRepository,
                                UsuarioClient usuarioClient) {
        this.matriculaRepository = matriculaRepository;
        this.cursoRepository = cursoRepository;
        this.usuarioClient = usuarioClient;
    }

    private MatriculaResponseDTO toResponseDTO(Matricula m) {
        MatriculaResponseDTO dto = new MatriculaResponseDTO();
        dto.setIdMatricula(m.getId());
        dto.setAnioAcademicoMatricula(m.getAnioAcademicoMatricula());
        dto.setEstudianteIdUsuario(m.getEstudianteIdUsuario());

        // Enriquece con el nombre del estudiante consultando ms-usuario
        try {
            UsuarioDTOInternal usuario = usuarioClient.obtenerUsuarioPorId(m.getEstudianteIdUsuario());
            dto.setNombreEstudiante(usuario.getNombreCompleto());
            dto.setRutEstudiante(usuario.getRutUsuario());
        } catch (Exception e) {
            dto.setNombreEstudiante("Usuario no disponible");
        }

        if (m.getCursoIdCurso() != null) {
            dto.setIdCurso(m.getCursoIdCurso().getId());
            dto.setGradoCurso(m.getCursoIdCurso().getGradoCurso());
            dto.setSeccionCurso(m.getCursoIdCurso().getSeccionCurso());
            dto.setAnioCurso(m.getCursoIdCurso().getAnioCurso());
        }

        return dto;
    }

    private Matricula toEntity(MatriculaRequestDTO dto) {
        // Valida que el estudiante existe en ms-usuario antes de guardar
        usuarioClient.obtenerUsuarioPorId(dto.getEstudianteIdUsuario());

        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + dto.getIdCurso()));

        Matricula matricula = new Matricula();
        // El año de la matrícula se deriva del curso, no se recibe del cliente
        matricula.setAnioAcademicoMatricula(curso.getAnioCurso());
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
    public List<MatriculaResponseDTO> listarMatriculasPorCurso(Long idCurso) {
        return matriculaRepository.findAllByCursoIdCurso_Id(idCurso).stream()
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
        return toResponseDTO(matriculaRepository.save(toEntity(dto)));
    }

    @Override
    public MatriculaResponseDTO actualizarMatricula(MatriculaRequestDTO dto, Long id) {
        Matricula existente = matriculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada con id: " + id));

        // Valida que el nuevo estudiante existe en ms-usuario
        usuarioClient.obtenerUsuarioPorId(dto.getEstudianteIdUsuario());

        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + dto.getIdCurso()));

        // El año de la matrícula se deriva del curso, no se recibe del cliente
        existente.setAnioAcademicoMatricula(curso.getAnioCurso());
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

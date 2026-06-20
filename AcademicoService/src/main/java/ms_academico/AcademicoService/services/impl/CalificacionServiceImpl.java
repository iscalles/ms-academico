package ms_academico.academicoservice.services.impl;

import ms_academico.academicoservice.client.UsuarioClient;
import ms_academico.academicoservice.dto.CalificacionRequestDTO;
import ms_academico.academicoservice.dto.CalificacionResponseDTO;
import ms_academico.academicoservice.model.Calificacion;
import ms_academico.academicoservice.model.Evaluacion;
import ms_academico.academicoservice.model.Matricula;
import ms_academico.academicoservice.repository.CalificacionRepository;
import ms_academico.academicoservice.repository.EvaluacionRepository;
import ms_academico.academicoservice.repository.MatriculaRepository;
import ms_academico.academicoservice.services.CalificacionService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalificacionServiceImpl implements CalificacionService {

    private final CalificacionRepository calificacionRepository;
    private final MatriculaRepository matriculaRepository;
    private final EvaluacionRepository evaluacionRepository;
    private final UsuarioClient usuarioClient;

    public CalificacionServiceImpl(CalificacionRepository calificacionRepository,
                                   MatriculaRepository matriculaRepository,
                                   EvaluacionRepository evaluacionRepository,
                                   UsuarioClient usuarioClient) {
        this.calificacionRepository = calificacionRepository;
        this.matriculaRepository = matriculaRepository;
        this.evaluacionRepository = evaluacionRepository;
        this.usuarioClient = usuarioClient;
    }

    private CalificacionResponseDTO toResponseDTO(Calificacion c) {
        CalificacionResponseDTO dto = new CalificacionResponseDTO();
        dto.setIdCalificacion(c.getId());
        dto.setNotaCalificacion(c.getNotaCalificacion());
        dto.setFechaRegistro(c.getFechaRegistro());
        dto.setCreadoPorIdUsuario(c.getCreadoPorIdUsuario());
        dto.setUltimaModificacion(c.getUltimaModificacion());
        dto.setModificadoPorIdUsuario(c.getModificadoPorIdUsuario());

        if (c.getMatriculaIdMatricula() != null) {
            dto.setIdMatricula(c.getMatriculaIdMatricula().getId());
            dto.setEstudianteIdUsuario(c.getMatriculaIdMatricula().getEstudianteIdUsuario());
        }

        if (c.getEvaluacionIdEvaluacion() != null) {
            dto.setIdEvaluacion(c.getEvaluacionIdEvaluacion().getId_evaluacion());
            dto.setNombreEvaluacion(c.getEvaluacionIdEvaluacion().getNombreEvaluacion());
            dto.setFechaEvaluacion(c.getEvaluacionIdEvaluacion().getFechaEvaluacion());
            if (c.getEvaluacionIdEvaluacion().getCursoAsignatura() != null &&
                c.getEvaluacionIdEvaluacion().getCursoAsignatura().getIdAsignatura() != null) {
                dto.setNombreAsignatura(
                    c.getEvaluacionIdEvaluacion().getCursoAsignatura().getIdAsignatura().getNombreAsignatura()
                );
            }
        }

        return dto;
    }

    private Calificacion toEntity(CalificacionRequestDTO dto) {
        // Valida que el usuario que registra la nota existe en ms-usuario
        usuarioClient.obtenerUsuarioPorId(dto.getCreadoPorIdUsuario());

        Matricula matricula = matriculaRepository.findById(dto.getIdMatricula())
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada con id: " + dto.getIdMatricula()));

        Evaluacion evaluacion = evaluacionRepository.findById(dto.getIdEvaluacion())
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + dto.getIdEvaluacion()));

        validarMismoCurso(matricula, evaluacion);

        Calificacion calificacion = new Calificacion();
        calificacion.setNotaCalificacion(dto.getNotaCalificacion());
        calificacion.setMatriculaIdMatricula(matricula);
        calificacion.setEvaluacionIdEvaluacion(evaluacion);
        calificacion.setCreadoPorIdUsuario(dto.getCreadoPorIdUsuario());
        calificacion.setFechaRegistro(LocalDateTime.now());
        return calificacion;
    }

    // Verifica que la evaluación y la matrícula pertenezcan al mismo curso.
    // La evaluación llega a su curso vía CursoAsignatura; la matrícula lo tiene directo.
    private void validarMismoCurso(Matricula matricula, Evaluacion evaluacion) {
        Long cursoMatricula  = matricula.getCursoIdCurso().getId();
        Long cursoEvaluacion = evaluacion.getCursoAsignatura().getIdCurso().getId();
        if (!cursoMatricula.equals(cursoEvaluacion)) {
            throw new RuntimeException(
                "La evaluación pertenece a un curso distinto al de la matrícula del estudiante.");
        }
    }

    @Override
    public List<CalificacionResponseDTO> listarCalificaciones() {
        return calificacionRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CalificacionResponseDTO buscarCalificacionPorId(Long id) {
        Calificacion calificacion = calificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificacion no encontrada con id: " + id));
        return toResponseDTO(calificacion);
    }

    @Override
    public List<CalificacionResponseDTO> buscarCalificacionesPorEvaluacion(Long evaluacionId) {
        return calificacionRepository.findAllByEvaluacionIdEvaluacion(evaluacionId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CalificacionResponseDTO> buscarCalificacionesPorAlumno(Long matriculaId) {
        return calificacionRepository.findAllByMatriculaIdMatricula(matriculaId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CalificacionResponseDTO crearCalificacion(CalificacionRequestDTO dto) {
        Calificacion calificacion = toEntity(dto);
        return toResponseDTO(calificacionRepository.save(calificacion));
    }

    @Override
    public CalificacionResponseDTO actualizarCalificacion(CalificacionRequestDTO dto, Long id) {
        Calificacion existente = calificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificacion no encontrada con id: " + id));

        Matricula matricula = matriculaRepository.findById(dto.getIdMatricula())
                .orElseThrow(() -> new RuntimeException("Matricula no encontrada con id: " + dto.getIdMatricula()));

        Evaluacion evaluacion = evaluacionRepository.findById(dto.getIdEvaluacion())
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + dto.getIdEvaluacion()));

        validarMismoCurso(matricula, evaluacion);

        existente.setNotaCalificacion(dto.getNotaCalificacion());
        existente.setMatriculaIdMatricula(matricula);
        existente.setEvaluacionIdEvaluacion(evaluacion);
        existente.setModificadoPorIdUsuario(dto.getCreadoPorIdUsuario());
        existente.setUltimaModificacion(LocalDateTime.now());

        return toResponseDTO(calificacionRepository.save(existente));
    }

    @Override
    public void eliminarCalificacion(Long id) {
        Calificacion existente = calificacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificacion no encontrada con id: " + id));
        calificacionRepository.delete(existente);
    }
}

package ms_academico.academicoservice.services.impl;

import ms_academico.academicoservice.dto.CursoAsignaturaRequestDTO;
import ms_academico.academicoservice.dto.CursoAsignaturaResponseDTO;
import ms_academico.academicoservice.model.Asignatura;
import ms_academico.academicoservice.model.Curso;
import ms_academico.academicoservice.model.CursoAsignatura;
import ms_academico.academicoservice.model.Evaluacion;
import ms_academico.academicoservice.repository.AsignaturaRepository;
import ms_academico.academicoservice.repository.CursoAsignaturaRepository;
import ms_academico.academicoservice.repository.CursoRepository;
import ms_academico.academicoservice.repository.EvaluacionRepository;
import ms_academico.academicoservice.services.CursoAsignaturaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoAsignaturaServiceImpl implements CursoAsignaturaService {

    private final CursoAsignaturaRepository cursoAsignaturaRepository;
    private final CursoRepository cursoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final EvaluacionRepository evaluacionRepository;

    public CursoAsignaturaServiceImpl(CursoAsignaturaRepository cursoAsignaturaRepository,
                                      CursoRepository cursoRepository,
                                      AsignaturaRepository asignaturaRepository,
                                      EvaluacionRepository evaluacionRepository) {
        this.cursoAsignaturaRepository = cursoAsignaturaRepository;
        this.cursoRepository = cursoRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.evaluacionRepository = evaluacionRepository;
    }

    // Entidad → DTO de salida: aplana Curso, Asignatura y Evaluacion
    private CursoAsignaturaResponseDTO toResponseDTO(CursoAsignatura ca) {
        CursoAsignaturaResponseDTO dto = new CursoAsignaturaResponseDTO();
        dto.setIdCursoAsignatura(ca.getId());
        dto.setDocenteIdUsuario(ca.getDocenteIdUsuario());

        if (ca.getIdCurso() != null) {
            dto.setIdCurso(ca.getIdCurso().getId());
            dto.setGradoCurso(ca.getIdCurso().getGradoCurso());
            dto.setSeccionCurso(ca.getIdCurso().getSeccionCurso());
            dto.setAnioCurso(ca.getIdCurso().getAnioCurso());
        }

        if (ca.getIdAsignatura() != null) {
            dto.setIdAsignatura(ca.getIdAsignatura().getId_asignatura());
            dto.setNombreAsignatura(ca.getIdAsignatura().getNombreAsignatura());
        }

        if (ca.getIdEvaluacion() != null) {
            dto.setIdEvaluacion(ca.getIdEvaluacion().getId_evaluacion());
            dto.setNombreEvaluacion(ca.getIdEvaluacion().getNombreEvaluacion());
            dto.setFechaEvaluacion(ca.getIdEvaluacion().getFechaEvaluacion());
        }

        return dto;
    }

    // DTO de entrada → Entidad: busca los 3 objetos relacionados en BD
    private CursoAsignatura toEntity(CursoAsignaturaRequestDTO dto) {
        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + dto.getIdCurso()));

        Asignatura asignatura = asignaturaRepository.findById(dto.getIdAsignatura())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + dto.getIdAsignatura()));

        Evaluacion evaluacion = evaluacionRepository.findById(dto.getIdEvaluacion())
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + dto.getIdEvaluacion()));

        CursoAsignatura cursoAsignatura = new CursoAsignatura();
        cursoAsignatura.setIdCurso(curso);
        cursoAsignatura.setIdAsignatura(asignatura);
        cursoAsignatura.setIdEvaluacion(evaluacion);
        cursoAsignatura.setDocenteIdUsuario(dto.getDocenteIdUsuario());
        return cursoAsignatura;
    }

    @Override
    public List<CursoAsignaturaResponseDTO> listarCursoAsignatura() {
        return cursoAsignaturaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CursoAsignaturaResponseDTO buscarCursoAsignaturaPorId(Long id) {
        CursoAsignatura cursoAsignatura = cursoAsignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CursoAsignatura no encontrada con id: " + id));
        return toResponseDTO(cursoAsignatura);
    }

    @Override
    public CursoAsignaturaResponseDTO crearCursoAsignatura(CursoAsignaturaRequestDTO dto) {
        CursoAsignatura cursoAsignatura = toEntity(dto);
        return toResponseDTO(cursoAsignaturaRepository.save(cursoAsignatura));
    }

    @Override
    public CursoAsignaturaResponseDTO actualizarCursoAsignatura(CursoAsignaturaRequestDTO dto, Long id) {
        CursoAsignatura existente = cursoAsignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CursoAsignatura no encontrada con id: " + id));

        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + dto.getIdCurso()));

        Asignatura asignatura = asignaturaRepository.findById(dto.getIdAsignatura())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + dto.getIdAsignatura()));

        Evaluacion evaluacion = evaluacionRepository.findById(dto.getIdEvaluacion())
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + dto.getIdEvaluacion()));

        existente.setIdCurso(curso);
        existente.setIdAsignatura(asignatura);
        existente.setIdEvaluacion(evaluacion);
        existente.setDocenteIdUsuario(dto.getDocenteIdUsuario());

        return toResponseDTO(cursoAsignaturaRepository.save(existente));
    }

    @Override
    public void eliminarCursoAsignatura(Long id) {
        CursoAsignatura existente = cursoAsignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CursoAsignatura no encontrada con id: " + id));
        cursoAsignaturaRepository.delete(existente);
    }
}

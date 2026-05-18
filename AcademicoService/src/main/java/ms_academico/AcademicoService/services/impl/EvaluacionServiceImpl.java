package ms_academico.academicoservice.services.impl;


import ms_academico.academicoservice.dto.EvaluacionRequestDTO;
import ms_academico.academicoservice.dto.EvaluacionResponseDTO;
import ms_academico.academicoservice.model.CursoAsignatura;
import ms_academico.academicoservice.model.Evaluacion;
import ms_academico.academicoservice.repository.CursoAsignaturaRepository;
import ms_academico.academicoservice.repository.EvaluacionRepository;
import ms_academico.academicoservice.services.EvaluacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    private final EvaluacionRepository evaluacionRepository;
    private final CursoAsignaturaRepository cursoAsignaturaRepository;

    public EvaluacionServiceImpl(EvaluacionRepository evaluacionRepository,
                                 CursoAsignaturaRepository cursoAsignaturaRepository) {
        this.evaluacionRepository = evaluacionRepository;
        this.cursoAsignaturaRepository = cursoAsignaturaRepository;
    }

    // Entidad → DTO de salida: aplana la curso-asignatura a la que pertenece
    private EvaluacionResponseDTO toResponseDTO(Evaluacion e) {
        EvaluacionResponseDTO dto = new EvaluacionResponseDTO();
        dto.setIdEvaluacion(e.getId_evaluacion());
        dto.setNombreEvaluacion(e.getNombreEvaluacion());
        dto.setFechaEvaluacion(e.getFechaEvaluacion());

        CursoAsignatura ca = e.getCursoAsignatura();
        if (ca != null) {
            dto.setIdCursoAsignatura(ca.getId());
            if (ca.getIdAsignatura() != null) {
                dto.setIdAsignatura(ca.getIdAsignatura().getId_asignatura());
                dto.setNombreAsignatura(ca.getIdAsignatura().getNombreAsignatura());
            }
            if (ca.getIdCurso() != null) {
                dto.setIdCurso(ca.getIdCurso().getId());
                dto.setGradoCurso(ca.getIdCurso().getGradoCurso());
                dto.setSeccionCurso(ca.getIdCurso().getSeccionCurso());
            }
        }
        return dto;
    }

    // DTO de entrada → Entidad: busca la curso-asignatura en BD
    private Evaluacion toEntity(EvaluacionRequestDTO dto) {
        CursoAsignatura ca = cursoAsignaturaRepository.findById(dto.getIdCursoAsignatura())
                .orElseThrow(() -> new RuntimeException("CursoAsignatura no encontrada con id: " + dto.getIdCursoAsignatura()));

        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setNombreEvaluacion(dto.getNombreEvaluacion());
        evaluacion.setFechaEvaluacion(dto.getFechaEvaluacion());
        evaluacion.setCursoAsignatura(ca);
        return evaluacion;
    }

    @Override
    public List<EvaluacionResponseDTO> listarEvaluacion() {
        return evaluacionRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EvaluacionResponseDTO buscarEvaluacionPorId(Long id) {
        Evaluacion evaluacion = evaluacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + id));
        return toResponseDTO(evaluacion);
    }

    @Override
    public EvaluacionResponseDTO crearEvaluacion(EvaluacionRequestDTO dto) {
        Evaluacion evaluacion = toEntity(dto);
        return toResponseDTO(evaluacionRepository.save(evaluacion));
    }

    @Override
    public EvaluacionResponseDTO actualizarEvaluacion(EvaluacionRequestDTO dto, Long id) {
        Evaluacion existente = evaluacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + id));

        CursoAsignatura ca = cursoAsignaturaRepository.findById(dto.getIdCursoAsignatura())
                .orElseThrow(() -> new RuntimeException("CursoAsignatura no encontrada con id: " + dto.getIdCursoAsignatura()));

        existente.setNombreEvaluacion(dto.getNombreEvaluacion());
        existente.setFechaEvaluacion(dto.getFechaEvaluacion());
        existente.setCursoAsignatura(ca);

        return toResponseDTO(evaluacionRepository.save(existente));
    }

    @Override
    public void eliminarEvaluacion(Long id) {
        Evaluacion existente = evaluacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evaluacion no encontrada con id: " + id));
        evaluacionRepository.delete(existente);
    }
}

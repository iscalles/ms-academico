package ms_academico.academicoservice.services.impl;

import ms_academico.academicoservice.client.UsuarioClient;
import ms_academico.academicoservice.client.UsuarioDTOInternal;
import ms_academico.academicoservice.dto.CursoAsignaturaRequestDTO;
import ms_academico.academicoservice.dto.CursoAsignaturaResponseDTO;
import ms_academico.academicoservice.model.Asignatura;
import ms_academico.academicoservice.model.Curso;
import ms_academico.academicoservice.model.CursoAsignatura;
import ms_academico.academicoservice.repository.AsignaturaRepository;
import ms_academico.academicoservice.repository.CursoAsignaturaRepository;
import ms_academico.academicoservice.repository.CursoRepository;
import ms_academico.academicoservice.services.CursoAsignaturaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoAsignaturaServiceImpl implements CursoAsignaturaService {

    private final CursoAsignaturaRepository cursoAsignaturaRepository;
    private final CursoRepository cursoRepository;
    private final AsignaturaRepository asignaturaRepository;
    private final UsuarioClient usuarioClient;

    public CursoAsignaturaServiceImpl(CursoAsignaturaRepository cursoAsignaturaRepository,
                                      CursoRepository cursoRepository,
                                      AsignaturaRepository asignaturaRepository,
                                      UsuarioClient usuarioClient) {
        this.cursoAsignaturaRepository = cursoAsignaturaRepository;
        this.cursoRepository = cursoRepository;
        this.asignaturaRepository = asignaturaRepository;
        this.usuarioClient = usuarioClient;
    }

    // Entidad → DTO de salida: aplana Curso y Asignatura, y enriquece con nombre del docente
    private CursoAsignaturaResponseDTO toResponseDTO(CursoAsignatura ca) {
        CursoAsignaturaResponseDTO dto = new CursoAsignaturaResponseDTO();
        dto.setIdCursoAsignatura(ca.getId());
        dto.setDocenteIdUsuario(ca.getDocenteIdUsuario());

        // Enriquece con el nombre del docente consultando ms-usuario
        try {
            UsuarioDTOInternal docente = usuarioClient.obtenerUsuarioPorId(ca.getDocenteIdUsuario());
            dto.setNombreDocente(docente.getNombreCompleto());
        } catch (Exception e) {
            dto.setNombreDocente("Usuario no disponible");
        }

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

        return dto;
    }

    // DTO de entrada → Entidad: valida el docente en ms-usuario y busca los objetos en BD
    private CursoAsignatura toEntity(CursoAsignaturaRequestDTO dto) {
        // Valida que el docente existe en ms-usuario antes de guardar
        usuarioClient.obtenerUsuarioPorId(dto.getDocenteIdUsuario());

        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + dto.getIdCurso()));

        Asignatura asignatura = asignaturaRepository.findById(dto.getIdAsignatura())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + dto.getIdAsignatura()));

        CursoAsignatura cursoAsignatura = new CursoAsignatura();
        cursoAsignatura.setIdCurso(curso);
        cursoAsignatura.setIdAsignatura(asignatura);
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

        // Valida que el nuevo docente existe en ms-usuario
        usuarioClient.obtenerUsuarioPorId(dto.getDocenteIdUsuario());

        Curso curso = cursoRepository.findById(dto.getIdCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + dto.getIdCurso()));

        Asignatura asignatura = asignaturaRepository.findById(dto.getIdAsignatura())
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada con id: " + dto.getIdAsignatura()));

        existente.setIdCurso(curso);
        existente.setIdAsignatura(asignatura);
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

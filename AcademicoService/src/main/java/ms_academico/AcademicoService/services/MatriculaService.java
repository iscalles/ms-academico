package ms_academico.academicoservice.services;

import ms_academico.academicoservice.dto.MatriculaRequestDTO;
import ms_academico.academicoservice.dto.MatriculaResponseDTO;

import java.util.List;

public interface MatriculaService {
    List<MatriculaResponseDTO> listarMatriculas();
    List<MatriculaResponseDTO> listarMatriculasPorCurso(Long idCurso);
    MatriculaResponseDTO buscarMatriculaPorId(Long id);
    MatriculaResponseDTO crearMatricula(MatriculaRequestDTO dto);
    MatriculaResponseDTO actualizarMatricula(MatriculaRequestDTO dto, Long id);
    void eliminarMatricula(Long id);
}

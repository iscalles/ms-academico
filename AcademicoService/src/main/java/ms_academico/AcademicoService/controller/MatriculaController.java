package ms_academico.academicoservice.controller;

import ms_academico.academicoservice.dto.MatriculaRequestDTO;
import ms_academico.academicoservice.dto.MatriculaResponseDTO;
import ms_academico.academicoservice.services.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MatriculaResponseDTO>> listarMatriculas() {
        return ResponseEntity.ok(service.listarMatriculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> buscarMatriculaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarMatriculaPorId(id));
    }

    @GetMapping("/curso/{idCurso}")
    public ResponseEntity<List<MatriculaResponseDTO>> listarMatriculasPorCurso(@PathVariable Long idCurso) {
        return ResponseEntity.ok(service.listarMatriculasPorCurso(idCurso));
    }

    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> crearMatricula(@RequestBody MatriculaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearMatricula(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> actualizarMatricula(@PathVariable Long id,
                                                                    @RequestBody MatriculaRequestDTO dto) {
        return ResponseEntity.ok(service.actualizarMatricula(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatricula(@PathVariable Long id) {
        service.eliminarMatricula(id);
        return ResponseEntity.noContent().build();
    }
}

package ms_academico.academicoservice.controller;

import ms_academico.academicoservice.dto.EvaluacionRequestDTO;
import ms_academico.academicoservice.dto.EvaluacionResponseDTO;
import ms_academico.academicoservice.services.EvaluacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    private final EvaluacionService service;

    public EvaluacionController(EvaluacionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EvaluacionResponseDTO>> listarEvaluaciones() {
        return ResponseEntity.ok(service.listarEvaluacion());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionResponseDTO> buscarEvaluacionPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarEvaluacionPorId(id));
    }

    @GetMapping("/curso-asignatura/{idCursoAsignatura}")
    public ResponseEntity<List<EvaluacionResponseDTO>> listarEvaluacionesPorCursoAsignatura(@PathVariable Long idCursoAsignatura) {
        return ResponseEntity.ok(service.listarEvaluacionesPorCursoAsignatura(idCursoAsignatura));
    }

    @PostMapping
    public ResponseEntity<EvaluacionResponseDTO> crearEvaluacion(@RequestBody EvaluacionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearEvaluacion(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionResponseDTO> actualizarEvaluacion(@PathVariable Long id,
                                                                      @RequestBody EvaluacionRequestDTO dto) {
        return ResponseEntity.ok(service.actualizarEvaluacion(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable Long id) {
        service.eliminarEvaluacion(id);
        return ResponseEntity.noContent().build();
    }
}

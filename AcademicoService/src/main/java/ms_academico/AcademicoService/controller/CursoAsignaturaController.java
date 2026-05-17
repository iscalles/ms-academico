package ms_academico.academicoservice.controller;

import ms_academico.academicoservice.dto.CursoAsignaturaRequestDTO;
import ms_academico.academicoservice.dto.CursoAsignaturaResponseDTO;
import ms_academico.academicoservice.services.CursoAsignaturaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso-asignatura")
public class CursoAsignaturaController {

    private final CursoAsignaturaService service;

    public CursoAsignaturaController(CursoAsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CursoAsignaturaResponseDTO>> listarCursoAsignaturas() {
        return ResponseEntity.ok(service.listarCursoAsignatura());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoAsignaturaResponseDTO> buscarCursoAsignaturaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarCursoAsignaturaPorId(id));
    }

    @PostMapping
    public ResponseEntity<CursoAsignaturaResponseDTO> crearCursoAsignatura(@RequestBody CursoAsignaturaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearCursoAsignatura(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoAsignaturaResponseDTO> actualizarCursoAsignatura(@PathVariable Long id,
                                                                                @RequestBody CursoAsignaturaRequestDTO dto) {
        return ResponseEntity.ok(service.actualizarCursoAsignatura(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCursoAsignatura(@PathVariable Long id) {
        service.eliminarCursoAsignatura(id);
        return ResponseEntity.noContent().build();
    }
}

package ms_academico.academicoservice.controller;

import ms_academico.academicoservice.dto.CalificacionLoteRequestDTO;
import ms_academico.academicoservice.dto.CalificacionRequestDTO;
import ms_academico.academicoservice.dto.CalificacionResponseDTO;
import ms_academico.academicoservice.services.CalificacionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificacionController {

    private final CalificacionService service;

    public CalificacionController(CalificacionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CalificacionResponseDTO>> getCalificaciones() {
        return ResponseEntity.ok(service.listarCalificaciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CalificacionResponseDTO> getCalificacionById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarCalificacionPorId(id));
    }

    @GetMapping("/id_evaluacion/{id_evaluacion}")
    public ResponseEntity<List<CalificacionResponseDTO>> getCalificacionesByEvaluacion(@PathVariable Long id_evaluacion) {
        return ResponseEntity.ok(service.buscarCalificacionesPorEvaluacion(id_evaluacion));
    }

    @GetMapping("/id_matricula/{id_matricula}")
    public ResponseEntity<List<CalificacionResponseDTO>> getCalificacionesByAlumno(@PathVariable Long id_matricula) {
        return ResponseEntity.ok(service.buscarCalificacionesPorAlumno(id_matricula));
    }

    @PostMapping
    public ResponseEntity<CalificacionResponseDTO> createCalificacion(@RequestBody CalificacionRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearCalificacion(dto));
    }

    @PostMapping("/lote")
    public ResponseEntity<List<CalificacionResponseDTO>> registrarCalificacionesLote(@RequestBody CalificacionLoteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarCalificacionesLote(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CalificacionResponseDTO> actualizarCalificacion(@PathVariable Long id,
                                                                          @RequestBody CalificacionRequestDTO dto) {
        return ResponseEntity.ok(service.actualizarCalificacion(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCalificacion(@PathVariable Long id) {
        service.eliminarCalificacion(id);
        return ResponseEntity.noContent().build();
    }
}

package ms_academico.AcademicoService.controller;

import ms_academico.AcademicoService.model.CursoAsignatura;
import ms_academico.AcademicoService.services.CursoAsignaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso-asignatura")
public class CursoAsignaturaController {
    private final CursoAsignaturaService service;

    public CursoAsignaturaController(CursoAsignaturaService service) {
        this.service = service;
    }

    @GetMapping()
    List<CursoAsignatura> listarCursoAsignaturas() {
        return service.listarCursoAsignatura();
    }

    @GetMapping("/{id}")
    CursoAsignatura buscarCursoAsignaturaPorId(@PathVariable Long id) {
        return service.buscarCursoAsignaturaPorId(id);
    }

    @PostMapping()
    CursoAsignatura crearCursoAsignatura(@RequestBody CursoAsignatura cursoAsignatura) {
        return service.crearCursoAsignatura(cursoAsignatura);
    }

    @PutMapping("/{id}")
    CursoAsignatura actualizarCursoAsignatura(@PathVariable Long id, @RequestBody CursoAsignatura cursoAsignatura) {
        return service.actualizarCursoAsignatura(cursoAsignatura, id);
    }

    @DeleteMapping("/{id}")
    void eliminarCursoAsignatura(@PathVariable Long id) {
        service.eliminarCursoAsignatura(id);
    }
}

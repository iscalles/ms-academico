package ms_academico.academicoservice.controller;

import ms_academico.academicoservice.model.Asignatura;
import ms_academico.academicoservice.services.AsignaturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {
    private final AsignaturaService service;

    public AsignaturaController(AsignaturaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Asignatura> listarAsignaturas() {
        return service.listarAsignatura();
    }

    @GetMapping("/{id}")
    public Asignatura buscarAsignaturaPorId(@PathVariable Long id) {
        return service.buscarAsignaturaPorId(id);
    }

    @PostMapping
    public Asignatura crearAsignatura(@RequestBody Asignatura asignatura) {
        return service.crearAsignatura(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura actualizarAsignatura(@PathVariable Long id, @RequestBody Asignatura asignatura) {
        return service.actualizarAsignatura(asignatura, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarAsignatura(@PathVariable Long id) {
        service.eliminarAsignatura(id);
    }
}

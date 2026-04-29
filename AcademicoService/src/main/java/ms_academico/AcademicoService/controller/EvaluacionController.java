package ms_academico.AcademicoService.controller;


import ms_academico.AcademicoService.model.Evaluacion;
import ms_academico.AcademicoService.services.EvaluacionService;
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
    public List<Evaluacion> listarEvaluaciones() {
        return service.listarEvaluacion();
    }

    @GetMapping("/{id}")
    public Evaluacion buscarEvaluacionPorId(@PathVariable Long id) {
        return service.buscarEvaluacionPorId(id);
    }

    @PostMapping
    public Evaluacion crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return service.crearEvaluacion(evaluacion);
    }

    @PutMapping("/{id}")
    public Evaluacion actualizarEvaluacion(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        return service.actualizarEvaluacion(evaluacion, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarEvaluacion(@PathVariable Long id) {
        service.eliminarEvaluacion(id);
    }

}

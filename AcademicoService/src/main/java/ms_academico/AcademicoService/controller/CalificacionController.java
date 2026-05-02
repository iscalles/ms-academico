package ms_academico.academicoservice.controller;


import ms_academico.academicoservice.model.Calificacion;
import ms_academico.academicoservice.services.CalificacionService;
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
    public List<Calificacion> getCalificaciones(){
        return service.listarCalificaciones();
    }

    @GetMapping("/{id}")
    public Calificacion getCalificacionById(@PathVariable Long id){
        return service.buscarCalificacionPorId(id);
    }

    @GetMapping("/id_evaluacion/{id_evaluacion}")
    public List<Calificacion> getCalificacionesByEvaluacion(@PathVariable Long id_evaluacion){
        return service.buscarCalificacionesPorEvaluacion(id_evaluacion);
    }

    @GetMapping("/id_matricula/{id_matricula}")
    public List<Calificacion> getCalificacionesByAlumno(@PathVariable Long id_matricula){
        return service.buscarCalificacionesPorAlumno(id_matricula);
    }

    @PostMapping
    public Calificacion createCalificacion(@RequestBody Calificacion calificacion){
        return service.crearCalificacion(calificacion);
    }

    @PutMapping("/{id}")
    public Calificacion actualizarCalificacion(@PathVariable Long id, @RequestBody Calificacion calificacion){
        return service.actualizarCalificacion(calificacion, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarCalificacion(@PathVariable Long id){
        service.eliminarCalificacion(id);
    }
}

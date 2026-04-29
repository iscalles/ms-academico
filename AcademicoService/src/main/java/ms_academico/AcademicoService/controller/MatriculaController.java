package ms_academico.academicoservice.controller;


import ms_academico.academicoservice.model.Matricula;
import ms_academico.academicoservice.services.MatriculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
    private final MatriculaService service;

    public MatriculaController(MatriculaService service){
        this.service = service;
    }

    @GetMapping()
    public List<Matricula> listarMatriculas() {
        return service.listarMatriculas();
    }

    @GetMapping("/{id}")
    public Matricula buscarMatriculaPorId(Long id) {
        return service.buscarMatriculaPorId(id);
    }

    @PostMapping
    public Matricula crearMatricula(@RequestBody Matricula matricula) {
        return service.crearMatricula(matricula);
    }

    @PutMapping("/{id}")
    public Matricula actualizarMatricula(@PathVariable Long id, @RequestBody Matricula matricula) {
        return service.actualizarMatricula(matricula, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMatricula(@PathVariable Long id) {
        service.eliminarMatricula(id);
    }
}

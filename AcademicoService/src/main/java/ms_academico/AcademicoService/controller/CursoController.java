package ms_academico.academicoservice.controller;


import ms_academico.academicoservice.model.Curso;
import ms_academico.academicoservice.services.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @GetMapping()
    List<Curso> listarCursos() {
        return service.listarCursos();
    }

    @GetMapping("/{id}")
    Curso buscarCursoPorId(@PathVariable Long id) {
        return service.buscarCursoPorId(id);
    }

    @PostMapping()
    Curso crearCurso(@RequestBody Curso curso) {
        return service.crearCurso(curso);
    }

    @PutMapping("/{id}")
    Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return service.actualizarCurso(curso, id);
    }

    @DeleteMapping("/{id}")
    void eliminarCurso(@PathVariable Long id) {
        service.eliminarCurso(id);
    }
}

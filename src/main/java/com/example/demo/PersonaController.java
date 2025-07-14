package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public Iterable<Persona> listar() {
        return personaService.findAll();
    }

    @PostMapping
    public Persona salvar(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Persona> actualizar(@PathVariable Long id, @RequestBody Persona persona) {
        try {
            Persona personaActualizada = personaService.update(id, persona);
            return  ResponseEntity.ok(personaActualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Persona> actualizarParcial(@PathVariable Long id, @RequestBody Persona persona) {
        try {
            Persona personaActualizada = personaService.updateParcial(id, persona);
            return  ResponseEntity.ok(personaActualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

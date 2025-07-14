package com.example.demo;

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

    @PutMapping
    public Persona actualizar(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Persona persona) {
        personaService.delete(persona);
    }
}

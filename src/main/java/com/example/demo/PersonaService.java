package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void delete(Persona persona) {
        personaRepository.delete(persona);
    }

    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

    public Persona update(Long id, Persona persona) {
        return personaRepository.findById(id).map(Persona personaExistente -> {
            personaExistente.setNombre(persona.getNombre());
            personaExistente.setApellido(persona.getApellido());
            personaExistente.setEdad(persona.getEdad());
        }).orElse( () -> new RuntimeException("Persona no encontrada"));
    }
}


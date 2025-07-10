package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona findById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public Persona update(Long id, Persona persona) {
        return personaRepository.findById(id).map(personaExistente -> {
            personaExistente.setNombre(persona.getNombre());
            personaExistente.setApellido(persona.getApellido());
            personaExistente.setEdad(persona.getEdad());
            return personaRepository.save(personaExistente);
        }).orElseThrow(()-> new RuntimeException("Persona no encontrada"));

    }


    public Persona updateParcial(Long id, Persona persona) {
        return personaRepository.findById(id).map(personaExistente -> {
            if (persona.getNombre() != null) {
                personaExistente.setNombre(persona.getNombre());
            }
            if (persona.getApellido() != null) {
                personaExistente.setApellido(persona.getApellido());
            }
            if (persona.getEdad() != null) {
                personaExistente.setEdad(persona.getEdad());
            }
            return personaRepository.save(personaExistente);
        }).orElseThrow(()-> new RuntimeException("Persona no encontrada"));

    }


    public void deleteById(Long id) {
        personaRepository.deleteById(id);
    }

}

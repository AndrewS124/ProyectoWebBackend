
package com.example.musiclist2.service;


import com.example.musiclist2.DTO.GeneroDTO;
import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;

    private GeneroDTO convertirDto(Genero genero){
        GeneroDTO dto= new GeneroDTO();
        dto.setId(genero.getId());
        dto.setCanciones(genero.getCanciones());
        dto.setTipo(genero.getTipo());
        
        
        return dto;
    }
 

    public List<GeneroDTO> findAll() {
         Iterable<Genero> generos = generoRepository.findAll();
    return StreamSupport.stream(generos.spliterator(), false)
            .map(this::convertirDto)
            .collect(Collectors.toList());
    }
    public Optional<GeneroDTO> findById(Long id){
        Optional<Genero> Genero= generoRepository.findById(id);
        return Genero.map(this::convertirDto);

    }
    public GeneroDTO createGenero(GeneroDTO GeneroDTO) {
        Genero Genero = ConvertirGenero(GeneroDTO);
        Genero nuevoGenero = generoRepository.save(Genero);
        return convertirDto(nuevoGenero);
    }

    public GeneroDTO updateGenero(Long id, GeneroDTO GeneroDTO) {
        Optional<Genero> GeneroExistente = generoRepository.findById(id);

        if (GeneroExistente.isPresent()) {
            Genero Genero = ConvertirGenero(GeneroDTO);
            Genero.setId(id);
            Genero GeneroActualizado = generoRepository.save(Genero);
            return convertirDto(GeneroActualizado);
        }

        return null; 
    }

    public void deleteGenero(Long id) {
        generoRepository.deleteById(id);
    }

    private Genero ConvertirGenero(GeneroDTO dto){
        Genero genero= new Genero();

        genero.setId(dto.getId());
        genero.setCanciones(dto.getCanciones());
        genero.setTipo(dto.getTipo());
        return genero;
       
    }

}





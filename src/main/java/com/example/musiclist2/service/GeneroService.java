<<<<<<< HEAD

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




=======

package com.example.musiclist2.service;


import com.example.musiclist2.modelo.Genero;
import com.example.musiclist2.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService implements GeneroRepository {
    @Autowired
    GeneroRepository generoRepository;
    @Override
    public <S extends Genero> S save(S entity) {
        return generoRepository.save(entity);
    }

    @Override
    public <S extends Genero> Iterable<S> saveAll(Iterable<S> entities) {
        return generoRepository.saveAll(entities);
    }

    @Override
    public Optional<Genero> findById(Long id) {
        return generoRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return generoRepository.existsById(id);
    }

    @Override
    public Iterable<Genero> findAll() {
        return generoRepository.findAll();
    }

    @Override
    public Iterable<Genero> findAllById(Iterable<Long> longs) {
        return generoRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return generoRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }

    @Override
    public void delete(Genero entity) {
        generoRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        generoRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Genero> entities) {
        generoRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        generoRepository.deleteAll();
    }


   /* public List<Genero> getGenerosConCanciones() {
        return (List<Genero>) generoRepository.findAll(); // Esto recupera todos los géneros con sus canciones asociadas debido a la relación bidireccional.
    }*/


}

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437

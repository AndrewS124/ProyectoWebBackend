<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7

package com.example.musiclist2.service;

import com.example.musiclist2.DTO.CancionDTO;
import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.repositories.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CancionService {
    @Autowired
    CancionRepository cancionRepository;

    private CancionDTO convertirDto(Cancion cancion){
        CancionDTO dto= new CancionDTO();
        dto.setAutor(cancion.getAutor());
        dto.setId(cancion.getId());
        dto.setNombreCancion(cancion.getNombreCancion());
        dto.setGenero(cancion.getGenero());
        dto.setUsuarioAdmin(cancion.getUsuarioAdmin());
        return dto;
    }
 

    public List<CancionDTO> findAll() {
        List<Cancion> canciones = cancionRepository.findAll();
        return canciones.stream()
                .map(this::convertirDto)
                .collect(Collectors.toList());
    }
    public Optional<CancionDTO> findById(Long id){
        Optional<Cancion> cancion= cancionRepository.findById(id);
        return cancion.map(this::convertirDto);

    }
    public CancionDTO createCancion(CancionDTO CancionDTO) {
        Cancion Cancion = ConvertirCancion(CancionDTO);
        Cancion nuevoCancion = cancionRepository.save(Cancion);
        return convertirDto(nuevoCancion);
    }

    public CancionDTO updateCancion(Long id, CancionDTO CancionDTO) {
        Optional<Cancion> CancionExistente = cancionRepository.findById(id);

        if (CancionExistente.isPresent()) {
            Cancion Cancion = ConvertirCancion(CancionDTO);
            Cancion.setId(id);
            Cancion CancionActualizado = cancionRepository.save(Cancion);
            return convertirDto(CancionActualizado);
        }

        return null; 
    }

    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
    }

    private Cancion ConvertirCancion(CancionDTO dto){
        Cancion cancion= new Cancion();
        cancion.setAutor(dto.getAutor());
        cancion.setGenero(dto.getGenero());
        cancion.setId(dto.getId());
        cancion.setNombreCancion(dto.getNombreCancion());
        cancion.setUsuarioAdmin(dto.getUsuarioAdmin());
        return cancion;
       
    }

}

<<<<<<< HEAD
=======
=======

package com.example.musiclist2.service;

import com.example.musiclist2.modelo.Cancion;
import com.example.musiclist2.repositories.CancionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService implements CancionRepository {
    @Autowired
    CancionRepository cancionRepository;

    @Override
    public <S extends Cancion> S save(S entity) {
        return cancionRepository.save(entity);
    }

    @Override
    public <S extends Cancion> Iterable<S> saveAll(Iterable<S> entities) {
        return cancionRepository.saveAll(entities);
    }

    @Override
    public Optional<Cancion> findById(Long id) {
        return cancionRepository.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return cancionRepository.existsById(id);
    }

    @Override
    public Iterable<Cancion> findAll() {
        return cancionRepository.findAll();
    }

    @Override
    public Iterable<Cancion> findAllById(Iterable<Long> longs) {
        return cancionRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return cancionRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        cancionRepository.deleteById(id);
    }

    @Override
    public void delete(Cancion entity) {
        cancionRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        cancionRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Cancion> entities) {
        cancionRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        cancionRepository.deleteAll();
    }

}

>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
>>>>>>> ac1dc0fde5fdf18c2bb71f14c00e15c361f4f2c7

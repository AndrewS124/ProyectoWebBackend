
package com.example.musiclist2.service;

import com.example.musiclist2.dto.CancionDTO;
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


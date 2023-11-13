<<<<<<< HEAD
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.Cancion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CancionRepository extends CrudRepository<Cancion, Long> {
     List<Cancion> findAll();
=======
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.Cancion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CancionRepository extends CrudRepository<Cancion, Long> {


>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
}
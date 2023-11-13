<<<<<<< HEAD
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.Genero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;



public interface GeneroRepository extends CrudRepository<Genero, Long> {


=======
package com.example.musiclist2.repositories;

import com.example.musiclist2.modelo.Genero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GeneroRepository extends CrudRepository<Genero, Long> {


    //List<Genero> getGenerosConCanciones();
>>>>>>> 4b536887f4596e5e8beee34f135d93d87dab3437
}
package com.cursoalura.canciones.repository;

import com.cursoalura.canciones.modelos.Cancion;
import com.cursoalura.canciones.modelos.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CantanteRepositorio extends JpaRepository<Cantante, Long> {

    Optional<Cantante> findByNombreCantanteContainsIgnoreCase(String nombreCantante);

    @Query("SELECT e FROM Cantante c JOIN c.cancionlist e WHERE c.nombreCantante = :nombreCantante")
    List<Cancion> porCancion(String nombreCantante);


}

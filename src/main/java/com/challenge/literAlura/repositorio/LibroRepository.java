package com.challenge.literAlura.repositorio;

import com.challenge.literAlura.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository <Libro, Long> {
    Optional<Libro> findByTituloContainsIgnoreCase(String titulo);

    List<Libro> findByIdiomaContaining(String idioma);

    List<Libro> findTop10ByOrderByNumeroDescargasDesc();

}

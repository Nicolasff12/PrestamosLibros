package com.junior.nff0928.repositorio;


import com.junior.nff0928.entidad.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Integer> {
}

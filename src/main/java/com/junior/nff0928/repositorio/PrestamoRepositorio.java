package com.junior.nff0928.repositorio;

import com.junior.nff0928.entidad.Estudiante;
import com.junior.nff0928.entidad.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepositorio extends JpaRepository<Prestamo, Integer> {

    List<Prestamo> findByEstudiante(Estudiante estudiante);
}

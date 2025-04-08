package com.junior.nff0928.repositorio;

import com.junior.nff0928.entidad.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudianteRrepositorio extends JpaRepository<Estudiante, String> {

    Optional<Estudiante> findByDocumentoAndEmail(String documento, String email );

    Optional<Estudiante> findByEmail(String email );

}

package com.junior.nff0928.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junior.nff0928.entidad.Tarea;

public interface   TareaRepositorio  extends JpaRepository<Tarea, Long>{


    long countByEstado(boolean b);
} 

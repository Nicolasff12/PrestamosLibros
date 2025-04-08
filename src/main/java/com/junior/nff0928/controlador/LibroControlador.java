package com.junior.nff0928.controlador;


import com.junior.nff0928.entidad.Libro;
import com.junior.nff0928.entidad.Tarea;
import com.junior.nff0928.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/libro")
public class LibroControlador {


    @Autowired
    private LibroRepositorio libroRepositorio;

    @GetMapping("/libros")
    public String mostrarLibros(Model model) {
        List<Libro> libros = libroRepositorio.findAll(); // Asegúrate de tener este repositorio
        model.addAttribute("libros", libros);
        return "libreria"; // nombre del archivo HTML sin la extensión
    }

}

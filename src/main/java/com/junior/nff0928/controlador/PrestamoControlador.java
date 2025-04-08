package com.junior.nff0928.controlador;



import com.junior.nff0928.entidad.Estudiante;
import com.junior.nff0928.entidad.Libro;
import com.junior.nff0928.entidad.Prestamo;
import com.junior.nff0928.repositorio.EstudianteRrepositorio;
import com.junior.nff0928.repositorio.LibroRepositorio;
import com.junior.nff0928.repositorio.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;


@Controller
@RequestMapping("/prestamo")
public class PrestamoControlador {

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private EstudianteRrepositorio estudianteRrepositorio;

    @GetMapping("/formulario")
    public String formularioPrestamo(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("libros", libroRepositorio.findAll());
        model.addAttribute("estudiantes", estudianteRrepositorio.findAll());
        return "formPrestamo";
    }

    @PostMapping("/guardar")
    public String guardarPrestamo(@ModelAttribute Prestamo prestamo) {
        prestamo.setFechaPrestamo(LocalDate.now().toString());
        prestamoRepositorio.save(prestamo);
        return "redirect:/prestamo/lista";
    }

    @GetMapping("/lista")
    public String listaPrestamos(Model model) {
        model.addAttribute("prestamos", prestamoRepositorio.findAll());
        return "listaPrestamos";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("estudiantes", estudianteRrepositorio.findAll());
        model.addAttribute("libros", libroRepositorio.findAll());
        return "formPrestamo";
    }

    @GetMapping("/editar/{id}")
    public String editarPrestamo(@PathVariable int id, Model model) {
        Optional<Prestamo> prestamo = prestamoRepositorio.findById(id);
        if (prestamo.isPresent()) {
            model.addAttribute("prestamo", prestamo.get());
            model.addAttribute("estudiantes", estudianteRrepositorio.findAll());
            model.addAttribute("libros", libroRepositorio.findAll());
            return "EditarFormulario";
        }
        return "redirect:/prestamo/listaPrestamos";
    }
    @PostMapping("/prestamo/actualizar")
    public String actualizarPrestamo(@ModelAttribute Prestamo prestamo) {
        // Buscar el estudiante y el libro reales en la base de datos
        Optional<Estudiante> estudianteOpt = estudianteRrepositorio.findById(prestamo.getEstudiante().getDocumento());
        Optional<Libro> libroOpt = libroRepositorio.findById(prestamo.getLibro().getIsbn());

        if (estudianteOpt.isPresent() && libroOpt.isPresent()) {
            prestamo.setEstudiante(estudianteOpt.get());
            prestamo.setLibro(libroOpt.get());

            prestamoRepositorio.save(prestamo);
        }

        // Redirigir a la lista de préstamos después de actualizar
        return "redirect:/listaPrestamos";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarPrestamo(@PathVariable int id) {
        prestamoRepositorio.deleteById(id);
        return "redirect:/prestamo/lista";
    }

}

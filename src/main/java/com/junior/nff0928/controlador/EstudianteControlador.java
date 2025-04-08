package com.junior.nff0928.controlador;


import com.junior.nff0928.entidad.Estudiante;
import com.junior.nff0928.repositorio.EstudianteRrepositorio;
import com.junior.nff0928.repositorio.LibroRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiante")
public class EstudianteControlador {

    @Autowired
    private EstudianteRrepositorio estudianteRrepositorio;

    @GetMapping("registro")
    public String FormRegistro(Model model){
        model.addAttribute("estudiante", new Estudiante());

        return "Registrarse";
    }

    @PostMapping("/registro")
    public String procesarFormulario(@ModelAttribute Estudiante estudiante) {
        estudianteRrepositorio.save(estudiante);
        System.out.println("Estudiante registrado: " + estudiante);
        return "perfil";
    }

    @PostMapping("/inicioSesion")
    public String incioSesion(@RequestParam String email, @RequestParam String documento, HttpSession session, Model model) {
        Optional<Estudiante> estudiante = estudianteRrepositorio.findByDocumentoAndEmail(documento, email);

        if (estudiante.isPresent()) {
            Estudiante estudianteEncontrado = estudiante.get(); // ✅ Extrae el objeto de Optional
            session.setAttribute("estudianteLogueado", estudianteEncontrado);
            model.addAttribute("estudiante", estudianteEncontrado); // ✅ Envíalo como objeto, no como Optional
            return "perfil";
        } else {
            model.addAttribute("error", "Credenciales inválidas");
            return "inicioSesion";
        }
    }

    @GetMapping("/perfil")
    public String verPerfil(HttpSession session, Model model) {
        Estudiante estudiante = (Estudiante) session.getAttribute("estudianteLogueado"); // 👈 Recuperas desde sesión
        if (estudiante != null) {
            model.addAttribute("estudiante", estudiante); // 👈 Pasas al HTML
            return "perfil";
        } else {
            return "redirect:/inicioSesion";
        }
    }



}

package com.junior.nff0928.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexControlador {

    @GetMapping("/")
    public String mostrarDashboard(Model model) {
        return "#"; // Vista para mostrar la gráfica
    }

    @GetMapping("inicioSesion")
    public String mostrarForm(){
        return "InicioSesion";
    }


}

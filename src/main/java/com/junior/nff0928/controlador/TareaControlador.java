package com.junior.nff0928.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.junior.nff0928.entidad.Tarea;
import com.junior.nff0928.repositorio.TareaRepositorio;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/*
@Controller
@RequestMapping("/tarea")
public class TareaControlador {

    @Autowired
    private TareaRepositorio tareaRepositorio;


    @GetMapping("/")
    public String mostrarDashboard(Model model) {
        // Obtener todas las tareas
        List<Tarea> tareas = tareaRepositorio.findAll();

        long tareasPendientes = tareaRepositorio.countByEstado(false); // Tareas pendientes
        long tareasCompletadas = tareaRepositorio.countByEstado(true); // Tareas completadas

        model.addAttribute("tareasPendientes", tareasPendientes);
        model.addAttribute("tareasCompletadas", tareasCompletadas);

        return "#"; // Vista para mostrar la gráfica
    }


    @GetMapping("/tareas")
    public String listarTareas(Model model) {
        model.addAttribute("tareas", tareaRepositorio.findAll()); // Obtiene todas las tareas
        return "listartareas"; // Retorna el nombre de la vista
    }



    @GetMapping("/crear")
    public String mostrarFormTareaCrear(Model model) {
        model.addAttribute("tarea", new Tarea()); // Añade un objeto vacío al modelo
        return "formTarea"; // Devuelve el nombre del template
    }



    @PostMapping("/guardar")
    public String guardarTarea(@ModelAttribute Tarea tarea) {
        if (tarea == null) {
            return "redirect:/#";
        }
        //System.out.println("Guardando tarea: " + tarea.getNombre() + ", " + tarea.getDescripcion() + ", " + tarea.isEstado());
        tareaRepositorio.save(tarea);  // Guarda la tarea en la base de datos
        return "redirect:/#";  // Redirige a la lista de tareas
    }



    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("tarea", tareaRepositorio.findById(id).orElse(null));
        return "formTarea";  // Vista para editar la tarea
    }

    @PostMapping("/actualizar")
    public String actualizarTarea(@ModelAttribute Tarea tarea) {
        if (tarea != null && tarea.getId() != null) {
            tareaRepositorio.save(tarea); // Si el id está presente, Hibernate hará una actualización en lugar de una inserción
        }
        return "redirect:/tarea/tareas"; // Redirigir a la lista de tareas
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaRepositorio.deleteById(id);
        return "redirect:/#";  // Redirigir a la lista de tareas
    }

    @GetMapping("/completar/{id}")
    public String completarTarea(@PathVariable Long id) {
        Tarea tarea = tareaRepositorio.findById(id).orElse(null);
        if (tarea != null) {
            tarea.setEstado(true);
            tareaRepositorio.save(tarea);
        }
        return "redirect:/#";  // Redirigir a la lista de tareas
    }
}
*/
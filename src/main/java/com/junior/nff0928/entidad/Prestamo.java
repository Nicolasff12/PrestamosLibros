package com.junior.nff0928.entidad;


import jakarta.persistence.*;
import lombok.*;
import com.junior.nff0928.entidad.Estudiante;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Prestamo")
@Data
public class Prestamo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int idPrestamo;
        @ManyToOne
        @JoinColumn(name = "estudiante_documento")
        private Estudiante estudiante;
        @ManyToOne
        @JoinColumn(name = "libro_isbn")
        private Libro libro;
        @Column(name = "Fecha", nullable = false,length = 15)
        private String fechaPrestamo;

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
}


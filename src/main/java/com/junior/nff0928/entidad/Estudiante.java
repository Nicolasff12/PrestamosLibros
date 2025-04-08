package com.junior.nff0928.entidad;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Estudiantes")

public class Estudiante {

    @Id
    @Column(name="documento",nullable=false, length = 30)
    private String documento;
    @Column(name="nombre",nullable=false, length = 50)
    private String nombre;
    @Column(name="apellido",nullable=false, length = 50)
    private String apellido;
    @Column(name="email",nullable=false, length = 100)
    private String email;
    @Column(name="telefono",nullable=false, length = 30)
    private String telefono;

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

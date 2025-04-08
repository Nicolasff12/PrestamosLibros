package com.junior.nff0928.entidad;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long  id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descrpcion", nullable = false)
    private String descripcion;
    @Column(name = "estado", nullable = false)
    private boolean estado = false;




}

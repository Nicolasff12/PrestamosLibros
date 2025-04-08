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
@Table(name = "Libros")
@Data
public class Libro {


    @Id
    @Column(name="ISBN",nullable=false, length = 30)
    private int isbn;
    @Column(name="Titulo",nullable=false, length = 50)
    private String titulo;
    @Column(name="Editorail",nullable=false, length = 50)
    private String editorial;
    @Column(name="Autor",nullable=false, length = 100)
    private String autor;
    @Column(name="NumPag",nullable=false, length = 30)
    private int numPag;


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }
}

package com.challenge.literAlura.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true)
    private String titulo;
    private String idioma;
    private Double numeroDescargas;
    private String nombreAutor;
    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;

    public Libro(){}


    public Libro(DatosLibro datosLibro, List<Autor> autor){
        this.titulo = datosLibro.titulo();
        this.idioma = datosLibro.idiomas().get(0);
        this.autor = autor.get(0);
        this.nombreAutor = autor.get(0).getNombre();

        this.numeroDescargas = datosLibro.numeroDescargas();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(Double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "------- Libro ---------" + "\n" +
                "Título: " + titulo + '\n' +
                "Autor: " + autor.getNombre() + '\n' +
                "Idioma: " + idioma + "\n" +
                "Número de descargas: " + numeroDescargas + "\n"
                + "------------------------";
    }
}

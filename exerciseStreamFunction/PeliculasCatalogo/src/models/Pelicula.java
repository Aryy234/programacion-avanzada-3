package models;

import java.util.List;

public class Pelicula {
    String titulo;
    int anio;
    double duracion;
    List<String> generos;

    public Pelicula(String titulo, int anio, double duracion, List<String> generos) {
        this.titulo = titulo;
        this.anio = anio;
        this.duracion = duracion;
        this.generos = generos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", duracion=" + duracion +
                ", generos=" + generos +
                '}';
    }
}

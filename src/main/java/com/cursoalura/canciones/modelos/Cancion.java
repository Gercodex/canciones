package com.cursoalura.canciones.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Canciones")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreCancion;
    @ManyToOne
    private Cantante cantante;

    public Cancion() {
    }

    public Cancion(Cantante cantante) {
        this.cantante = cantante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public Cantante getCantante() {
        return cantante;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }

    @Override
    public String toString() {
        return "nombreCancion='" + nombreCancion + '\'' + "\n" ;
    }
}

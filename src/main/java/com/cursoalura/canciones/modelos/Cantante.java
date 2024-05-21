package com.cursoalura.canciones.modelos;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cantantes")
public class Cantante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombreCantante;
    @OneToMany(mappedBy = "cantante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cancion> cancionlist;

    public void agregarCancion(Cancion cancion) {
        cancionlist.add(cancion);
    }

    public Cantante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCantante() {
        return nombreCantante;
    }

    public void setNombreCantante(String nombreCantante) {
        this.nombreCantante = nombreCantante;
    }

    public List<Cancion> getCancionlist() {
        return cancionlist;
    }

    public void setCancionlist(List<Cancion> cancionlist) {
        this.cancionlist = cancionlist;
    }

    @Override
    public String toString() {
        return "nombreCantante='" + nombreCantante + '\'';
    }
}

package com.cursoalura.canciones.principal;

import com.cursoalura.canciones.modelos.Cancion;
import com.cursoalura.canciones.modelos.Cantante;
import com.cursoalura.canciones.repository.CantanteRepositorio;
import org.hibernate.Cache;
import org.springframework.boot.CommandLineRunner;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal{

    private CantanteRepositorio cantanteRepositorio;
    private Scanner scanner = new Scanner(System.in);
    private Cantante cantante;
    private List<Cantante> cantantes;

    public Principal(CantanteRepositorio cantanteRepositorio) {
        this.cantanteRepositorio = cantanteRepositorio;
    }

    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            String menu = """
                
                1 - Agregar cantante
                2 - Buscar cantante
                3 - Agregar canciones a cantante
                4 - Mostrar Lista de cantantes
                5 - Listar canciones de cantante
                0 - Salir
                """;

            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarCantante();
                    break;
                case 2:
                    buscarCantante();
                    break;
                case 3:
                    agregarCancionesDeCantante();
                    break;
                case 4:
                    mostrarCancionesDeCantante();
                    break;
                case 5:
                    buscarCancion();
                    break;
                case 0:
                    System.out.println("Hasta pronto! Aplicación terminada.");
                    break;
                default:
                    System.out.println("Opcion inválida.");
            }
        }
    }

    private void mostrarCancionesDeCantante() {
        cantantes = cantanteRepositorio.findAll();
        System.out.println(cantantes);
    }

    private void agregarCancionesDeCantante() {
        buscarCantante();
        System.out.println("Escriba el nombre de la canción que desea agregar del cantante");
        String nombreCancion = scanner.nextLine();
        Cancion cancion = new Cancion(cantante);
        cancion.setNombreCancion(nombreCancion);
        cantante.agregarCancion(cancion);
        cantanteRepositorio.save(cantante);
    }

    private void agregarCantante() {
        System.out.println("Ingresa el nombre del cantante");
        String nombre = scanner.nextLine();
        cantante = new Cantante();
        cantante.setNombreCantante(nombre);
        cantanteRepositorio.save(cantante);

    }

    private void buscarCancion() {
        buscarCantante();
        List<Cancion> canciones = cantanteRepositorio.porCancion(cantante.getNombreCantante());
        canciones.forEach(System.out::println);
    }

    private void buscarCantante() {
        System.out.println("Escriba el nombre del cantante que desea buscar:");
        var busqueda = scanner.nextLine();
        Optional<Cantante> resultadoCantante = cantanteRepositorio.findByNombreCantanteContainsIgnoreCase(busqueda);
        if (resultadoCantante.isPresent()) {
            cantante = resultadoCantante.get();
            System.out.println(cantante);
        }else {
            System.out.println("No se ha encontrado el cantante");
        }
    }
}

package ui;

import servicios.BibliotecaService;
import estructuras.Validaciones.validaciones;
import estructuras.listaEnlazadas.SimpleLinkedList;
import modelos.Libro;

public class MenuLibros {
    private final BibliotecaService bibliotecaService;

    public MenuLibros(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    public void mostrar() {
        int opcion;
        do {
            validaciones.clearScreen();
            System.out.println("=== GESTION DE LIBROS ===");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Buscar libro por codigo");
            System.out.println("3. Mostrar catalogo completo");
            System.out.println("4. Buscar libros por autor");
            System.out.println("5. Calcular monto total de libros Prestados");
            System.out.println("0. Volver al menu principal");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> buscarPorCodigo();
                case 3 -> mostrarCatalogo();
                case 4 -> buscarPorAutor();
                case 5 -> calcularMontoTotalPrestamos();
                case 0 -> {
                }
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

    private void registrarLibro() {
        System.out.println("\n=== REGISTRAR NUEVO LIBRO ===");
        int codigo = bibliotecaService.generarCodigoLibroUnico();// Generar un codigo aleatorio
        String titulo = validaciones.readString("Ingrese titulo: ");
        String autor = validaciones.readString("Ingrese autor: ");
        double precio = validaciones.readDouble("Ingrese precio: ");

        if (bibliotecaService.registrarLibro(codigo, titulo, autor, precio)) {
            System.out.println("Libro registrado exitosamente!");
            System.out.println("Codigo generado: " + codigo);
        } else {
            System.out.println("Error El codigo ya existe o se alcanzo la capacidad maxima!!");
        }

    }

    private void buscarPorCodigo() {
        System.out.println("\n=== BUSCAR LIBRO POR CÓDIGO ===");
        int codigo = validaciones.readInt("Ingrese código del libro: ");
        Libro libro = bibliotecaService.buscarLibroPorCodigo(codigo);

        if (libro != null) {
            System.out.println("\nLIBRO ENCONTRADO:");
            System.out.println(libro);
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    private void mostrarCatalogo() {
        System.out.println("\n=== CATÁLOGO COMPLETO ===");
        System.out.println(bibliotecaService.mostrarCatalogoCompleto());
    }

    private void buscarPorAutor() {
        System.out.println("\n=== BUSCAR LIBROS POR AUTOR ===");
        String autor = validaciones.readString("Ingrese nombre del autor: ");
        SimpleLinkedList<Libro> resultados = bibliotecaService.buscarLibrosPorAutor(autor);

        if (resultados.size() > 0) {
            System.out.println("\nLIBROS ENCONTRADOS:");
            for (Libro libro : resultados) {
                System.out.println(libro);
            }
            System.out.println("Total: " + resultados.size() + " libros");
        } else {
            System.out.println("No se encontraron libros de este autor");
        }
    }

    public void calcularMontoTotalPrestamos(){
        System.out.println("\n=== CALCULAR MONTOS DE PRESTAMOS ===");
        System.out.println("Monto total de prestamos: $ "+bibliotecaService.calcularMontoTotalPrestamos());
    }
}
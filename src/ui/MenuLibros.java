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

    }

    private void mostrarCatalogo() {
        System.out.println("\n<<< CATÁLOGO ACTUALIZADO A LA FECHA >>>.");
        bibliotecaService.mostrarCatalogo();
    }

    private void buscarPorAutor() {
        System.out.println("\n<<< BÚSQUEDA DE LIBRO POR AUTOR >>>:");
        String autorBuscado = validaciones.readString("Nombre: ");
        SimpleLinkedList<Libro> lista = bibliotecaService.buscarLibrosPorAutor(autorBuscado);
        for (Libro libro : lista) {
            System.out.println(libro);
        }
    }

    public void calcularMontoTotalPrestamos() {
        System.out.println("\n<<< MONTO TOTAL DE LOS LIBROS QUE SE ENCUENTRAN EN PRÉSTAMO >>>");
        System.out.println("Total: " + bibliotecaService.montoLibrosPrestados());
    }
}
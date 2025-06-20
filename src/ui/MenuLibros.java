package ui;

import servicios.BibliotecaService;
import estructuras.Validaciones.validaciones;


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
            System.out.println("5. Actualizar disponibilidad");
            System.out.println("6. Calcular monto total de libros Prestados");
            System.out.println("0. Volver al menu principal");
            opcion = validaciones.readInt("Seleccione una opcion: ");

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> buscarPorCodigo();
                case 3 -> mostrarCatalogo();
                case 4 -> buscarPorAutor();
                case 5 -> actualizarDisponibilidad();
                case 6 -> calcularMontoTotalPrestamos();
                case 0 -> {}
                default -> System.out.println("Opcion invalida");
            }
            validaciones.pause();
        } while (opcion != 0);
    }

    private void registrarLibro() {
        
    }

    private void buscarPorCodigo() {
       
    }

    private void mostrarCatalogo() {
        
    }

    private void buscarPorAutor() {
        
    }

    private void actualizarDisponibilidad() {
        
    }

    public void calcularMontoTotalPrestamos(){
        
    }
}
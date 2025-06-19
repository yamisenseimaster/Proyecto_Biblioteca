


import servicios.BibliotecaService;
import ui.MenuPrincipal;
import estructuras.Validaciones.validaciones;

public class Main {
    public static void main(String[] args) {

        // se inicia con la capacidad de 100 libros y 50 usuarios
        BibliotecaService bibliotecaService = new BibliotecaService(100, 50);
        
        System.out.println("\n");
        // Mensaje de bienvenida
        System.out.println("====================================");
        System.out.println("  SISTEMA DE GESTIÓN DE BIBLIOTECA  ");
        System.out.println("====================================");
        System.out.println("Cargando recursos...\n");

        // Esperar a que el usuario presione Enter
        validaciones.pause();

       
        MenuPrincipal menuPrincipal = new MenuPrincipal(bibliotecaService);
        
        // Iniciar la aplicación
        menuPrincipal.mostrar();
        
        System.out.println("\n====================================");
        System.out.println("  ¡Gracias por usar el sistema!     ");
        System.out.println("====================================");
    }
}
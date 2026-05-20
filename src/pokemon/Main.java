package pokemon;

import pokemon.data.TipoLoader;
import pokemon.ui.MenuPrincipal;

/**
 * Punto de entrada principal de la aplicación Pokémon POO.
 * 
 * Responsabilidades:
 * - Inicializar recursos globales (tipos de Pokémon)
 * - Iniciar la interfaz de usuario
 * 
 * @author UTP
 * @version 3.0 - Optimizado con STATIC y DEFAULT
 */
public class Main {

    /**
     * Método main - ejecuta la aplicación.
     * STATIC: Es el punto de entrada de la JVM, no requiere instancia.
     */
    public static void main(String[] args) {
        try {
            // Cargar tipos desde JSON (operación única al inicio)
            TipoLoader.cargarTipos("src/pokemon/data/tipos.json");
            
            // Ejecutar menú principal
            MenuPrincipal.iniciar();
        } catch (Exception e) {
            System.err.println("❌ Error al iniciar la aplicación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

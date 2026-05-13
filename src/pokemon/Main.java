package pokemon;

import pokemon.data.TipoLoader;
import pokemon.ui.MenuPrincipal;

/**
 * Punto de entrada principal de la aplicación Pokémon POO.
 * @author UTP
 * @version 2.0 - Con static y default
 */
public class Main {

    /**
     * Método main - ejecuta la aplicación.
     * STATIC: No necesita instancia de Main, es el punto de entrada.
     */
    public static void main(String[] args) {
        // Cargar tipos desde JSON (operación única al inicio)
        TipoLoader.cargarTipos("src/pokemon/data/tipos.json");

        // Ejecutar menú principal
        MenuPrincipal.iniciar();
    }
}

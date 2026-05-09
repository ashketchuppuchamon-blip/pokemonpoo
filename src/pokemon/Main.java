package pokemon;

import pokemon.data.TipoLoader;
import pokemon.ui.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        // IMPORTANTE: Cargar los tipos antes que nada
        TipoLoader.cargarTipos("src/pokemon/data/tipos.json");

        // Mostrar menú principal
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrar();
    }
}

package pokemon.model;

import java.util.List;

/**
 * Interfaz que define las estrategias de juego.
 * PUBLIC: Contrato para implementaciones concretas.
 */
public interface Estrategia {
    int elegirMovimiento(Pokemon pokemon);
    boolean debeSwitch(Pokemon pokemonActual, List<Pokemon> equipo);
}

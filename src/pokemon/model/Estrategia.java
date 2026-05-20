package pokemon.model;

import java.util.List;

/**
 * Interfaz que define el comportamiento estratégico de un entrenador en batalla.
 * 
 * Implementa el patrón Strategy para permitir diferentes tácticas:
 * - EstrategiaJugador: Decisiones del jugador humano
 * - EstrategiaIA: Inteligencia artificial con múltiples niveles
 * 
 * PUBLIC: Contrato visible para todas las implementaciones.
 * 
 * @author UTP
 */
public interface Estrategia {

    /**
     * Elige qué movimiento usar basado en la estrategia.
     * 
     * @param pokemon El Pokémon que atacará
     * @return Índice del movimiento a usar (0-3)
     */
    int elegirMovimiento(Pokemon pokemon);

    /**
     * Decide si cambiar de Pokémon durante la batalla.
     * 
     * @param pokemonActual Pokémon en batalla actualmente
     * @param equipo Lista de todos los Pokémon del entrenador
     * @return true si desea cambiar de Pokémon
     */
    boolean debeSwitch(Pokemon pokemonActual, List<Pokemon> equipo);
}

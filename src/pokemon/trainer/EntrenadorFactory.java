package pokemon.trainer;

import pokemon.data.Pokedex;
import java.util.List;
import pokemon.model.Pokemon;

/**
 * STATIC Factory para crear entrenadores.
 * 
 * Patrón Factory Pattern:
 * - Centraliza creación de entrenadores con sus equipos
 * - Integra con Pokedex para obtener Pokémon
 * - Encapsula complejidad de inicialización
 * 
 * STATIC: Solo métodos estáticos.
 * PUBLIC: Accesible desde interfaz de usuario.
 * 
 * @author UTP
 */
public class EntrenadorFactory {

    // ========== CONSTANTES PRIVADAS STATIC ==========
    private static final int TAMAÑO_EQUIPO_STANDAR = 3;

    /**
     * Constructor privado (clase utilitaria).
     */
    private EntrenadorFactory() {
        // Factory class
    }

    /**
     * STATIC: Crea un entrenador jugador con equipo.
     * 
     * @param nombre Nombre del jugador
     * @return EntrenadorJugador configurado
     */
    public static Entrenador crearEntrenadorJugador(String nombre) {
        Equipo equipo = new Equipo();
        // Agregar 3 Pokémon al azar del Pokédex
        List<Pokemon> disponibles = Pokedex.obtenerTodos();
        
        for (int i = 0; i < TAMAÑO_EQUIPO_STANDAR && i < disponibles.size(); i++) {
            equipo.agregarPokemon(disponibles.get(i));
        }
        
        return new EntrenadorJugador(nombre, equipo);
    }

    /**
     * STATIC: Crea un entrenador IA con equipo.
     * 
     * @param nombre Nombre de la IA
     * @param dificultad Nivel de dificultad (1-3)
     * @return EntrenadorIA configurado
     */
    public static Entrenador crearEntrenadorIA(String nombre, int dificultad) {
        Equipo equipo = new Equipo();
        // Agregar 3 Pokémon al azar del Pokédex
        List<Pokemon> disponibles = Pokedex.obtenerTodos();
        
        for (int i = 0; i < TAMAÑO_EQUIPO_STANDAR && i < disponibles.size(); i++) {
            equipo.agregarPokemon(disponibles.get(i));
        }
        
        return new EntrenadorIA(nombre, equipo, dificultad);
    }
}

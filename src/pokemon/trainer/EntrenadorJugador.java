package pokemon.trainer;

import pokemon.model.Estrategia;
import pokemon.model.EstrategiaFactory;

/**
 * Entrenador Jugador Humano.
 * 
 * DEFAULT: Visibilidad package-private.
 * Utiliza estrategia de jugador humano (input manual).
 * 
 * @author UTP
 */
class EntrenadorJugador extends Entrenador {

    /**
     * Constructor del entrenador jugador.
     * 
     * @param nombre Nombre del entrenador
     * @param equipo Equipo de Pokémon
     */
    EntrenadorJugador(String nombre, Equipo equipo) {
        super(nombre, equipo, EstrategiaFactory.crearEstrategiaJugador());
    }

    @Override
    public String getDescripcion() {
        return "🎮 Jugador Humano";
    }
}

package pokemon.trainer;

import pokemon.model.Estrategia;
import pokemon.model.EstrategiaFactory;

/**
 * Entrenador de Inteligencia Artificial.
 * 
 * DEFAULT: Visibilidad package-private.
 * Utiliza estrategia de IA con nivel de dificultad configurable.
 * 
 * @author UTP
 */
class EntrenadorIA extends Entrenador {

    // ========== ATRIBUTOS PRIVADOS ==========
    private final int dificultad;

    /**
     * Constructor del entrenador IA.
     * 
     * @param nombre Nombre del entrenador IA
     * @param equipo Equipo de Pokémon
     * @param dificultad Nivel de dificultad (1-3)
     */
    EntrenadorIA(String nombre, Equipo equipo, int dificultad) {
        super(nombre, equipo, EstrategiaFactory.crearEstrategiaIA(dificultad));
        this.dificultad = dificultad;
    }

    @Override
    public String getDescripcion() {
        String nivel = switch (dificultad) {
            case 1 -> "Fácil";
            case 2 -> "Normal";
            case 3 -> "Difícil";
            default -> "Desconocido";
        };
        return String.format("🤖 IA (%s)", nivel);
    }
}

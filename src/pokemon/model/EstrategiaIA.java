package pokemon.model;

import java.util.List;

/**
 * Estrategia de Inteligencia Artificial.
 * 
 * DEFAULT: Visibilidad package-private.
 * 
 * Implementa 3 niveles de dificultad:
 * - FACIL: Movimientos aleatorios
 * - NORMAL: Prioriza movimientos de mayor poder
 * - DIFICIL: Estrategia óptima con análisis táctico
 * 
 * @author UTP
 */
class EstrategiaIA implements Estrategia {

    // ========== CONSTANTES PRIVADAS ==========
    private static final int DIFICULTAD_FACIL = 1;
    private static final int DIFICULTAD_NORMAL = 2;
    private static final int DIFICULTAD_DIFICIL = 3;
    private static final double PROBABILIDAD_SWITCH_FACIL = 0.2;
    private static final double UMBRAL_HP_BAJO = 0.3;

    // ========== ATRIBUTOS PRIVADOS ==========
    private final int dificultad;

    /**
     * Constructor de la estrategia de IA.
     * 
     * @param dificultad Nivel de dificultad (1-3)
     */
    EstrategiaIA(int dificultad) {
        this.dificultad = Math.max(DIFICULTAD_FACIL, Math.min(DIFICULTAD_DIFICIL, dificultad));
    }

    /**
     * Elige movimiento según el nivel de dificultad.
     */
    @Override
    public int elegirMovimiento(Pokemon pokemon) {
        List<Movimiento> movimientos = pokemon.getMovimientos();

        switch (dificultad) {
            case DIFICULTAD_FACIL:
                return elegirMovimientoAleatorio(movimientos);
            case DIFICULTAD_NORMAL:
                return elegirMovimientoMejor(movimientos);
            case DIFICULTAD_DIFICIL:
                return elegirMovimientoOptimo(pokemon, movimientos);
            default:
                return 0;
        }
    }

    /**
     * DEFAULT: Elige un movimiento aleatorio entre los disponibles.
     */
    private int elegirMovimientoAleatorio(List<Movimiento> movimientos) {
        int index;
        do {
            index = (int) (Math.random() * movimientos.size());
        } while (!movimientos.get(index).tienePP());
        return index;
    }

    /**
     * DEFAULT: Elige el movimiento con mayor poder.
     */
    private int elegirMovimientoMejor(List<Movimiento> movimientos) {
        int mejorIndex = 0;
        int mejorPoder = 0;

        for (int i = 0; i < movimientos.size(); i++) {
            Movimiento mov = movimientos.get(i);
            if (mov.tienePP() && mov.getPoder() > mejorPoder) {
                mejorPoder = mov.getPoder();
                mejorIndex = i;
            }
        }
        return mejorIndex;
    }

    /**
     * DEFAULT: Estrategia óptima considerando factores múltiples.
     */
    private int elegirMovimientoOptimo(Pokemon pokemon, List<Movimiento> movimientos) {
        // Priorizar movimientos con mejor relación poder/precisión
        int mejorIndex = 0;
        double mejorValor = 0;

        for (int i = 0; i < movimientos.size(); i++) {
            Movimiento mov = movimientos.get(i);
            if (mov.tienePP()) {
                double valor = (mov.getPoder() * mov.getPrecision()) / 100.0;
                if (valor > mejorValor) {
                    mejorValor = valor;
                    mejorIndex = i;
                }
            }
        }
        return mejorIndex;
    }

    /**
     * Decide si cambiar según el nivel de dificultad y estado del Pokémon.
     */
    @Override
    public boolean debeSwitch(Pokemon pokemonActual, List<Pokemon> equipo) {
        switch (dificultad) {
            case DIFICULTAD_FACIL:
                return Math.random() < PROBABILIDAD_SWITCH_FACIL;
            case DIFICULTAD_NORMAL:
                return pokemonActual.getHp() < pokemonActual.getHpMax() * UMBRAL_HP_BAJO;
            case DIFICULTAD_DIFICIL:
                return false; // No cambia en dificultad difícil
            default:
                return false;
        }
    }
}

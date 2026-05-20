package pokemon.model;

/**
 * STATIC Factory para crear estrategias.
 * 
 * Patrón Factory Pattern:
 * - Centraliza la creación de estrategias
 * - Facilita cambios en implementación
 * - Encapsula acceso a clases package-private
 * 
 * STATIC: Solo métodos estáticos.
 * DEFAULT: Clase package-private.
 * 
 * @author UTP
 */
class EstrategiaFactory {

    /**
     * Constructor privado (clase utilitaria).
     */
    private EstrategiaFactory() {
        // Factory class
    }

    /**
     * STATIC: Crea estrategia de jugador humano.
     * 
     * @return EstrategiaJugador
     */
    static Estrategia crearEstrategiaJugador() {
        return new EstrategiaJugador();
    }

    /**
     * STATIC: Crea estrategia de IA con dificultad especificada.
     * 
     * @param dificultad Nivel de dificultad (1-3)
     * @return EstrategiaIA
     */
    static Estrategia crearEstrategiaIA(int dificultad) {
        return new EstrategiaIA(dificultad);
    }
}

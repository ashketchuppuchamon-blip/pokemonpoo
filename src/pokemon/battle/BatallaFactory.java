package pokemon.battle;

import pokemon.trainer.Entrenador;

/**
 * STATIC Factory para crear batallas.
 * 
 * Patrón Factory Pattern:
 * - Centraliza la creación de objetos Batalla
 * - Encapsula la lógica de inicialización
 * - Facilita modificaciones futuras
 * 
 * STATIC: Solo contiene métodos estáticos.
 * DEFAULT: Clase package-private.
 * 
 * @author UTP
 */
class BatallaFactory {

    /**
     * Constructor privado (clase utilitaria).
     */
    private BatallaFactory() {
        // Factory class
    }

    /**
     * STATIC: Crea y retorna una batalla entre dos entrenadores.
     * 
     * @param entrenador1 Primer entrenador
     * @param entrenador2 Segundo entrenador
     * @return Batalla lista para iniciar
     */
    static Batalla crearBatalla(Entrenador entrenador1, Entrenador entrenador2) {
        if (entrenador1 == null || entrenador2 == null) {
            throw new IllegalArgumentException("Los entrenadores no pueden ser nulos");
        }
        return new Batalla(entrenador1, entrenador2);
    }
}

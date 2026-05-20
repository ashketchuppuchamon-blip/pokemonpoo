package pokemon.model;

/**
 * Estado Concreto: Pokémon en perfectas condiciones.
 * 
 * DEFAULT: Visibilidad package-private.
 * No tiene efectos negativos.
 * 
 * @author UTP
 */
class EstadoNormal extends Estado {

    /**
     * Constructor del estado normal.
     */
    EstadoNormal() {
        super("Normal");
    }

    /**
     * No aplica ningún efecto negativo.
     */
    @Override
    public void aplicarEfecto(Pokemon p) {
        // Sin efecto negativo
    }
}

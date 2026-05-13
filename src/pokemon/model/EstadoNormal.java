package pokemon.model;

/**
 * Estado: Pokémon completamente saludable.
 * DEFAULT: Visibilidad de paquete.
 */
class EstadoNormal extends Estado {

    EstadoNormal() {
        super("Normal");
    }

    @Override
    public void aplicarEfecto(Pokemon p) {
        // Sin efecto
    }
}

package pokemon.model;

/**
 * Estado: Pokémon paralizado (25% chance de no poder atacar).
 * DEFAULT: Visibilidad de paquete.
 */
class EstadoParalizado extends Estado {

    EstadoParalizado() {
        super("Paralizado");
    }

    @Override
    public boolean puedeAtacar() {
        return Math.random() >= 0.25;
    }

    @Override
    public void aplicarEfecto(Pokemon p) {
        if (!puedeAtacar()) {
            System.out.println("⚡ " + p.getNombre() + " está paralizado y no puede atacar!");
        }
    }
}

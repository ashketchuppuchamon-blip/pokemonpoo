package pokemon.model;

/**
 * Estado Concreto: Pokémon paralizado (movimiento lento).
 * 
 * DEFAULT: Visibilidad package-private.
 * 
 * Efecto:
 * - 25% de probabilidad de no poder atacar cada turno
 * - La velocidad se reduce implícitamente por fallos de ataque
 * 
 * @author UTP
 */
class EstadoParalizado extends Estado {

    // ========== CONSTANTES PRIVADAS ==========
    private static final double PROBABILIDAD_FALLO = 0.25;

    /**
     * Constructor del estado paralizado.
     */
    EstadoParalizado() {
        super("Paralizado");
    }

    /**
     * Sobreescribe puedeAtacar() para 25% de probabilidad de fallo.
     */
    @Override
    public boolean puedeAtacar() {
        return Math.random() >= PROBABILIDAD_FALLO;
    }

    /**
     * Aplica el efecto visual cuando no puede atacar.
     */
    @Override
    public void aplicarEfecto(Pokemon p) {
        if (!puedeAtacar()) {
            System.out.println("⚡ " + p.getNombre() + " está paralizado y no puede atacar!");
        }
    }
}

package pokemon.model;

/**
 * Estado Concreto: Pokémon en llamas.
 * 
 * DEFAULT: Visibilidad package-private.
 * 
 * Efecto:
 * - Pierde 1/8 del HP máximo cada turno
 * - Efecto acumulativo durante la batalla
 * 
 * @author UTP
 */
class EstadoQuemado extends Estado {

    // ========== CONSTANTES PRIVADAS ==========
    private static final int DIVISOR_DAÑO = 8; // 1/8 del HP máximo

    /**
     * Constructor del estado quemado.
     */
    EstadoQuemado() {
        super("Quemado");
    }

    /**
     * Aplica daño por quemadura cada turno.
     */
    @Override
    public void aplicarEfecto(Pokemon p) {
        int daño = p.getHpMax() / DIVISOR_DAÑO;
        p.recibirDanio(daño);
        System.out.println("🔥 " + p.getNombre() + " sufre daño por quemadura (-" + daño + "HP)");
    }
}

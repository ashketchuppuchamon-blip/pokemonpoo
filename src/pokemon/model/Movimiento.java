package pokemon.model;

/**
 * Representa un movimiento/ataque que puede usar un Pokémon.
 * 
 * DEFAULT: Visibilidad package-private (usada por Pokemon y CalculadoraDanio).
 * PRIVADO: Los detalles del PP se encapsulan internamente.
 * 
 * Responsabilidades:
 * - Mantener información del movimiento
 * - Gestionar los Puntos de Poder (PP)
 * - Calcular precisión del ataque
 * 
 * @author UTP
 */
class Movimiento {

    // ========== CONSTANTES PRIVADAS ==========
    private static final int PP_MIN = 0;

    // ========== ATRIBUTOS PRIVADOS ==========
    private final String nombre;
    private final int poder;
    private final Tipo tipo;
    private final int precision; // 0-100
    private final int ppMax;
    private int ppActual;

    /**
     * Constructor del Movimiento.
     * 
     * @param nombre Nombre del movimiento
     * @param poder Daño base del movimiento
     * @param tipo Tipo de Pokémon al que afecta
     * @param precision Porcentaje de precisión (0-100)
     * @param pp Puntos de Poder máximos
     */
    Movimiento(String nombre, int poder, Tipo tipo, int precision, int pp) {
        this.nombre = nombre;
        this.poder = poder;
        this.tipo = tipo;
        this.precision = Math.max(0, Math.min(100, precision)); // Validar rango
        this.ppMax = pp;
        this.ppActual = pp;
    }

    // ========== MÉTODOS DEFAULT (PACKAGE-PRIVATE) ==========

    /**
     * DEFAULT: Verifica si el movimiento acierta basado en su precisión.
     * 
     * @return true si el movimiento acierta
     */
    boolean acertar() {
        return Math.random() * 100 <= precision;
    }

    /**
     * DEFAULT: Verifica si el movimiento tiene PP disponible.
     * 
     * @return true si ppActual > 0
     */
    boolean tienePP() {
        return ppActual > PP_MIN;
    }

    /**
     * DEFAULT: Consume un PP del movimiento.
     */
    void usarPP() {
        if (ppActual > PP_MIN) {
            ppActual--;
        }
    }

    /**
     * DEFAULT: Restaura el PP al máximo.
     */
    void restaurarPP() {
        this.ppActual = ppMax;
    }

    // ========== GETTERS PÚBLICOS ==========
    public String getNombre() {
        return nombre;
    }

    public int getPoder() {
        return poder;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getPrecision() {
        return precision;
    }

    public int getPPMax() {
        return ppMax;
    }

    public int getPPActual() {
        return ppActual;
    }

    @Override
    public String toString() {
        return String.format("%s [Poder: %d, PP: %d/%d]", nombre, poder, ppActual, ppMax);
    }
}

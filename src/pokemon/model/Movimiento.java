package pokemon.model;

/**
 * Representa un movimiento/ataque en batalla.
 * DEFAULT: Visibilidad interna - solo Pokemon y CalculadoraDanio lo acceden.
 */
public class Movimiento {

    private String nombre;
    private int poder;
    private Tipo tipo;
    private int precision;
    private int ppMax;
    private int ppActual;

    public Movimiento(String nombre, int poder, Tipo tipo, int precision, int pp) {
        this.nombre = nombre;
        this.poder = poder;
        this.tipo = tipo;
        this.precision = precision;
        this.ppMax = pp;
        this.ppActual = pp;
    }

    /**
     * DEFAULT: Verificación interna.
     */
    boolean acertar() {
        return Math.random() * 100 <= precision;
    }

    boolean tienePP() {
        return ppActual > 0;
    }

    void usarPP() {
        if (ppActual > 0) {
            ppActual--;
        }
    }

    void restaurarPP() {
        this.ppActual = ppMax;
    }

    // ========== GETTERS ==========
    public String getNombre() { return nombre; }
    public int getPoder() { return poder; }
    public Tipo getTipo() { return tipo; }
    public int getPrecision() { return precision; }
    public int getPPMax() { return ppMax; }
    public int getPPActual() { return ppActual; }
}

package pokemon.model;

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

    public boolean acertar() {
        return Math.random() * 100 <= precision;
    }

    public boolean tienePP() {
        return ppActual > 0;
    }

    public void usarPP() {
        if (ppActual > 0) {
            ppActual--;
        }
    }

    public void restaurarPP() {
        this.ppActual = ppMax;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getPoder() { return poder; }
    public Tipo getTipo() { return tipo; }
    public int getPrecision() { return precision; }
    public int getPPMax() { return ppMax; }
    public int getPPActual() { return ppActual; }
}

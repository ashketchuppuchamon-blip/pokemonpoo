package pokemon.trainer;

import pokemon.model.Estrategia;

/**
 * Clase abstracta que representa un entrenador.
 * DEFAULT: Visibilidad de paquete para subclases del mismo paquete.
 */
public abstract class Entrenador {

    protected String nombre;
    protected Equipo equipo;
    protected Estrategia estrategia;
    protected int victorias;
    protected int derrotas;

    Entrenador(String nombre, Equipo equipo, Estrategia estrategia) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.estrategia = estrategia;
        this.victorias = 0;
        this.derrotas = 0;
    }

    public abstract String getDescripcion();

    public void ganarBatalla() {
        victorias++;
    }

    public void perderBatalla() {
        derrotas++;
    }

    /**
     * DEFAULT: Método interno que las subclases llaman.
     */
    void restaurarEquipo() {
        for (int i = 0; i < equipo.getTamaño(); i++) {
            equipo.get(i).restaurarHP();
            equipo.get(i).restaurarEstado();
            equipo.get(i).restaurarPP();
        }
    }

    // ========== GETTERS ==========
    public String getNombre() { return nombre; }
    public Equipo getEquipo() { return equipo; }
    public Estrategia getEstrategia() { return estrategia; }
    public int getVictorias() { return victorias; }
    public int getDerrotas() { return derrotas; }
}

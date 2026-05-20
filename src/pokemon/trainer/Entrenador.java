package pokemon.trainer;

import pokemon.model.Estrategia;

/**
 * Clase abstracta que representa a un entrenador de Pokémon.
 * 
 * Responsabilidades:
 * - Gestionar equipo de Pokémon
 * - Aplicar estrategia en batalla
 * - Rastrear récord (victorias/derrotas)
 * 
 * DEFAULT: Constructores y métodos son package-private.
 * PROTEGIDO: Atributos accesibles para subclases.
 * ABSTRACTO: Define contrato para EntrenadorJugador y EntrenadorIA.
 * 
 * @author UTP
 */
abstract class Entrenador {

    // ========== ATRIBUTOS PROTEGIDOS ==========
    protected String nombre;
    protected Equipo equipo;
    protected Estrategia estrategia;
    protected int victorias;
    protected int derrotas;

    /**
     * Constructor protegido del entrenador.
     * 
     * @param nombre Nombre del entrenador
     * @param equipo Equipo de Pokémon
     * @param estrategia Estrategia de batalla
     */
    Entrenador(String nombre, Equipo equipo, Estrategia estrategia) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.estrategia = estrategia;
        this.victorias = 0;
        this.derrotas = 0;
    }

    // ========== MÉTODOS ABSTRACTOS ==========

    /**
     * Obtiene descripción del entrenador.
     * 
     * @return Descripción única del tipo de entrenador
     */
    public abstract String getDescripcion();

    // ========== MÉTODOS CONCRETOS ==========

    /**
     * Registra una victoria.
     */
    public void ganarBatalla() {
        victorias++;
    }

    /**
     * Registra una derrota.
     */
    public void perderBatalla() {
        derrotas++;
    }

    /**
     * DEFAULT: Restaura el equipo post-batalla.
     */
    void restaurarEquipo() {
        for (int i = 0; i < equipo.getTamaño(); i++) {
            equipo.get(i).restaurarHP();
            equipo.get(i).restaurarEstado();
            equipo.get(i).restaurarPP();
        }
    }

    /**
     * Obtiene el récord del entrenador.
     * 
     * @return String con victorias y derrotas
     */
    public String obtenerRecordBatalla() {
        return String.format("📊 Récord: %d V - %d D", victorias, derrotas);
    }

    // ========== GETTERS PÚBLICOS ==========
    public String getNombre() {
        return nombre;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    @Override
    public String toString() {
        return String.format("%s (%s)", nombre, getDescripcion());
    }
}

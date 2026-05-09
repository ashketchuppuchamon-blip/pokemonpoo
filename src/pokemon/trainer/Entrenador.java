package pokemon.trainer;

import pokemon.model.Estrategia;

public abstract class Entrenador {

    protected String nombre;
    protected Equipo equipo;
    protected Estrategia estrategia;
    protected int victorias;
    protected int derrotas;

    public Entrenador(String nombre, Equipo equipo, Estrategia estrategia) {
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

    public void restaurarEquipo() {
        for (int i = 0; i < equipo.getTamaño(); i++) {
            equipo.get(i).restaurarHP();
            equipo.get(i).restaurarEstado();
            equipo.get(i).restaurarPP();
        }
    }

    // Getters
    public String getNombre() { return nombre; }
    public Equipo getEquipo() { return equipo; }
    public Estrategia getEstrategia() { return estrategia; }
    public int getVictorias() { return victorias; }
    public int getDerrotas() { return derrotas; }
}

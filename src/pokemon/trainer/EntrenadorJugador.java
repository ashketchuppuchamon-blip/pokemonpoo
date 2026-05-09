package pokemon.trainer;

import pokemon.model.Estrategia;

public class EntrenadorJugador extends Entrenador {

    private String apodo;

    public EntrenadorJugador(String nombre, String apodo, Equipo equipo, Estrategia estrategia) {
        super(nombre, equipo, estrategia);
        this.apodo = apodo;
    }

    @Override
    public String getDescripcion() {
        return String.format("👨 %s (Apodo: %s) - Victorias: %d | Derrotas: %d", nombre, apodo, victorias, derrotas);
    }
}

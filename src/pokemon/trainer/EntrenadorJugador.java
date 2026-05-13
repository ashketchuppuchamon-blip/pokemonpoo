package pokemon.trainer;

import pokemon.model.Estrategia;

/**
 * Entrenador humano (controlado por el usuario).
 * DEFAULT: Visibilidad de paquete.
 */
class EntrenadorJugador extends Entrenador {

    private String apodo;

    EntrenadorJugador(String nombre, String apodo, Equipo equipo, Estrategia estrategia) {
        super(nombre, equipo, estrategia);
        this.apodo = apodo;
    }

    @Override
    public String getDescripcion() {
        return String.format("👨 %s (Apodo: %s) - Victorias: %d | Derrotas: %d", 
                             nombre, apodo, victorias, derrotas);
    }

    public String getApodo() {
        return apodo;
    }
}

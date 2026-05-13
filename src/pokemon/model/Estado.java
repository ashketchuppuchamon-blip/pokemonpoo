package pokemon.model;

/**
 * Clase abstracta que representa el estado del Pokémon.
 * DEFAULT: Métodos internos del paquete model.
 */
public abstract class Estado {

    protected String nombre;

    Estado(String nombre) {
        this.nombre = nombre;
    }

    public abstract void aplicarEfecto(Pokemon p);

    public boolean puedeAtacar() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }
}

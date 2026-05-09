package pokemon.model;

public abstract class Estado {

    protected String nombre;

    public Estado(String nombre) {
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

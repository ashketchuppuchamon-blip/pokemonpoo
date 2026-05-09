package pokemon.model;

public class EstadoNormal extends Estado {

    public EstadoNormal() {
        super("Normal");
    }

    @Override
    public void aplicarEfecto(Pokemon p) {
        // No tiene efecto
    }
}

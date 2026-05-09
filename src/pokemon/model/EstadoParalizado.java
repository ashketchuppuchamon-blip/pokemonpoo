package pokemon.model;

public class EstadoParalizado extends Estado {

    public EstadoParalizado() {
        super("Paralizado");
    }

    @Override
    public boolean puedeAtacar() {
        return Math.random() >= 0.25;
    }

    @Override
    public void aplicarEfecto(Pokemon p) {
        if (!puedeAtacar()) {
            System.out.println("⚡ " + p.getNombre() + " está paralizado y no puede atacar!");
        }
    }
}

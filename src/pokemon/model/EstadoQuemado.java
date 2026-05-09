package pokemon.model;

public class EstadoQuemado extends Estado {

    public EstadoQuemado() {
        super("Quemado");
    }

    @Override
    public void aplicarEfecto(Pokemon p) {
        int daño = p.getHpMax() / 8; // 12.5% de HP máximo
        p.recibirDanio(daño);
        System.out.println("🔥 " + p.getNombre() + " sufre daño por quemadura (-" + daño + "HP)");
    }
}

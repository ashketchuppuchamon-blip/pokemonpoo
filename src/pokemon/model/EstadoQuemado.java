package pokemon.model;

/**
 * Estado: Pokémon en llamas (pierde 12.5% HP cada turno).
 * DEFAULT: Visibilidad de paquete.
 */
class EstadoQuemado extends Estado {

    EstadoQuemado() {
        super("Quemado");
    }

    @Override
    public void aplicarEfecto(Pokemon p) {
        int daño = p.getHpMax() / 8;
        p.recibirDanio(daño);
        System.out.println("🔥 " + p.getNombre() + " sufre daño por quemadura (-" + daño + "HP)");
    }
}

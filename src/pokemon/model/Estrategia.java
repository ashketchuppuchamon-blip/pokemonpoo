package pokemon.model;

public interface Estrategia {
    int elegirMovimiento(Pokemon pokemon);
    boolean debeSwitch(Pokemon pokemonActual, java.util.List<Pokemon> equipo);
}

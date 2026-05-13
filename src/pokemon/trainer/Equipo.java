package pokemon.trainer;

import pokemon.model.Pokemon;
import java.util.List;

/**
 * Clase que representa el equipo de 6 Pokémon de un entrenador.
 * DEFAULT: Métodos internos son package-private.
 */
public class Equipo {

    private List<Pokemon> pokemons;
    private int indexActual;

    public Equipo(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
        this.indexActual = 0;
    }

    /**
     * DEFAULT: Método interno de acceso.
     */
    Pokemon get(int i) {
        return pokemons.get(i);
    }

    public Pokemon getActual() {
        return pokemons.get(indexActual);
    }

    /**
     * DEFAULT: Cambio interno durante batalla.
     */
    void cambiarA(int index) {
        if (index >= 0 && index < pokemons.size() && pokemons.get(index).estaVivo()) {
            indexActual = index;
        }
    }

    public boolean hayPokemonsVivos() {
        for (Pokemon p : pokemons) {
            if (p.estaVivo()) {
                return true;
            }
        }
        return false;
    }

    public int getPokemonsVivos() {
        int count = 0;
        for (Pokemon p : pokemons) {
            if (p.estaVivo()) {
                count++;
            }
        }
        return count;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public int getTamaño() {
        return pokemons.size();
    }

    public void mostrarEquipo() {
        System.out.println("\n=== EQUIPO ===");
        for (int i = 0; i < pokemons.size(); i++) {
            Pokemon p = pokemons.get(i);
            String marca = (i == indexActual) ? ">>> " : "    ";
            String estado = p.estaVivo() ? "✓" : "✗";
            System.out.printf("%s[%d] %s - HP: %d/%d %s\n", marca, i + 1, p.getNombre(), 
                             p.getHp(), p.getHpMax(), estado);
        }
    }
}

package pokemon.trainer;

import pokemon.model.Pokemon;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa el equipo de Pokémon de un entrenador.
 * 
 * Responsabilidades:
 * - Gestionar la lista de Pokémon
 * - Rastrear el Pokémon actual en batalla
 * - Verificar estado del equipo
 * 
 * PUBLIC: Interfaz de acceso al equipo.
 * PRIVADO: Detalles internos encapsulados.
 * 
 * @author UTP
 */
public class Equipo {

    // ========== CONSTANTES PRIVADAS STATIC ==========
    private static final int TAMAÑO_MAXIMO = 6;
    private static final int INDICE_INICIAL = 0;

    // ========== ATRIBUTOS PRIVADOS ==========
    private final List<Pokemon> pokemon;
    private int indexActual;

    /**
     * Constructor del equipo.
     */
    public Equipo() {
        this.pokemon = new ArrayList<>(TAMAÑO_MAXIMO);
        this.indexActual = INDICE_INICIAL;
    }

    /**
     * Agrega un Pokémon al equipo.
     * 
     * @param p Pokémon a agregar
     * @return true si fue agregado, false si equipo está lleno
     */
    public boolean agregarPokemon(Pokemon p) {
        if (pokemon.size() < TAMAÑO_MAXIMO && p != null) {
            pokemon.add(p);
            return true;
        }
        return false;
    }

    /**
     * Cambia al Pokémon en el índice especificado.
     * 
     * @param index Índice del Pokémon (0-5)
     * @return true si cambio fue exitoso
     */
    public boolean cambiarA(int index) {
        if (index >= 0 && index < pokemon.size()) {
            indexActual = index;
            return true;
        }
        return false;
    }

    /**
     * Obtiene el Pokémon actualmente en batalla.
     * 
     * @return Pokémon actual
     */
    public Pokemon getActual() {
        return pokemon.get(indexActual);
    }

    /**
     * Obtiene un Pokémon por índice.
     * 
     * @param index Índice del Pokémon
     * @return Pokémon en ese índice
     */
    public Pokemon get(int index) {
        if (index >= 0 && index < pokemon.size()) {
            return pokemon.get(index);
        }
        return null;
    }

    /**
     * Obtiene el tamaño del equipo.
     * 
     * @return Número de Pokémon
     */
    public int getTamaño() {
        return pokemon.size();
    }

    /**
     * Verifica si hay Pokémon vivos en el equipo.
     * 
     * @return true si al menos uno está vivo
     */
    public boolean hayPokemonsVivos() {
        for (Pokemon p : pokemon) {
            if (p.estaVivo()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cuenta cuántos Pokémon están vivos.
     * 
     * @return Número de Pokémon vivos
     */
    public int getPokemonsVivos() {
        int vivos = 0;
        for (Pokemon p : pokemon) {
            if (p.estaVivo()) {
                vivos++;
            }
        }
        return vivos;
    }

    @Override
    public String toString() {
        return String.format("Equipo [%d Pokémon]", pokemon.size());
    }
}

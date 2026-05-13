package pokemon.data;

import pokemon.model.*;
import pokemon.trainer.*;
import java.util.*;

/**
 * STATIC FACTORY PATTERN: Métodos estáticos que crean objetos.
 * No necesita instancia porque solo fabrica objetos.
 */
public class Pokedex {

    // STATIC: Constantes que se usan en todo el proyecto
    public static final int NIVEL_DEFECTO = 50;
    public static final int MAX_POKEMONES = 6;

    // ========== TIPOS FUEGO ==========
    public static Pokemon charizard() {
        return new Pokemon("Charizard", 180, 84, 109, 78, 85, 100, NIVEL_DEFECTO, Tipo.FIRE,
                Arrays.asList(
                        new Movimiento("Lanzallamas", 90, Tipo.FIRE, 100, 15),
                        new Movimiento("Garra Dragón", 80, Tipo.DRAGON, 100, 15),
                        new Movimiento("Ataque Ala", 70, Tipo.FLYING, 100, 15),
                        new Movimiento("Ascuas", 40, Tipo.FIRE, 100, 25)
                ));
    }

    public static Pokemon arcanine() {
        return new Pokemon("Arcanine", 180, 110, 80, 90, 80, 95, NIVEL_DEFECTO, Tipo.FIRE,
                Arrays.asList(
                        new Movimiento("Lanzallamas", 90, Tipo.FIRE, 100, 15),
                        new Movimiento("Terremoto", 100, Tipo.GROUND, 100, 10),
                        new Movimiento("Ataque Rápido", 40, Tipo.NORMAL, 100, 30),
                        new Movimiento("Mordisco", 60, Tipo.DARK, 100, 25)
                ));
    }

    // ========== TIPOS AGUA ==========
    public static Pokemon blastoise() {
        return new Pokemon("Blastoise", 200, 83, 100, 100, 85, 78, NIVEL_DEFECTO, Tipo.WATER,
                Arrays.asList(
                        new Movimiento("Hidrobomba", 110, Tipo.WATER, 80, 5),
                        new Movimiento("Pistola Agua", 40, Tipo.WATER, 100, 25),
                        new Movimiento("Hielo Rayo", 90, Tipo.ICE, 100, 10),
                        new Movimiento("Defensa Férrea", 0, Tipo.STEEL, 100, 15)
                ));
    }

    public static Pokemon lapras() {
        return new Pokemon("Lapras", 200, 85, 95, 80, 125, 60, NIVEL_DEFECTO, Tipo.WATER,
                Arrays.asList(
                        new Movimiento("Hidrobomba", 110, Tipo.WATER, 80, 5),
                        new Movimiento("Hielo Rayo", 90, Tipo.ICE, 100, 10),
                        new Movimiento("Terremoto", 100, Tipo.GROUND, 100, 10),
                        new Movimiento("Rayo", 90, Tipo.ELECTRIC, 100, 15)
                ));
    }

    public static Pokemon gyarados() {
        return new Pokemon("Gyarados", 200, 125, 79, 100, 80, 81, NIVEL_DEFECTO, Tipo.WATER,
                Arrays.asList(
                        new Movimiento("Hidrobomba", 110, Tipo.WATER, 80, 5),
                        new Movimiento("Salto Potencia", 85, Tipo.FIGHTING, 100, 15),
                        new Movimiento("Terremoto", 100, Tipo.GROUND, 100, 10),
                        new Movimiento("Rayo", 90, Tipo.ELECTRIC, 100, 15)
                ));
    }

    // ========== TIPOS PLANTA ==========
    public static Pokemon venusaur() {
        return new Pokemon("Venusaur", 180, 82, 100, 83, 100, 80, NIVEL_DEFECTO, Tipo.GRASS,
                Arrays.asList(
                        new Movimiento("Bomba de Semillas", 80, Tipo.GRASS, 100, 15),
                        new Movimiento("Polvo Ácido", 75, Tipo.POISON, 100, 15),
                        new Movimiento("Vendetta", 75, Tipo.GRASS, 95, 10),
                        new Movimiento("Síntesis", 0, Tipo.GRASS, 100, 5)
                ));
    }

    // ========== TIPOS ELÉCTRICO ==========
    public static Pokemon pikachu() {
        return new Pokemon("Pikachu", 140, 55, 90, 40, 50, 90, NIVEL_DEFECTO, Tipo.ELECTRIC,
                Arrays.asList(
                        new Movimiento("Rayo", 90, Tipo.ELECTRIC, 100, 15),
                        new Movimiento("Voltios", 65, Tipo.ELECTRIC, 100, 20),
                        new Movimiento("Ataque Rápido", 40, Tipo.NORMAL, 100, 30),
                        new Movimiento("Impactrueno", 40, Tipo.ELECTRIC, 100, 30)
                ));
    }

    // ========== TIPOS PSÍQUICO ==========
    public static Pokemon alakazam() {
        return new Pokemon("Alakazam", 165, 70, 125, 65, 95, 120, NIVEL_DEFECTO, Tipo.PSYCHIC,
                Arrays.asList(
                        new Movimiento("Psicorrayo", 90, Tipo.PSYCHIC, 100, 10),
                        new Movimiento("Bola Sombra", 80, Tipo.GHOST, 100, 15),
                        new Movimiento("Rayo de Hielo", 90, Tipo.ICE, 100, 10),
                        new Movimiento("Trueno", 110, Tipo.ELECTRIC, 70, 10)
                ));
    }

    // ========== TIPOS LUCHA ==========
    public static Pokemon machamp() {
        return new Pokemon("Machamp", 180, 130, 65, 100, 85, 55, NIVEL_DEFECTO, Tipo.FIGHTING,
                Arrays.asList(
                        new Movimiento("Golpe Dinámico", 100, Tipo.FIGHTING, 100, 5),
                        new Movimiento("Terremoto", 100, Tipo.GROUND, 100, 10),
                        new Movimiento("Salto Potencia", 85, Tipo.FIGHTING, 100, 15),
                        new Movimiento("Golpe Cuerpo", 85, Tipo.FIGHTING, 100, 15)
                ));
    }

    // ========== TIPOS DRAGÓN ==========
    public static Pokemon dragonite() {
        return new Pokemon("Dragonite", 200, 134, 100, 95, 100, 80, NIVEL_DEFECTO, Tipo.DRAGON,
                Arrays.asList(
                        new Movimiento("Pulso Dragón", 85, Tipo.DRAGON, 100, 10),
                        new Movimiento("Garra Dragón", 80, Tipo.DRAGON, 100, 15),
                        new Movimiento("Terremoto", 100, Tipo.GROUND, 100, 10),
                        new Movimiento("Avalancha", 130, Tipo.ICE, 100, 5)
                ));
    }

    // ========== TIPOS NORMAL ==========
    public static Pokemon snorlax() {
        return new Pokemon("Snorlax", 250, 110, 65, 65, 110, 30, NIVEL_DEFECTO, Tipo.NORMAL,
                Arrays.asList(
                        new Movimiento("Hiperrayo", 150, Tipo.NORMAL, 90, 5),
                        new Movimiento("Terremoto", 100, Tipo.GROUND, 100, 10),
                        new Movimiento("Rayo de Hielo", 90, Tipo.ICE, 100, 10),
                        new Movimiento("Rayo", 90, Tipo.ELECTRIC, 100, 15)
                ));
    }
}

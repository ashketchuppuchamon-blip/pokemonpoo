package pokemon.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum de tipos Pokémon con sistema de efectividad de tipo.
 * STATIC: Los valores del enum son estáticos, se cargan UNA VEZ.
 * DEFAULT: Visibilidad package-private para métodos internos.
 */
public enum Tipo {
    NORMAL, FIRE, WATER, ELECTRIC, GRASS, ICE, FIGHTING, POISON,
    GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, STEEL, FAIRY;

    // Atributos (se crean UNA VEZ por tipo)
    private List<Tipo> immunes = new ArrayList<>();
    private List<Tipo> weaknesses = new ArrayList<>();
    private List<Tipo> strengths = new ArrayList<>();

    /**
     * DEFAULT: Solo clases del paquete model pueden configurar.
     */
    void configurarRelaciones(List<Tipo> imm, List<Tipo> weak, List<Tipo> str) {
        this.immunes = imm;
        this.weaknesses = weak;
        this.strengths = str;
    }

    /**
     * Calcula la efectividad del ataque.
     * PUBLIC: Es la interfaz pública del sistema de tipos.
     */
    public double efectividadContra(Tipo defensor) {
        if (defensor.immunes.contains(this)) return 0.0;
        if (this.strengths.contains(defensor)) return 2.0;
        if (defensor.weaknesses.contains(this)) return 2.0;
        return 1.0;
    }
}

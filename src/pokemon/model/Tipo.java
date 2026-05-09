package pokemon.model;

import java.util.ArrayList;
import java.util.List;

public enum Tipo {
    NORMAL, FIRE, WATER, ELECTRIC, GRASS, ICE, FIGHTING, POISON,
    GROUND, FLYING, PSYCHIC, BUG, ROCK, GHOST, DRAGON, DARK, STEEL, FAIRY;

    private List<Tipo> immunes = new ArrayList<>();
    private List<Tipo> weaknesses = new ArrayList<>();
    private List<Tipo> strengths = new ArrayList<>();

    public void configurarRelaciones(List<Tipo> imm, List<Tipo> weak, List<Tipo> str) {
        this.immunes = imm;
        this.weaknesses = weak;
        this.strengths = str;
    }

    public double efectividadContra(Tipo defensor) {
        // Si el defensor es inmune a MÍ (el atacante)
        if (defensor.immunes.contains(this)) return 0.0;

        // Si yo (el atacante) soy fuerte contra el defensor
        if (this.strengths.contains(defensor)) return 2.0;

        // Si el defensor es resistente a MÍ
        if (defensor.weaknesses.contains(this)) return 2.0;

        return 1.0;
    }
}

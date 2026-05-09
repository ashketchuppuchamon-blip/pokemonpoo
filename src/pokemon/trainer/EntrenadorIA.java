package pokemon.trainer;

import pokemon.model.Estrategia;

public class EntrenadorIA extends Entrenador {

    private int dificultad; // 1=fácil, 2=normal, 3=difícil
    private String titulo;

    public EntrenadorIA(String nombre, Equipo equipo, Estrategia estrategia, int dificultad, String titulo) {
        super(nombre, equipo, estrategia);
        this.dificultad = dificultad;
        this.titulo = titulo;
    }

    @Override
    public String getDescripcion() {
        String nivel = "";
        switch (dificultad) {
            case 1: nivel = "⭐ Fácil"; break;
            case 2: nivel = "⭐⭐ Medio"; break;
            case 3: nivel = "⭐⭐⭐ Difícil"; break;
        }
        return String.format("🤖 %s (%s) - %s", nombre, titulo, nivel);
    }

    public int getDificultad() {
        return dificultad;
    }
}

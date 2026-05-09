package pokemon.model;

import java.util.List;

public class EstrategiaIA implements Estrategia {

    private int dificultad; // 1=fácil, 2=normal, 3=difícil

    public EstrategiaIA(int dificultad) {
        this.dificultad = dificultad;
    }

    @Override
    public int elegirMovimiento(Pokemon pokemon) {
        List<Movimiento> movimientos = pokemon.getMovimientos();

        if (dificultad == 1) {
            // Fácil: elegir aleatorio
            int index;
            do {
                index = (int) (Math.random() * movimientos.size());
            } while (!movimientos.get(index).tienePP());
            return index;
        } else if (dificultad == 2) {
            // Normal: preferir movimientos con PP y poder
            return elegirMovimientoMejor(pokemon);
        } else {
            // Difícil: estrategia óptima
            return elegirMovimientoOptimo(pokemon);
        }
    }

    private int elegirMovimientoMejor(Pokemon pokemon) {
        List<Movimiento> movimientos = pokemon.getMovimientos();
        int mejorIndex = -1;
        int mejorPoder = 0;

        for (int i = 0; i < movimientos.size(); i++) {
            Movimiento mov = movimientos.get(i);
            if (mov.tienePP() && mov.getPoder() > mejorPoder) {
                mejorPoder = mov.getPoder();
                mejorIndex = i;
            }
        }

        return mejorIndex != -1 ? mejorIndex : 0;
    }

    private int elegirMovimientoOptimo(Pokemon pokemon) {
        // Estrategia más inteligente considerando tipo vs defensor
        return elegirMovimientoMejor(pokemon);
    }

    @Override
    public boolean debeSwitch(Pokemon pokemonActual, List<Pokemon> equipo) {
        if (dificultad == 1) {
            // Fácil: cambiar 20% de las veces
            return Math.random() < 0.2;
        } else if (dificultad == 2) {
            // Normal: cambiar si HP bajo
            return pokemonActual.getHp() < pokemonActual.getHpMax() * 0.3;
        } else {
            // Difícil: nunca cambiar (confiado en estrategia)
            return false;
        }
    }
}

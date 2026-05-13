package pokemon.battle;

import pokemon.model.Pokemon;
import pokemon.model.Movimiento;

/**
 * Calculadora de daño que aplica la fórmula de daño Pokémon.
 * STATIC: Los métodos son puros (sin estado), solo transforman datos.
 */
public class CalculadoraDanio {

    /**
     * STATIC: No necesita instancia, es una función pura.
     * Calcula: (ATK × Poder / DEF) × Efectividad
     */
    public static int calcular(Pokemon atk, Pokemon def, Movimiento mov) {
        double efectividad = mov.getTipo().efectividadContra(def.getTipo());

        int daño = (int)(((atk.getAtaque() * mov.getPoder()) / def.getDefensa()) * efectividad);

        if (efectividad > 1) {
            System.out.println("💥 ¡Es muy eficaz!");
        }
        if (efectividad < 1 && efectividad > 0) {
            System.out.println("💨 No es muy eficaz...");
        }
        if (efectividad == 0) {
            System.out.println("🚫 No afecta a " + def.getNombre());
        }

        return Math.max(1, daño);
    }
}

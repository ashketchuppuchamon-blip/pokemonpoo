package pokemon.battle;

import pokemon.model.Pokemon;
import pokemon.model.Movimiento;
import pokemon.model.Tipo;

/**
 * Clase utilitaria para calcular daño en batalla.
 * 
 * STATIC: Solo contiene métodos estáticos, no se instancia.
 * Responsabilidad: Encapsular la lógica de cálculo de daño.
 * 
 * Fórmula simplificada:
 * Daño = ((Poder * Ataque / Defensa) * Nivel / 50 + 2) * STAB * Efectividad
 * 
 * Donde:
 * - STAB = 1.5 si tipos coinciden, 1.0 si no
 * - Efectividad = varía según tabla de tipos
 * 
 * @author UTP
 */
public class CalculadoraDanio {

    // ========== CONSTANTES PRIVADAS STATIC ==========
    private static final double BONUS_STAB = 1.5;
    private static final double BONUS_EFECTIVO = 2.0;
    private static final double BONUS_NO_EFECTIVO = 0.5;
    private static final double FACTOR_CRITICO = 1.5;
    private static final double PROBABILIDAD_CRITICO = 0.1;
    private static final int FACTOR_NIVEL = 50;
    private static final int BONUS_MINIMO = 2;

    /**
     * Constructor privado (clase utilitaria no se instancia).
     */
    private CalculadoraDanio() {
        // Clase utilitaria
    }

    /**
     * STATIC: Calcula el daño de un ataque.
     * 
     * @param atacante Pokémon que ataca
     * @param defensor Pokémon que defiende
     * @param movimiento Movimiento usado
     * @return Daño calculado
     */
    public static int calcular(Pokemon atacante, Pokemon defensor, Movimiento movimiento) {
        if (movimiento.getPoder() == 0) {
            return 0; // Movimientos sin daño (curacion, buffs)
        }

        // Base del cálculo
        double daño = atacante.getNivel() * 0.4 + 2;
        daño = daño * movimiento.getPoder() * atacante.getAtaque() / defensor.getDefensa();
        daño = daño / 50 + BONUS_MINIMO;

        // STAB (Same Type Attack Bonus)
        if (atacante.getTipo() == movimiento.getTipo()) {
            daño *= BONUS_STAB;
        }

        // Efectividad de tipos
        daño *= obtenerEfectividad(movimiento.getTipo(), defensor.getTipo());

        // Golpe crítico (10% de probabilidad)
        if (Math.random() < PROBABILIDAD_CRITICO) {
            daño *= FACTOR_CRITICO;
            System.out.println("🎯 ¡Golpe crítico!");
        }

        // Variación aleatoria (±10%)
        double variacion = 0.9 + Math.random() * 0.2;
        daño *= variacion;

        // Mínimo 1 de daño
        return Math.max(1, (int) daño);
    }

    /**
     * DEFAULT: Obtiene la efectividad de un tipo contra otro.
     * 
     * @param tipoAtaque Tipo del movimiento
     * @param tipoDefensa Tipo del defensor
     * @return Multiplicador de efectividad
     */
    private static double obtenerEfectividad(Tipo tipoAtaque, Tipo tipoDefensa) {
        // Tabla simplificada de efectividad
        if (tipoAtaque == Tipo.FIRE && tipoDefensa == Tipo.GRASS) return BONUS_EFECTIVO;
        if (tipoAtaque == Tipo.FIRE && tipoDefensa == Tipo.ICE) return BONUS_EFECTIVO;
        if (tipoAtaque == Tipo.WATER && tipoDefensa == Tipo.FIRE) return BONUS_EFECTIVO;
        if (tipoAtaque == Tipo.WATER && tipoDefensa == Tipo.GRASS) return BONUS_NO_EFECTIVO;
        if (tipoAtaque == Tipo.ELECTRIC && tipoDefensa == Tipo.WATER) return BONUS_EFECTIVO;
        if (tipoAtaque == Tipo.GRASS && tipoDefensa == Tipo.WATER) return BONUS_EFECTIVO;

        // Inmunidades
        if (tipoAtaque == Tipo.GROUND && tipoDefensa == Tipo.FLYING) return BONUS_NO_EFECTIVO;

        return 1.0; // Efectividad normal
    }
}

package pokemon.battle;

/**
 * Representa un turno de batalla.
 * DEFAULT: Visibilidad interna del paquete battle.
 */
class Turno {
    private int numero = 1;

    void siguiente() {
        numero++;
    }

    int getNumero() {
        return numero;
    }
}

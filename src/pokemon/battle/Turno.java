package pokemon.battle;

/**
 * Representa un turno en la batalla.
 * 
 * DEFAULT: Visibilidad package-private.
 * Responsabilidad: Rastrear el número de turno actual.
 * 
 * @author UTP
 */
class Turno {

    // ========== CONSTANTES PRIVADAS STATIC ==========
    private static final int TURNO_INICIAL = 1;

    // ========== ATRIBUTOS PRIVADOS ==========
    private int numero;

    /**
     * Constructor del turno.
     */
    Turno() {
        this.numero = TURNO_INICIAL;
    }

    /**
     * Avanza al siguiente turno.
     */
    void siguiente() {
        numero++;
    }

    /**
     * Obtiene el número de turno actual.
     * 
     * @return Número del turno
     */
    int getNumero() {
        return numero;
    }
}

package pokemon.model;

/**
 * Clase abstracta que representa los estados de condición de un Pokémon.
 * 
 * Utiliza el patrón Strategy para aplicar efectos diferentes según el estado.
 * 
 * DEFAULT: Visibilidad package-private (solo para clases del paquete model).
 * 
 * Estados concretos:
 * - EstadoNormal: Sin efectos
 * - EstadoParalizado: Reduce probabilidad de atacar
 * - EstadoQuemado: Causa daño por turno
 * 
 * @author UTP
 */
abstract class Estado {

    // ========== ATRIBUTOS PROTEGIDOS ==========
    protected final String nombre;

    /**
     * Constructor protegido del estado.
     * 
     * @param nombre Nombre del estado
     */
    Estado(String nombre) {
        this.nombre = nombre;
    }

    // ========== MÉTODOS ABSTRACTOS ==========

    /**
     * Aplica el efecto del estado al Pokémon.
     * 
     * @param p El Pokémon afectado por el estado
     */
    public abstract void aplicarEfecto(Pokemon p);

    // ========== MÉTODOS CONCRETOS ==========

    /**
     * Verifica si el Pokémon puede atacar en este estado.
     * 
     * @return true si puede atacar (por defecto sí)
     */
    public boolean puedeAtacar() {
        return true;
    }

    /**
     * Obtiene el nombre del estado.
     * 
     * @return Nombre del estado
     */
    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

package pokemon.model;

import java.util.List;
import pokemon.battle.CalculadoraDanio;

/**
 * Clase que representa un Pokémon individual.
 * 
 * Responsabilidades:
 * - Almacenar estadísticas del Pokémon
 * - Gestionar su estado (paralizado, quemado, etc.)
 * - Realizar ataques
 * - Gestionar HP y PP
 * 
 * DEFAULT: Métodos de batalla son package-private (usados solo por Batalla).
 * PRIVADO: Todas las estadísticas están encapsuladas.
 * STATIC: Métodos de utilidad como obtenerEmojiTipo().
 * 
 * @author UTP
 */
public class Pokemon {

    // ========== CONSTANTES PRIVADAS STATIC ==========
    private static final int HP_MINIMO = 0;
    private static final String MENSAJE_PARALIZADO = "⚡ %s está paralizado y no puede atacar!";
    private static final String MENSAJE_SIN_PP = "❌ %s no tiene PP para %s!";
    private static final String MENSAJE_FALLO_ATAQUE = "💨 %s falló el ataque!";
    private static final String MENSAJE_ATAQUE = "⚔️ %s usó %s";

    // ========== ATRIBUTOS PRIVADOS ==========
    private final String nombre;
    private final int hpMax;
    private int hpActual;
    private final int ataque;
    private final int ataqueEsp;
    private final int defensa;
    private final int defensaEsp;
    private final int velocidad;
    private final int nivel;
    private final Tipo tipo;
    private final List<Movimiento> movimientos;
    private Estado estado;

    /**
     * Constructor del Pokémon.
     * 
     * @param nombre Nombre del Pokémon
     * @param hp Salud máxima
     * @param atk Ataque físico
     * @param atkEsp Ataque especial
     * @param def Defensa física
     * @param defEsp Defensa especial
     * @param vel Velocidad
     * @param nivel Nivel del Pokémon
     * @param tipo Tipo elemental
     * @param movs Movimientos disponibles
     */
    public Pokemon(String nombre, int hp, int atk, int atkEsp, int def, int defEsp,
                   int vel, int nivel, Tipo tipo, List<Movimiento> movs) {
        this.nombre = nombre;
        this.hpMax = Math.max(1, hp); // Validar que sea positivo
        this.hpActual = hpMax;
        this.ataque = Math.max(0, atk);
        this.ataqueEsp = Math.max(0, atkEsp);
        this.defensa = Math.max(0, def);
        this.defensaEsp = Math.max(0, defEsp);
        this.velocidad = Math.max(0, vel);
        this.nivel = Math.max(1, nivel);
        this.tipo = tipo != null ? tipo : Tipo.NORMAL;
        this.movimientos = movs;
        this.estado = new EstadoNormal();
    }

    // ========== MÉTODOS DEFAULT (PACKAGE-PRIVATE) ==========

    /**
     * DEFAULT: Ejecuta un ataque del Pokémon.
     * Solo es llamado por la clase Batalla.
     * 
     * @param objetivo Pokémon objetivo del ataque
     * @param index Índice del movimiento a usar
     */
    void atacar(Pokemon objetivo, int index) {
        if (!estado.puedeAtacar()) {
            System.out.println(String.format(MENSAJE_PARALIZADO, nombre));
            return;
        }

        Movimiento mov = movimientos.get(index);

        if (!mov.tienePP()) {
            System.out.println(String.format(MENSAJE_SIN_PP, nombre, mov.getNombre()));
            return;
        }

        if (!mov.acertar()) {
            System.out.println(String.format(MENSAJE_FALLO_ATAQUE, nombre));
            mov.usarPP();
            return;
        }

        int daño = CalculadoraDanio.calcular(this, objetivo, mov);
        objetivo.recibirDanio(daño);
        mov.usarPP();

        System.out.println(String.format(MENSAJE_ATAQUE, nombre, mov.getNombre()));
    }

    /**
     * DEFAULT: Aplica el efecto del estado cada turno.
     * Solo es llamado por Batalla.
     */
    void aplicarEstado() {
        estado.aplicarEfecto(this);
    }

    /**
     * DEFAULT: Recibe daño del Pokémon.
     * Solo es llamado por atacar() e estados.
     * 
     * @param daño Cantidad de daño a recibir
     */
    void recibirDanio(int daño) {
        hpActual = Math.max(HP_MINIMO, hpActual - daño);
    }

    // ========== MÉTODOS PÚBLICOS UTILITARIOS ==========

    /**
     * STATIC: Obtiene el emoji del tipo.
     * No depende de instancia, es utilidad pura.
     * 
     * @param tipo Tipo del Pokémon
     * @return Emoji representativo
     */
    public static String obtenerEmojiTipo(Tipo tipo) {
        return tipo != null ? tipo.getEmoji() : "⚪";
    }

    /**
     * Verifica si el Pokémon está vivo.
     * 
     * @return true si HP > 0
     */
    public boolean estaVivo() {
        return hpActual > HP_MINIMO;
    }

    /**
     * Restaura el HP al máximo (post-batalla).
     */
    public void restaurarHP() {
        this.hpActual = hpMax;
    }

    /**
     * Restaura el estado al normal (post-batalla).
     */
    public void restaurarEstado() {
        this.estado = new EstadoNormal();
    }

    /**
     * Restaura todos los PP de los movimientos (post-batalla).
     */
    public void restaurarPP() {
        for (Movimiento mov : movimientos) {
            mov.restaurarPP();
        }
    }

    /**
     * Muestra los movimientos disponibles en consola.
     */
    public void mostrarMovimientos() {
        for (int i = 0; i < movimientos.size(); i++) {
            Movimiento mov = movimientos.get(i);
            String tipo = mov.getTipo().getEmoji() + " " + mov.getTipo().getNombre();
            System.out.println(String.format("%d. %-15s [%s] Poder: %d | PP: %d/%d",
                    i + 1, mov.getNombre(), tipo, mov.getPoder(),
                    mov.getPPActual(), mov.getPPMax()));
        }
    }

    /**
     * Retorna estado detallado del Pokémon para mostrar.
     * 
     * @return String con información completa
     */
    public String mostrarEstadoDetallado() {
        return String.format("%s %s Nv.%d | HP: %d/%d | ATK: %d | DEF: %d | VEL: %d | Estado: %s",
                obtenerEmojiTipo(tipo), nombre, nivel, hpActual, hpMax, ataque, defensa, velocidad, estado);
    }

    // ========== GETTERS PÚBLICOS ==========
    public String getNombre() {
        return nombre;
    }

    public int getHp() {
        return hpActual;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEsp() {
        return ataqueEsp;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDefensaEsp() {
        return defensaEsp;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getNivel() {
        return nivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return mostrarEstadoDetallado();
    }
}

package pokemon.battle;

import pokemon.model.Pokemon;
import pokemon.model.Estrategia;
import pokemon.trainer.Entrenador;
import java.util.Scanner;

/**
 * Clase que gestiona una batalla entre dos entrenadores.
 * 
 * Responsabilidades:
 * - Controlar el flujo de la batalla
 * - Ejecutar turnos alternados
 * - Mostrar estado de batalla
 * - Determinar ganador
 * 
 * DEFAULT: Métodos privados encapsulan lógica de batalla.
 * STATIC: Constantes de reglas (MAX_TURNOS, etc.)
 * 
 * @author UTP
 */
public class Batalla {

    // ========== CONSTANTES PRIVADAS STATIC ==========
    private static final int MAX_TURNOS = 100;
    private static final int BARRA_HP_LONGITUD = 20;
    private static final String SEPARADOR_BATALLA = "=".repeat(60);
    private static final String SEPARADOR_TURNO = "─".repeat(60);
    private static final String EMOJI_BATALLA = "⚔️";
    private static final String EMOJI_FIN = "🏆";
    private static final String EMOJI_VICTORIA = "🎉";
    private static final String EMOJI_EMPATE = "🤝";
    private static final String EMOJI_DERROTA = "💥";

    // ========== ATRIBUTOS PRIVADOS ==========
    private final Entrenador entrenador1;
    private final Entrenador entrenador2;
    private final Turno turno;
    private final Scanner sc;

    /**
     * Constructor de la batalla.
     * 
     * @param ent1 Primer entrenador
     * @param ent2 Segundo entrenador
     */
    Batalla(Entrenador ent1, Entrenador ent2) {
        this.entrenador1 = ent1;
        this.entrenador2 = ent2;
        this.turno = new Turno();
        this.sc = new Scanner(System.in);
    }

    /**
     * Inicia la batalla entre los dos entrenadores.
     */
    public void iniciar() {
        mostrarInicio();

        while (entrenador1.getEquipo().hayPokemonsVivos() &&
               entrenador2.getEquipo().hayPokemonsVivos() &&
               turno.getNumero() <= MAX_TURNOS) {

            System.out.println("\n" + SEPARADOR_TURNO);
            System.out.println("TURNO " + turno.getNumero());
            System.out.println(SEPARADOR_TURNO);

            ejecutarTurno();

            // Aplicar efectos de estado
            entrenador1.getEquipo().getActual().aplicarEstado();
            entrenador2.getEquipo().getActual().aplicarEstado();

            mostrarEstado();

            // Cambiar automático si hay Pokémon derrotados
            if (!entrenador1.getEquipo().getActual().estaVivo()) {
                cambiarPokemonAutomatico(entrenador1);
            }
            if (!entrenador2.getEquipo().getActual().estaVivo()) {
                cambiarPokemonAutomatico(entrenador2);
            }

            turno.siguiente();
        }

        decidirGanador();
    }

    /**
     * DEFAULT: Muestra el mensaje de inicio.
     */
    private void mostrarInicio() {
        System.out.println("\n" + SEPARADOR_BATALLA);
        System.out.println(EMOJI_BATALLA + "  COMIENZA LA BATALLA");
        System.out.println(entrenador1.toString() + " VS " + entrenador2.toString());
        System.out.println(SEPARADOR_BATALLA + "\n");
    }

    /**
     * DEFAULT: Ejecuta un turno de batalla (ambos Pokémon atacan).
     */
    private void ejecutarTurno() {
        Pokemon p1 = entrenador1.getEquipo().getActual();
        Pokemon p2 = entrenador2.getEquipo().getActual();

        // Orden por velocidad
        if (p1.getVelocidad() >= p2.getVelocidad()) {
            atacar(entrenador1, entrenador2);
            if (entrenador2.getEquipo().getActual().estaVivo()) {
                atacar(entrenador2, entrenador1);
            }
        } else {
            atacar(entrenador2, entrenador1);
            if (entrenador1.getEquipo().getActual().estaVivo()) {
                atacar(entrenador1, entrenador2);
            }
        }
    }

    /**
     * DEFAULT: Un entrenador ataca al otro.
     */
    private void atacar(Entrenador atacante, Entrenador defensor) {
        Pokemon pAtaque = atacante.getEquipo().getActual();
        Pokemon pDefensa = defensor.getEquipo().getActual();
        Estrategia estrategia = atacante.getEstrategia();

        int movIndex = estrategia.elegirMovimiento(pAtaque);
        pAtaque.atacar(pDefensa, movIndex);
    }

    /**
     * DEFAULT: Cambia automáticamente a otro Pokémon si está disponible.
     */
    private void cambiarPokemonAutomatico(Entrenador entrenador) {
        System.out.println("\n" + EMOJI_DERROTA + " " + 
                           entrenador.getEquipo().getActual().getNombre() + " fue derrotado!");

        for (int i = 0; i < entrenador.getEquipo().getTamaño(); i++) {
            if (entrenador.getEquipo().get(i).estaVivo()) {
                entrenador.getEquipo().cambiarA(i);
                System.out.println("🔄 " + entrenador.getNombre() + " envió a " +
                                 entrenador.getEquipo().getActual().getNombre());
                return;
            }
        }
    }

    /**
     * DEFAULT: Muestra el estado actual de la batalla.
     */
    private void mostrarEstado() {
        Pokemon p1 = entrenador1.getEquipo().getActual();
        Pokemon p2 = entrenador2.getEquipo().getActual();
        
        System.out.println("\n" + mostrarBarraHP(p1) + " vs " + mostrarBarraHP(p2));
        System.out.println("Pokémon vivos - " + entrenador1.getNombre() + ": " +
                          entrenador1.getEquipo().getPokemonsVivos() +
                          " | " + entrenador2.getNombre() + ": " +
                          entrenador2.getEquipo().getPokemonsVivos());
    }

    /**
     * DEFAULT: Crea una barra visual del HP.
     */
    private String mostrarBarraHP(Pokemon p) {
        int barras = (p.getHp() * BARRA_HP_LONGITUD) / p.getHpMax();
        StringBuilder sb = new StringBuilder();
        sb.append(p.getNombre()).append(" ");
        
        for (int i = 0; i < BARRA_HP_LONGITUD; i++) {
            sb.append(i < barras ? "█" : "░");
        }
        
        sb.append(" ").append(p.getHp()).append("/").append(p.getHpMax());
        return sb.toString();
    }

    /**
     * DEFAULT: Determina y anuncia al ganador.
     */
    private void decidirGanador() {
        System.out.println("\n" + SEPARADOR_BATALLA);
        System.out.println(EMOJI_FIN + " FIN DE LA BATALLA");
        System.out.println(SEPARADOR_BATALLA);

        boolean p1Vivo = entrenador1.getEquipo().hayPokemonsVivos();
        boolean p2Vivo = entrenador2.getEquipo().hayPokemonsVivos();

        if (p1Vivo && !p2Vivo) {
            System.out.println(EMOJI_VICTORIA + " ¡" + entrenador1.getNombre() + " ganó la batalla!");
            entrenador1.ganarBatalla();
            entrenador2.perderBatalla();
        } else if (p2Vivo && !p1Vivo) {
            System.out.println(EMOJI_VICTORIA + " ¡" + entrenador2.getNombre() + " ganó la batalla!");
            entrenador2.ganarBatalla();
            entrenador1.perderBatalla();
        } else {
            System.out.println(EMOJI_EMPATE + " ¡Empate! Ambos entrenadores dieron su máximo esfuerzo.");
        }
        
        System.out.println("\n" + entrenador1.obtenerRecordBatalla());
        System.out.println(entrenador2.obtenerRecordBatalla() + "\n");
    }
}

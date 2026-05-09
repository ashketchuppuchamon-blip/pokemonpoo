package pokemon.battle;

import pokemon.model.Pokemon;
import pokemon.model.Estrategia;
import pokemon.trainer.Entrenador;
import java.util.Scanner;

public class Batalla {

    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Turno turno;
    private Scanner sc;
    private static final int MAX_TURNOS = 100;

    public Batalla(Entrenador ent1, Entrenador ent2) {
        this.entrenador1 = ent1;
        this.entrenador2 = ent2;
        this.turno = new Turno();
        this.sc = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("⚔️  COMIENZA LA BATALLA");
        System.out.println(entrenador1.getNombre() + " VS " + entrenador2.getNombre());
        System.out.println("=".repeat(60) + "\n");

        while (entrenador1.getEquipo().hayPokemonsVivos() &&
               entrenador2.getEquipo().hayPokemonsVivos() &&
               turno.getNumero() <= MAX_TURNOS) {

            System.out.println("\n" + "─".repeat(60));
            System.out.println("TURNO " + turno.getNumero());
            System.out.println("─".repeat(60));

            ejecutarTurno();

            // Aplicar efectos de estado
            entrenador1.getEquipo().getActual().aplicarEstado();
            entrenador2.getEquipo().getActual().aplicarEstado();

            mostrarEstado();

            // Verificar si alguien fue derrotado
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

    private void ejecutarTurno() {
        Pokemon p1 = entrenador1.getEquipo().getActual();
        Pokemon p2 = entrenador2.getEquipo().getActual();

        // Determinar quien ataca primero por velocidad
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

    private void atacar(Entrenador atacante, Entrenador defensor) {
        Pokemon pAtaque = atacante.getEquipo().getActual();
        Pokemon pDefensa = defensor.getEquipo().getActual();
        Estrategia estrategia = atacante.getEstrategia();

        int movIndex = estrategia.elegirMovimiento(pAtaque);
        pAtaque.atacar(pDefensa, movIndex);
    }

    private void cambiarPokemonAutomatico(Entrenador entrenador) {
        System.out.println("\n💥 " + entrenador.getEquipo().getActual().getNombre() + " fue derrotado!");

        for (int i = 0; i < entrenador.getEquipo().getTamaño(); i++) {
            if (entrenador.getEquipo().get(i).estaVivo()) {
                entrenador.getEquipo().cambiarA(i);
                System.out.println("🔄 " + entrenador.getNombre() + " envió a " + entrenador.getEquipo().getActual().getNombre());
                return;
            }
        }
    }

    private void mostrarEstado() {
        System.out.println("\n" + mostrarBarraHP(entrenador1.getEquipo().getActual()) +
                           " vs " +
                           mostrarBarraHP(entrenador2.getEquipo().getActual()));
        System.out.println("Pokémon vivos - " + entrenador1.getNombre() + ": " + entrenador1.getEquipo().getPokemonsVivos() +
                          " | " + entrenador2.getNombre() + ": " + entrenador2.getEquipo().getPokemonsVivos());
    }

    private String mostrarBarraHP(Pokemon p) {
        int barras = (p.getHp() * 20) / p.getHpMax();
        StringBuilder sb = new StringBuilder();
        sb.append(p.getNombre()).append(" ");
        for (int i = 0; i < 20; i++) {
            sb.append(i < barras ? "█" : "░");
        }
        sb.append(" ").append(p.getHp()).append("/").append(p.getHpMax());
        return sb.toString();
    }

    private void decidirGanador() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🏆 FIN DE LA BATALLA");
        System.out.println("=".repeat(60));

        if (entrenador1.getEquipo().hayPokemonsVivos() && !entrenador2.getEquipo().hayPokemonsVivos()) {
            System.out.println("\n🎉 ¡" + entrenador1.getNombre() + " ha ganado la batalla!");
            entrenador1.ganarBatalla();
            entrenador2.perderBatalla();
        } else if (entrenador2.getEquipo().hayPokemonsVivos() && !entrenador1.getEquipo().hayPokemonsVivos()) {
            System.out.println("\n🎉 ¡" + entrenador2.getNombre() + " ha ganado la batalla!");
            entrenador2.ganarBatalla();
            entrenador1.perderBatalla();
        } else {
            System.out.println("\n🤝 ¡Empate! Ambos entrenadores dieron su máximo esfuerzo.");
        }
        System.out.println();
    }
}

package pokemon.model;

import java.util.List;
import java.util.Scanner;

/**
 * Estrategia del jugador humano (toma decisiones manuales).
 * DEFAULT: Visibilidad package-private.
 */
class EstrategiaJugador implements Estrategia {

    private Scanner scanner;

    EstrategiaJugador() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int elegirMovimiento(Pokemon pokemon) {
        System.out.println("\n" + pokemon.getNombre() + ", elige tu movimiento:");
        pokemon.mostrarMovimientos();

        int opcion;
        do {
            System.out.print("Opción: ");
            try {
                opcion = scanner.nextInt() - 1;
            } catch (Exception e) {
                scanner.nextLine();
                opcion = -1;
            }
        } while (opcion < 0 || opcion >= pokemon.getMovimientos().size());

        return opcion;
    }

    @Override
    public boolean debeSwitch(Pokemon pokemonActual, List<Pokemon> equipo) {
        System.out.println("\n¿Deseas cambiar de Pokémon? (s/n): ");
        String respuesta = scanner.next();
        return respuesta.equalsIgnoreCase("s");
    }
}

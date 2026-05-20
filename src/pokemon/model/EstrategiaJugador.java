package pokemon.model;

import java.util.List;
import java.util.Scanner;

/**
 * Estrategia de Jugador Humano.
 * 
 * DEFAULT: Visibilidad package-private.
 * 
 * Responsabilidades:
 * - Solicitar entrada al usuario
 * - Validar opciones
 * - Implementar la interfaz Estrategia
 * 
 * @author UTP
 */
class EstrategiaJugador implements Estrategia {

    // ========== ATRIBUTOS PRIVADOS ==========
    private final Scanner scanner;

    /**
     * Constructor de la estrategia del jugador.
     */
    EstrategiaJugador() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * El jugador elige manualmente su movimiento.
     */
    @Override
    public int elegirMovimiento(Pokemon pokemon) {
        System.out.println("\n🎮 " + pokemon.getNombre() + ", elige tu movimiento:");
        pokemon.mostrarMovimientos();

        int opcion;
        do {
            System.out.print("Opción (1-" + pokemon.getMovimientos().size() + "): ");
            try {
                opcion = scanner.nextInt() - 1;
                if (opcion < 0 || opcion >= pokemon.getMovimientos().size()) {
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
                    continue;
                }
                if (!pokemon.getMovimientos().get(opcion).tienePP()) {
                    System.out.println("❌ Ese movimiento no tiene PP. Elige otro.");
                    opcion = -1;
                }
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("❌ Entrada inválida. Intenta de nuevo.");
                opcion = -1;
            }
        } while (opcion < 0);

        return opcion;
    }

    /**
     * El jugador decide manualmente si cambiar de Pokémon.
     */
    @Override
    public boolean debeSwitch(Pokemon pokemonActual, List<Pokemon> equipo) {
        System.out.println("\n" + pokemonActual.getNombre() + " - HP: " + 
                          pokemonActual.getHp() + "/" + pokemonActual.getHpMax());
        System.out.print("¿Deseas cambiar de Pokémon? (s/n): ");
        
        String respuesta = scanner.next();
        return respuesta.equalsIgnoreCase("s");
    }
}

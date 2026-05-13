package pokemon.ui;

import pokemon.model.*;
import pokemon.trainer.*;
import pokemon.battle.Batalla;
import pokemon.data.EntrenadorFactory;
import pokemon.data.Pokedex;
import java.util.*;

/**
 * Menú principal de la aplicación.
 * STATIC: El método iniciar() es static porque gestiona el flujo global.
 * DEFAULT: Otros métodos son privados porque son internos de la clase.
 */
public class MenuPrincipal {

    private static Scanner scanner;
    private static EntrenadorJugador jugador;
    private static List<EntrenadorIA> oponentes;

    /**
     * STATIC: Constructor privado para prevenir instancias.
     */
    private MenuPrincipal() {
    }

    /**
     * STATIC: Método de inicialización.
     */
    public static void iniciar() {
        scanner = new Scanner(System.in);
        oponentes = EntrenadorFactory.obtenerTodosOponentes();
        inicializarJugador();
        mostrarMenuPrincipal();
    }

    /**
     * DEFAULT: Método privado de inicialización de jugador.
     */
    private static void inicializarJugador() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎮 BIENVENIDO A POKÉMON SHOWDOWN - POO");
        System.out.println("=".repeat(60));
        System.out.print("\n¿Cuál es tu nombre entrenador? ");
        String nombre = scanner.nextLine();
        System.out.print("¿Cuál es tu apodo? ");
        String apodo = scanner.nextLine();

        Equipo equipoJugador = crearEquipo();
        jugador = new EntrenadorJugador(nombre, apodo, equipoJugador, new EstrategiaJugador());
    }

    /**
     * DEFAULT: Crea equipo del jugador.
     */
    private static Equipo crearEquipo() {
        System.out.println("\n¿Cómo deseas crear tu equipo?");
        System.out.println("1. Usar equipo predefinido (recomendado)");
        System.out.println("2. Seleccionar Pokémon manualmente");
        System.out.print("\nOpción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            return crearEquipoPredefinido();
        } else {
            return crearEquipoPersonalizado();
        }
    }

    /**
     * DEFAULT: Equipos predefinidos con templates.
     */
    private static Equipo crearEquipoPredefinido() {
        System.out.println("\n=== EQUIPOS PREDEFINIDOS ===");
        System.out.println("1. Equipo Equilibrado (Fuego, Agua, Planta)");
        System.out.println("2. Equipo Ofensivo (Dragón, Psíquico, Lucha)");
        System.out.println("3. Equipo Defensivo (Agua, Hielo, Acero)");
        System.out.print("\nElige tu equipo: ");
        int equipoElegido = scanner.nextInt();
        scanner.nextLine();

        List<Pokemon> equipo = new ArrayList<>();

        switch (equipoElegido) {
            case 1:
                equipo.add(Pokedex.charizard());
                equipo.add(Pokedex.blastoise());
                equipo.add(Pokedex.venusaur());
                break;
            case 2:
                equipo.add(Pokedex.dragonite());
                equipo.add(Pokedex.alakazam());
                equipo.add(Pokedex.machamp());
                break;
            case 3:
                equipo.add(Pokedex.lapras());
                equipo.add(Pokedex.snorlax());
                equipo.add(Pokedex.gyarados());
                break;
            default:
                equipo.add(Pokedex.pikachu());
                equipo.add(Pokedex.charizard());
                equipo.add(Pokedex.blastoise());
        }

        System.out.println("\n✅ Equipo seleccionado:");
        for (Pokemon p : equipo) {
            System.out.println("  - " + p.getNombre());
        }

        return new Equipo(equipo);
    }

    /**
     * DEFAULT: Creación manual de equipo.
     */
    private static Equipo crearEquipoPersonalizado() {
        List<Pokemon> equipo = new ArrayList<>();
        String[] pokemones = {"Charizard", "Blastoise", "Venusaur", "Pikachu", "Alakazam", 
                              "Machamp", "Dragonite", "Arcanine", "Lapras", "Gyarados", "Snorlax"};

        System.out.println("\n=== SELECCIONA 3 POKÉMON ===");
        for (int i = 0; i < 3; i++) {
            System.out.println("\nPokémon disponibles:");
            for (int j = 0; j < pokemones.length; j++) {
                System.out.println((j + 1) + ". " + pokemones[j]);
            }
            System.out.print("\nElige el Pokémon #" + (i + 1) + ": ");
            int eleccion = scanner.nextInt() - 1;
            scanner.nextLine();

            if (eleccion >= 0 && eleccion < pokemones.length) {
                Pokemon p = obtenerPokemon(pokemones[eleccion]);
                if (p != null) {
                    equipo.add(p);
                }
            }
        }

        return new Equipo(equipo);
    }

    /**
     * DEFAULT: Factory inline para obtener Pokémon por nombre.
     */
    private static Pokemon obtenerPokemon(String nombre) {
        switch (nombre) {
            case "Charizard": return Pokedex.charizard();
            case "Blastoise": return Pokedex.blastoise();
            case "Venusaur": return Pokedex.venusaur();
            case "Pikachu": return Pokedex.pikachu();
            case "Alakazam": return Pokedex.alakazam();
            case "Machamp": return Pokedex.machamp();
            case "Dragonite": return Pokedex.dragonite();
            case "Arcanine": return Pokedex.arcanine();
            case "Lapras": return Pokedex.lapras();
            case "Gyarados": return Pokedex.gyarados();
            case "Snorlax": return Pokedex.snorlax();
            default: return null;
        }
    }

    /**
     * STATIC: Menú principal de opciones.
     */
    private static void mostrarMenuPrincipal() {
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n" + "=".repeat(60));
            System.out.println("📋 MENÚ PRINCIPAL");
            System.out.println("=".repeat(60));
            System.out.println("1. Ver equipo");
            System.out.println("2. Elegir oponente y batallar");
            System.out.println("3. Ver estadísticas");
            System.out.println("4. Restaurar equipo");
            System.out.println("5. Salir");
            System.out.print("\nOpción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verEquipo();
                    break;
                case 2:
                    elegirOponenteYBatallar();
                    break;
                case 3:
                    verEstadisticas();
                    break;
                case 4:
                    restaurarEquipo();
                    break;
                case 5:
                    ejecutando = false;
                    System.out.println("\n👋 ¡Gracias por jugar!");
                    break;
                default:
                    System.out.println("❌ Opción inválida");
            }
        }
    }

    /**
     * DEFAULT: Muestra equipo del jugador.
     */
    private static void verEquipo() {
        jugador.getEquipo().mostrarEquipo();
        System.out.println("\nPulsa Enter para continuar...");
        scanner.nextLine();
    }

    /**
     * DEFAULT: Flujo de batalla.
     */
    private static void elegirOponenteYBatallar() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("⚔️  ELIGE TU OPONENTE");
        System.out.println("=".repeat(60));

        for (int i = 0; i < oponentes.size(); i++) {
            System.out.println((i + 1) + ". " + oponentes.get(i).getDescripcion());
        }

        System.out.print("\nOpción: ");
        int opcion = scanner.nextInt() - 1;
        scanner.nextLine();

        if (opcion >= 0 && opcion < oponentes.size()) {
            EntrenadorIA oponente = oponentes.get(opcion);

            jugador.restaurarEquipo();
            oponente.restaurarEquipo();

            Batalla batalla = new Batalla(jugador, oponente);
            batalla.iniciar();

            System.out.println("\nPulsa Enter para continuar...");
            scanner.nextLine();
        } else {
            System.out.println("❌ Opción inválida");
        }
    }

    /**
     * DEFAULT: Muestra estadísticas.
     */
    private static void verEstadisticas() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("📊 ESTADÍSTICAS");
        System.out.println("=".repeat(60));
        System.out.println(jugador.getDescripcion());

        System.out.println("\n=== RÉCORD CONTRA OPONENTES ===");
        for (EntrenadorIA oponente : oponentes) {
            System.out.println(oponente.getNombre() + ": " + oponente.getVictorias() + 
                             "V - " + oponente.getDerrotas() + "D");
        }

        System.out.println("\nPulsa Enter para continuar...");
        scanner.nextLine();
    }

    /**
     * DEFAULT: Restaura equipo completo.
     */
    private static void restaurarEquipo() {
        jugador.restaurarEquipo();
        System.out.println("\n✅ ¡Tu equipo ha sido restaurado!");
        System.out.println("Todos los Pokémon recuperaron HP y PP.");
        System.out.println("\nPulsa Enter para continuar...");
        scanner.nextLine();
    }
}

package pokemon.ui;

import pokemon.battle.BatallaFactory;
import pokemon.trainer.EntrenadorFactory;
import pokemon.trainer.Entrenador;
import pokemon.battle.Batalla;
import java.util.Scanner;

/**
 * STATIC Menú Principal de la aplicación.
 * 
 * Responsabilidades:
 * - Mostrar interfaz de usuario
 * - Procesar entrada del usuario
 * - Orquestar el flujo de la aplicación
 * 
 * STATIC: Solo métodos estáticos.
 * DEFAULT: Clase package-private.
 * 
 * @author UTP
 */
class MenuPrincipal {

    // ========== CONSTANTES PRIVADAS STATIC ==========
    private static final String TITULO = "POKÉMON SHOWDOWN - UTP";
    private static final String SEPARADOR = "=".repeat(50);

    /**
     * Constructor privado (clase utilitaria).
     */
    private MenuPrincipal() {
        // Clase utilitaria
    }

    /**
     * STATIC: Inicia el menú principal.
     */
    static void iniciar() {
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;

        while (ejecutando) {
            mostrarMenuPrincipal();
            
            System.out.print("\nSelecciona una opción (1-4): ");
            String opcion = scanner.nextLine().trim();

            switch (opcion) {
                case "1":
                    jugarContraIA(scanner);
                    break;
                case "2":
                    jugarDosJugadores(scanner);
                    break;
                case "3":
                    mostrarInfo();
                    break;
                case "4":
                    System.out.println("\n👋 ¡Gracias por jugar! Hasta pronto.");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
            }
        }
        
        scanner.close();
    }

    /**
     * DEFAULT: Muestra el menú principal.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n" + SEPARADOR);
        System.out.println(TITULO);
        System.out.println(SEPARADOR);
        System.out.println("1. Jugar contra IA");
        System.out.println("2. Batalla (2 Jugadores)");
        System.out.println("3. Información");
        System.out.println("4. Salir");
    }

    /**
     * DEFAULT: Inicia una batalla contra IA.
     */
    private static void jugarContraIA(Scanner scanner) {
        System.out.print("\nIngresa tu nombre: ");
        String nombreJugador = scanner.nextLine().trim();
        
        if (nombreJugador.isEmpty()) {
            nombreJugador = "Entrenador";
        }
        
        System.out.println("\nElige dificultad de IA:");
        System.out.println("1. Fácil");
        System.out.println("2. Normal");
        System.out.println("3. Difícil");
        System.out.print("Opción (1-3): ");
        
        int dificultad = validarDificultad(scanner.nextLine().trim());
        
        Entrenador jugador = EntrenadorFactory.crearEntrenadorJugador(nombreJugador);
        Entrenador ia = EntrenadorFactory.crearEntrenadorIA("IA", dificultad);
        
        iniciarBatalla(jugador, ia);
    }

    /**
     * DEFAULT: Inicia una batalla entre 2 jugadores humanos.
     */
    private static void jugarDosJugadores(Scanner scanner) {
        System.out.print("\nNombre del Jugador 1: ");
        String nombre1 = scanner.nextLine().trim();
        if (nombre1.isEmpty()) nombre1 = "Entrenador 1";
        
        System.out.print("Nombre del Jugador 2: ");
        String nombre2 = scanner.nextLine().trim();
        if (nombre2.isEmpty()) nombre2 = "Entrenador 2";
        
        Entrenador jugador1 = EntrenadorFactory.crearEntrenadorJugador(nombre1);
        Entrenador jugador2 = EntrenadorFactory.crearEntrenadorJugador(nombre2);
        
        iniciarBatalla(jugador1, jugador2);
    }

    /**
     * DEFAULT: Valida e interpreta la dificultad seleccionada.
     */
    private static int validarDificultad(String input) {
        try {
            int dificultad = Integer.parseInt(input);
            if (dificultad >= 1 && dificultad <= 3) {
                return dificultad;
            }
        } catch (NumberFormatException ignored) {
        }
        return 2; // Normal por defecto
    }

    /**
     * DEFAULT: Inicia una batalla.
     */
    private static void iniciarBatalla(Entrenador ent1, Entrenador ent2) {
        try {
            Batalla batalla = BatallaFactory.crearBatalla(ent1, ent2);
            batalla.iniciar();
        } catch (Exception e) {
            System.err.println("❌ Error durante la batalla: " + e.getMessage());
        }
    }

    /**
     * DEFAULT: Muestra información del juego.
     */
    private static void mostrarInfo() {
        System.out.println("\n" + SEPARADOR);
        System.out.println("INFORMACIÓN DEL JUEGO");
        System.out.println(SEPARADOR);
        System.out.println("🎮 Pokémon Showdown - Simulador de Batallas");
        System.out.println("📚 Versión: 3.0 - POO Avanzado");
        System.out.println("🏫 Universidad Tecnológica de Panamá (UTP)");
        System.out.println("\n📖 Mecánicas:");
        System.out.println("• Batallas por turnos");
        System.out.println("• Sistema de tipos y efectividad");
        System.out.println("• Estados de condición (Paralizado, Quemado)");
        System.out.println("• 3 niveles de dificultad de IA");
        System.out.println("• Golpes críticos y variación de daño");
        System.out.println("\n✨ Características POO:");
        System.out.println("• Clases abstractas (Estado, Entrenador)");
        System.out.println("• Interfaces (Estrategia)");
        System.out.println("• Métodos STATIC para utilidades");
        System.out.println("• DEFAULT para encapsulamiento interno");
        System.out.println("• Factory Pattern para creación de objetos");
        System.out.println("• Patrón Strategy para IA");
    }
}

package pokemon;

import pokemon.data.Pokedex;
import pokemon.trainer.Entrenador;
import pokemon.trainer.EntrenadorJugador;
import pokemon.ui.MenuPrincipal;
import java.util.Scanner;

/**
 * Punto de entrada principal de la aplicación Pokémon.
 * 
 * Responsabilidades:
 * - Inicializar el Pokédex
 * - Configurar la aplicación
 * - Ejecutar el menú principal
 * 
 * Compatible y optimizado para JDK 24.0.2.
 * 
 * @author UTP
 * @version 4.1 - JDK 24 Ready + ArrayList
 */
public class Main {

    /**
     * Método main - punto de entrada de la JVM.
     * Inicializa y ejecuta la aplicación de Pokémon.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        try {
            // Banner de inicio
            mostrarBanner();

            // Inicializar Pokédex con datos predeterminados
            System.out.println("🔄 Inicializando Pokédex...");
            Pokedex.inicializar();

            // Mostrar información del sistema
            mostrarInfoSistema();

            // Crear Scanner para entrada del usuario
            Scanner scanner = new Scanner(System.in);

            // Solicitar nombre del jugador
            System.out.print("\n👤 Ingresa tu nombre de entrenador: ");
            String nombreJugador = scanner.nextLine().trim();

            if (nombreJugador.isEmpty()) {
                nombreJugador = "Entrenador";
                System.out.println("⚠️ Nombre por defecto: " + nombreJugador);
            }

            // Crear entrenador jugador
            System.out.println("✅ Entrenador '" + nombreJugador + "' creado correctamente\n");
            Entrenador jugador = new EntrenadorJugador(nombreJugador);

            // Ejecutar interfaz principal
            System.out.println("🎮 Iniciando menú principal...\n");
            MenuPrincipal.iniciar(scanner, jugador);

            // Cerrar recursos
            scanner.close();

            System.out.println("\n👋 ¡Gracias por jugar! Hasta luego.");
            System.exit(0);

        } catch (Exception e) {
            System.err.println("\n❌ ERROR CRÍTICO AL INICIAR LA APLICACIÓN:");
            System.err.println("   " + e.getMessage());
            System.err.println("\n🔍 Stack Trace:");
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Muestra el banner de bienvenida.
     */
    private static void mostrarBanner() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("  🎮 ╔═══════════════════════════════════════════════════════╗ 🎮");
        System.out.println("  🎮 ║    POKÉMON BATALLA - SISTEMA DE COMBATE AVANZADO      ║ 🎮");
        System.out.println("  🎮 ║    ⭐ Versión 4.1 | Optimizado para JDK 24.0.2        ║ 🎮");
        System.out.println("  🎮 ║    ✨ Con ArrayList, Static, Default Methods          ║ 🎮");
        System.out.println("  🎮 ╚═══════════════════════════════════════════════════════╝ 🎮");
        System.out.println("=".repeat(80) + "\n");
    }

    /**
     * Muestra información del sistema.
     */
    private static void mostrarInfoSistema() {
        System.out.println("📊 Información del Sistema:");
        System.out.println("   ✓ Java Version: " + System.getProperty("java.version"));
        System.out.println("   ✓ JVM Name: " + System.getProperty("java.vm.name"));
        System.out.println("   ✓ Vendor: " + System.getProperty("java.vendor"));
        System.out.println("   ✓ OS: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        System.out.println("   ✓ Pokédex Cargado: " + Pokedex.getTamaño() + " Pokémon disponibles");
        System.out.println();
    }
}

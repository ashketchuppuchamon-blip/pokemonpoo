package pokemon.data;

import pokemon.model.Tipo;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * STATIC Cargador de Tipos desde JSON.
 * 
 * Responsabilidades:
 * - Cargar información de tipos desde archivo JSON
 * - Inicializar el Pokédex
 * 
 * STATIC: Solo métodos estáticos.
 * PUBLIC: Debe ser accedido desde Main.
 * 
 * @author UTP
 */
public class TipoLoader {

    /**
     * Constructor privado (clase utilitaria).
     */
    private TipoLoader() {
        // Clase utilitaria
    }

    /**
     * STATIC: Carga tipos desde archivo JSON e inicializa Pokédex.
     * 
     * @param rutaJSON Ruta del archivo JSON
     */
    public static void cargarTipos(String rutaJSON) {
        try {
            File archivo = new File(rutaJSON);
            
            if (!archivo.exists()) {
                System.out.println("⚠️  Archivo de tipos no encontrado: " + rutaJSON);
                System.out.println("📦 Inicializando Pokédex con datos por defecto...");
            } else {
                System.out.println("📂 Tipos cargados desde: " + rutaJSON);
            }
            
            // Inicializar Pokédex
            Pokedex.inicializar();
            System.out.println("✅ Pokédex inicializado con " + Pokedex.getTamaño() + " Pokémon");
            
        } catch (Exception e) {
            System.err.println("❌ Error cargando tipos: " + e.getMessage());
            throw new RuntimeException("No se pudo cargar la configuración de tipos", e);
        }
    }
}

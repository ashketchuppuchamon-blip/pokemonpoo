package pokemon.data;

import pokemon.model.Pokemon;
import pokemon.model.Movimiento;
import pokemon.model.Tipo;
import java.util.ArrayList;
import java.util.List;

/**
 * STATIC Pokédex - Base de datos de Pokémon.
 * 
 * Responsabilidades:
 * - Almacenar todos los Pokémon disponibles
 * - Proporcionar búsqueda por nombre
 * - Gestionar catálogo global
 * 
 * STATIC: Solo contiene métodos y atributos estáticos.
 * PUBLIC: Acceso global a la información.
 * 
 * @author UTP
 */
public class Pokedex {

    // ========== ATRIBUTOS PRIVADOS STATIC ==========
    private static final List<Pokemon> POKEDEX = new ArrayList<>();
    private static boolean cargado = false;

    /**
     * Constructor privado (clase utilitaria).
     */
    private Pokedex() {
        // Clase utilitaria
    }

    /**
     * STATIC: Inicializa el Pokédex con Pokémon de prueba.
     * Es llamado una sola vez por TipoLoader.
     */
    static void inicializar() {
        if (cargado) return;
        
        // Agregar Pokémon de prueba
        POKEDEX.add(crearPikachu());
        POKEDEX.add(crearCharizard());
        POKEDEX.add(crearVenusaur());
        POKEDEX.add(crearBlastoise());
        POKEDEX.add(crearDragonite());
        POKEDEX.add(crearMewtwo());
        
        cargado = true;
    }

    // ========== MÉTODOS STATIC DE CREACIÓN (PRIVATE) ==========

    /**
     * DEFAULT: Crea un Pikachu.
     */
    private static Pokemon crearPikachu() {
        List<Movimiento> movs = new ArrayList<>();
        movs.add(new Movimiento("Rayo", 90, Tipo.ELECTRIC, 100, 15));
        movs.add(new Movimiento("Impactrueno", 40, Tipo.ELECTRIC, 100, 30));
        movs.add(new Movimiento("Ataque Rápido", 40, Tipo.NORMAL, 100, 30));
        movs.add(new Movimiento("Gruñido", 0, Tipo.NORMAL, 100, 40));
        return new Pokemon("Pikachu", 35, 55, 50, 40, 50, 90, 25, Tipo.ELECTRIC, movs);
    }

    /**
     * DEFAULT: Crea un Charizard.
     */
    private static Pokemon crearCharizard() {
        List<Movimiento> movs = new ArrayList<>();
        movs.add(new Movimiento("Llamarada", 110, Tipo.FIRE, 85, 5));
        movs.add(new Movimiento("Lanzallamas", 90, Tipo.FIRE, 100, 15));
        movs.add(new Movimiento("Alivio", 0, Tipo.NORMAL, 100, 20));
        movs.add(new Movimiento("Envite", 75, Tipo.NORMAL, 100, 35));
        return new Pokemon("Charizard", 78, 84, 109, 78, 85, 100, 50, Tipo.FIRE, movs);
    }

    /**
     * DEFAULT: Crea un Venusaur.
     */
    private static Pokemon crearVenusaur() {
        List<Movimiento> movs = new ArrayList<>();
        movs.add(new Movimiento("Rayo Solar", 120, Tipo.GRASS, 100, 10));
        movs.add(new Movimiento("Bomba de Lodo", 90, Tipo.POISON, 100, 10));
        movs.add(new Movimiento("Polvo Somnífero", 0, Tipo.GRASS, 75, 15));
        movs.add(new Movimiento("Azote", 75, Tipo.NORMAL, 100, 15));
        return new Pokemon("Venusaur", 80, 82, 100, 83, 100, 80, 50, Tipo.GRASS, movs);
    }

    /**
     * DEFAULT: Crea un Blastoise.
     */
    private static Pokemon crearBlastoise() {
        List<Movimiento> movs = new ArrayList<>();
        movs.add(new Movimiento("Hidrocañón", 110, Tipo.WATER, 80, 5));
        movs.add(new Movimiento("Surf", 90, Tipo.WATER, 100, 15));
        movs.add(new Movimiento("Rayo de Hielo", 90, Tipo.ICE, 100, 10));
        movs.add(new Movimiento("Pulso Acuático", 60, Tipo.WATER, 100, 20));
        return new Pokemon("Blastoise", 79, 83, 100, 100, 85, 78, 50, Tipo.WATER, movs);
    }

    /**
     * DEFAULT: Crea un Dragonite.
     */
    private static Pokemon crearDragonite() {
        List<Movimiento> movs = new ArrayList<>();
        movs.add(new Movimiento("Ímpetu Dragón", 85, Tipo.DRAGON, 100, 10));
        movs.add(new Movimiento("Envite", 90, Tipo.NORMAL, 100, 20));
        movs.add(new Movimiento("Tormenta de Arena", 0, Tipo.GROUND, 85, 10));
        movs.add(new Movimiento("Terremoto", 100, Tipo.GROUND, 100, 10));
        return new Pokemon("Dragonite", 91, 134, 100, 100, 100, 80, 50, Tipo.DRAGON, movs);
    }

    /**
     * DEFAULT: Crea un Mewtwo (final boss).
     */
    private static Pokemon crearMewtwo() {
        List<Movimiento> movs = new ArrayList<>();
        movs.add(new Movimiento("Explosión Psíquica", 90, Tipo.PSYCHIC, 100, 10));
        movs.add(new Movimiento("Rayo de Hielo", 90, Tipo.ICE, 100, 10));
        movs.add(new Movimiento("Llamarada", 110, Tipo.FIRE, 85, 5));
        movs.add(new Movimiento("Terremoto", 100, Tipo.GROUND, 100, 10));
        return new Pokemon("Mewtwo", 106, 110, 154, 90, 100, 140, 70, Tipo.PSYCHIC, movs);
    }

    // ========== MÉTODOS STATIC PÚBLICOS ==========

    /**
     * STATIC: Obtiene un Pokémon por nombre.
     * 
     * @param nombre Nombre del Pokémon
     * @return Pokémon encontrado o null
     */
    public static Pokemon obtener(String nombre) {
        if (!cargado) inicializar();
        
        for (Pokemon p : POKEDEX) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    /**
     * STATIC: Obtiene todos los Pokémon del Pokédex.
     * 
     * @return Lista de todos los Pokémon
     */
    public static List<Pokemon> obtenerTodos() {
        if (!cargado) inicializar();
        return new ArrayList<>(POKEDEX);
    }

    /**
     * STATIC: Obtiene la cantidad de Pokémon registrados.
     * 
     * @return Número de Pokémon
     */
    public static int getTamaño() {
        if (!cargado) inicializar();
        return POKEDEX.size();
    }
}

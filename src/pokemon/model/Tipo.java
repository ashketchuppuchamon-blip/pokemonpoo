package pokemon.model;

/**
 * Enumeración de tipos de Pokémon.
 * 
 * STATIC: Los enums son implícitamente static.
 * Cada constante representa un tipo con propiedades fijas.
 * 
 * @author UTP
 */
public enum Tipo {
    FIRE("Fuego", "🔥"),
    WATER("Agua", "💧"),
    GRASS("Planta", "🌿"),
    ELECTRIC("Eléctrico", "⚡"),
    PSYCHIC("Psíquico", "🧠"),
    DRAGON("Dragón", "🐉"),
    FIGHTING("Lucha", "💪"),
    ICE("Hielo", "❄️"),
    NORMAL("Normal", "⚪"),
    POISON("Veneno", "☠️"),
    FLYING("Volador", "🦅"),
    GROUND("Tierra", "🪨"),
    ROCK("Roca", "🏔️"),
    BUG("Bicho", "🐛"),
    GHOST("Fantasma", "👻"),
    STEEL("Acero", "⚙️"),
    FAIRY("Hada", "✨"),
    DARK("Siniestro", "🌑");

    private final String nombre;
    private final String emoji;

    /**
     * Constructor privado del enum.
     */
    Tipo(String nombre, String emoji) {
        this.nombre = nombre;
        this.emoji = emoji;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmoji() {
        return emoji;
    }

    /**
     * STATIC: Método de utilidad para obtener un tipo por nombre.
     * 
     * @param nombre Nombre del tipo
     * @return El tipo encontrado o NORMAL por defecto
     */
    public static Tipo obtenerPorNombre(String nombre) {
        try {
            return Tipo.valueOf(nombre.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NORMAL;
        }
    }
}

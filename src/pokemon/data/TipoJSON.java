package pokemon.data;

import java.util.List;

/**
 * Clase auxiliar para parsear JSON (no se usa directamente en el proyecto).
 * DEFAULT: Visibilidad de paquete.
 */
class TipoJSON {
    String name;
    List<String> immunes;
    List<String> weaknesses;
    List<String> strengths;
}

package pokemon.data;

import pokemon.model.Tipo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * STATIC UTILITIES: Métodos estáticos para cargar datos.
 * No necesita instancia porque es una utilidad.
 */
public class TipoLoader {

    /**
     * STATIC: Método utilitario que carga tipos desde JSON.
     */
    public static void cargarTipos(String rutaArchivo) {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get(rutaArchivo)));

            Pattern pattern = Pattern.compile("\\{\"name\":\"(.*?)\",\"immunes\":\\[(.*?)\\],\"weaknesses\":\\[(.*?)\\],\"strengths\":\\[(.*?)\\]\\}");
            Matcher matcher = pattern.matcher(contenido);

            while (matcher.find()) {
                String nombre = matcher.group(1).toUpperCase();
                String inmStr = matcher.group(2);
                String weakStr = matcher.group(3);
                String strStr = matcher.group(4);

                Tipo tipoActual = Tipo.valueOf(nombre);

                tipoActual.configurarRelaciones(
                        limpiarYConvertir(inmStr),
                        limpiarYConvertir(weakStr),
                        limpiarYConvertir(strStr)
                );
            }
            System.out.println("✅ Tabla de tipos cargada correctamente.");

        } catch (IOException e) {
            System.err.println("❌ Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error procesando el formato: " + e.getMessage());
        }
    }

    /**
     * STATIC: Método privado de utilidad para limpiar strings de JSON.
     */
    private static List<Tipo> limpiarYConvertir(String listaJson) {
        List<Tipo> tipos = new ArrayList<>();
        if (listaJson == null || listaJson.trim().isEmpty()) return tipos;

        String[] nombres = listaJson.replace("\"", "").split(",");
        for (String n : nombres) {
            String limpio = n.trim().toUpperCase();
            if (!limpio.isEmpty()) {
                tipos.add(Tipo.valueOf(limpio));
            }
        }
        return tipos;
    }
}

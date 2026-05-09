package pokemon.data;

import pokemon.model.*;
import pokemon.trainer.*;
import java.util.*;

public class EntrenadorFactory {

    public static EntrenadorIA crearBlaine() {
        List<Pokemon> equipo = Arrays.asList(
                Pokedex.arcanine(),
                Pokedex.charizard(),
                Pokedex.dragonite()
        );
        return new EntrenadorIA("Blaine", new Equipo(equipo), new EstrategiaIA(1), 1, "Líder Fuego");
    }

    public static EntrenadorIA crearMisty() {
        List<Pokemon> equipo = Arrays.asList(
                Pokedex.blastoise(),
                Pokedex.lapras(),
                Pokedex.gyarados()
        );
        return new EntrenadorIA("Misty", new Equipo(equipo), new EstrategiaIA(2), 2, "Líder Agua");
    }

    public static EntrenadorIA crearErika() {
        List<Pokemon> equipo = Arrays.asList(
                Pokedex.venusaur(),
                Pokedex.charizard(),
                Pokedex.lapras()
        );
        return new EntrenadorIA("Erika", new Equipo(equipo), new EstrategiaIA(1), 1, "Líder Planta");
    }

    public static EntrenadorIA crearBlue() {
        List<Pokemon> equipo = Arrays.asList(
                Pokedex.alakazam(),
                Pokedex.machamp(),
                Pokedex.gyarados(),
                Pokedex.dragonite(),
                Pokedex.charizard(),
                Pokedex.snorlax()
        );
        return new EntrenadorIA("Blue", new Equipo(equipo), new EstrategiaIA(2), 2, "Tu Rival");
    }

    public static EntrenadorIA crearLance() {
        List<Pokemon> equipo = Arrays.asList(
                Pokedex.dragonite(),
                Pokedex.dragonite(),
                Pokedex.dragonite(),
                Pokedex.alakazam(),
                Pokedex.arcanine(),
                Pokedex.snorlax()
        );
        return new EntrenadorIA("Lance", new Equipo(equipo), new EstrategiaIA(3), 3, "Campeón");
    }

    public static List<EntrenadorIA> obtenerTodosOponentes() {
        return Arrays.asList(
                crearBlaine(),
                crearMisty(),
                crearErika(),
                crearBlue(),
                crearLance()
        );
    }
}

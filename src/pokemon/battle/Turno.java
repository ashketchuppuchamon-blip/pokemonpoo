package pokemon.battle;

public class Turno {
    private int numero = 1;

    public void siguiente() {
        numero++;
    }

    public int getNumero() {
        return numero;
    }
}

package pokemon.model;

import java.util.List;
import pokemon.battle.CalculadoraDanio;

public class Pokemon {

    private String nombre;
    private int hpMax;
    private int hpActual;
    private int ataque;
    private int ataqueEsp;
    private int defensa;
    private int defensaEsp;
    private int velocidad;
    private int nivel;
    private Tipo tipo;
    private List<Movimiento> movimientos;
    private Estado estado;

    public Pokemon(String nombre, int hp, int atk, int atkEsp, int def, int defEsp, int vel, int nivel, Tipo tipo, List<Movimiento> movs) {
        this.nombre = nombre;
        this.hpMax = hp;
        this.hpActual = hp;
        this.ataque = atk;
        this.ataqueEsp = atkEsp;
        this.defensa = def;
        this.defensaEsp = defEsp;
        this.velocidad = vel;
        this.nivel = nivel;
        this.tipo = tipo;
        this.movimientos = movs;
        this.estado = new EstadoNormal();
    }

    public void atacar(Pokemon objetivo, int index) {
        if (!estado.puedeAtacar()) {
            System.out.println(nombre + " está paralizado y no puede atacar!");
            return;
        }

        Movimiento mov = movimientos.get(index);

        if (!mov.tienePP()) {
            System.out.println(nombre + " no tiene PP para " + mov.getNombre() + "!");
            return;
        }

        if (!mov.acertar()) {
            System.out.println(nombre + " falló el ataque!");
            mov.usarPP();
            return;
        }

        int daño = CalculadoraDanio.calcular(this, objetivo, mov);
        objetivo.recibirDanio(daño);
        mov.usarPP();

        System.out.println(nombre + " usó " + mov.getNombre());
    }

    public void aplicarEstado() {
        estado.aplicarEfecto(this);
    }

    public void recibirDanio(int daño) {
        hpActual = Math.max(0, hpActual - daño);
    }

    public boolean estaVivo() {
        return hpActual > 0;
    }

    public void restaurarHP() {
        this.hpActual = hpMax;
    }

    public void restaurarEstado() {
        this.estado = new EstadoNormal();
    }

    public void restaurarPP() {
        for (Movimiento mov : movimientos) {
            mov.restaurarPP();
        }
    }

    public void mostrarMovimientos() {
        for (int i = 0; i < movimientos.size(); i++) {
            Movimiento mov = movimientos.get(i);
            System.out.println((i + 1) + ". " + mov.getNombre() + " (PP: " + mov.getPPActual() + "/" + mov.getPPMax() + ")");
        }
    }

    public String mostrarEstadoDetallado() {
        return String.format("%s Nv.%d | HP: %d/%d | ATK: %d | DEF: %d | VEL: %d",
                nombre, nivel, hpActual, hpMax, ataque, defensa, velocidad);
    }

    // Getters
    public int getHp() { return hpActual; }
    public int getHpMax() { return hpMax; }
    public int getAtaque() { return ataque; }
    public int getAtaqueEsp() { return ataqueEsp; }
    public int getDefensa() { return defensa; }
    public int getDefensaEsp() { return defensaEsp; }
    public int getVelocidad() { return velocidad; }
    public int getNivel() { return nivel; }
    public Tipo getTipo() { return tipo; }
    public List<Movimiento> getMovimientos() { return movimientos; }
    public String getNombre() { return nombre; }
    public Estado getEstado() { return estado; }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

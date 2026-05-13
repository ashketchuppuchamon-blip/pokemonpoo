# 🎮 Pokémon Showdown - POO (v2.1 con STATIC y DEFAULT)

Proyecto educativo de simulador de batallas Pokémon en Java usando **Programación Orientada a Objetos** con énfasis en **Static** y **Default**.

## ✨ Características

✅ **5 Oponentes predefinidos** (Blaine, Misty, Erika, Blue, Lance)  
✅ **Sistema de batalla completo** con cambio de Pokémon  
✅ **IA inteligente** con 3 niveles de dificultad  
✅ **12 Pokémon diferentes** en forma final  
✅ **Sistema de efectos de tipo** y daño realista  
✅ **Menú interactivo** con interfaz visual  
✅ **Seguimiento de estadísticas** de victorias/derrotas  
✅ **Sistema de PP (Power Points)** por movimiento  
✅ **STATIC y DEFAULT aplicado profesionalmente**  

## 📚 CONCEPTOS APLICADOS

### 🔴 STATIC - Cuando Usarlo

**STATIC = SIN INSTANCIA**

```java
// ❌ SIN STATIC (necesita new)
MenuPrincipal menu = new MenuPrincipal();
menu.iniciar();

// ✅ CON STATIC (acceso directo)
MenuPrincipal.iniciar();
```

**CASOS EN ESTE PROYECTO:**

| Clase | Método STATIC | Por Qué |
|-------|---------------|--------|
| `MenuPrincipal` | `iniciar()` | Punto de entrada único, sin estado |
| `Pokedex` | `charizard()`, `blastoise()`, etc | Factory - crea objetos sin estado interno |
| `EntrenadorFactory` | `crearBlaine()`, `crearLance()`, etc | Factory Pattern - crear oponentes |
| `CalculadoraDanio` | `calcular()` | Función pura: entra datos, sale daño |
| `TipoLoader` | `cargarTipos()` | Utilidad de carga única al inicio |
| `Pokemon` | `obtenerEmojiTipo()` | Utilidad que no depende de instancia |

**VENTAJAS:**

| Beneficio | Explicación |
|-----------|-------------|
| **Memoria** | Se carga UNA SOLA VEZ en la JVM |
| **Rapidez** | No hay overhead de crear objetos |
| **Claridad** | `Clase.metodo()` = operación de la clase |
| **Singleton** | Garantiza un único punto de acceso |
| **Funciones Puras** | Sin efectos secundarios ni estado |

---

### 🔵 DEFAULT - Encapsulación Interna

**DEFAULT = VISIBILIDAD DE PAQUETE (sin modificador)**

```java
// Solo clases del mismo paquete pueden verlo
class EstrategiaJugador implements Estrategia {  // ← DEFAULT
    int elegirMovimiento(Pokemon p) { }  // ← DEFAULT
}

// Clases en otros paquetes: NO PUEDEN acceder
```

**NIVELES DE VISIBILIDAD:**

```
public      ✅✅✅✅  Accesible desde cualquier lugar
protected   ✅✅✅   Solo herencia y mismo paquete
default     ✅✅     Solo dentro del mismo paquete  ← OUR USE
private     ✅      Solo dentro de la clase
```

**CASOS EN ESTE PROYECTO:**

| Clase | Visibilidad | Por Qué |
|-------|-------------|--------|
| `EstrategiaJugador` | DEFAULT | Implementación interna de estrategia |
| `EstrategiaIA` | DEFAULT | Implementación interna de estrategia |
| `EntrenadorJugador` | DEFAULT | Constructor solo desde MenuPrincipal |
| `EntrenadorIA` | DEFAULT | Constructor solo desde factory |
| `EstadoNormal/Paralizado/Quemado` | DEFAULT | Estados internos del modelo |
| `Pokemon.atacar()` | DEFAULT | Llamado solo desde Batalla |
| `Batalla.ejecutarTurno()` | DEFAULT | Lógica interna de batalla |
| `MenuPrincipal` (métodos) | DEFAULT | Flujo interno del menú |

**VENTAJAS:**

| Beneficio | Explicación |
|-----------|-------------|
| **Encapsulación** | Oculta detalles internos |
| **Seguridad** | Evita uso incorrecto desde fuera |
| **Cohesión** | Mantiene relacionado lo que pertenece |
| **Flexibilidad** | Puedo cambiar internos sin afectar extern |
| **Claridad** | Solo lo necesario es público |

---

## 🏗️ Estructura del Proyecto

```
src/pokemon/
├── Main.java                 ✨ STATIC en main()
│
├── model/
│   ├── Tipo.java            ✨ STATIC enums
│   ├── Pokemon.java         ✨ STATIC obtenerEmojiTipo()
│   ├── Movimiento.java      🔵 DEFAULT métodos internos
│   ├── Estrategia.java      PUBLIC interfaz
│   ├── EstrategiaJugador.java   🔵 DEFAULT clase
│   ├── EstrategiaIA.java    🔵 DEFAULT clase
│   ├── Estado.java          PUBLIC abstracta
│   └── Estado[Normal/Paralizado/Quemado].java  🔵 DEFAULT
│
├── trainer/
│   ├── Entrenador.java      PUBLIC abstracta
│   ├── EntrenadorJugador.java   🔵 DEFAULT
│   ├── EntrenadorIA.java    🔵 DEFAULT
│   └── Equipo.java          PUBLIC
│
├── battle/
│   ├── Batalla.java         PUBLIC
│   ├── CalculadoraDanio.java    ✨ STATIC calcular()
│   └── Turno.java           🔵 DEFAULT
│
├── data/
│   ├── Pokedex.java         ✨ STATIC factory methods
│   ├── EntrenadorFactory.java   ✨ STATIC factory methods
│   ├── TipoLoader.java      ✨ STATIC cargarTipos()
│   └── tipos.json
│
└── ui/
    └── MenuPrincipal.java   ✨ STATIC métodos principales
```

---

## 💻 Cómo Compilar y Ejecutar

```bash
# Compilar
javac -d bin src/pokemon/**/*.java src/pokemon/model/*.java \
  src/pokemon/trainer/*.java src/pokemon/battle/*.java \
  src/pokemon/ui/*.java src/pokemon/data/*.java

# Ejecutar
java -cp bin pokemon.Main
```

---

## 📊 Ejemplos de STATIC en el Código

### 1️⃣ Factory Pattern (STATIC)

```java
public class Pokedex {
    // STATIC: No necesita instancia
    public static final int NIVEL_DEFECTO = 50;
    
    public static Pokemon charizard() {
        return new Pokemon(...);
    }
}

// Uso
Pokemon p = Pokedex.charizard();  // ← Sin new Pokedex()
```

### 2️⃣ Calculadora Pura (STATIC)

```java
public class CalculadoraDanio {
    // STATIC: Función pura
    public static int calcular(Pokemon atk, Pokemon def, Movimiento mov) {
        int daño = (atk.getAtaque() * mov.getPoder()) / def.getDefensa();
        return daño * efectividad;
    }
}

// Uso
int daño = CalculadoraDanio.calcular(p1, p2, movimiento);  // ← Sin instancia
```

### 3️⃣ Utilidades (STATIC)

```java
public class TipoLoader {
    // STATIC: Se ejecuta una sola vez al inicio
    public static void cargarTipos(String rutaArchivo) {
        // Carga JSON y configura tipos
    }
}

// En Main
public static void main(String[] args) {
    TipoLoader.cargarTipos("src/pokemon/data/tipos.json");  // ← Carga global
}
```

---

## 📊 Ejemplos de DEFAULT en el Código

### 1️⃣ Estrategias Internas (DEFAULT)

```java
// DEFAULT: Solo visible en el paquete model
class EstrategiaJugador implements Estrategia {
    int elegirMovimiento(Pokemon pokemon) {  // ← DEFAULT
        // Implementación interna
    }
}
```

### 2️⃣ Lógica Interna de Batalla (DEFAULT)

```java
public class Batalla {
    public void iniciar() {  // ← PUBLIC (interfaz externa)
        ejecutarTurno();  // ← DEFAULT (uso interno)
    }
    
    private void ejecutarTurno() {  // ← PRIVATE (muy interno)
        atacar(entrenador1, entrenador2);  // ← DEFAULT
    }
    
    private void atacar(Entrenador atacante, Entrenador defensor) {  // ← PRIVATE
        // Lógica de ataque
    }
}
```

### 3️⃣ Estados Ocultos (DEFAULT)

```java
// DEFAULT: Solo visible en el paquete model
class EstadoParalizado extends Estado {
    EstadoParalizado() {  // ← DEFAULT constructor
        super("Paralizado");
    }
    
    @Override
    public void aplicarEfecto(Pokemon p) {
        // Efecto paralizado
    }
}
```

---

## 🎓 Lecciones Aprendidas

✅ **STATIC** = Para operaciones sin estado (factory, utilidades, constantes)  
✅ **DEFAULT** = Para mantener cohesión dentro del paquete  
✅ **PUBLIC** = Solo lo que necesita ser accedido desde fuera  
✅ **PRIVATE** = Solo lo más interno de la clase  

**REGLA DE ORO:** 
> "Siempre usa el nivel MÍNIMO de visibilidad necesario"

---

## 🎯 Para la Universidad (UTP)

Este proyecto implementa profesionalmente:
- ✅ Static methods y variables
- ✅ Default (package-private) visibility
- ✅ Access modifiers correctamente
- ✅ Factory Pattern con STATIC
- ✅ Encapsulación profesional
- ✅ POO completo en Java

---

**¡Versión 2.1 - STATIC y DEFAULT Aplicado Profesionalmente!** 🚀

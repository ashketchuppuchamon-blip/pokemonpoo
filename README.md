# 🎮 Pokémon Showdown - POO

Proyecto educativo de un simulador de batallas Pokémon en Java usando **Programación Orientada a Objetos**.

## ✨ Características

✅ **5 Oponentes predefinidos** (Blaine, Misty, Erika, Blue, Lance)  
✅ **Sistema de batalla completo** con cambio de Pokémon  
✅ **IA inteligente** con 3 niveles de dificultad  
✅ **12 Pokémon diferentes** en forma final  
✅ **Sistema de efectos de tipo** y daño realista  
✅ **Menú interactivo** con interfaz visual  
✅ **Seguimiento de estadísticas** de victorias/derrotas  
✅ **Sistema de PP (Power Points)** por movimiento  

## 🏗️ Estructura POO

### Patrones Utilizados
- ✅ **Factory Pattern**: `EntrenadorFactory` para crear oponentes
- ✅ **Strategy Pattern**: `Estrategia` para comportamientos de batalla
- ✅ **Template Method**: Clase abstracta `Entrenador`
- ✅ **Polimorfismo**: Interfaces y herencia

### Clases Principales

```
Model/
├── Pokemon.java          - Entidad principal
├── Movimiento.java       - Ataques con PP
├── Tipo.java             - Sistema de tipos
├── Estado.java (abstract) - Estados especiales
├── Estrategia.java       - Interfaz para comportamientos
└── EstrategiaJugador/IA.java - Implementaciones

Trainer/
├── Entrenador.java       - Clase abstracta
├── EntrenadorJugador.java
└── EntrenadorIA.java

Battle/
├── Batalla.java          - Sistema de combate
├── CalculadoraDanio.java
└── Turno.java

Data/
├── Pokedex.java          - Catálogo de Pokémon
├── EntrenadorFactory.java - Factory para oponentes
├── TipoLoader.java       - Cargador JSON
└── tipos.json            - Tabla de efectividad

UI/
└── MenuPrincipal.java    - Interfaz de usuario
```

## 🎯 Pokémon Disponibles

**Forma Final (50 nivel):**
- 🔥 Charizard, Arcanine
- 💧 Blastoise, Lapras, Gyarados
- 🌿 Venusaur
- ⚡ Pikachu
- 🧠 Alakazam
- 💪 Machamp
- 🐉 Dragonite
- 😴 Snorlax

## 🏆 Oponentes

1. **Blaine** (Líder Fuego) ⭐ - Fácil
2. **Misty** (Líder Agua) ⭐⭐ - Fácil
3. **Erika** (Líder Planta) ⭐⭐ - Fácil
4. **Blue** (Tu Rival) ⭐⭐⭐ - Normal
5. **Lance** (Campeón) ⭐⭐⭐⭐⭐ - Difícil

## 🚀 Cómo Compilar y Ejecutar

```bash
# Compilar
javac -d bin src/pokemon/**/*.java src/pokemon/model/*.java \
  src/pokemon/trainer/*.java src/pokemon/battle/*.java \
  src/pokemon/ui/*.java src/pokemon/data/*.java

# Ejecutar
java -cp bin pokemon.ui.MenuPrincipal
```

## 📝 Cómo Jugar

1. **Crea tu entrenador** con nombre y apodo
2. **Forma tu equipo** (predefinido o personalizado)
3. **Elige oponente** y comienza la batalla
4. **Selecciona movimientos** estratégicamente
5. **Cambia de Pokémon** cuando sea necesario
6. **Vence a todos los líderes** y al Campeón

## 🎓 Conceptos POO Demostrados

- ✅ **Encapsulación**: Atributos privados, getters/setters
- ✅ **Herencia**: Clases abstractas y subclases
- ✅ **Polimorfismo**: Interfaces y métodos abstractos
- ✅ **Composición**: Objetos dentro de objetos
- ✅ **Patrones de Diseño**: Factory, Strategy, Template Method
- ✅ **Gestión de Colecciones**: ArrayList, List<>
- ✅ **Manejo de Excepciones**: Try-catch

## 📊 Sistema de Daño

La fórmula de daño considera:
- Ataque del atacante
- Poder del movimiento
- Defensa del defensor
- **Efectividad de tipo** (0.5x, 1x, 2x)

```
Daño = (ATK × Poder / DEF) × Efectividad
```

## 🔧 Tecnologías

- **Lenguaje**: Java 8+
- **Paradigma**: Programación Orientada a Objetos
- **Input/Output**: Scanner, System.out
- **Datos**: JSON (tipos.json)

## 📚 Para la Universidad (UTP)

Este proyecto implementa:
- Clases abstractas y concretas
- Interfaces y contrato de métodos
- Herencia y polimorfismo
- Factory y Strategy patterns
- Composición de objetos
- Gestión de estado
- Lógica de juego compleja

## 👨‍💻 Autor

Desarrollado como proyecto educativo de POO para UTP.

## 📄 Licencia

Proyecto educativo - Libre para uso académico.

---

**¡Que comience la batalla!** ⚔️

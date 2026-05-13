# Pokémon Showdown UTP

Proyecto educativo de simulador de batallas Pokémon en Java usando **Programación Orientada a Objetos** con énfasis en **Static** y **Default**.


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



# Notas Programación II

## Programación orientada a objetos

### Abstracción

- La abstracción consiste en ocultar los detalles complejos de un objeto y mostrar solo las características esenciales que son relevantes para el contexto en el que se está trabajando.
- Te permite trabajar con ideas generales y dejar detalles en concreto para después o para otras partes del código

#### Ejemplo

- Desde la perspectiva del conductor: Solo necesita saber cómo acelerar, frenar y girar el volante. No necesita entender cómo funciona el motor o la transmisión.
- Desde la perspectiva del mecánico: Necesita conocer los detalles internos del motor, la caja de cambios, etc.

### Encapsulación

- Su objetivo principal es proteger los datos internos de un objeto y controlar cómo se accede a ellos y se modifican.

### Jerarquización

- Permite organizar clases en una estructura de padres e hijos (superclases y subclases) para reutilizar código, generalizar comportamientos y crear relaciones lógicas entre objetos.

#### Ejemplo

```java

class Vehiculo {
    private String marca;
    private int año;

    public Vehiculo(String marca, int año) {
        this.marca = marca;
        this.año = año;
    }

    public void arrancar() {
        System.out.println("El vehículo está arrancando...");
    }
}

// Subclase de Vehiculo (nivel intermedio)
class Coche extends Vehiculo {
    private int puertas;

    public Coche(String marca, int año, int puertas) {
        super(marca, año); // Llama al constructor del padre
        this.puertas = puertas;
    }

    public void abrirPuertas() {
        System.out.println("Abriendo " + puertas + " puertas.");
    }
}

// Subclase de Coche (nivel más específico)
class CocheElectrico extends Coche {
    private int autonomia;

    public CocheElectrico(String marca, int año, int puertas, int autonomia) {
        super(marca, año, puertas);
        this.autonomia = autonomia;
    }

    public void cargarBateria() {
        System.out.println("Cargando batería... Autonomía: " + autonomia + " km");
    }
}

public class Main {
    public static void main(String[] args) {
        CocheElectrico tesla = new CocheElectrico("Tesla", 2023, 4, 500);
        tesla.arrancar();      // Método heredado de Vehiculo
        tesla.abrirPuertas();  // Método heredado de Coche
        tesla.cargarBateria(); // Método propio
    }
}
```

### Modularidad

- Consiste en dividir un sistema complejo en partes más pequeñas, independientes y reutilizables (llamadas módulos). Cada módulo encapsula una funcionalidad específica y se comunica con otros módulos mediante interfaces bien definidas.

- Ejemplo:
  Un coche es un sistema complejo que puede dividirse en módulos (componentes) más simples, cada uno con una función específica:

1. Motor → Encargado de generar potencia.
2. Transmisión → Controla la velocidad y dirección.
3. Frenos → Detiene el vehículo.
4. Sistema de combustible → Alimenta al motor.
   Cada componente funciona de manera independiente, pero interactúa con los demás para que el auto funcione correctamente.

- Estos cuatro conceptos (AEJM), hacen que un código sea comprensible, escalable y flexible
- Un código al ser CEF -> permite reducir los costos de mantenimiento(Correctivo, perfectivo y adaptativo)
- Al reducir los costos de mantenimiento, se reducen los costos de desarrollo

## Leyes de Lheman y Belady

### Ley de cambio continuo

- Un programa que se usa en el ámbito del mundo real con el paso del tiempo, debe cambiar o convertirse menos útil.

### Ley de complejidad creciente

- Los programas cambian por evolución
- Este cambio hace que sus estructuras se hagan más complejas, al menos de que se hagan esfuerzos activos para evitar esto

## Conceptos

- Qué es una clase?
  Es una abstracción de datos y operaciones, que reúne las operaciones y datos de elementos de un universo de un mismo tipo

- Qué es un objeto?
  Es un ejemplar/instancia de una clase, por ende no es parte de una clase

- Definición atributo
  Un atributo es una característica, son los datos que definen una clase

- Las diferentes clases y objetos pueden tener vista pública o privada
- Vista pública: se define el nombre de la clase(entender las capacidades que se espera que la clase tenga), también se define las operaciones que debe hacer esa clase y por último se debe determinar qué tipo de dato void, double, int, etc.

```java
      public Ejemplo(PARÁMETROS){
        BLOQUE DE CÓDIGO
     }
```

Los objetos se pueden crear apartir de una clase, a esto se le conoce como instancia

- Definión instancia:
  Una instancia es un objeto que se ha creado a partir de una clase

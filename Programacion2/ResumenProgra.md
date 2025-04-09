# 🧠 Resumen - Programación II

## 🧱 Principios de la Programación Orientada a Objetos (POO)

### 1. Abstracción

- Oculta los detalles complejos y muestra solo lo esencial.
- Permite enfocarse en lo que realmente importa en cada contexto.
- **Ejemplo**: El conductor solo necesita saber cómo manejar el coche, no cómo funciona internamente.

### 2. Encapsulación

- Protege los datos internos de un objeto.
- Controla el acceso y modificación de los atributos.

### 3. Jerarquización (Herencia)

- Organización de clases en superclases y subclases.
- Facilita la reutilización de código y la generalización de comportamientos.

```java
// Ejemplo jerárquico:
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

class Coche extends Vehiculo {
    private int puertas;

    public Coche(String marca, int año, int puertas) {
        super(marca, año);
        this.puertas = puertas;
    }

    public void abrirPuertas() {
        System.out.println("Abriendo " + puertas + " puertas.");
    }
}

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
        tesla.arrancar();
        tesla.abrirPuertas();
        tesla.cargarBateria();
    }
}
```

### 4. Modularidad

- Divide un sistema complejo en partes más simples (módulos).
- Cada módulo es independiente y reutilizable.

**Ejemplo: Un coche como sistema modular:**

- **Motor** → Genera potencia.
- **Transmisión** → Controla velocidad y dirección.
- **Frenos** → Detiene el vehículo.
- **Sistema de combustible** → Alimenta al motor.

---

## 📉 Beneficios de AEJM

- Código más **Comprensible**, **Escalable** y **Flexible** (CEF).
- Reducción de **costos de mantenimiento** (correctivo, perfectivo y adaptativo).
- Menores **costos de desarrollo**.

---

## 📜 Leyes de Lehman y Belady

### Ley del cambio continuo

- Un programa en uso real debe cambiar o se volverá obsoleto.

### Ley de complejidad creciente

- Los programas tienden a volverse más complejos con el tiempo si no se controlan los cambios.

---

## 🧩 Conceptos Clave

- **Clase**: Abstracción que agrupa datos (atributos) y comportamientos (métodos).
- **Objeto**: Instancia de una clase.
- **Atributo**: Característica o propiedad de una clase.
- **Instancia**: Objeto creado a partir de una clase.

```java
public Clase(PARÁMETROS) {
    // Código del constructor
}
```

## 📚 Resumen: Manejo de Objetos en Java

### 🔸 Vista pública de los objetos

Los objetos en Java se crean y manejan usando tres acciones fundamentales:

- **Creación**: usar `new` para crear instancias de una clase.
- **Referencia**: almacenar la dirección del objeto en una variable.
- **Interacción**: usar esa referencia para enviar mensajes (llamar métodos).

### 🛠️ Creación de objetos

Se usa el operador `new`, que reserva espacio en memoria y llama al constructor correspondiente.

**Sintaxis**:

```java
new Clase([argumentos]);

Calculadora calculadora = new Calculadora();
// Calculadora -> Nombre de la clase
// calculadora -> Nombre de la variable
// new -> instancia una clase nueva
// Calculadora (); -> Constructor de una clase
// Ejemplo de constructor de una clase -> Coche miCoche = new Coche();  // Llama al constructor de Coche automáticamente
```

## 🔐 Vista Privada de los Objetos

### 📦 Desencadenamiento de Instanciaciones (Creación de Objetos)

- Se asigna memoria para los atributos definidos en la clase.
- Se inicializan los atributos (valores por defecto o explícitos).
- Puede provocar la creación de nuevos objetos.
- Se ejecuta el constructor del objeto.
- Recursivamente, pueden crearse objetos de otras clases hasta llegar a tipos primitivos.
- Los bloques `static` se ejecutan **una sola vez** cuando la clase se carga, **antes de cualquier instanciación**.

### 📩 Desencadenamiento de Mensajes (Invocación de Métodos)

- Se crean variables locales y se ejecuta el cuerpo del método.
- Se pueden enviar mensajes a:
  - Atributos de la clase
  - Objetos pasados como argumentos
  - Objetos creados durante la ejecución del método
- Recursivamente, pueden invocarse más métodos hasta llegar a los que usan tipos primitivos.
- El contexto `this` se establece en cada invocación, permitiendo acceder a los atributos del objeto receptor.

## 🔐 Vista Privada de las Clases en Java

### 1. Definición de Atributos

- Declarados con `private`.
- Tipos:
  - Constantes
  - Tipos primitivos
  - Referencias a objetos
  - Vectores de objetos

```java
private int contador;
private String mensaje;
private double[] valores;

```

## 🔐 Vista Privada de las Clases en Java

### 1. Definición de Atributos

- Declarados con `private`.
- Tipos:
  - Constantes
  - Tipos primitivos
  - Referencias a objetos
  - Vectores de objetos

```java
private int contador;
private String mensaje;
private double[] valores;
```

## 2. Constructores

- **Inicializan atributos del objeto**.
- **Previenen objetos inconsistentes**.
- **Reutilización mediante `this(...)`**.

**Ejemplo**:

```java
public Calculadora(int capacidad) {
    numeros = new double[capacidad];
    posicionActual = 0;
    error = false;
    mensajeError = "";
}

public Calculadora() {
    this(10);
}
```

## 3. Métodos

- Contienen **operaciones secuenciales**, **condicionales**, **iterativas**.
- Acceden a **atributos**, **parámetros** y **variables locales**.

**Ejemplo**:

```java
public void ingresarNumero(double valor) {
    if (posicionActual < numeros.length) {
        numeros[posicionActual] = valor;
        posicionActual++;
    } else {
        error = true;
        mensajeError = "MEMORIA LLENA!!!";
    }
}
```

## 4. Referencia `this`

- **Referencia al objeto actual**.
- Uso:
  - Resolver **ambigüedad con nombres**.
  - **Reutilizar constructores**.
  - **Reutilizar métodos**.

**Ejemplo**:

```java
this.min = min;
this.max = max;
this.includes(valor);
this(10);
```

## 5. Métodos privados

- **Uso interno** en la implementación de la clase.
- Sirven para **reutilizar lógica** sin exponerla.

**Ejemplo**:

```java
private double[] extraerOperandos(int numeroOperandos) {
    double[] operandos = new double[numeroOperandos];
    for (int i = 0; i < numeroOperandos; i++) {
        operandos[i] = extraeOperando();
    }
    return operandos;
}
```

## 🌐 Vista Pública de las Clases en Java

### 🧱 Sintaxis básica de clase

```java
class NombreClase {
    // Atributos y métodos
}
```

## 🔧 Cabecera de Métodos

```java
public <TipoRetorno> nombreMetodo(<TipoParam> parametro, ...)
```

## El tipo de retorno (TipoRetorno) puede ser:

- `void`: no devuelve nada.
- Tipo primitivo (`int`, `double`, etc.) o clase (`String`, etc.).
- Arreglo: `<tipo>[]` o matriz `<tipo>[][]`.

- El nombre del método debe comenzar con **minúscula**.

- Los **parámetros** se pasan por valor.

### 🧠 Importante sobre objetos:

- Cuando pasas un **objeto**, se pasa una **copia de la referencia**.
- Se puede **modificar el objeto dentro del método**.
- No se puede hacer que la **referencia original** apunte a otro objeto.

## ➕ Sobrecarga de Métodos

- Se pueden definir varios métodos con el mismo nombre si se **diferencian en tipos o número de parámetros**.
- Si están en **diferentes clases**, no hay restricciones.

**Ejemplo**:

```java
public void metodo(int a)
public void metodo(String texto)
```

## 🏗️ Constructores

- Son **métodos especiales** que se llaman al **crear objetos**.
- Se usan para **inicializar atributos**.
- Tienen el **mismo nombre que la clase** y **no retornan nada** (ni siquiera `void`).

**Ejemplo**:

```java
public NombreClase() {
    // Inicialización
}
```

## 🧹 Destructores (`finalize`)

- Método que se llama cuando un objeto es **destruido**.
- **Muy poco usado en Java**.

**Firma**:

```java
public void finalize()
```

### 🔍 ¿Por qué casi no se usan?

- Java tiene **recolección automática de basura**.
- Es mejor gestionar **manualmente recursos** como archivos o conexiones si se necesitan cerrar explícitamente.

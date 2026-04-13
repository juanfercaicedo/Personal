# Introducción a la construcción

## ¿Qué va primero, Ordernar o Buscar?
- Tenemos que tratar de optimizar una búsqueda
    - Se lo hace bajando la complejidad
- Siempre tenemos que tratar de bajar la complejidad a una O(1), la más simple de todas

---

- **Construcción:** Implica que las cosas llegan secuencialmente de una en una
    - La información llega de poco a poco
- Como construir para tratar de ordenar algo
    - Para construir algo te deben ir llegando información
- Notación Big O - Complejidad
- En arrays
    - Insertar datos es complejidad O(1), ya que es inmediata
    - En cambio buscar un dato es más complejo, hay que recorrer elemento por elemento para encontrarlo
        - Complejidad O(n)

### Tabla de Complejidades de Big O

| Notación | Nombre | Calificación | ¿Qué significa? | Ejemplo Clásico |
| :--- | :--- | :--- | :--- | :--- |
| **$O(1)$** | Constante | Excelente | El tiempo de ejecución es el mismo sin importar cuántos datos haya. | Acceder a un elemento en un array usando su índice (`array[5]`). |
| **$O(\log n)$** | Logarítmica | Muy Buena | El tiempo crece muy lentamente, dividiendo el problema a la mitad en cada paso. | Búsqueda binaria en una lista que ya está ordenada. |
| **$O(n)$** | Lineal | Buena | El tiempo crece de forma directamente proporcional a la cantidad de datos. | Recorrer un array completo con un bucle `for`. |
| **$O(n \log n)$** | Linealítmica | Decente | Un poco peor que lineal, suele aparecer al dividir datos y luego ordenarlos. | Algoritmos eficientes de ordenamiento como *Merge Sort* o *Quick Sort*. |
| **$O(n^2)$** | Cuadrática | Mala | El tiempo crece exponencialmente de forma moderada al cuadrado de los datos. | Bucles anidados (un `for` dentro de otro `for`); algoritmos lentos como *Bubble Sort*. |
| **$O(2^n)$** | Exponencial | Pésima | El tiempo se duplica con cada elemento adicional que agregas. Inviable para muchos datos. | Calcular la secuencia de Fibonacci con recursividad simple sin optimizar. |
| **$O(n!)$** | Factorial | Desastrosa | La peor de todas. Agrega un solo dato y el tiempo de ejecución explota geométricamente. | Generar todas las combinaciones o permutaciones posibles de una lista (El problema del viajante). |

---

# Guía de Complejidad: Arrays vs. Listas en Java

## 1. Array Desordenado
Es la estructura más simple. Los datos se añaden conforme llegan.

| Operación | Complejidad | Razón |
| :--- | :--- | :--- |
| **Inserción** | $O(1)$ | Se añade al final de la última posición ocupada. |
| **Búsqueda** | $O(n)$ | Hay que revisar uno por uno (Búsqueda Lineal). |

### Ejemplo en Java:
```java
public class ArrayDesordenado {
    int[] array = new int[10];
    int size = 0;

    // Inserción: O(1)
    public void insertar(int valor) {
        if (size < array.length) {
            array[size] = valor;
            size++;
        }
    }

    // Búsqueda: O(n)
    public int buscar(int valor) {
        for (int i = 0; i < size; i++) {
            if (array[i] == valor) return i; // Encontrado
        }
        return -1; // No encontrado
    }
}
```

---

## 2. Array Ordenado
Los datos se mantienen en un orden específico (ej. de menor a mayor).

| Operación | Complejidad | Razón |
| :--- | :--- | :--- |
| **Inserción** | $O(n)$ | Hay que buscar el sitio y **desplazar** los elementos a la derecha. |
| **Búsqueda** | $O(\log n)$ | Al estar ordenado, podemos usar **Búsqueda Binaria**. |



### Ejemplo en Java:
```java
public class ArrayOrdenado {
    int[] array = new int[10];
    int size = 0;

    // Inserción: O(n) debido al desplazamiento
    public void insertar(int valor) {
        int i;
        for (i = size - 1; (i >= 0 && array[i] > valor); i--) {
            array[i + 1] = array[i]; // Desplazar a la derecha
        }
        array[i + 1] = valor;
        size++;
    }

    // Búsqueda: O(log n) usando Búsqueda Binaria
    public int buscar(int valor) {
        int inicio = 0, fin = size - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (array[medio] == valor) return medio;
            if (array[medio] < valor) inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1;
    }
}
```

---

## 3. Lista Desordenada (Linked List)
Nodos dispersos en memoria conectados por punteros.

| Operación | Complejidad | Razón |
| :--- | :--- | :--- |
| **Inserción** | $O(1)$ | Se inserta siempre al principio (Cabeza) de la lista. |
| **Búsqueda** | $O(n)$ | Hay que seguir los punteros uno a uno. |



### Ejemplo en Java:
```java
class Nodo {
    int dato;
    Nodo siguiente;
    Nodo(int d) { dato = d; siguiente = null; }
}

public class ListaDesordenada {
    Nodo cabeza = null;

    // Inserción: O(1) al inicio
    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
    }

    // Búsqueda: O(n)
    public boolean buscar(int valor) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) return true;
            actual = actual.siguiente;
        }
        return false;
    }
}
```

---

## 4. Lista Ordenada (Linked List)
Nodos conectados por punteros, manteniendo un orden.

| Operación | Complejidad | Razón |
| :--- | :--- | :--- |
| **Inserción** | $O(n)$ | Hay que recorrer la lista para encontrar el lugar correcto. |
| **Búsqueda** | $O(n)$ | **No hay acceso aleatorio**, no se puede hacer búsqueda binaria. |



### Ejemplo en Java:
```java
public class ListaOrdenada {
    Nodo cabeza = null;

    // Inserción: O(n) - Hay que buscar el lugar para mantener el orden
    public void insertar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null || cabeza.dato >= nuevo.dato) {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null && actual.siguiente.dato < nuevo.dato) {
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual.siguiente;
            actual.siguiente = nuevo;
        }
    }

    // Búsqueda: O(n) - Sigue siendo lineal pese a estar ordenada
    public boolean buscar(int valor) {
        Nodo actual = cabeza;
        while (actual != null && actual.dato <= valor) {
            if (actual.dato == valor) return true;
            actual = actual.siguiente;
        }
        return false;
    }
}
```

---

## Resumen Comparativo Final

| Estructura | Inserción | Búsqueda | ¿Por qué? |
| :--- | :--- | :--- | :--- |
| **Array Desordenado** | $O(1)$ | $O(n)$ | Rápido insertar (al final), lento buscar (lineal). |
| **Array Ordenado** | $O(n)$ | **$O(\log n)$** | Lento insertar (desplazamiento), **Rápido buscar (binaria)**. |
| **Lista Desordenada**| **$O(1)$** | $O(n)$ | **Muy rápido insertar (al inicio)**, lento buscar. |
| **Lista Ordenada** | $O(n)$ | $O(n)$ | Lento insertar y lento buscar (sin acceso aleatorio). |
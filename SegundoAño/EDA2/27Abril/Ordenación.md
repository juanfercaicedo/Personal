- Olog(n) es el coste de ordenar en un BST
---
# Ordenación
## Algorítmos de Inserción
- **Construcción** con orden garantiza búsqueda eficiente, pero exige controlar como llegan los datos
    - Coste de inserción **alto**
- **Ordenar**: Imponer una invariante
    - Planetamos un criterio de orden, y aplicamos ese criterio a una colección de elementos
- **Reordenar**: Actúa sobre un conjunto completo y estático: Toma lo que hay y lo reorganiza

### Ordenación por comparación
- Sentramos en dos elementos y aplicamos una operación
    - Complejidad -> O(n log n)

### Insert Sort

- **Concepto principal:** Construye el array ordenado elemento por elemento. Divide lógicamente el array en una parte ordenada (izquierda) y otra desordenada (derecha), tomando elementos de la desordenada e insertándolos en la posición correcta de la ordenada.
- Partimos de O(n log n) como coste de referencia conocido (límite teórico para algoritmos por comparación avanzados). Insertion sort no alcanza esto en su caso general, pero tiene otras fortalezas.
- Comparamos en un array:

```java
public static void ordenar(int[] array){
    for(int i = 1; i < array.length; i++){
        int actual = array[i];
        int j = i - 1;
        while(j >= 0 && array[j] > actual){
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = actual;
    }
}
```
- Complejidad Temporal 
---
| Estados de los datos | Comparaciones | Complejidad |
| :--- | :--- | :--- |
| Ordenados | n - 1 | O(n) |
| Inversamente Ordenados | n(n - 1)/2 | O(n²) |
| Aleatorios | ~n²/4 en promedio | O(n²) |

- Complejidad Espacial: O(1)

- **Ventajas**
- No duplica la memoria: Modifica los datos directamente en el array original (In-place), por lo que su complejidad espacial es O(1).

- Es Estable: No altera el orden relativo de los elementos que tienen el mismo valor (clave si ordenas objetos complejos por un solo atributo).

- Es Adaptativo: Su rendimiento mejora drásticamente si los datos ya están casi ordenados (acercándose a O(n)).


- Rápido en listas pequeñas: Tiene muy poca sobrecarga (overhead). Para arrays muy pequeños (menos de 15-20 elementos), es más rápido que los algoritmos O(n log n) como Quick Sort o Merge Sort.

**- Desventajas**
- Inescalable para grandes volúmenes: Al ser O(n²) en su caso promedio y peor, el tiempo de ejecución se dispara rápidamente con arrays grandes.

- Exceso de escrituras: En el peor de los casos (array ordenado al revés), tiene que desplazar demasiados elementos uno a uno, lo que supone muchas operaciones de escritura en memoria.

Aquí tienes el bloque completo para **Merge Sort** (Ordenamiento por Mezcla), siguiendo exactamente la misma estructura para que tus apuntes mantengan la coherencia. 

Este es el algoritmo que marca el estándar del coste **O(n log n)** del que hablábamos al principio.

### Merge Sort

- **Concepto principal:** Utiliza el paradigma **"Divide y Vencerás"** (*Divide and Conquer*). Divide el array por la mitad de forma recursiva hasta obtener subarrays de 1 solo elemento (un array de 1 elemento ya está ordenado por definición). Luego, va "fusionando" (*merging*) esos pequeños arrays en arrays más grandes y ordenados, hasta reconstruir el array original completo.



- Comparamos en un array:

```java
public static void mergeSort(int[] array, int inicio, int fin) {
    if (inicio < fin) {
        int medio = (inicio + fin) / 2;
        
        // Dividir la primera y segunda mitad
        mergeSort(array, inicio, medio);
        mergeSort(array, medio + 1, fin);
        
        // Fusionar las mitades ordenadas
        merge(array, inicio, medio, fin);
    }
}

// Método auxiliar para fusionar
private static void merge(int[] array, int inicio, int medio, int fin) {
    int n1 = medio - inicio + 1;
    int n2 = fin - medio;

    int[] izquierda = new int[n1];
    int[] derecha = new int[n2];

    // Copiar datos a los arrays temporales
    for (int i = 0; i < n1; i++) izquierda[i] = array[inicio + i];
    for (int j = 0; j < n2; j++) derecha[j] = array[medio + 1 + j];

    // Índices iniciales de los subarrays y del array fusionado
    int i = 0, j = 0, k = inicio;

    // Fusionar de vuelta al array original
    while (i < n1 && j < n2) {
        if (izquierda[i] <= derecha[j]) {
            array[k] = izquierda[i];
            i++;
        } else {
            array[k] = derecha[j];
            j++;
        }
        k++;
    }

    // Copiar los elementos restantes (si quedan)
    while (i < n1) { array[k++] = izquierda[i++]; }
    while (j < n2) { array[k++] = derecha[j++]; }
}

// Nota: Para usarlo inicialmente se llama con: mergeSort(array, 0, array.length - 1);
```

- **Complejidad Temporal** ---
| Estados de los datos | Comparaciones | Complejidad |
| :--- | :--- | :--- |
| Ordenados | ~ n log n | O(n log n) |
| Inversamente Ordenados | ~ n log n | O(n log n) |
| Aleatorios | ~ n log n | O(n log n) |

- **Complejidad Espacial:** **O(n)** (Requiere memoria adicional para los arrays temporales de la fusión).

#### Ventajas 
- **Rendimiento garantizado:** Su complejidad es siempre O(n log n) sin importar si los datos están ordenados, invertidos o aleatorios. No tiene un "peor caso" de O(n²) como el Quick Sort.
- **Es Estable:** Mantiene el orden relativo de los elementos con el mismo valor (la condición `izquierda[i] <= derecha[j]` en la fusión garantiza esto).
- **Ideal para grandes volúmenes de datos:** Es extremadamente escalable.
- **Excelente para Listas Enlazadas (Linked Lists):** En estructuras donde el acceso no es secuencial, Merge Sort brilla por encima de otros algoritmos, y en esos casos puede llegar a ser O(1) en espacio.

#### Desventajas
- **Uso extra de memoria:** No es un algoritmo *In-place*. La creación constante de arrays temporales (`izquierda` y `derecha`) requiere una memoria auxiliar equivalente al tamaño del array original, lo que lo hace O(n) en espacio espacial.
- **Sobrecarga (Overhead) en arrays pequeños:** Debido a la recursividad y a la creación de arrays auxiliares en cada paso, es más lento que Insertion Sort para conjuntos de datos muy pequeños.

### Quicksort

- **Concepto principal:** Al igual que Merge Sort, utiliza **"Divide y Vencerás"**. La clave de este algoritmo es elegir un elemento del array llamado **pivote**. Luego, reorganiza el array de manera que todos los elementos menores que el pivote queden a su izquierda y todos los mayores queden a su derecha (este proceso se llama *partición*). Finalmente, aplica este mismo proceso de forma recursiva a las sublistas izquierda y derecha.

- Comparamos en un array:

```java
public static void quickSort(int[] array, int inicio, int fin) {
    if (inicio < fin) {
        // Obtenemos el índice del pivote ya colocado en su posición final
        int indicePivote = particion(array, inicio, fin);
        
        // Ordenamos recursivamente los elementos a la izquierda y derecha del pivote
        quickSort(array, inicio, indicePivote - 1);
        quickSort(array, indicePivote + 1, fin);
    }
}

// Método auxiliar para realizar la partición (usando el último elemento como pivote)
private static int particion(int[] array, int inicio, int fin) {
    int pivote = array[fin]; 
    int i = (inicio - 1); // Índice del elemento más pequeño
    
    for (int j = inicio; j < fin; j++) {
        // Si el elemento actual es menor o igual al pivote
        if (array[j] <= pivote) {
            i++;
            // Intercambiamos array[i] y array[j]
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    
    // Colocamos el pivote en su posición correcta intercambiándolo con array[i+1]
    int temp = array[i + 1];
    array[i + 1] = array[fin];
    array[fin] = temp;
    
    return i + 1;
}

// Nota: Para usarlo inicialmente se llama con: quickSort(array, 0, array.length - 1);
```

- **Complejidad Temporal** ---
| Estados de los datos | Comparaciones | Complejidad |
| :--- | :--- | :--- |
| Mejor Caso (Pivote divide justo por la mitad) | ~ n log n | O(n log n) |
| Peor Caso (Ordenados/Inversos con mal pivote) | n(n - 1)/2 | O(n²) |
| Aleatorios (Caso promedio) | ~ n log n | O(n log n) |

- **Complejidad Espacial:** **O(log n)** en promedio (debido a la pila de llamadas recursivas). En el peor de los casos, la pila de recursión puede llegar a O(n).

#### Ventajas 
- **Extremadamente rápido en la práctica:** Aunque teóricamente tiene la misma complejidad promedio que Merge Sort, Quick Sort suele ser más rápido en el mundo real porque sus bucles internos son muy eficientes y aprovecha de maravilla la memoria caché de la CPU.
- **Eficiencia espacial (*In-place*):** A diferencia de Merge Sort, no necesita crear grandes arrays temporales. Solo utiliza un poco de memoria en la pila para la recursividad.

#### Desventajas
- **Peor caso catastrófico:** Si el array ya está ordenado (o casi ordenado) y siempre elegimos el último o primer elemento como pivote, el rendimiento cae en picado a O(n²). (Para evitar esto en aplicaciones reales, el pivote suele elegirse al azar o calculando la mediana).
- **No es Estable:** El proceso de partición y los intercambios pueden alterar el orden original de los elementos que tengan el mismo valor.
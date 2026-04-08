# SEND + MORE = MONEY
## ¿Cómo funciona?

El núcleo de la solución se basa en el algoritmo de Backtracking. Consiste en una búsqueda sistemática de prueba y error mediante recursividad.

Imagina que el programa está recorriendo un laberinto de posibilidades:
1. Avanza asignando el primer número disponible a una letra.
2. Continúa avanzando hacia la siguiente letra.
3. Si llega a una combinación que rompe las reglas matemáticas (un callejón sin salida), da un paso atrás (**backtrack**), cambia el número de la última letra y vuelve a intentarlo.



## Estructura y Lógica del Código

### 1. Variables de Estado
* `LETRAS`: Arreglo que define el orden de procesamiento de las 8 letras únicas.
* `valores`: Arreglo que utiliza el valor de los caracteres (`char`) como índice para almacenar el dígito asignado a cada letra.
* `digitoAsignado`: Arreglo booleano (0-9) que actúa como registro. Garantiza la regla principal: dos letras diferentes no pueden tener el mismo valor numérico.

### 2. Recursividad y Backtracking (`resolver`)

El método `resolver(int indice)` es el motor del algoritmo y se divide en dos partes clave:

* **Caso Base:**
    ```java
    if (indice == LETRAS.length) {
        return esSumaValida();
    }
    ```
    La recursividad se detiene cuando `indice` llega a 8 (el tamaño del arreglo de letras). Esto significa que todas las letras ya tienen un número asignado provisionalmente. En este punto, el programa llama a `esSumaValida()` para evaluar si esa combinación en particular es la respuesta correcta.

* **Caso Recursivo y Backtracking:**
    ```java
    // ...
    valores[letraActual] = digito;        // 1. Asigna el número
    digitoAsignado[digito] = true;        // 2. Lo marca como ocupado

    if (resolver(indice + 1)) {           // 3. Llamada Recursiva (avanza a la siguiente letra)
        return true;
    }

    valores[letraActual] = -1;            // 4. BACKTRACKING: Deshace la asignación
    digitoAsignado[digito] = false;       // 5. Libera el número para probar el siguiente
    // ...
    ```
    Si no se ha llegado al caso base, el programa prueba los números del 0 al 9. Cuando encuentra uno libre, hace la **llamada recursiva** para la siguiente letra (`indice + 1`). Si esa rama falla y devuelve `false`, ejecuta el **Backtracking**: limpia la variable, libera el dígito y el ciclo `for` avanza al siguiente número.

### 3. Validación y Restricciones (`esSumaValida`)
Verifica si el estado actual del árbol de búsqueda es correcto basándose en dos reglas:
1.  **Restricción de Ceros a la Izquierda:** Los números formados no pueden empezar con cero (`valores['S'] == 0` o `valores['M'] == 0`).

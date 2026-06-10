# Estructura de datos y algorítmos 2
## Algorítmos
- Procedimientos o fórmulas para resolver un problema
- **Complejidad del tiempo**: Operaciones necesarias para completar algo
- **Complejidad del espacio**: La cantidad de memoria RAM que necesita un algorítmo para completar algo
- Para resolver los problemas de la complejidad podemos usar diferentes estrategias: 
    - Fuerza Bruta: Probar todas las posibilidades O(n)
    - Divide y conquistarás: Dividir el problema en problemas más pequeños (log n)
    - Voraces: Tomar la mejor decisión en el paso actual esperando que no lleve a lo más óptimo
    - Backtracking: Explorar un árbol de soluciones y retroceder cuando nos demos cuenta que el camino no sirve
    - Programación dinámica: Descomponer en subproblemas, pero ir guardando los resultados intermedios(memoization) para no calcular dos veces lo mismo

- [Notación Big(O)](./README.md)
---
## Recursividad
- **Caso Base**: Detiene las llamadas recursivas
    - Devuelve un valor
    - El caso más sencillo es el caso vacío
- **Caso Recursivo**: Método que se llama a sí mismo para resolver un problema
- Nuestro objetivo es reducir grados que tienden al caso base
    - (n - 1) -> tendiendo a nuestro caso base
    - donde n es la cantidad de elementos que se tiene que procesar
- Cuando no llegamos al caso base en java, se produce el famoso: `StackOverflowError` 
- ***Cuatro categorías que capturan distinciones fundamentales***:
- **Secuencial**: Procesos con progresión temporal o lógica determinada(Ej: Evaporación del agua)
- **Recurrente**: Se repite pero sin patrón fijo (Ej: Terremotos)
- **Iterativo**: Tiene el mismo patrón pero cada suceso es independiente al anterior (Ej: Latídos del corazón) / (En código búcles for y while)
- **Recursivo**: Estructura que se contiene a sí misma
    - Una función recursiva se elije porqué es el reflejo en código de la estructura del dato
- ### Método tabular
- Para encontrar patrón matemático dentro de la función
- Un esquema tabular de dos columnas
    - Una para la entrada (n)
    - Y otra para el resultado f(n)
- El proceso siempre es lo mismo:
1. Definir el caso base
2. Alejarse del caso base
3. Descender un orden (n - 1)
4. Observar en aspa
- Ejemplo(Factorial):
    - Queremos multiplicar todos los números desde 1 hasta n
        - Pasos:
        1. Definimos el caso base
            - Si n = 0, 0! = 1
        2. Nos alejamos del caso base, por ejemplo n = 5
            - 5! = 120
        3. Descendemos un orden
            - 4! = 24
        4. Método del aspa
            - Para llegar a el resultado de 5!, debemos multiplicar el resultado anterior por :
            - 24 * 5 = 120
        - Por lo tanto la conclusión final es:
            - f(n) = n * (n - 1)
- ¿Cómo identificar un caso base?
```java
static void resolver(int n, char origen, char destino, char auxiliar) {
    // 1. EL CASO BASE
    if (n == 1) {
        System.out.println("Mover disco 1 de " + origen + " a " + destino);
        return; // Detiene la recursión
    }

    // 2. LAS LLAMADAS RECURSIVAS
    resolver(n - 1, origen, auxiliar, destino); // Paso A: Mover n-1 a auxiliar
    System.out.println("Mover disco " + n + " de " + origen + " a " + destino); // Paso B
    resolver(n - 1, auxiliar, destino, origen); // Paso C: Mover n-1 de auxiliar a destino
}
```
- Un caso recursivo siempre:
    - Siempre va a tener una condición
    - NUNCA se vuelve a llamar a sí mismo
---
## Orden y búsqueda
- El order no es el objetivo, es una condición para poder realizar búsquedas de forma eficiente
- Cuando necesitamos una colección de datos a la que le vamos a realizar consultas debemos considerar dos cosas:
    - **Sin orden**: Podemos insertar más rápido O(1) pero al momento de realizar una búsqueda O(n)
    - **En orden**: Insertar un dato nuevo implica una complejidad O(n), realizar una búsqueda O(log n)
- Listas Enlazadas:
    - Listas Enlazadas Ordenadas:
        - Búsqueda tiene un costo de O(n)
        - Inserción de un dato nuevo O(n)
    - Listas Enlazadas No ordenadas:
        - Inserción de datos nuevos tiene un costo de O(1)
        - Busqueda tiene un costo de O(n)
        - No tiene acceso aleatorio
- Arrays
    - Array ordenado:
        - Búsqueda tiene un costo de O(log n)
        - Inserción tiene un costo de O(n)
    - Array no ordenado:
         - Los elementos se guardan de forma desordenada
         - Inserción es O(1)
         - Búsqueda es O(n), lo podemos hacer una búsqueda O(log n), porque necesitamos que los datos esten ordenados
         - Tiene acceso por índice
- BST(Binary Search Tree):
    - Es un árbol donde cada elemento es un nodo, cada nodo almacena un valor y tiene dos referencias: izquierdo y derecho
    - Para que sea un árbol tiene que cumplir:
        - Todo lo que esté en el lado izquiero debe ser menor al valor de su padre
        - Todo lo que esté en el lado derecho debe ser mayor al valor de su padre 
        - Para insertar un dato tenemos que buscar un hueco vacío
            - Si el dato a insertar es menor al padre se va a la izquiera, si es mayor se va a la derecha
    - Insertar un dato tiene un coste de O(log n)
    - No tiene acceso aleatorio
- Nuestra decisión de si ordenar los datos o no depende: 
    -  ¿Vamos a hacer más de una búsqueda?
--- 
### Ordenación
- Tenemos dos algorítmos de ordenación
1. Algorítmos por comparación
    - Son aquellos que se ordenan comparándose entre sí
    - Es A < B?
    - Ningún algorítmo por comparación puede ser más rápido que O(n log n)
    - Tenemos tres algorítmos:
        1. Insertion Sort: Va elemento a elemento comparando y arrastrando hacia atrás para colocarlo en su sitio. Su coste es de O(n²)
        2. Merge Sort: Corta el array por la mitad hasta llegar a elementos individuales, luego los fusiona en orden lineal. Garantiza O(n log n)
        3. Quicksort: Elige un elemento llamado pivote, coloca a los menores en un lado y a los mayores en otro, repitiendolo recursivamente, si elige mal el pivote el peor caso es O(n²) y en su caso promedio es O(n log n)

2. Algorítmos por conocimiento
- Logran una velocidad lineal O(n)
- Tiene dos algorítmos:
    1. Counting Sort: Cuántas veces aparece cada número usando un array auxiliar de frecuencias y luego reconstruye el array directamente ordenado 
    2. Radix Sort: Ordena los números procesando sus dígitos uno a uno sueltos (primero las unidades, luego las decenas, luego las centenas...), apoyándose habitualmente en un Counting Sort estable.

---
## Hashing 
- Integridad de datos: 
    - Su objetivo es obtener una huella digital única de información
    - Tiene dos restricciones:
        - Unidireccionalidad
        - Resistencia a colisiones 
- Tabla Hash: 
    - Estructura para guardar parejas Clave-Valor
- Toma una entrada de tamaño de una variable y lo transforma en una salida de tamaño fijo
- **Propiedades función hash**:
1. **Determinista**: La función siempre debe devolver el mismo resultado
2. **Eficiente(Rápida)**: Calcular una operación hash debe ser computacionalmente muy barata, idealmente O(1)
3. **Uniforme**: Debe distribuir los resultados de forma aleatoria y homogénea, para evitar que mchas datos caigan en el mismo sitio
4. **Efecto Avalancha**: Si cambiamos un solo bit al valor de entrada por ejemplo una letra mayúscula por una minúscula, el hash resultante debe cambiar de forma drástica
- Hay dos soluciones para evitar colisiones, encadenamiento directo(no guarda los valores en un array si no en una lista enlazada) y direccionamiento cerrado (cada casilla puede albergar únicamente un elemento)
---
## Inmutabilidad
- Un objeto inmutable es aquel cuyo estado interno no puede cambiar jamás despues de haber sido creado
- Ofrece seguridad absoluta
- Se hace mediante clases final, atributos private y final, no podemos utilizar setters 
- Para cambiar un dato se realiza una transformación, calculamos el nuevo estado y devolvemos una instancia nueva con el dato cambiado, dejando la antigua intacta



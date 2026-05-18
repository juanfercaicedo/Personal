## Hashing
- La función hash es el mapa que te dice exactamente en qué "cajón" está guardada la información, sin tener que abrir todos los cajones.

## 1. El Valor Hash (Digest)

El valor hash es el resultado de pasar una entrada (un nombre, un archivo, un número) por una **función hash**. Imagínalo como una "huella digital" única para ese dato.

### Propiedades clave:

* **Determinismo:** Si le das la misma entrada hoy o en un año, el valor hash será siempre el mismo.
* **Longitud fija:** No importa si la entrada es una palabra o un libro entero; el resultado suele tener el mismo tamaño (por ejemplo, 64 caracteres).
* **Irreversibilidad:** No puedes obtener el dato original a partir del valor hash. Es un camino de una sola vía.

---

## 2. Tablas Hash (Hash Tables)

Una tabla hash es una estructura de datos que organiza la información en pares de **llave (key)** y **valor (value)**. Es como un diccionario gigante donde puedes saltar directamente a la página que buscas.

### ¿Cómo funciona el proceso?

1. **Entrada:** Quieres guardar el teléfono de "Juan". La llave es "Juan".
2. **Función Hash:** Se aplica la función a "Juan" y esta devuelve un número (ej. `4`).
3. **Almacenamiento:** El teléfono de Juan se guarda en la "cubeta" o índice `4` de la tabla.
4. **Búsqueda:** Cuando quieras el dato de "Juan", la función volverá a dar el `4`, y el sistema irá directo allí sin revisar el resto de la tabla.

---

## 3. El problema de las Colisiones

A veces, la función hash puede devolver el mismo número para dos entradas distintas (ej. "Juan" y "Maria" ambos dan `4`). Esto se llama **colisión**.

Existen dos formas principales de resolverlas:

* **Encadenamiento (Chaining):** En el índice `4` se crea una lista enlazada donde se guardan ambos elementos.
* **Direccionamiento Abierto:** El sistema busca el siguiente espacio vacío disponible en la tabla.

---

## Resumen técnico

En matemáticas discretas, verás que la eficiencia de una tabla hash se mide por su **factor de carga** ($\alpha$):

$$\alpha = \frac{n}{m}$$

Donde:

* $n$ es el número de elementos insertados.
* $m$ es el tamaño de la tabla (número de espacios disponibles).

Si $\alpha$ es bajo, la tabla es rápida; si es cercano a 1 (o mayor en encadenamiento), las colisiones aumentan y el rendimiento baja.

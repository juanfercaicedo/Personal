- Una pirámide es una pirámide con una base de abajo
- Caso base:
    - El caso base no tiene recursión
    - En una pirámide el caso base es un tamaño, porque sabe cuando "deternse"
    - **Caso base detiene**
    - Otro caso base es cuando una tabla de datos está vacía

## Factorial
- Ejemplo caso base:
    -  Tabla de Trazabilidad: Recursividad

| $n$ | $f(n)$ | ¿Caso Base? | Observaciones |
| :---: | :---: | :---: | :--- |
| **0** | 1 | **SÍ** | **Punto de parada.** La función retorna el valor directamente. |
| **1** | 1 | **NO** | Realiza la llamada recursiva a $f(0)$ antes de resolver. |
| **2** | $f(1) \dots$ | **NO** | Caso recursivo general. |

---
    - Mientras menos casos base es mejor
- Cuando estemos en lista no decimos "restamos", decimos "reducimos un grado, tendiendo hacia el caso base"

## Contar números
- Ejemplo contar números

| n | f(n) |
| :---: | :---: |
| 1 | 1 | -> Caso base
|  - | -  |1
| 19  | 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 |
| 25  |1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25   |   

- `1` es el caso base
---
## Invertir una cadena de texto
| n | f(n) |
| :---: | :---: |
|   -   |   -   |
|   abcd   |   dcba   |
|   abcde   |   edcba   |
- f(n-1) + n

---

## Contar la cantidad de veces que aparece una letra en una cadena
- Caso base: Que la cadena esté vacía

| n | f(n) |
|:---:|:---:|
| " " , a   |   0   |
| "so"      |   0   |
|   "sol"   |   0    |
- Caso base: Cadena vacía y se busca la letra `a`.
- Si la cola no es igual a `a`, el resultado es f(n-1)
cola = a -> 1+f(n-1)

---

- Repo clase: [Recursividad](https://github.com/mmasias/EDA2/tree/main/temario/002-recursividad/bateria)
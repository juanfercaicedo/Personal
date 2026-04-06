## ¿Qué es backtracking?

Backtracking ("volver hacia atrás") es una técnica para resolver problemas en los que:

* Hay varias opciones posibles en cada paso.
* Se prueba una opción.
* Si esa opción no lleva a una solución, se deshace.
* Entonces se intenta otra opción.

La idea general es:

1. Elegir una posibilidad.
2. Avanzar.
3. Si funciona, continuar.
4. Si no funciona, volver atrás.
5. Probar otra posibilidad.

---

# Tu ejemplo del laberinto

Tu programa intenta encontrar un camino desde la esquina superior izquierda `(0,0)` hasta la esquina inferior derecha.

Cada casilla puede ser:

```java
static final int LIBRE = 0;
static final int PARED = 1;
static final int CAMINO = 2;
static final int VISITADO = 3;
```

Eso significa:

* `0` → se puede pasar
* `1` → pared
* `2` → parte del camino correcto
* `3` → camino que ya se probó y no servía

---

# Dónde está el backtracking en tu código

La función principal es:

```java
static boolean resolver(int[][] laberinto, int fila, int columna)
```

Esta función recibe:

* El laberinto
* La fila actual
* La columna actual

Y trata de encontrar una salida desde esa posición.

---

# Paso 1: Caso inválido

```java
if (fila < 0 || fila >= laberinto.length || columna < 0 || columna >= laberinto[0].length) {
    return false;
}
if (laberinto[fila][columna] != LIBRE) {
    return false;
}
```

Aquí se descartan posiciones inválidas:

* Si sales del laberinto
* Si la casilla es una pared
* Si ya fue visitada

En backtracking esto se llama "podar" ramas inútiles.

Es como decir:

> "No tiene sentido seguir por aquí".

---

# Paso 2: Caso base

```java
if (fila == laberinto.length - 1 && columna == laberinto[0].length - 1) {
    laberinto[fila][columna] = CAMINO;
    return true;
}
```

Este es el objetivo:

* Si llegaste a la última casilla
* Entonces encontraste la salida

En recursión esto se llama el caso base.

---

# Paso 3: Elegir una opción

```java
laberinto[fila][columna] = CAMINO;
```

Aquí el algoritmo toma una decisión:

> "Voy a intentar pasar por esta casilla"

Todavía no sabe si la decisión es correcta.

Solo la marca temporalmente.

---

# Paso 4: Probar todas las direcciones

```java
if (resolver(laberinto, fila + 1, columna) ||
    resolver(laberinto, fila, columna + 1) ||
    resolver(laberinto, fila - 1, columna) ||
    resolver(laberinto, fila, columna - 1)) {
    return true;
}
```

Aquí está el verdadero backtracking.

El algoritmo intenta:

1. Abajo
2. Derecha
3. Arriba
4. Izquierda

Si alguna dirección encuentra salida, entonces devuelve `true`.

---

# ¿Qué pasa si ninguna dirección sirve?

```java
laberinto[fila][columna] = VISITADO;
return false;
```

Esto significa:

> "Probé todas las opciones y ninguna funcionó"

Entonces:

* La casilla deja de ser parte del camino
* Se marca como camino fallido
* El algoritmo vuelve atrás a la llamada anterior

Este es exactamente el momento del backtracking.

---

# Ejemplo visual paso a paso

Supón este mini laberinto:

```text
0 0 1
1 0 1
0 0 0
```

Visualmente:

```text
· · []
[] · []
· · ·
```

El algoritmo comienza en `(0,0)`.

---

## Primera llamada

```java
resolver(laberinto, 0, 0)
```

Marca la posición como camino:

```text
* · []
[] · []
· · ·
```

Luego intenta bajar.

---

## Intento: bajar

Quiere ir a `(1,0)`.

Pero ahí hay una pared.

```java
resolver(laberinto, 1, 0)
```

Devuelve:

```java
false
```

Entonces intenta derecha.

---

## Intento: derecha

Va a `(0,1)`.

```text
* * []
[] · []
· · ·
```

Luego desde ahí vuelve a intentar las 4 direcciones.

Finalmente llega a:

```text
* * []
[] * []
· * *
```

Y alcanza la salida.

---

# Ejemplo donde sí hay retroceso

Imagina este otro laberinto:

```text
· · []
[] · []
[] [] ·
```

El algoritmo intenta avanzar, pero llega a un callejón sin salida.

Cuando eso pasa ejecuta:

```java
laberinto[fila][columna] = VISITADO;
```

Y visualmente se vería algo así:

```text
* x []
[] x []
[] [] ·
```

Las `x` significan:

> "Ya probé este camino y no funciona"

---

# Cómo se ve en la pila de llamadas

Supón que el algoritmo hace esto:

```text
resolver(0,0)
  resolver(0,1)
    resolver(1,1)
      resolver(2,1)
        resolver(2,2)
```

Si `resolver(2,2)` encuentra la salida, todas las llamadas anteriores regresan `true`.

Pero si una rama falla:

```text
resolver(0,0)
  resolver(0,1)
    resolver(1,1)
      resolver(1,2) -> false
```

Entonces la función vuelve a `resolver(1,1)` y prueba otra dirección.

Eso es volver atrás en la pila.

---

# Diferencia entre recursión y backtracking

Tu laberinto usa ambas cosas.

## Recursión

La función se llama a sí misma:

```java
resolver(...)
```

## Backtracking

La función:

1. Prueba una decisión.
2. Si falla, la deshace.
3. Luego prueba otra.

La línea que convierte la recursión en backtracking es:

```java
laberinto[fila][columna] = VISITADO;
```

Porque ahí se está "deshaciendo" la decisión anterior.

---

# Estructura general de un algoritmo de backtracking

Tu código sigue exactamente esta plantilla:

```java
boolean backtracking(estado) {

    if (estado es inválido) {
        return false;
    }

    if (estado es solución) {
        return true;
    }

    hacer una elección;

    for (cada posibilidad) {
        if (backtracking(siguiente estado)) {
            return true;
        }
    }

    deshacer la elección;
    return false;
}
```

Tu versión concreta sería:

```java
boolean resolver(...) {
    if (no se puede pasar)
        return false;

    if (llegué a la salida)
        return true;

    marcar como camino;

    intentar abajo, derecha, arriba e izquierda;

    si nada funcionó:
        marcar como visitado;
        return false;
}
```

---

# ¿Por qué funciona?

Porque el algoritmo explora el laberinto como si fuera un árbol.

Cada casilla genera hasta 4 caminos nuevos:

```text
          inicio
        /   |   \
   abajo derecha arriba
```

Si una rama falla, vuelve al nodo anterior y prueba otra.

---

# Complejidad

En el peor caso, el algoritmo podría visitar casi todas las casillas.

Por eso el tiempo puede crecer mucho si el laberinto es grande.

Aproximadamente:

```text
O(4^n)
```

Aunque en tu caso mejora bastante porque las casillas visitadas se marcan y no se vuelven a probar.

---

# Lo más importante que debes recordar

Backtracking siempre tiene estas 4 partes:

1. Elegir

```java
laberinto[fila][columna] = CAMINO;
```

2. Probar

```java
resolver(...)
```

3. Fallar

```java
return false;
```

4. Deshacer

```java
laberinto[fila][columna] = VISITADO;
```

Si puedes identificar esas 4 partes, entonces estás viendo un algoritmo de backtracking.

---

# Resumen final

Tu programa del laberinto sí usa backtracking porque:

* Tiene varias opciones posibles.
* Prueba una por una.
* Si una no sirve, vuelve atrás.
* Marca caminos fallidos.
* Continúa hasta encontrar una salida.

La línea más importante de todo el algoritmo es:

```java
laberinto[fila][columna] = VISITADO;
```

Porque ahí ocurre el "volver hacia atrás" que da nombre al backtracking.

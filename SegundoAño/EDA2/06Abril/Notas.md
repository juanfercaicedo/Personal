# Criptoaritmo `SEND + MORE = MONEY` 

## Idea del problema

Queremos asignar dígitos (0–9) a letras para que se cumpla:

```
  SEND
+ MORE
------
 MONEY
```

Reglas:

* Cada letra tiene un dígito distinto.
* No se pueden repetir dígitos.
* `S` y `M` no pueden ser 0 (no hay ceros a la izquierda).

---

## Estructuras clave del código

```java
private static final char[] LETRAS = {'S', 'E', 'N', 'D', 'M', 'O', 'R', 'Y'};
```

👉 Orden en que se asignan las letras.

```java
private final static int[] valores = new int[256];
```

👉 Mapea cada carácter a un dígito.

```java
private final static boolean[] digitoAsignado = new boolean[10];
```

👉 Marca qué dígitos ya están ocupados.

---

## Dónde está la recursividad

```java
private static boolean resolver(int indice)
```

Esta función intenta asignar un dígito a la letra en posición `indice`.

### Llamada recursiva

```java
if (resolver(indice + 1)) {
    return true;
}
```

👉 Se avanza a la siguiente letra tras asignar un dígito.

---

## Caso base

```java
if (indice == LETRAS.length) {
    return esSumaValida();
}
```

👉 Significa: ya asignamos todas las letras.

* Se verifica si la suma es correcta.
* Si lo es → `true` (solución encontrada)
* Si no → `false` (hay que retroceder)

---

## Asignación de dígitos

```java
for (int digito = 0; digito <= 9; digito++) {
    if (!digitoAsignado[digito]) {
        valores[letraActual] = digito;
        digitoAsignado[digito] = true;

        if (resolver(indice + 1)) {
            return true;
        }

        valores[letraActual] = -1;
        digitoAsignado[digito] = false;
    }
}
```

### Qué hace:

1. Prueba todos los dígitos posibles (0–9).
2. Solo usa los que no están ocupados.
3. Asigna el dígito a la letra.
4. Llama recursivamente para la siguiente letra.

---

## Aquí ocurre BACKTRACKING

```java
valores[letraActual] = -1;
digitoAsignado[digito] = false;
```

👉 Esto significa:

* “Este intento no funcionó”
* Se deshace la asignación
* Se prueba otro dígito

Esto es el corazón del backtracking.

---

## Validación de la solución

```java
private static boolean esSumaValida()
```

### Restricción importante

```java
if (valores['S'] == 0 || valores['M'] == 0) {
    return false;
}
```

👉 Evita números con ceros a la izquierda.

### Construcción de números

```java
int send  = valores['S'] * 1000 + valores['E'] * 100 + valores['N'] * 10 + valores['D'];
int more  = valores['M'] * 1000 + valores['O'] * 100 + valores['R'] * 10 + valores['E'];
int money = valores['M'] * 10000 + valores['O'] * 1000 + valores['N'] * 100 + valores['E'] * 10 + valores['Y'];
```

### Verificación

```java
return (send + more == money);
```

---

## Flujo completo del algoritmo

1. Empieza con `resolver(0)` → letra `S`
2. Intenta asignar un dígito
3. Pasa a la siguiente letra (`E`, luego `N`, etc.)
4. Cuando todas tienen valor:

   * Verifica la suma
5. Si falla:

   * Retrocede (backtracking)
   * Cambia el último dígito
6. Repite hasta encontrar solución

---

## Interpretación como árbol de decisiones

Cada nivel del árbol es una letra:

```
S
├── 1
│   ├── E
│   │   ├── 0
│   │   ├── 2
│   │   └── ...
```

* Cada rama es una asignación posible
* Si una rama falla → se poda (backtracking)

---

## Salida

```java
imprimirSolucion()
```

Muestra:

* La suma formateada
* La asignación de cada letra

---

## Resumen

✔ Recursividad:

```java
resolver(indice + 1)
```

✔ Caso base:

```java
indice == LETRAS.length
```

✔ Backtracking:

```java
valores[letraActual] = -1;
digitoAsignado[digito] = false;
```

✔ Idea clave:

* Probar combinaciones
* Deshacer si no sirven
* Continuar hasta encontrar solución
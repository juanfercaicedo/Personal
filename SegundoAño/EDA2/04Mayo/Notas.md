## Counting Sort
* Nos dan un valor mínimo y un máximo
* Contamos la cantidad de veces que aparece un elemento dentro de un array
* Ordenamos sin comparar
* Ejemplo:
[3, 1, 2, 4, 1, 3]
---
| Número | Cantidad de veces que está en el array |
|:---|:---|
| 1 | II |
| 2 | I |
| 3 | II |
| 4 | I |
---
* Ordena en función de cuántas aveces aparece un elemento dentro de un array

## Radix Sort 
* Array inicial: [300, 624, 115, 745, 426]
* Primero ordenamos por unidad
* Luego por decena y por último por centena
---
**Paso 1: Ordenar por las UNIDADES** *(De derecha a izquierda, la última cifra)*

| Número original | Dígito evaluado | Orden temporal |
|:---|:---|:---|
| 30**0** | 0 | 1º |
| 62**4** | 4 | 2º |
| 11**5** | 5 | 3º |
| 74**5** | 5 | 4º |
| 42**6** | 6 | 5º |

*Nota: Curiosamente, en este caso los números ya estaban ordenados por sus unidades (0, 4, 5, 5, 6). Recuerda que el 115 y el 745 mantienen su orden relativo.*
* El array temporal tras el paso 1 queda igual: **[300, 624, 115, 745, 426]**

---
**Paso 2: Ordenar por las DECENAS** *(Usando el array temporal del Paso 1)*

| Número | Dígito evaluado | Orden temporal |
|:---|:---|:---|
| 3**0**0 | 0 | 1º |
| 1**1**5 | 1 | 2º |
| 6**2**4 | 2 | 3º |
| 4**2**6 | 2 | 4º |
| 7**4**5 | 4 | 5º |

*Nota: Aquí se reordenan. El 624 y el 426 empatan en la decena (2), pero el 624 se coloca antes porque en el array del Paso 1 estaba primero.*
* El array temporal tras el paso 2 queda: **[300, 115, 624, 426, 745]**

---
**Paso 3: Ordenar por las CENTENAS** *(Usando el array temporal del Paso 2)*

| Número | Dígito evaluado | Orden final |
|:---|:---|:---|
| **1**15 | 1 | 1º |
| **3**00 | 3 | 2º |
| **4**26 | 4 | 3º |
| **6**24 | 6 | 4º |
| **7**45 | 7 | 5º |

---
* Array ordenado final: **[115, 300, 426, 624, 745]**
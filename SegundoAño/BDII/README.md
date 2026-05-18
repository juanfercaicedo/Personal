# Funciones en python
1. ## Distancia euclidiana:##
* **Librerias Necesarias**: numpy(Numbers is python)
``` python
import numpy as np
def distancia_euclidiana(a,b):
    return np.linalg.norm(a - b)

```
* En base de datos vectoriales la similitud se mide en funcion de la distancia 
---
2. ## Similitud de Coseno: ##
```python
import numpy as np
def coseno(a, b):
    return np.dot(a, b) / (np.linalg.norm(a) * np.linalg.norm(b))

```
* np.dot -> calcula el producto escalar / producto entre dos vectores
---
3. ## Buscador semántico: ##
```python
def coseno(a, b):
    norm_a = np.linalg.norm(a)
    norm_b = np.linalg.norm(b)

    if norm_a == 0 or norm_b == 0:
        return 0  # o -1 según criterio

    return np.dot(a, b) / (norm_a * norm_b)
```

---

## Embedding ##
* Convertir un texto a una palabra
* Código de ejemplo:

```python
def embedding_simple(texto):
    if texto == "gato":
        return np.array([1.0, 1.0])
    elif texto == "felino":
        return np.array([1.1, 1.05])
    elif texto == "perro":
        return np.array([0.9, 1.0])
    elif texto == "auto":
        return np.array([-1.0, -1.0])
    else:
        return np.array([0.0, 0.0])
```
* Cuando tenemos un conjunto de palabras sin `,`:
```python

def embedding_frase(texto):
    palabras = texto.lower().split() // pone todo en minúsculas y cada palabra lo pone como un elemento de un array
    vector = np.zeros(4) // crea un array con 4 espacios vacíos para guardar los resultados

    for p in palabras:
        if p in ["gato", "felino"]:
            vector += np.array([1, 0, 0, 0])
        elif p in ["perro"]:
            vector += np.array([0, 1, 0, 0])
        elif p in ["auto"]:
            vector += np.array([0, 0, 1, 0])
        elif p in ["pequeño", "grande", "salvaje", "rápido"]:
            vector += np.array([0, 0, 0, 1])

    return vector
```

* **Embedding** depende de su diseño
* Pasos para realizar embedding:
1. Creamos un espacio donde cada entidad dimensión representa un tipo de entidad 
```python
vocabulario_1 = {
    "gato": np.array([1, 0, 0]),
    "felino": np.array([1, 0, 0]),
    "perro": np.array([0, 1, 0]),
    "auto": np.array([0, 0, 1])
}
```
* En este diseño:
    * dimensión 0 → gatos/felinos
    * dimensión 1 → perros
    * dimensión 2 → vehículos

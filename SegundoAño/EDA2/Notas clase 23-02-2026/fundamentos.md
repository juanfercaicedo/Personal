### Definiciones
- **Caso Recursivo**: Se llama a si misma con elemenos diferentes.
    - La llamada debe ser tendiendo (converger) hacia el caso base

- **Caso base**: Detiene la llamada recursiva
    - Devuelve un valor
    - El caso base más sencillo es el **vacío**

#### Ejemplo
**Palabras Palindromicas:** Palabras que se leen igual de izquierda a derecha 
- Ejemplo caso base con palabras palindromicas
" " -> Verdadero (caso base/cadena vacio)
"a" -> verdadero (se lee igual de izquierda a derecha)
"bc cb" -> verdadero (se lee igual de izquierda a derecha)
"abc cba" -> verdadero (se lee igual de izquierda a derecha)
    - Cada vez que tenemos un grado verdadero nos acercamos un grado al caso base
    - En una pila de llamada una vez un proceso sea verdadero se elimina y se sigue al siguiente, en este caso eliminamos la `cabeza` y la `cola`
    - Cuando llegamos a una cadena vacía o de un solo carácter, alcanzamos el caso base.
    - Luego las llamadas se van resolviendo en la pila hasta llegar a la llamada inicial.

---
### Más notas de clase:
- [Inducción](https://github.com/mmasias/EDA2/tree/main/temario/002-recursividad/induccion) 
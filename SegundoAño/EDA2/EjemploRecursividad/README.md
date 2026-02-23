# Pila de Llamas (LIFO)
- Una pila siempre ocupa LIFO
    - Last In First Out

## ¿Qué es una Pila de Llamadas?
- Cada vez que se llama a un método, se crea un Marco de Pila (Stack Frame).
- Este marco se coloca en la parte superior de la pila.
- Cuando el método termina, su marco se elimina y el control vuelve al marco que está justo debajo.

## Anatomía de un Marco de Pila (Stack Frame)
- Variables Locales: Los valores de los parámetros (como valorFinal) y variables internas.
- Dirección de Retorno: Una "migaja de pan" que le dice a la CPU a qué línea de código debe volver cuando el método actual termine.
- Operandos y Contexto: Datos temporales necesarios para realizar cálculos.

## Recursividad
- En un método recursivo, la pila crece con cada llamada a sí mismo.
    - **Fase de Expansión:** La pila se llena de marcos. Cada marco está "en pausa" esperando a que el siguiente termine.
    - **Punto de Inflexión:** (Caso Base): Se alcanza la condición de salida. No se crean más marcos.
    - **Fase de Contracción:** Los marcos se van resolviendo y eliminando de arriba hacia abajo.


- Para mas notas más detalladas: [Repositorio clase](https://github.com/mmasias/EDA2/blob/main/temario/002-recursividad/laPilaDeLlamadas.md)

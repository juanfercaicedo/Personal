# Topología
## Caso Base:
- Es el más fácil en la topología recursiva porque es el que para resolverse no tiene `llamada recursiva`
    - **Llamada Recursiva**: Llamada a sí misma
- El caso base no puede estar dentro de la función recursiva.
```java
class Recursivo{
    static void funcionRecursiva(int parametro){
        funcionRecursiva(parametro - 1);
    }

    public static void main(String[] args){
        funcionRecursiva(5);
    }
}
```
`Exception in thread "main" java.lang.StackOverflowError`
- La pila de llamada se llena y se `desborda`
    - Es similar a un while(true);
    - Diferencia entre while (true) y caso base
        - Con while(true) la computadora no va a reventar, ya que es una secuencia de instrucciones, es decir el programa puede continuar en un ciclo infinito
            - Cuando estamos dentro de un bucle, todos los elementos tienen el mismo contexto
        - Con una topología recursiva, estamos creando un contexto y lo apilamos al contexto anterior
            - Cada contexto ocupa recursos.
            - La pila de llamada sirve para:
            1. Saber a donde vuelvo
            2. Crea y guarda el contexto
- Este ejemplo no tiene caso base, no se detiene la recursividad
- Ahora con caso base: 
```java
class Recursivo{
    static void funcionRecursiva(int parametro){
        if(parametro == 0){
            return; // caso base
        }
        funcionRecursiva(parametro - 1);
    }

    public static void main(String[] args){
        funcionRecursiva(5);
    }
}
```
- El **caso base** deja de apilar elementos en la pila de llamada.

- Más notas de clase en: [topología](https://github.com/mmasias/EDA2/blob/main/temario/002-recursividad/implementacion/00-topologia.md)

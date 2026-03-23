## Memoización 
- Reutilizar un calculo 
- Evita realizar operaciones costosas varias veces
- **Definición**: `Técnica de optimización en programación que mejora el rendimiento almacenando en caché los resultados de funciones costosas`

## Método Tabular
- El método tabular es una técnica de optimización dentro de la Programación Dinámica que resuelve problemas de abajo hacia arriba
- En lugar de empezar por el problema gigante y dividirlo usando recursividad (como hace la memoización), la tabulación hace exactamente lo contrario: se olvida por completo de la recursividad y usa bucles (for o while). Empieza resolviendo los problemas más pequeños y triviales, guarda sus resultados en una "tabla" (que en Java suele ser un array o una matriz), y usa esos datos para ir construyendo las respuestas de los problemas más grandes hasta llegar al objetivo final.
- Características: 
    - Es iterativo: No hay llamadas a funciones dentro de sí mismas. Cero recursividad.
    - Es secuencial: Llena la tabla paso a paso, desde la posición 0 hasta la n.
    - Ahorra memoria: Al no usar recursividad, no corre el riesgo de saturar la memoria de la computadora (el famoso error StackOverflow) que a veces ocurre cuando las funciones se llaman a sí mismas miles de veces.
- Ejemplo:
``` java
public class EscalerasTabulacion {

    public static int formasDeSubir(int n) {
        // Si la escalera es muy pequeña, devolvemos el número directamente
        if (n == 1) return 1;
        if (n == 2) return 2;

        // 1. Creamos nuestra "tabla" (un array). 
        // Le sumamos 1 al tamaño para que los índices coincidan con el número del escalón.
        int[] tabla = new int[n + 1];

        // 2. Llenamos los casos base (los problemas más pequeños que ya sabemos)
        tabla[1] = 1; 
        tabla[2] = 2;

        // 3. Iteramos de "abajo hacia arriba" usando un bucle.
        // Empezamos en el escalón 3 y vamos construyendo hasta 'n'.
        for (int i = 3; i <= n; i++) {
            // El resultado del escalón actual es la suma de los dos anteriores
            tabla[i] = tabla[i - 1] + tabla[i - 2];
        }

        // 4. El resultado final de nuestro problema gigante está en el último cajón
        return tabla[n];
    }

    public static void main(String[] args) {
        int escalones = 5;
        System.out.println("Formas de subir " + escalones + " escalones: " + formasDeSubir(escalones));
        // Para 5 escalones, la tabla se llenaría así: [0, 1, 2, 3, 5, 8]
        // y devolvería el 8.
    }
}
```

## Método Iterativo
- Un enfoque iterativo es cuando utilizas estructuras de control de repetición (los famosos bucles for, while o do-while) para ejecutar un bloque de código una y otra vez hasta que se cumpla una condición.
- Características: 
    - Avanza hacia adelante paso a paso.
    - Se basa en una condición clara para detenerse (ej. i < 5).
- Ejemplo:
``` java
static void cuentaRegresivaIterativa(int n) {
    // Usamos un bucle para repetir la acción
    for (int i = n; i > 0; i--) {
        System.out.println(i);
    }
    System.out.println("¡Despegue!");
}
```
## Método Recursivo
- La función se `llama` a si misma
- Llamada recursiva, pilas de llamadas
- [Más notas](../NotasClase18Feb/README.md)

``` java
static void cuentaRegresivaRecursiva(int n) {
    // 1. EL CASO BASE: ¿Cuándo nos detenemos? (La muñeca más pequeña)
    if (n == 0) {
        System.out.println("¡Despegue!");
        return; // Esto rompe el ciclo y empieza a cerrar funciones
    }
    
    // 2. LA ACCIÓN: Imprimimos el número actual
    System.out.println(n);
    
    // 3. LA LLAMADA RECURSIVA: La función se llama a sí misma, 
    // pero con un problema más pequeño (n - 1)
    cuentaRegresivaRecursiva(n - 1);
}
```
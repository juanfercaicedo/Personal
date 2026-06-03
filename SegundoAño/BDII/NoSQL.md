## Problemas de SQL 
* Escalabilidad Vertical: 
    * Añadir más CPU / RAM: aumentar la capacidad de un único servidor añadiendo más memoria, más potencia de procesamiento o almacenamiento más rápido
    * Es costoso
* Escalabilidad Horizontal: 
    * Distribuir carga entre servidores

---
# Bases de Datos NoSQL
* Crecimiento del Big Data: Conjunto de datos masivos 
* Aplicaciones masivas con gran tráfico de red
* Uso de cloud computing
* Necesidad de sistemas distribuidos

## 5 V del Big Data
* **V**olumen: Por gran cantidad de datos
* **V**elocidad: Flujo de datos en tiempo real
* **V**ariedad: Datos estructurados y no estructurados
* **V**eracidad: Precisión y confianza 
* **V**alor: Información útil extraída

---
* No SQL consiste en eliminar el modelo tradicional relacional que se maneja en SQL 

---
## Características No SQL 
* Se basa en **BASE**:
    * Basically Available: Prioriza disponibilidad del sistema
    * Soft State: Permite que el estado de los datos cambie de forma gradual
    * Eventual consistency: Busca alcanzar una consistencia eventual

---
## Teorema CAP (Consistency, Availability, Partition Tolerance)
* Consistency: Todos los datos devuelven la misma información al mismo tiempop
* Availability: Asegura que el sistema responda a las solicitudes
* Partition Tolerance: Permite que el sistema continue funcionando incluso si hay fallo en la comunicación entre nodos 

---
## Clasificición No SQL 
* Base-Valor
* Columnares
* Documentales
* Grafos
* Vectoriales (Utilizada con IA)

1. Base de datos **Base-valor**:
* Alta velocidad
* Facilidad de escalabilidad
* Simplicidad de implementación

* No permite consultas complejas
* No maneja relaciones entre datos

2. Base de datos **Columnares**:
* Organiza los datos en familias de columnas
* Se caracteriza por su flexibilidad: 
    * No todos los registros están obligados a tener la misma estructura
* Se utiliza por su alto rendimiento a gran escala
* Almacenamiento optimizado
* Velocidad de Lectura
* Es difícil de configurar
    * Riesgo de mal rendimiento por mala planeación

3. Base de datos **Documentales**:
* Almacena la información en un documento con formato similar a un JSON 
* Cada documento puede tener su propia estructura 
* Alta flexibilidad
* Facilidad para evolucionar de modelo
* Buen soporte para consultas
* Puede ser que duplique la información
* Las relaciones complejas pueden resultar costosas

4. Bases de datos **Grafos**:
* Diseñadas para manejar relaciones complejas entre entidades
* Utilizan nodos y relaciones para representar datos 
* Bueno para el manejo de relaciones
* Eficientes para consultas complejas

5. Base de datos **Vectoriales**:
* Almacenan información en forma de vectores numéricos que permiten medir similitud entre datos
* Permiten búsquedas por similitud
* Integración con sistemas de IA
* No reemplazan a bases de datos tradicionales
* Requieren procesamiento previo de datos


### Ejecutar terminal de MongoDB
```bash
 docker exec -it mongosh_docencia mongosh "mongodb://admin:admin123@mongodb_docencia:27017/"
```
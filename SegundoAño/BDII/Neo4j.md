# Lenguaje de grafos
## Sintáxis básica
* Crear un nodo
```Neo4j
CREATE(a:Persona{nombre:"Juan"})
RETURN a
```
* Crear una relación:
```Neo4j
MATCH (a:Persona {nombre: "Luis"}), (b:Persona {nombre: "Ana"})
CREATE (a)-[r:AMIGO_DE]->(b)
RETURN a.nombre AS Nombre, type(r) AS Relacion, b.nombre AS NombreAmigo
```

* Buscar una relación
```Neo4j
MATCH(a:Persona)-[r:AMIGO_DE]->(b:Persona)
RETURN a, r, b
```
* Este tipo de consultas nos devuelven grafos
* r es un tipo de relación, dentro de una base de datos pueden haber miles de relaciones
* En esta base de datos nosotros podemos:
```Neo4j
CREATE(a:Persona{nombre:"Ana"})
CREATE(a:Persona{nombre:"Ana"})
```
* Se crearan dos personas con el nombre de `Ana`
* Para evitar esto podemos utilizar `MERGE`:
```Neo4j
MERGE(a:Persona{nombre:"Ana"})
```
* Con eso creará a una nueva persona solo si no existe
* **Solo revisa los campos que le estamos dando**, es decir si nosotros tenemos a una Ana y hacemos el siguiente merge:
```Neo4j
MERGE(a:Persona{nombre:"Ana", edad: 17})
```
* Creará una nueva `Ana` porque no hay ninguna Ana con edad: 17 en nuestra base de datos
---

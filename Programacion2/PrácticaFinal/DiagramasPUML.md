# Diagramas Jerarquización

## Estructura básica de inicio de un diagrama `puml `

```puml
@startuml

// Aquí va el diagrama

@enduml

```

## Declaración de clases

```puml

class NombreClase {
    +atributoPublico: Tipo
    -atributoPrivado: Tipo
    #atributoProtegido: Tipo
    ~atributoPackage: Tipo

    +metodoPublico(param: Tipo): Retorno
    -metodoPrivado(): void
}

```

## Maneras de declarar la visibilidad

| Símbolo | Visibilidad | Java equivalente  |
| ------- | ----------- | ----------------- |
| `+`     | Public      | `public`          |
| `-`     | Private     | `private`         |
| `#`     | Protected   | `protected`       |
| `~`     | Package     | (sin modificador) |

## Modificadores de Clase en PlantUML

Los **modificadores de clase** en PlantUML son palabras clave que cambian el tipo o comportamiento de una clase. Son como "etiquetas" que le dicen a PlantUML qué tipo de elemento estás creando.

### Ejemplo de Modificadores

```puml
abstract class Animal
interface Volador
enum TipoColor
class Mascota <<singleton>> // estereotipo
```

> **abstract**

- abstract: modificador
- abstract nos dice que es una clase abstracta(no se puede instaciar directamente)

> **interface**

- interface = modificador
- Define una interfaz

> **enum**

- enum = modificador
- Crea una enumeración (lista fija de valores como ROJO, VERDE, AZUL)

> **class**

- class = tipo básico

> **Otros tipos de modifcadores**

- static class - clase estática
- final class - clase que no se puede heredar
- package - paquete o namespace

## Relaciones entre clases

```puml
' Herencia
ClasePadre <|-- ClaseHija

' Implementación de interfaz
Interfaz <|.. Clase

' Asociación (uso o referencia)
ClaseA --> ClaseB

' Agregación (tiene, pero no posee)
ClaseA o-- ClaseB

' Composición (posee y controla el ciclo de vida)
ClaseA *-- ClaseB

' Dependencia (usa temporalmente)
ClaseA ..> ClaseB

```

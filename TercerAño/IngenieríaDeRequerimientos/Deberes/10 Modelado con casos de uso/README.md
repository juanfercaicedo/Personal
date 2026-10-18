# Casos de uso Ingeniería de Requerimientos
## Ejercicio 1
- **Ejercicio en lenguaje natural**: "Quiero que el socio pueda reservar su clase de Yoga o Crossfit. Pero ojo, el sistema debe ser súper seguro, así que antes de dejarlo reservar nada, debe loguearse sí o sí. ¡Ah! Y si el socio tiene una lesión registrada en su perfil, el sistema debe avisarle y ofrecerle un plan de ejercicios suave de forma opcional antes de confirmar."
### Diagramas:
```plantuml
@startuml
left to right direction
skinparam packageStyle rectangle

actor Socio

rectangle "App Fit & Go" {
  usecase "Reservar clase\n(Yoga o Crossfit)" as UC_Reservar
  usecase "Autenticar usuario" as UC_Autenticar
  usecase "Ofrecer plan de ejercicios suave" as UC_Plan
}

Socio -- UC_Reservar
UC_Reservar ..> UC_Autenticar : <<include>>
UC_Plan ..> UC_Reservar : <<extend>>\n(Condición: Lesión registrada)
@enduml
```
---
## Ejercicio 2
- **Ejercicio en lenguaje natural**:  "Necesito que el estudiante pueda pedir prestado un libro. Obviamente, el sistema tiene que revisar siempre si el libro está disponible en los estantes. Si por alguna razón el estudiante tiene una multa pendiente de más de 5 dólares, el sistema debe bloquear el préstamo y mandarlo directo a la pantalla de 'Pago de Multas' para que se arregle de inmediato."
    - **Reto del estudiante:** ¿Cómo definimos técnicamente "arreglarse de inmediato"?.
### Diagramas: 
```plantuml

@startuml
left to right direction
skinparam packageStyle rectangle

actor Estudiante

rectangle "BiblioTech" {
  usecase "Pedir prestado un libro" as UC_Prestar
  usecase "Revisar disponibilidad en estantes" as UC_Disponibilidad
  usecase "Pagar multas" as UC_Multas
}

Estudiante -- UC_Prestar
UC_Prestar ..> UC_Disponibilidad : <<include>>
UC_Multas ..> UC_Prestar : <<extend>>\n(Condición: Multa > $5.00)
@enduml
```
---
## Ejercicio 3
- **Ejercicio en lenguaje natural:** "Quiero que el usuario haga su pedido de comida. Al pagar, el sistema siempre debe calcular el costo de envío según la distancia. Ahora, si el usuario tiene un 'Cupón de Cumpleaños' activo, quiero que le deje aplicarlo para que no pague nada de envío, pero solo si es su mes de cumple."
    - **Reto para el estudiante:** (Usuario y Google Maps como Sistema Externo para la distancia).
### Diagramas:
```plantuml
@startuml diagram3
left to right direction
skinparam packageStyle rectangle

actor Usuario
actor "Google Maps" as Maps <<System>>

rectangle "Rápido & Rico" {
  usecase "Hacer pedido de comida" as UC_Pedido
  usecase "Calcular costo de envío" as UC_Envio
  usecase "Aplicar cupón de cumpleaños" as UC_Cupon
}

Usuario -- UC_Pedido
UC_Pedido ..> UC_Envio : <<include>>
UC_Envio -- Maps
UC_Cupon ..> UC_Pedido : <<extend>>\n(Condición: Mes de cumpleaños)
@enduml
```

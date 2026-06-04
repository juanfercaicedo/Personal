## Ejecutar terminal de MongoDB
```bash
 docker exec -it mongosh_docencia mongosh "mongodb://admin:admin123@mongodb_docencia:27017/"
```
## Sintaxis busqueda
```bash
// Búsqueda básica
db.coleccion.find({ nivel: "Básico" })

// Búsqueda con operadores de comparación
db.coleccion.find({ creditos: { $lt: 3 } })  // Menor que (<)
db.coleccion.find({ creditos: { $lte: 3 } }) // Menor o igual (<=)
db.coleccion.find({ creditos: { $gt: 3 } })  // Mayor que (>)
db.coleccion.find({ creditos: { $gte: 3 } }) // Mayor o igual (>=)

// Ordenar (sort) -> 1 Ascendente (A-Z, 0-9) | -1 Descendente (Z-A, 9-0)
db.coleccion.find().sort({ creditos: 1 })
db.coleccion.find().sort({ nivel: 1, creditos: -1 }) // Ordenamiento múltiple
```
## Sintaxis UPDATE
```bash
// Actualización parcial (Cirugía)
db.coleccion.updateOne({_id: 1}, { ... })   // Actualiza solo el primero que coincida
db.coleccion.updateMany({activo: true}, { ... }) // Actualiza TODOS los que coincidan

// Reemplazo total (¡Peligro: Borra la estructura anterior!)
db.coleccion.replaceOne(
   { nombre: "Bases de Datos" }, 
   { nombre: "Bases de Datos", creditos: 4 } // Nuevo documento completo
)

// --- OPERADORES DE ACTUALIZACIÓN ---
db.coleccion.updateOne(
    { nombre: "Bases de Datos" },
    {
        $set: { profesor: "Dr. Ramírez" }, // Modifica o crea un campo nuevo
        $unset: { comentarios: "" },       // Elimina un campo por completo
        $inc: { creditos: 1 },             // Suma (usar números negativos para restar)
        $push: { estudiantes: "Pedro" },   // Agrega un elemento a una lista (Array)
        $pull: { estudiantes: "Carlos" }   // Saca un elemento de una lista (Array)
    }
)

// --- ACTUALIZAR DENTRO DE ARRAYS ($ Posicional) ---
// El operador $ recuerda la posición exacta del elemento encontrado en el filtro
db.pedidos.updateOne(
  { "productos.nombre": "Mouse" },                // Buscar con notación de puntos
  { $set: { "productos.$.precio": 20}}          // Actualizar usando $
)
```
## Sintaxis DELETE
```bash
// Eliminar documentos (La colección sigue viva)
db.coleccion.deleteOne({ _id: 1 })               // Borra solo el primero que coincida
db.coleccion.deleteMany({ estado: "Cancelado" }) // Borra TODOS los que coincidan
db.coleccion.deleteMany({})                      // ¡Peligro! Borra TODOS los datos

// Eliminar la colección completa
db.coleccion.drop()                              // Destruye datos, colección e índices
```
## Indices y Rendimiento
```bash
// Crear un índice para acelerar búsquedas
db.coleccion.createIndex({ nombre: 1 })                  // Índice simple
db.coleccion.createIndex({ nivel: 1, creditos: -1 })     // Índice compuesto

// Ver los índices que existen en una colección
db.coleccion.getIndexes()

// Medir el rendimiento de una consulta (Verificar si usa el índice: IXSCAN vs COLLSCAN)
db.coleccion.find({ nombre: "Bases de Datos" }).explain("executionStats")
```

## Indices sin colisiones
```bash
db.cursos.createIndex(
    {emai:1}, 
    {unique:true}
)

db.pedidos.createIndex(
    { estado: 1 }, 
    { partialFilterExpression: { estado: "activo" } } // Crea indices a aquellos pedidos que tengan el estado activo 
)
```
**FetchType.LAZY**

Es una estrategia de carga de relaciones en Java Persistence API (JPA) que indica que la relación asociada a una entidad no se debe cargar automáticamente cuando se recupera la entidad principal. En cambio, la relación solo se carga cuando se accede a ella explícitamente a través de su método getter.

En JPA, las relaciones entre entidades se representan mediante anotaciones como **@OneToMany**, **@ManyToMany**, **@OneToOne** y **@ManyToOne**. Estas anotaciones permiten definir la cardinalidad y la navegabilidad de las relaciones.

Por defecto, JPA carga automáticamente las relaciones asociadas a una entidad cuando se recupera la entidad principal. Sin embargo, esto puede tener un impacto negativo en el rendimiento, especialmente si las relaciones son grandes o no se utilizan en la consulta actual.

Para evitar la carga innecesaria de relaciones, se puede utilizar la estrategia FetchType.LAZY. Al anotar una relación con FetchType.LAZY, se indica a JPA que no cargue la relación automáticamente. En su lugar, la relación solo se cargará cuando se acceda a ella explícitamente a través de su método getter.

**Ventajas de usar FetchType.LAZY**

- Mejora del rendimiento: Al evitar la carga innecesaria de relaciones, FetchType.LAZY puede mejorar significativamente el rendimiento, especialmente para entidades con relaciones grandes.
- Menor uso de memoria: Al no cargar las relaciones en la memoria hasta que se necesiten, FetchType.LAZY puede reducir el uso de memoria de la aplicación.

**Desventajas de usar FetchType.LAZY**

- Consultas adicionales: Si se necesita acceder a una relación LAZY en una consulta, se generará una consulta SQL adicional para cargar la relación. Esto puede tener un impacto negativo en el rendimiento si se accede a la relación con frecuencia.
- Inicialización perezosa: Las relaciones LAZY no se inicializan hasta que se acceden a ellas explícitamente. Esto puede generar problemas si se intenta acceder a una relación LAZY en un contexto en el que no se puede ejecutar una consulta adicional, como dentro de una transacción.

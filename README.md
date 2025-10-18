# iLib / Syntek (versión adaptada)

Aplicación Java de escritorio basada en Swing que utiliza un tema Material (FlatLaf) y el patrón DAO para gestionar información de facturación, clientes, proveedores e inventario.

Esta rama/proyecto contiene una versión adaptada del antiguo sistema de biblioteca para manejar facturas y gestión básica de existencias.

## Interfaz principal (Dashboard)
El `Dashboard` proporciona la navegación lateral con los siguientes botones y módulos:

- Principal: vista inicial del panel de control.
- Facturas: muestra el listado/tabla de facturas (`FacturasTable`).
- Crear facturas: abre el formulario para crear nuevas facturas (`Facturas`).
- Existencias: abre el módulo de inventario (`Inventario`).
- Clientes: muestra y gestiona clientes (`Clientes`).
- Proveedores: muestra y gestiona proveedores (`SuppliersList`).

El tema visual aplicado es FlatMaterialLighterIJTheme (FlatLaf). El texto de la cabecera muestra la fecha en español.

## Características

- Interfaz gráfica con estilo Material (FlatLaf).
- Conexión a base de datos MySQL mediante clases DAO.
- Módulos para facturas, inventario, clientes y proveedores.
- Uso del patrón DAO para acceder a tablas: `DAOClients`, `DAOInvoices`, `DAOInvoiceLines`, `DAOInventoryProducts`, `DAOSuppliers`.

## Requisitos

- JDK 8+ (se recomienda JDK 11 o superior).
- Maven (para construir el proyecto) si se usa la estructura `pom.xml` incluida.
- Base de datos MySQL con el esquema provisto (ver `db_schema.sql` y `db_module_tables.sql`).

## Configuración

1. Importa el proyecto en tu IDE (Eclipse, IntelliJ, NetBeans) como proyecto Maven.
2. Importa/ejecuta los scripts SQL (`db_schema.sql`, `db_module_tables.sql`) en tu servidor MySQL para crear las tablas y datos iniciales.
3. Abre `src/main/java/com/mycompany/db/Database.java` y ajusta las credenciales de conexión (host, puerto, usuario, contraseña, nombre de la base de datos).

Ejemplo (editar la clase `Database.java`):

"Edita los parámetros JDBC para apuntar a tu servidor MySQL y prueba la conexión desde la aplicación."

## Cómo ejecutar

Desde la línea de comandos (desde la raíz del proyecto):

```bash
mvn clean package
java -jar target/report-app-1.0-SNAPSHOT.jar
```

O bien ejecuta la clase `com.mycompany.ilib.Dashboard` desde tu IDE.

## Notas de desarrollo

- El main del `Dashboard` aplica el tema FlatMaterialLighterIJTheme antes de crear la ventana.
- Si faltan iconos en tiempo de ejecución, revisa la carpeta `src/main/resources` o los recursos incluidos en el JAR.
- Los formularios y vistas se encuentran en `src/main/java/com/mycompany/views`.

## Contribuir

Si vas a hacer cambios significativos, crea una rama y abre un pull request. Incluye una breve descripción del cambio y cómo probarlo.

## Licencia y créditos

Proyecto original: ITPLibrary adaptado por el autor del repositorio.


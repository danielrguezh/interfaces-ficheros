# interfaces-ficheros
Repositorio usado para realizar tareas de programación orientadas a a manejo de interfaces y de ficheros
#  Code, Learn & Practice(Programación: Trabajando con Ficheros: `Interfaces y Clases sobre ficheros`

## Descripción

En el ejercicio, se debe de implementar un sistema `CRUD (create/read/update/delete)` genérico utilizando una interfaz que definirá los métodos necesarios para trabajar con ficheros.

### Objetivos

- Implementar una interfaz `CRUD (create/read/update/delete)` para gestionar objetos.
- Trabajar con ficheros.
- Utilizar clases para la gestión de la persistencia de los objetos.

### Requerimientos

#### 1. **Interfaz CRUD**

Debes crear una interfaz `Operations` que declare los métodos básicos para un CRUD. Cada uno de los métodos debe devolver un valor para indicar si la operación fue exitosa o no:

- `boolean create(Empleado empleado)`: Crear un nuevo objeto y almacenarlo.
- `Empleado read(String identificador)`: Leer un empleado a partir de su identificador.
- `Empleado read(Empleado empleado)`: Leer un empleado a partir de objeto de tipo empleado.
- `boolean update(Empleado empleado)`: Actualizar un objeto existente.
- `boolean delete(String identificador)`: Eliminar un objeto a partir de su identificador.
- `Set<Empleado> empleadosPorPuesto(String puesto)`: Debe de devolver el listado de empleados de un puesto en concreto.
- - `Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin)`: Debe de devolver el listado de empleados entre dos fechas.

#### 2. **Clases a Implementar**

- **Clase `Empleado`** (Clase de objeto):
  - Propiedades:
    - `String identificador`: Identificador único del empleado.
    - `String nombre`: Nombre del empleado.
    - `String puesto`: Puesto de trabajo del empleado.
    - `double salario`: Salario del empleado.
    - `String fechaNacimiento`: Indica la fecha de nacimiento en formato `dd\mm\aaaa`.
  - Métodos:
    - Constructor para inicializar los atributos. Todos aquellos que consideres oportunos.
    - Getters y setters para los atributos.
    - Método `toString()` para representar un empleado en formato texto (será útil al almacenar y leer los datos del archivo).
    - Método `equals` y `hash`. Sólo debe de contener la propiedad adecuada dentro del método.
    - Método `getEdad`. Permitirá obtener la edad del empleado a partir de la `fecha de nacimiento`.
- **Clase `FileOperations`** (Subclase):
  - Esta clase será una **clase** que implementará la interfaz `Operations` para gestionar los empleados almacenados en un fichero plano de texto. Debe de implementar los métodos de la `interfaz Operations`.
  
#### 3. **Formato de los Ficheros**

Los datos de los empleados deben ser almacenados en un archivo de texto con el siguiente formato '(empleados.txt)':

```console
1, Juan Pérez, Desarrollador, 3000.50, 15\10\1995
2, Ana Gómez, Diseñadora, 2800.75, 10\01\1990
3, Luis López, Gerente, 4000.00, 30\07\2000
```

Cada línea en el archivo representa un objeto `Empleado`, con los `atributos separados por una coma`.

#### 4. **Clases Abstractas y Métodos**

Puedes implmentar clases abstractas si lo consideras oportuno. Recuerda utilizar la `lógica` y el `sentido común` sobre aquellas operaciones/propiedades que son comunes o se pueden ser necesarias en un futuro no muy lejano.

#### 5. **Pruebas de Funcionamiento**

Los estudiantes deben realizar pruebas para verificar que las operaciones CRUD funcionan correctamente con los ficheros de texto plano. Las pruebas deben incluir:

- **Crear** un nuevo empleado y verificar que se añade correctamente al archivo.
- **Leer** los datos de un empleado a partir del archivo.
- **Actualizar** la información de un empleado y verificar que se guarda correctamente en el archivo.
- **Eliminar** un empleado y verificar que se elimina correctamente del archivo.
- Obtener los empleados entre un rango de fechas, y por puesto que ocupan.
- Incluye una clase para probar el correcto funcionamiento de los métodos tal y como se ha realizado en clase.

#### 6. **Documentación**

La documentación debe incluir:

- Descripción de la interfaz `Operations` y sus métodos.
- Explicación de las clases `Empleado` y `FileOperations`.
- Descripción de la clase abstracta si es creada.
- Documentación de código.

### Evaluación

El ejercicio será evaluado según los siguientes criterios:

1. **Correcta Implementación de la Interfaz CRUD**: La interfaz `Operations` debe ser implementada correctamente, y cada operación CRUD debe devolver un valor idóneo.
2. **Uso de Clases Abstractas**: Se evaluará el diseño y la implementación si fuera creada.
3. **Funcionamiento de los Métodos**: Se verificará si las operaciones CRUD funcionan correctamente en el almacenamiento de ficheros planos.
4. **Claridad del Código y Documentación**: El código debe ser claro, eficiente y bien documentado. La documentación debe ser completa y precisa.
5. **Documentación**: Documentación de las clases y métodos implementados.
6. **Repositorio**: Crea un repositorio en `github` y muestra en el **README** el funcionamiento de la solución.

### Objetivo del Ejercicio

El objetivo de este ejercicio es comprender cómo implementar un sistema CRUD utilizando interfaces y clases abstractas.

## Nota

Utiliza los ejercicios realizados en clase y la [documentación de ficheros](https://github.com/jpexposito/code-learn/blob/main/primero/pro/unidades/unidad-4/MANEJO-FICHEROS-JAVA.md) y [fechas](https://github.com/jpexposito/code-learn/blob/main/primero/pro/unidades/comun/DATETIMEFORMATTER.md) para resolver el ejercicio.

## Licencia 📄

Este proyecto está bajo la Licencia (Apache 2.0) - mira el archivo [LICENSE.md]([../../../LICENSE.md](https://github.com/jpexposito/code-learn-practice/blob/main/LICENSE)) para detalles.
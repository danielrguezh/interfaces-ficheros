package es.ies.puerto.model;

import java.util.Set;
/**
 * Interfaz de operaciones CRUD
 * @author danielrguezh
 * @version 1.0.0
 */
public interface Operations {
    /**
     * Crear un nuevo objeto y almacenarlo
     * @param empleado
     * @return true/false
     */
    public boolean create(Empleado empleado);

    /**
     * Leer un empleado a partir de su identificador
     * @param identificador
     * @return true/false
     */
    public Empleado read(String identificador);

    /**
     * Leer un empleado a partir de objeto de tipo empleado
     * @param empleado
     * @return true/false
     */
    public Empleado read(Empleado empleado);

    /**
     * Actualizar un objeto existente
     * @param empleado
     * @return true/false
     */
    public boolean update(Empleado empleado);

    /**
     * Eliminar un objeto a partir de su identificador
     * @param identificador
     * @return true/false
     */
    public boolean delete(String identificador);

    /**
     * Debe de devolver el listado de empleados de un puesto en concreto
     * @param puesto
     * @return set de empleados en determinado puesto
     */
    public Set<Empleado> empleadosPorPuesto(String puesto);

    /**
     * Debe de devolver el listado de empleados entre dos fechas
     * @param fechaInicio 
     * @param fechaFin 
     * @return set de empleados en determinado puesto
     */
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin);
}

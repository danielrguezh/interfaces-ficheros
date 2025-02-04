package es.ies.puerto.model.fichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import es.ies.puerto.model.Empleado;
/**
 * Clase de ejmplo de operaciones con Map
 * @author danielrguezh
 * @version 1.0.0
 */
public class FileHashMapOperations extends FileOperations{
    /**
     * Constructor por defecto
     */
    public FileHashMapOperations(){
        super();
    }

    /**
     * Metodo que convierte la informacion del fichero en un Map
     * @param file
     * @return Map con los datos del fichero
     */
    private Map<String, Empleado> fileToMap (File file){
        Map<String, Empleado> empleadosMap=new TreeMap<>();

        Set<Empleado> empleados=super.readFile(file);
        for (Empleado empleado : empleados) {
            empleadosMap.put(empleado.getIdentificador(), empleado);
        }
        return empleadosMap;
    }
}

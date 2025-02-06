package es.ies.puerto.model.fichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import es.ies.puerto.model.Empleado;
import es.ies.puerto.model.Operations;
/**
 * Clase de ejmplo de operaciones con Map
 * @author danielrguezh
 * @version 1.0.0
 */
public class FileHashMapOperations extends FileOperations {
    File fichero;
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
    protected Map<String, Empleado> fileToMap (File file){
        Map<String, Empleado> empleadosMap=new TreeMap<>();

        Set<Empleado> empleados=super.fileToSet(file);
        for (Empleado empleado : empleados) {
            empleadosMap.put(empleado.getIdentificador(), empleado);
        }
        return empleadosMap;
    }

    @Override
    public boolean create(Empleado empleado) {
        if (empleado==null ||empleado.getIdentificador()==null) {
            return false;
        }
        Map<String,Empleado> empleados = fileToMap(fichero);
        if (empleados.containsKey(empleado.getIdentificador())) {
            return false;
        }
        return create(empleado.toString(), fichero);
    }

    /**
     * Metodo que agrega escribe la inforrmacion de la clase en el fichero
     * @param data
     * @param file
     * @return true/false
     */
    public boolean create(String data, File file) {
        try (BufferedWriter writer=new BufferedWriter(new FileWriter(file,true))){
            writer.write(data);
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public Empleado read(String identificador) {
        if (identificador==null || identificador.isBlank()) {
            return null;
        }
        Empleado empleado=new Empleado(identificador);
        return read(empleado);
    }

    @Override
    public Empleado read(Empleado empleado) {
        if (empleado==null) {
            return null;
        }
        Map<String,Empleado> empleados= fileToMap(fichero);
        Empleado empleadoBuscar=empleados.get(empleado.getIdentificador());
        if (empleadoBuscar==null) {
            return null;
        }
        return empleadoBuscar;
    }

    @Override
    public boolean update(Empleado empleado) {
        if (empleado ==null || empleado.getIdentificador()==null) {
            return false;
        }
        Map<String,Empleado> empleados = fileToMap(fichero);
        if (!empleados.containsKey(empleado.getIdentificador())) {
            return false;
        }
        empleados.put(empleado.getIdentificador(), empleado);
        return updateFile(empleados, fichero);
    }

    /**
     * Metodo que sobresescribe el fichero
     * @param empleados
     * @param file
     * @return
     */
    private boolean updateFile(Map<String,Empleado> empleados, File file){
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            return false;
        }
        for (Empleado empleado : empleados.values()) {
            create(empleado);
        }
        return true;
    }

    @Override
    public boolean delete(String identificador) {
        if (identificador==null || identificador.isBlank()) {
            return false;
        }
        Empleado empleado=new Empleado(identificador);
        Map<String, Empleado> empleados = fileToMap(fichero);
        if (!empleados.containsKey(empleado.getIdentificador())) {
            return false;
        }
        empleados.remove(identificador);
         return updateFile(empleados, fichero);
    }

    @Override
    public Set<Empleado> empleadosPorPuesto(String puesto) {
        Set<Empleado> empleados = (Set<Empleado>) fileToSet(fichero).stream().filter(e -> e.getPuesto().equals(puesto));
        return empleados;
    }

    @Override
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin) {
        if (fechaInicio==null || fechaInicio.trim().isEmpty() ||fechaFin==null || fechaFin.trim().isEmpty()) {
            return null;
        }
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio=LocalDate.parse(fechaInicio.trim(),formato);
        LocalDate fin=LocalDate.parse(fechaFin.trim(),formato);
        Set<Empleado> empleados = (Set<Empleado>) fileToSet(fichero);
        for (Empleado empleado : empleados) {
            LocalDate fecha=LocalDate.parse(empleado.getFechaNacimiento().trim(),formato);
            if (fecha.isBefore(inicio) || fecha.isAfter(fin)) {
                empleados.remove(empleado);
            }
        }
        return empleados;
    }

}

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

        Set<Empleado> empleados=super.readFile(file);
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
        Set<Empleado> empleados = readFile(fichero);
        if (empleados.contains(empleado)) {
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
        Set<Empleado> empleados= readFile(fichero);
        for (Empleado personaBuscar : empleados) {
            if (personaBuscar.equals(empleado)) {
                return personaBuscar;
            }
        }
        return empleado;
    }

    @Override
    public boolean update(Empleado empleado) {
        if (empleado ==null || empleado.getIdentificador()==null) {
            return false;
        }
        Set<Empleado> empleados = readFile(fichero);
        if (!empleados.contains(empleado)) {
            return false;
        }
        for (Empleado empleadoBuscado : empleados) {
            if (empleadoBuscado.equals(empleado)) {
                empleados.remove(empleadoBuscado);
                empleados.add(empleado);
                return updateFile(empleados, fichero);
            }
        }
        return false;
    }

    /**
     * Metodo que sobresescribe el fichero
     * @param empleados
     * @param file
     * @return
     */
    private boolean updateFile(Set<Empleado> empleados, File file){
        String path = file.getAbsolutePath();
        file.delete();
        try {
            file.delete();
            file.createNewFile();
        } catch (IOException e) {
            return false;
        }
        for (Empleado empleado : empleados) {
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
        Set<Empleado> empleados = readFile(fichero);
        if (!empleados.contains(empleado)) {
            return false;
        }
        for (Empleado empleadoBuscado : empleados) {
            if (empleadoBuscado.equals(empleado)) {
                empleados.remove(empleadoBuscado);
                return updateFile(empleados, fichero);
            }
        }
        return false;
    }

    @Override
    public Set<Empleado> empleadosPorPuesto(String puesto) {
        Set<Empleado> empleados = (Set<Empleado>) readFile(fichero).stream().filter(e -> e.getPuesto().equals(puesto));
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
        Set<Empleado> empleados = (Set<Empleado>) readFile(fichero);
        for (Empleado empleado : empleados) {
            LocalDate fecha=LocalDate.parse(empleado.getFechaNacimiento().trim(),formato);
            if (fecha.isBefore(inicio) || fecha.isAfter(fin)) {
                empleados.remove(empleado);
            }
        }
        return empleados;
    }

}

package es.ies.puerto.model.fichero.abstracts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import es.ies.puerto.model.Empleado;

public abstract class FileAbstractOperations {
    File fichero;
    //String ficheroNombre="empleados.txt";
    String path="/home/dam/Escritorio/interfaces-ficheros/src/main/resources/empleados.txt";

    /**
     * Constructorpor defecto
     * public FileOperations(){
        try {
            URL resource=getClass().getClassLoader().getResource(ficheroNombre);
            if (ficheroNombre==null) {
                
            }
            fichero=new File(resource.toURI());
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
     */
    public FileAbstractOperations() {
        fichero = new File(path);
        if (!fichero.exists() || !fichero.isFile()) {
            throw new IllegalArgumentException("El recurso no es de tipo fichero" +path);
        }
    }

    /**
     * Metodo que lee el fichero y retorna la documentacion
     * @param file
     * @return documentacion listada de empleados
     */
    public Set<Empleado> fileToSet(File file) {
        Set<Empleado> empleados=new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayLine = line.split(",");
                Empleado empleado=new Empleado(arrayLine[0], arrayLine[1], arrayLine[2],Double.parseDouble(arrayLine[3]), arrayLine[4]);
                empleados.add(empleado);
            }
        } catch (IOException e) {
            return new HashSet<>();
        }
        return empleados;
    }
}

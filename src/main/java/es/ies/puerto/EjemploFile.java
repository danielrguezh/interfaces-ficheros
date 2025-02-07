package es.ies.puerto;


import java.io.File;

import es.ies.puerto.model.Empleado;
import es.ies.puerto.model.fichero.FileHashMapOperations;
import es.ies.puerto.model.fichero.FileOperations;



public class EjemploFile {
    
    public static void main(String[] args) {

        FileOperations setOperations=new FileOperations();
        FileHashMapOperations mapOperations=new FileHashMapOperations();

        Empleado empleado=new Empleado("1", "Juan Perez", "Desarrollador", 3000.50, "15/10/1995");
        Empleado empleado2=new Empleado("2", "Ana Gomez", "Diseniadora", 2800.75,"10/01/1990");
        Empleado empleado3=new Empleado("3", "Luis Lopez", "Gerente", 4000.00, "30/07/2000");
        setOperations.create(empleado);
        mapOperations.create(empleado2);
        setOperations.create(empleado3);

        Empleado empleado2Update=new Empleado("2", "Ana Gomez", "Gerente", 2800.75,"10/01/1990");
        mapOperations.update(empleado2Update);
        setOperations.empleadosPorPuesto("Gerente");
        setOperations.empleadosPorEdad("01/01/1990", "01/01/2000");
        setOperations.delete("3");
        
 

    }
}
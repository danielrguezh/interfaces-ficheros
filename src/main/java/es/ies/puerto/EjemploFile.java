package es.ies.puerto;


import java.io.File;

import es.ies.puerto.model.Empleado;
import es.ies.puerto.model.fichero.FileOperations;



public class EjemploFile {
    
    public static void main(String[] args) {

        FileOperations fOperations=new FileOperations();
        Empleado empleado=new Empleado("1", "Juan Perez", "Desarrollador", 3000.50, "15/10/1995");
        Empleado empleado2=new Empleado("2", "Ana Gomez", "Diseniadora", 2800.75,"10/01/1990");
        Empleado empleado3=new Empleado("3", "Luis Lopez", "Gerente", 4000.00, "30/07/2000");
        fOperations.create(empleado);
        fOperations.create(empleado2);
        fOperations.create(empleado3);
        
        


    }
}
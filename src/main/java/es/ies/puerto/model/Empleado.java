package es.ies.puerto.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Set;
/**
 * Clase Empleado
 * @author danielrguezh
 * @version 1.0.0
 */
public class Empleado {
    private String identificador;
    private String nombre;
    private String puesto;
    private double salario;
    private String fechaNacimiento;

    /**
     * Constructor vacio
     */
    public Empleado() {
    }

    /**
     * Constructor con identificador
     * @param identificador
     */
    public Empleado(String identificador) {
        this.identificador = identificador;
    }

    /**
     * Constructor con propiedades
     * @param identificador
     * @param nombre
     * @param puesto
     * @param salario
     * @param fechaNacimiento
     */
    public Empleado(String identificador, String nombre, String puesto, double salario, String fechaNacimiento) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo que devuelve la edad del empleado
     * @return edad
     */
    public int getEdad(){
        DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDateNacimiento=LocalDate.parse(fechaNacimiento.trim(),formato);
        return (int) ChronoUnit.YEARS.between(localDateNacimiento, LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Empleado)) {
            return false;
        }
        Empleado empleado = (Empleado) o;
        return Objects.equals(identificador, empleado.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        return getIdentificador() +","+ getNombre() +","+ getPuesto() +","+ getSalario() +","+ getFechaNacimiento();
    }
    
}

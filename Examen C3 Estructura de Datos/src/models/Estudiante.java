package models;
public class Estudiante {
    private String matricula;
    private String nombre;
    private String carrera;

    public Estudiante(String matricula) {
        this.matricula = matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarrera() {
        return carrera;
    }
}
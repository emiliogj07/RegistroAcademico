/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registroacademico;


public class Estudiante {
    private String nombreCompleto;
    private String matricula;
    private String carrera;
    private double practicas;
    private double parciales;
    private double asignaciones;
    private double examenFinal;

    public Estudiante(String nombreCompleto, String matricula, String carrera, 
                      double practicas, double parciales, double asignaciones, double examenFinal) {
        this.nombreCompleto = nombreCompleto;
        this.matricula = matricula;
        this.carrera = carrera;
        this.practicas = practicas;
        this.parciales = parciales;
        this.asignaciones = asignaciones;
        this.examenFinal = examenFinal;
    }

  
    public double calcularNotaFinal() {
        return practicas + parciales + asignaciones + examenFinal;
    }

    public String obtenerEstado() {
        return calcularNotaFinal() >= 60.0 ? "APROBADO" : "REPROBADO";
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public double getPracticas() { return practicas; }
    public void setPracticas(double practicas) { this.practicas = practicas; }

    public double getParciales() { return parciales; }
    public void setParciales(double parciales) { this.parciales = parciales; }

    public double getAsignaciones() { return asignaciones; }
    public void setAsignaciones(double asignaciones) { this.asignaciones = asignaciones; }

    public double getExamenFinal() { return examenFinal; }
    public void setExamenFinal(double examenFinal) { this.examenFinal = examenFinal; }
}
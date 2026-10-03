public class Expediente {
    private Empleado empleado;
    private Departamento departamento;

    public Expediente(Empleado e, Departamento d) {
        this.empleado = e;
        this.departamento = d;
    }
    public Empleado getEmpleado() { return empleado; }
    public Departamento getDepartamento() { return departamento; }
}
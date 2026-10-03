public class Departamento {
    private String nombreDepartamento;
    private String ubicacion; // "Matriz" o "Sucursal"
    private int idDepartamento;

    public Departamento(int id, String nombre, String ubicacion) {
        this.idDepartamento = id;
        this.nombreDepartamento = nombre;
        this.ubicacion = ubicacion;
    }
    public String getNombreDepartamento() { return nombreDepartamento; }
    public String getUbicacion() { return ubicacion; }
    public int getIdDepartamento() { return idDepartamento; }
}
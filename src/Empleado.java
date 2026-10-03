public class Empleado {
    private String nombreCompleto;
    private int identificador; // 5 dígitos

    public Empleado(String nombreCompleto, int identificador) {
        this.nombreCompleto = nombreCompleto;
        this.identificador = identificador;
    }
    public String getNombreCompleto() { return nombreCompleto; }
    public int getIdentificador() { return identificador; }
}
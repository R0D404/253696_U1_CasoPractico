import java.util.Scanner;

public class ProgramaConsulta {

    private static Departamento[] departamentos = new Departamento[5];
    private static Expediente[] expedientes = new Expediente[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        cargarDatos();

        int opcion;
        do {
            System.out.println("\n===== RECURSOS HUMANOS =====");
            System.out.println("1. Consultar empleado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                consultar(sc);
            }
        } while (opcion != 0);

        System.out.println("Hasta luego");
        sc.close();
    }

    // Datos de ejemplo
    private static void cargarDatos() {
        departamentos[0] = new Departamento(1, "Ventas", "Matriz");
        departamentos[1] = new Departamento(2, "Sistemas", "Matriz");
        departamentos[2] = new Departamento(3, "Logística", "Sucursal");
        departamentos[3] = new Departamento(4, "Contabilidad", "Matriz");
        departamentos[4] = new Departamento(5, "Almacén", "Sucursal");

        expedientes[0] = new Expediente(new Empleado("Ana López Pérez", 10001), departamentos[0]);
        expedientes[1] = new Expediente(new Empleado("Luis Gómez Ruiz", 10002), departamentos[0]);
        expedientes[2] = new Expediente(new Empleado("María Torres Díaz", 20001), departamentos[1]);
        expedientes[3] = new Expediente(new Empleado("Carlos Ramírez Soto", 20002), departamentos[1]);
        expedientes[4] = new Expediente(new Empleado("Sofía Hernández Cruz", 30001), departamentos[2]);
        expedientes[5] = new Expediente(new Empleado("Jorge Martínez Luna", 40001), departamentos[3]);
        expedientes[6] = new Expediente(new Empleado("Laura Flores Vega", 50001), departamentos[4]);
    }

    // Paso 1: elegir departamento, Paso 2: buscar empleado
    private static void consultar(Scanner sc) {
        System.out.println("\n--- Departamentos ---");
        for (int i = 0; i < departamentos.length; i++) {
            System.out.println(departamentos[i].getIdDepartamento() + ". "
                    + departamentos[i].getNombreDepartamento()
                    + " (" + departamentos[i].getUbicacion() + ")");
        }

        System.out.print("Elige el id del departamento: ");
        int idDepto = sc.nextInt();

        Expediente[] filtrados = filtrarDepartamentos(idDepto);
        if (filtrados.length == 0) {
            System.out.println("No hay expedientes en ese departamento.");
            return;
        }

        int id;
        do {
            System.out.print("Ingresa el identificador del empleado (5 dígitos): ");
            id = sc.nextInt();
            if (String.valueOf(id).length() != 5) {
                System.out.println("El identificador debe tener exactamente 5 dígitos.");
            }
        } while (String.valueOf(id).length() != 5);

        Expediente resultado = buscarEmpleado(filtrados, id);
        if (resultado == null) {
            System.out.println("Empleado no encontrado en ese departamento.");
        } else {
            mostrar(resultado);
        }
    }

    public static Expediente[] filtrarDepartamentos(int idDepto) {
        int cont = 0;
        for (Expediente ex : expedientes) {
            if (ex != null && ex.getDepartamento().getIdDepartamento() == idDepto) {
                cont++;
            }
        }

        Expediente[] resultado = new Expediente[cont];
        int j = 0;
        for (Expediente ex : expedientes) {
            if (ex != null && ex.getDepartamento().getIdDepartamento() == idDepto) {
                resultado[j++] = ex;
            }
        }
        return resultado;
    }

    public static Expediente buscarEmpleado(Expediente[] filtrados, int identificador) {
        for (Expediente ex : filtrados) {
            if (ex.getEmpleado().getIdentificador() == identificador) {
                return ex;
            }
        }
        return null;
    }

    private static void mostrar(Expediente ex) {
        System.out.println("\n--- EXPEDIENTE ---");
        System.out.println("Empleado: " + ex.getEmpleado().getNombreCompleto());
        System.out.println("Identificador: " + ex.getEmpleado().getIdentificador());
        System.out.println("Departamento: " + ex.getDepartamento().getNombreDepartamento());
        System.out.println("Ubicación: " + ex.getDepartamento().getUbicacion());
    }
}
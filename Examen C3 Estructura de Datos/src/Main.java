import models.Estudiante;
import java.util.*;

public class Main {
    private static final List<String> MATRICULAS_PRECARGADAS = Arrays.asList("173616", "182633", "173620", "192020", "202226", "213610", "193626", "182639", "173602", "173615");
    private static final Map<String, Estudiante> estudiantes = new HashMap<>(); //HashMap estudiantes.
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean flag = true; //Bandera principal.
        String opcion;
        do {
            System.out.println("\n*** Menú ***");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Buscar con matrícula");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Imprimir lista ordenada");
            System.out.println("x. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese la matrícula del estudiante: ");
                    String matricula = scanner.nextLine();
                    if (!MATRICULAS_PRECARGADAS.contains(matricula)) {
                        System.out.println("Matrícula inválida. Debe ser una de las diez matrículas proporcionadas.");
                        break;
                    }

                    Estudiante estudiante = new Estudiante(matricula); //Objeto estudiante contiene la matricula.

                    System.out.print("Ingrese el nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    estudiante.setNombre(nombre);

                    System.out.print("Ingrese la carrera del estudiante: ");
                    String carrera = scanner.nextLine();
                    estudiante.setCarrera(carrera);

                    estudiantes.put(matricula, estudiante); //Guardar al HashMap.
                    System.out.println("Estudiante agregado correctamente.");
                    break;
                case "2":
                    System.out.print("Ingrese la matrícula a buscar: ");
                    matricula = scanner.nextLine();
                    estudiante = estudiantes.get(matricula); //Obtiene la matricula
                    if (estudiante != null) { //Si el objeto no esta vacio...
                        System.out.println("Estudiante encontrado:");
                        System.out.println("Nombre: " + estudiante.getNombre());
                        System.out.println("Carrera: " + estudiante.getCarrera());
                    } else {
                        System.out.println("Estudiante no encontrado."); // Si esta vacio...
                    }
                    break;
                case "3":
                    System.out.print("Ingrese la matrícula del estudiante a eliminar: ");
                    matricula = scanner.nextLine();
                    estudiante = estudiantes.get(matricula);
                    
                    if (estudiante != null) {
                        System.out.println("¿Está seguro de que desea eliminar al estudiante? (S/N)");
                        String respuesta = scanner.nextLine().toUpperCase();
                        if (respuesta.equals("S")) {
                            estudiantes.remove(matricula);
                            System.out.println("Estudiante eliminado correctamente.");
                        } else {
                            System.out.println("No se eliminó al estudiante.");
                        }
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;
                case "4":
                    List<String> matriculasOrdenadas = new ArrayList<>(estudiantes.keySet());
                    Collections.sort(matriculasOrdenadas);
                    System.out.println("Lista de estudiantes ordenada por matrícula ascendente:");
                    for (String i: matriculasOrdenadas) {
                        estudiante = estudiantes.get(i);
                        System.out.println("Matrícula: " + estudiante.getMatricula() +
                                ", Nombre: " + estudiante.getNombre() +
                                ", Carrera: " + estudiante.getCarrera());
                    }
                    break;
                case "x":
                    System.out.println("Desea salir del programa?");
                    System.out.println("1) Salir / X) No");
                    String finalOption = scanner.nextLine() ;
                    if (finalOption.equals("1") ){
                        System.out.println("Cerrando Programa...");
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (flag);
    }
}

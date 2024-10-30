package EjercicioA;

import java.util.HashMap;
import java.util.Scanner;

public class Agenda {
    private static final HashMap<String, Long> agenda = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void inicio() {
        int opcion;
        do {
            System.out.println("1- Cargar Datos en la Agenda");
            System.out.println("2- Buscar Teléfono por Nombre");
            System.out.println("3- Listar Agenda");
            System.out.println("0- Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    cargar_datos_en_agenda();
                    break;
                case 2:
                    buscar_telefono_por_nombre();
                    break;
                case 3:
                    listar_agenda();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    private static void cargar_datos_en_agenda() {
        String nombre;
        long telefono;
        boolean seguirCargando = true;

        while (seguirCargando) {
            System.out.print("Ingrese el nombre completo: ");
            nombre = sc.nextLine();

            if (agenda.containsKey(nombre)) {
                System.out.println("El nombre ya existe en la agenda.");
            } else {
                System.out.print("Ingrese el teléfono: ");
                telefono = sc.nextLong();
                sc.nextLine(); // consume newline left-over

                agenda.put(nombre, telefono);
            }

            System.out.print("¿Desea seguir cargando? Ingrese 'n' para terminar o cualquier otra tecla para continuar: ");
            seguirCargando = !sc.nextLine().equalsIgnoreCase("n");
        }
    }

    private static void buscar_telefono_por_nombre() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = sc.nextLine();

        if (agenda.containsKey(nombre)) {
            System.out.println("Teléfono de " + nombre + ": " + agenda.get(nombre));
        } else {
            System.out.println("La persona buscada no se encuentra en la agenda");
        }
    }

    private static void listar_agenda() {
        for (String nombre : agenda.keySet()) {
            System.out.println("Nombre: " + nombre + ", Teléfono: " + agenda.get(nombre));
        }
    }

    public static void main(String[] args) {
        inicio();
    }
}
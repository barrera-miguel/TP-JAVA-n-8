package EjercicioB;

import java.util.Scanner;

public class CostoComputadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Ingrese la marca de la computadora: ");
            String marca = sc.nextLine();
            System.out.println("Ingrese el modelo de la computadora: ");
            String modelo = sc.nextLine();
            Computadora computadora = new Computadora(marca, modelo);
            while (true) {
                System.out.println("Ingrese el componente de CPU (o 'fin' para terminar): ");
                String componente = sc.nextLine();
                if (componente.equals("fin")) {
                    break;
                }
                System.out.println("Ingrese la marca del componente: ");
                String marcaComponente = sc.nextLine();
                System.out.println("Ingrese la cantidad del componente: ");
                int cantidad = sc.nextInt();
                System.out.println("Ingrese el precio del componente: ");
                double precio = sc.nextDouble();
                sc.nextLine();
                computadora.agregar_componente(new ComponenteCPU(componente, marcaComponente, cantidad, precio));
            }
            computadora.mostrarInformacion();
            System.out.println("Desea cotizar una nueva computadora? (SI/NO)");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("NO")) {
                break;
            }
        }
    }
}
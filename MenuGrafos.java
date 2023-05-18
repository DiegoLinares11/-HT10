import java.util.Scanner;

public class MenuGrafos {

    public static void main(String[] args) {
        Controlador op = new Controlador();
        Scanner scanner = new Scanner(System.in); 
        op.importText();
        String fila = "", columna = "";
        int valor = 0;
        op.iniciar();
        String opcion = "";
        while (!opcion.equals("7")) {
            System.out.print(
                    "Ingrese una opcion");
            System.out.println("1. Mostrar ruta entre 2 ciudades y su peso(distancia)");
            System.out.println("2. Mostrar centro");
            System.out.println("3. Realizar una interrupcion entre ciudades");
            System.out.println("4. Realizar modificacion de distancia de camino");
            System.out.println("5. Mostrar matriz de adyacencia");
            System.out.println("6. Mostrar matriz con calculos de floyd");
            System.out.println("7. Salir");
        
            opcion = scanner.nextLine();
            if (opcion.equals("1")) {
                System.out.print("Ingrese ciudad de inicio: ");
                fila = scanner.nextLine();
                System.out.print("Ingrese ciudad de destino: ");
                columna = scanner.nextLine();
                System.out.println(op.imprimirInfo(fila, columna));
            }
            if (opcion.equals("2")) {
                System.out.println(op.imprimirCentro());
            }
            if (opcion.equals("3")) {
                System.out.print("Ingrese ciudad de inicio: ");
                fila = scanner.nextLine();
                System.out.print("Ingrese ciudad de destino: ");
                columna = scanner.nextLine();
                op.Interrupcion(fila, columna);
                op.ReCalcular();
            }
            if (opcion.equals("4")) {
                System.out.print("Ingrese ciudad de inicio: ");
                fila = scanner.nextLine();
                System.out.print("Ingrese ciudad de destino: ");
                columna = scanner.nextLine();
                System.out.print("Ingrese distancia entre ciudades: ");
                valor = scanner.nextInt();
                op.modificarRuta(fila, columna, valor);
                op.ReCalcular();
            }
            if (opcion.equals("5"))
                System.out.println(op.imprimirMatriz());
            if (opcion.equals("6"))
                System.out.println(op.imprimirCalculos());
        }
    }

}



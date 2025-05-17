import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        String PURPLE = "\033[0;35m";
        String RESET = "\u001B[0m";

        Scanner teclado = new Scanner(System.in);

        System.out.println("---- Simulador de préstamos ----");
        System.out.println("Ingrese el monto del préstamo:");
        double monto = teclado.nextDouble();
        System.out.println("Ingrese la tasa de interés anual (%):");
        double tasa = teclado.nextDouble();
        System.out.println("Ingrese el plazo en meses:");
        int plazo = teclado.nextInt();

        Prestamo prestamo = new Prestamo(monto, tasa, plazo);
        System.out.println(PURPLE + "\nResumen del préstamo:" + RESET);
        Simulador.mostrarResumen(prestamo);

        teclado.close();
    }
}

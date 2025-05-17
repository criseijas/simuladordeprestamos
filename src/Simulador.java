public class Simulador {

    /*Usás métodos static cuando:
    Los métodos en Simulador.java están definidos como static porque no necesitan acceder a atributos propios de una instancia de la clase Simulador. Es decir, no es necesario crear un objeto de tipo Simulador para poder usar esos métodos.
    El método no depende de datos internos (atributos) del objeto.
    Su funcionalidad es utilitaria, como cálculos o acciones generales.
    Se los quiere llamar directamente con el nombre de la clase, sin instanciarla.
     */

    public static double calcularCuotaMensual(Prestamo prestamo) {
        double monto = prestamo.getMonto();
        double tasaMensual = prestamo.getTasaAnual() / 12 / 100; //se transforma la tasa anual a tasa mensual dividiendo por 12, y luego se convierte de porcentaje a decimal dividiendo por 100.
        int plazo = prestamo.getPlazoMeses(); //la cantidad de meses en los que se va a pagar.

        if (tasaMensual == 0) { //Si no hay interés (0%), entonces simplemente divide el monto en cuotas iguales. Por ejemplo, $12.000 en 12 meses = $1.000 por mes.
            return monto / plazo;
        }

        double cuota = monto * tasaMensual * Math.pow(1 + tasaMensual, plazo) /   //Esta es la fórmula de amortización francesa, que se usa en la mayoría de los préstamos personales, hipotecarios, etc. Calcula cuánto se paga cada mes con interés.
                (Math.pow(1 + tasaMensual, plazo) - 1);                           //Math.pow es un método en Java que sirve para elevar un número a una potencia.

        return cuota; //Devuelve el valor final de la cuota mensual.
    }

    public static void mostrarResumen(Prestamo prestamo) {

        double cuota = calcularCuotaMensual(prestamo);
        double total = cuota * prestamo.getPlazoMeses();
        double intereses = total - prestamo.getMonto();

        System.out.printf("Monto solicitado: $%.2f%n", prestamo.getMonto()); //%: indica que viene un formato especial
                                                                             //.2: muestra 2 decimales
                                                                             //f: significa que es un número de punto flotante (tipo float o double)
                                                                             //$: es simplemente un carácter normal, que en este contexto se usa para mostrar el símbolo de moneda
                                                                             //%n representa un salto de línea (como \n), pero es portátil entre distintos sistemas operativos (Windows, Linux, Mac)
        System.out.printf("Tasa de interés anual: %.2f%%%n", prestamo.getTasaAnual());//%%: Imprime un símbolo % literal
        System.out.printf("Plazo: %d meses%n", prestamo.getPlazoMeses());
        System.out.printf("Cuota mensual: $%.2f%n", cuota);
        System.out.printf("Total a pagar: $%.2f%n", total);
        System.out.printf("Total de intereses: $%.2f%n", intereses);

    }

    /*| Formato | Tipo de dato esperado | Descripción                         | Ejemplo de salida |
            | ------- | --------------------- | ----------------------------------- | ----------------- |
            | `%d`    | `int`                 | Número entero                       | `123`             |
            | `%f`    | `float` o `double`    | Número decimal (por defecto 6 dec.) | `3.141593`        |
            | `%.2f`  | `float` o `double`    | Decimal con 2 cifras después del .  | `3.14`            |
            | `%s`    | `String`              | Cadena de texto                     | `"Hola"`          |
            | `%c`    | `char`                | Un solo carácter                    | `A`               |
            | `%n`    | —                     | Nueva línea (cross-platform)        | (salto de línea)  |
            | `%b`    | `boolean`             | Valor booleano                      | `true` o `false`  |*/

}

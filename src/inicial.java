import java.util.Scanner;

public class Documentar {

    //El metodo main llama a los metodos pedirNumero(), generarVectorInicial(), generarVectorPrimos() e imprimirVector().
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int numero = pedirNumero(teclado);
        int[] vectorInicial = generarVectorInicial(numero);
        imprimirVector(vectorInicial, "Vector inicial hasta: " + numero);
        int[] primos = generarVectorPrimos(numero);
        imprimirVector(primos, "Vector de primos hasta: " + numero);
    }

    //El método pedirNumero() utiliza el Scanner para solicitar al usuario que ingrese un número entero y devuelve este valor.
    public static int pedirNumero(Scanner teclado) {
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        return teclado.nextInt();
    }

    //El método generarVectorInicial() crea un vector de tamaño "numero" e inicializa cada elemento del vector con valores consecutivos desde 1 hasta "numero".
    public static int[] generarVectorInicial(int numero) {
        int[] vector = new int[numero];

        for (int i = 0; i < vector.length; ++i) {
            vector[i] = i + 1;
        }

        return vector;
    }

    //El método generarVectorPrimos() utiliza el algoritmo de la criba de Eratóstenes para generar un vector de números primos hasta "numero".
    public static int[] generarVectorPrimos(int numero) {
        boolean[] esPrimo = new boolean[numero + 1];

        int i;
        for (i = 0; i < esPrimo.length; ++i) {
            esPrimo[i] = true;
        }

        esPrimo[0] = esPrimo[1] = false;

        int j;
        for (i = 2; (double) i <= Math.sqrt(numero); ++i) {
            if (esPrimo[i]) {
                for (j = i * i; j <= numero; j += i) {
                    esPrimo[j] = false;
                }
            }
        }

        i = 0;

        for (j = 0; j < esPrimo.length; ++j) {
            if (esPrimo[j]) {
                ++i;
            }
        }

        int[] primos = new int[i];
        i = 0;

        for (j = 0; i < esPrimo.length; ++i) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }

        return primos;
    }

    //El método imprimirVector() imprime el vector que se le pasa como argumento, con un mensaje que indica el propósito del vector y los números se imprimen en filas de 10 elementos.
    public static void imprimirVector(int[] vector, String mensaje) {
        System.out.println("\n" + mensaje);

        for (int i = 0; i < vector.length; ++i) {
            System.out.print(vector[i] + "\t");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }

    }
}


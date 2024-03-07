//1. Suma de elementos en un array: Crea un programa que reciba un array de enteros y calcule la suma de todos los elementos del array

public class Exercise1 {
    public void E1() {

        int[] numeros = { 2, 44, 5, 6, 87, 6 };
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
        }

        System.out.println("Array:");
        for (int j: numeros){
            System.out.print(j+" ");
        }
        System.out.println("\nLa suma de los elementos del array es : "+suma);

    }
}

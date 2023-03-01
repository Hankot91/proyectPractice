package com.main;


import java.io.*;
import java.util.Scanner;

import com.main.Funciones.Funciones;

class mainApp{
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean menu = true;
        boolean repetition = true;
        int option = 0;

        
        //menu
        while(repetition){
            while (menu) {
                try {
                
                    System.out.println("1. Invertir una cadena");
                    System.out.println("2. Recorrer un arreglo de strings");
                    System.out.println("3. Recorrer una matriz");
                    System.out.println("4. Creacion y eliminacion de elementos de un vector");
                    System.out.println("5.  ¿Cual es el problema de utilizar un Vector con la capacidad por defecto?");
                    System.out.println("6. Creacion y copia de un arrayList en una linkedList");
                    System.out.println("7. Mostrar una ArrayList con numeros impares");
                    System.out.println("8. Throws dividir entre cero");
                    System.out.println("9. Crear y copiar un fichero");
                    System.out.println("10. Contador de palabras");
                    System.out.println("11. Salir");
                    System.out.print("Selecione una opcion: ");
                    option = Integer.parseInt(scanner.nextLine());
                    menu = false;
                } catch (NumberFormatException e) {
                    System.out.println("No es una opcion valida.");
                }
            }

            switch (option) {
                case 1:
                    System.out.print("Ingrese una cadena: ");
                    String cadena = scanner.nextLine();
                    System.out.println("Su cadena invertida es: " + Funciones.stringInvertor(cadena));
                    menu = true;
                    break;

                case 2:
                    String array[] = Funciones.inputArray();
                    Funciones.showArray(array);
                    menu = true;
                    break;
                    
                case 3:
                    int matriz[][] = Funciones.inputMatriz();
                    Funciones.showMatriz(matriz);
                    menu = true;
                    break;

                case 4:
                    Funciones.showAndRemove();
                    menu = true;
                    break;

                case 5: 
                    Funciones.showAnswer();
                    menu = true;
                    break;

                case 6:
                    Funciones.showAndCopy();
                    menu = true;
                    break;

                case 7:
                    Funciones.fillArrayList();
                    menu = true;
                    break;

                case 8:
                    System.out.print("ingrese el dividendo: ");
                    int dividendo = scanner.nextInt();
                    System.out.print("Ingrese el divisor: ");
                    int divisor = scanner.nextInt();
                    try {
                        int result = Funciones.divideByZero(dividendo, divisor);
                        System.out.println("El resultado es: " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("Esto no puede hacerse.");
                    }   finally{
                        System.out.println("Demo del codigo: ");
                        System.out.println("Trata que el divisor no sea '0'" );
                    }
                    menu = true;
                    break;

                case 9:
                try {
                    InputStream fileIn = new FileInputStream("archivo.txt");
                    PrintStream fileOut = new PrintStream("copia.txt");
                    Funciones.copyFile(fileIn, fileOut);
                    } catch (FileNotFoundException e) {
                        System.out.println("No se ha encontrar el ficheros.");   
                    }
                    menu = true;
                    break;

                case 10:
                try {
                    Funciones.countWords();
                    
                } catch (FileNotFoundException e) {
                    System.out.println("Archivo no encontrado");
                }
                    menu = true;
                    break;

                case 11:

                    repetition = false;
                    break;

                default:
                    repetition = false;
                    break;
            }
    
            
        } 
        scanner.close();

    }

}


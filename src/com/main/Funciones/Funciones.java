package com.main.Funciones;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

@SuppressWarnings("resource")

public class Funciones {

    public static String stringInvertor(String str){
        return new StringBuilder(str).reverse().toString();
    }

    public static String[] inputArray(){
        Scanner scanner = new Scanner(System.in);
        String array[] = new  String[5];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Ingrese un texto para la posicion " + (i + 1) + ": ");
            array[i] = scanner.nextLine();
        }
        return array;
    }

    public static void showArray(String array[]){
        for(String line : array){
            System.out.print(line + ", ");
        }
        System.out.println(" ");
    }

    public static int[][] inputMatriz(){
        Scanner scanner = new Scanner(System.in);
        int matriz[][] = new int[3][3];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("Ingrese un numero para la posicion (" + (i + 1) + "),  (" + (j + 1) + "): ");
                matriz[i][j] = scanner.nextInt();
                System.out.println(" ");
            }
        }
        
        return matriz;
    }

    public static void showMatriz(int matriz[][]){
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print("(" + i + ")" + " (" + j + "): " +matriz[i][j] + ", ");
            }
            System.out.println(" ");
        }
    }

    public static void showAndRemove(){
        Vector<String> vector = new Vector<>(5);
        vector.add("Hola");
        vector.add("Como");
        vector.add("Estas");
        vector.add("Adios");
        vector.add("Buenas");

        showArray(vector.toArray(new String[vector.size()]));

        vector.remove("Como");
        vector.remove("Estas");

        System.out.println("Vector despues de eliminar el 2do y 3er elemento");

        showArray(vector.toArray(new String[vector.size()]));

    }

    public static void showAnswer(){
        System.out.println("En el caso de agregar 1000 elementos a un Vector con una capacidad por defecto de 10,\n" +
                                                        "el vector tendria que redimensionarse 8 veces ya que lo hace en multiplos de dos.\n" +
                                                        "Cada redimensionamiento conlleva un costo adicional de tiempo y memoria\n"+
                                                        "lo que puede afectar significativamente el rendimiento de la aplicación.\n" +
                                                        "Para evitar este problema, se recomienda especificar una capacidad inicial adecuada al crear un Vector. ");
    }

    public static void showAndCopy(){
        ArrayList<String> vector = new ArrayList<>();
        vector.add("Grecia");
        vector.add("Marruecos");
        vector.add("Colombia");
        vector.add("España");

        System.out.println("Valores de la arrayList: " + vector);
        LinkedList<String> vectorList = new LinkedList<>();
        vectorList.addAll(vector);
        System.out.println("Valores de la LinkedList: " + vectorList);
    }

    public static void fillArrayList(){
        ArrayList<Integer> numeros = new ArrayList<>();
        int count = 1;
        while(count <= 10){
            if(count % 2 != 0){
                numeros.add(count);
            }

            count++;
        }

        System.out.println("ArrayList excluyendo los numeros pares: " + numeros);
    }

    public static int divideByZero(int a, int b) throws ArithmeticException{
        try{
            return a / b;
        }catch(ArithmeticException e){
            throw new ArithmeticException("No se puede dividir por 0");
        }
    }


    public static void copyFile(InputStream fileIn, PrintStream fileOut){
        try {
            byte dato[] = fileIn.readAllBytes();
            fileIn.close();
            fileOut.write(dato);    
            fileOut.close();
            System.out.println(" ");

            } catch (FileNotFoundException e) {
                System.out.println("No se ha encontrar el ficheros.");
            } catch(IOException e){
                System.out.println("No se ha podido leer el fichero.");
            }
    }

    public static void countWords() throws IOException {
        //creamos tanto un mapa , como un array list y de un archivo txt un texto
        InputStream input = new FileInputStream("textoContator.txt");
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        ArrayList<String> words = new ArrayList<String>();
        Scanner fileScanner = new Scanner(input);

        //consiste en que escaneamos palabra por palabra del archivo  y si no se agregado al hashmap, se agraga
        // de lo contrario se aumenta su valor dentro del HashMap y se agrega tambien al arraylist
        //para evitar errores del contador todo del texto se paso a minuscula y se elimina cualquier caracter espeial
        while (fileScanner.hasNext()) {
            String word = fileScanner.next().toLowerCase().replaceAll("[^\\w\\d]", "");
            if (count.containsKey(word)) {
                count.put(word, count.get(word) + 1);
            } else {
                count.put(word, 1);
                words.add(word);
            }
        }

        //mosstrando las palabras con la cantidad de veces que aparecen en el texto
        System.out.println("Resultados:");
        for (String word : words) {
            System.out.print(word + ": " + count.get(word) + ", ");
        }
        input.close();
        fileScanner.close();
    }

}


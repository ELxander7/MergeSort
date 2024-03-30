package ru.itis.aisd304.mergesort2;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        TestGenerator.testGenerate();

        try {
            FileReader fr = new FileReader("myFile.txt");
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] str = line.split(" ");
                int[] array = new int[str.length];
                for (int i = 0; i < str.length; i++) {
                    array[i] = Integer.parseInt(str[i]);
                }

                //
                double start = System.nanoTime();
                int k = MergeSort.mergeSort(array, array.length);
                double end = System.nanoTime();
                //

                System.out.println(str.length + ": " + (end-start)  + " наносекунд " + k + " итераций");

                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
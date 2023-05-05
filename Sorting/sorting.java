import java.util.*;
import java.util.Collections;

public class sorting {

    // function for bubble sort
    public static void bubbleSort(int data[]) {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - 1 - i; j++) {
                if (data[j] > data[j + 1]) {
                    data[j] = data[j] ^ data[j + 1];
                    data[j + 1] = data[j] ^ data[j + 1];
                    data[j] = data[j] ^ data[j + 1];
                }
            }
        }
    }

    // function for selection sort
    public static void selectionSort(int data[]) {
        for (int i = 0; i < data.length - 1; i++) {
            int index = i;
            for (int j = i; j < data.length; j++) {
                if (data[index] < data[j]) {
                    index = j;
                }
            }
            // swaping
            int temp = data[i];
            data[i] = data[index];
            data[index] = temp;
        }
    }

    // function for incertion sort
    public static void incertionSort(int data[]) {
        for (int i = 1; i < data.length; i++) {
            int prev = i - 1;
            int temp = data[i];
            while (prev >= 0 && data[prev] > temp) {
                data[prev + 1] = data[prev];
                prev--;
            }
            data[prev + 1] = temp;
        }
    }



    public static void main(String[] args) {
        Integer data[] = { 5, 9, 1, 43, 9, 3 };
        //incertionSort(data);
        Arrays.sort(data,Collections.reverseOrder());
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
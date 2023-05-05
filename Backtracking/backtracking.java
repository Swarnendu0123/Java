import java.util.*;

public class backtracking {

    public static void changeArr(int data[], int i, int value) {
        // base case
        if (i == data.length) {
            printArr(data);
            return;
        }
        // recurtion step
        data[i] = value;
        changeArr(data, i + 1, value + 1);
        data[i] = data[i] - 2;
    }

    // function to print array
    public static void printArr(int data[]) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int data[] = new int[5];
        printArr(data);
        changeArr(data, 0, 1);
        printArr(data);
    }

}
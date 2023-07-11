import java.util.*;

interface Calculator {
    int add(int a, int b);
    int sub(int a, int b);
}

class Calc implements Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }
}

public class test {
    public static void main(String[] args) {
        Calculator c = new Calc();
        System.out.println(c.sub(12, 13));
    }
}
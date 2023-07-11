public class test3 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = -2;
        try {
            if (num2 < 0) {
                Exception e = new ArithmeticException();
                throw e;
            }
            int result = num1 / num2;
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Enter a valid number");
            System.out.println("Error: " + e);
        }
    }
}

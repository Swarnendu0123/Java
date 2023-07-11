public class test {
    public static void main(String[] args) {
        // normal statement
        int a = 10;
        int b = 0;
        // critical exceptation
        try {
            int temp = a / b;
            System.out.println(temp);
        } catch (Exception e) {
            System.err.println("Some error occured");
        }
        System.out.println("Bye");
    }
}
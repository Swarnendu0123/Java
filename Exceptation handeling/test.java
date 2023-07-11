public class test {
    public static void main(String[] args) {
        // normal statement
        int data[] = { 1, 2, 3, 4, 5 };
        // critical exceptation
        try {
            int temp = data[data.length];
            System.out.println(temp);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
        System.out.println("Bye");
    }
}
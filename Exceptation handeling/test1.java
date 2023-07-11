import java.util.*;

public class test1 {
    public static void main(String[] args) {
        int name = 0;
        try (Scanner in = new Scanner(System.in)) {
            name = in.nextInt();
        } catch (Exception e) {
            System.out.println("some error occured");
        }
        System.out.println(name);
    }
}
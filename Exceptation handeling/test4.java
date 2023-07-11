import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test4 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
    }
}

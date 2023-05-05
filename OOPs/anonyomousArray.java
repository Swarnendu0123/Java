import java.util.*;

class Calc{
    public int add(int[] data){
        int result = 0;
        for(int n:data){ // enhanced for loop
            result+=n;
        }
        return result;
    }
}
public class anonyomousArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            Calc obj =new Calc();
            int result=obj.add(new int[]{4,96,4,100,96});// anonyomous array
            System.out.println(result);
    } 
}

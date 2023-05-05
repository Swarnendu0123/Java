import java.util.*;
public class pattern3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int mid=n/2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(j==mid){
                    System.out.print(i+" ");
                }
                else{
                    System.out.print("  ");
                }
            }
            if(mid%2==0){
                mid=mid-i;
            }else{
                mid=mid+i;
            }
            System.out.println();
        }
    }
}

import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] augs) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();

       
    for(int i=0;i<n;i++){


        //D
        for(int j=0;j<n;j++){
            if(((i==0||i==n-1) && j<(n+1)/2)||(j==(n+1)/2&&(i<n-1&&i>0))||j==0){
                System.out.print("* ");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.print("    ");


        //A
        for(int j=0;j<n;j++){
            if((i==0&&j>0&&j<n-1)||i==(n-1)/2||((j==0||j==n-1)&&i>0)){
                System.out.print("* ");
            }
            else{
                System.out.print("  ");
            }
        }
        System.out.print("    ");


             //T
        for(int j=0;j<n;j++){
            if(i==0||j==n/2){
                System.out.print("* ");
            }
            else{
                System.out.print("  ");
            }
        }
            System.out.println();
        

        }
    }
}
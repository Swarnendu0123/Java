import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        int n=in.nextInt();
        for(int i=0;i<n;i++){

        // * * * * * * * * * * * * * 
        // * *       *   *       * * 
        // *   *   *       *   *   * 
        // *     *           *     * 
        // *   *   *       *   *   * 
        // * *       *   *       * * 
        // *           *           * 
        // * *       *   *       * * 
        // *   *   *       *   *   * 
        // *     *           *     * 
        // *   *   *       *   *   * 
        // * *       *   *       * * 
        // * * * * * * * * * * * * * 
         for(int j=0;j<n;j++){
            if(i==j||i+j==n-1||i==0||j==0||j==n-1||i==n-1||i+j==(n-1)/2||i+j==3*(n-1)/2||i-j==(n-1)/2||j-i==(n-1)/2){
            System.out.print("* ");
            }
            else{
                System.out.print("  ");
            }
         }  

         System.out.print("     ");

         for(int j=0;j<n;j++){
            if(i+j<=(n-1)/2||i-j>=(n-1)/2||(j-i>=(n-1)/2||i+j>=3*(n-1)/2)){
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

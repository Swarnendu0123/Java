import java.util.*;
class Gusser{
    int numGussed;
    public int tellNumber() {
    Scanner in = new Scanner(System.in);
    System.out.println("hi gusser enter the number");
    numGussed=in.nextInt();
    return numGussed; 
    }
}

class Player{
    int numGussed;
    public int tellNumber() {
    Scanner in = new Scanner(System.in);
    System.out.println("hi player enter the number");
    numGussed=in.nextInt();
    return numGussed;    
    }
}

class Umpair {
    int gussedNumber;
    int gussedP1;
    int gussedP2;
    int gussedP3;
   public void collectNumberFromGusser(){
    Gusser G1 = new Gusser();
    gussedNumber=G1.tellNumber();
   }
   public void collectNumbersFromPlayers(){
    Player P1 = new Player();
    Player P2 = new Player();
    Player P3 = new Player();
    gussedP1=P1.tellNumber();
    gussedP2=P2.tellNumber();
    gussedP3=P3.tellNumber();
   }

   public void result() {
      boolean check=false;
    if(gussedNumber==gussedP1){
        System.out.println("Player 1 wins!");
        check=true;
    } 
    if(gussedNumber==gussedP2){
        System.out.println("Player 2 wins!");
        check=true;
    } 
    if(gussedNumber==gussedP3){
        System.out.println("Player 3 wins!");
        check=true;
    }
    if(check==false){
        System.out.println("all lost");
    } 
    System.out.println("The number was "+gussedNumber);
   }
}

public class guesserGame{
    public static void main(String[] args) {
        Umpair U =new Umpair();
        U.collectNumberFromGusser();
        U.collectNumbersFromPlayers();
        U.result();
    }
}

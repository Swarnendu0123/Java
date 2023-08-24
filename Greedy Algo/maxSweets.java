// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class HelloWorld {
    static class Sweet {
        int price;
        int cashback;
        int id;
        int realPrice;
        Sweet(int id, int price, int cashback) {
            this.id = id;
            this.price = price;
            this.cashback = cashback;
            this.realPrice = price - cashback;
        }
    }

    public static void main(String[] args) {
        int money = 4;
        int sw[][] = { { 5, 1 }, { 4, 2 }};
        ArrayList<Sweet> sweets = new ArrayList<>();
        for (int i = 0; i < sw.length; i++) {
            sweets.add(new Sweet(i, sw[i][0], sw[i][1]));
        }
        
        //sorting according to their realPrice 
        Collections.sort(sweets, (a, b) -> a.realPrice - b.realPrice);
        ArrayList<Integer> mySweets = new ArrayList<>();
        
        int i=0;
        while(money > 0 && i<sweets.size()){
            if(money >= sweets.get(i).price){
                mySweets.add(sweets.get(i).id);
                money-=sweets.get(i).realPrice;
            }else{
                i++;
            }
        }

        System.out.println("max sweets = " + mySweets.size());
        System.out.println();
        System.out.println("------------------------");
        System.out.println("mySweets = " + mySweets);
    }
}

public class fractionalKnapsack {
    public static void main(String[] args) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        float product[][] = new float[value.length][3];
        for (int i = 0; i < weight.length; i++) {
            product[i][0] = value[i];
            product[i][1] = weight[i];
            product[i][2] = value[i] / weight[i];
        }
        // product array should be sorted in decreasing order of 3rd row ie :
        // product[i][2]
        // Arrays.sort(product, Comparator.comparingDouble(o -> o[2]));
        int capacity = 0;
        float money = 0;
        int i = 0;
        while ((capacity < W) && (i < value.length)) {
            if (W - capacity > product[i][1]) {
                capacity += product[i][1];
                money += product[i][0];
            } else {
                money = money + (product[i][2]) * (W - capacity);
                capacity = W;
            }
            i++;
        }
        System.out.println("Money = " + money);
    }
}

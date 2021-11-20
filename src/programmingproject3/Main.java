package programmingproject3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static Items [] items = new Items[321];
    public static int [] prices = new int[321];
    public static int [] values = new int[321];

    public static void main(String [] args){

        loadItems("items.csv");
        printItems();
        int n = prices.length;
        int W = values.length;
        /*int optimal[][] = */knapsack(n,W);
    }

    public static void loadItems(String fileName){
        int i =0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line1;
            br.readLine();
            while( (line1 = br.readLine()) != null ) { //loops through a .csv file until it reaches a null line
                String [] array = line1.split(",");
                items[i] = new Items (
                        array[0],
                        Integer.parseInt(array[1]),
                        Integer.parseInt(array[2])
                );//creates a new items object
                prices[i] = Integer.parseInt(array[1]);
                values[i] = Integer.parseInt(array[2]);
                i++;
            }
        } catch (IOException e) { // if file is not found
            e.printStackTrace();
        }
    }
    
    public static void printItems(){
        for (Items item : items) {
            System.out.println(item.getName() + ", " + item.getPrice() + ", " + item.getValue());
        }
    }

    public static int knapsack(int n, int W) {
        if (n <= 0 || W <= 0) {
            return 0;
        }

        int[][] m = new int[n + 1][W + 1];
            for (int j = 0; j <= W; j++) {
                m[0][j] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= W; j++) {
                    if (prices[i - 1] > j) {
                        m[i][j] = m[i - 1][j];
                    } else {
                        m[i][j] = Math.max(
                                m[i - 1][j],
                                m[i - 1][j - prices[i - 1]] + values[i - 1]);
                    }
                }
            }
            return m[n][W];
    }
}

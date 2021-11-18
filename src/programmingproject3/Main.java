package programmingproject3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static Items [] items = new Items[321];
    public static Items [] optimalItems;
    
    public static void main(String [] args){

        loadItems("items.csv");
        printItems();
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
                ); //creates a new store object
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
/*
    static int max(int a,int b) {
        return Math.max(a, b);
    }

 */

    static int KnapSack(int W, int cost[], int val[], int n) {
        /*
        int i, w;
        int[][] K = new int [n+1][W+1];

        for(i = 0; i < n; i++){
            for(w = 0; w <= W; w++){
                if(i == 0 ||w == 0)
                    K[i][w] = 0;
                else if(cost[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - cost[i - 1]], K[i - 1][w]);
                else K[i][w]=K[i - 1][w];
            }
        }
        return K[n][W];

         */
        return 0;
    }
}

package programmingproject3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        //loadItems("items.csv");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter the no of items:");

        int n = myObj.nextInt();
        int val[] = new int[n + 1];
        int cost[] = new int[n + 1];

        System.out.println("Enter the value of items:");
        for(int i = 0;i < n; i++)
            val[i] = myObj.nextInt();
        System.out.println("Enter the cost of items:");
        for(int i = 0;i < n; i++)
            cost[i] = myObj.nextInt();
        int W = 100;
        System.out.println("the max value we can get is");
        System.out.println(KnapSack(W, cost, val, n));

    }
/*
    public static void loadItems(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line1;
            br.readLine();
            while( (line1 = br.readLine()) != null ) { //loops through a .csv file until it reaches a null line
                String [] array = line1.split(",");
                Items s = new Items (
                        array[0],
                        Integer.parseInt(array[1]),
                        Integer.parseInt(array[2])
                ); //creates a new store object
                //FIXME add items to array or arraylist here
            }
        } catch (IOException e) { // if file is not found
            e.printStackTrace();
        }
    }
 */
    static int max(int a,int b) {
        return Math.max(a, b);
    }

    static int KnapSack(int W, int cost[], int val[], int n) {
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
    }

}

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items(7, 14));
        items.add(new Items(5, 10));
        items.add(new Items(10, 12));
        items.add(new Items(8, 16));
        items.add(new Items(9, 18));

        Knapsack k = new Knapsack(items, 10);
        k.sortByRatio();
        k.sortByCost();
        k.sortByWeight();
    }
}

class Items {
    int weight, cost;
    double ratio;
    Items (int weight, int cost)    {
        this.weight = weight;
        this.cost = cost;
        this.ratio = (double) cost/weight;
    }
}

class Knapsack {
    ArrayList<Items> items;
    int capacity;
    Knapsack(ArrayList<Items> items, int capacity)  {
        this.items = items;
        this.capacity = capacity;
    }
    public void sortByRatio()   {
        Collections.sort(items, Comparator.comparingDouble((Items i) -> i.ratio).reversed());
        System.out.println("Items in Knapsack (value/weight) approach");
        System.out.println("weight\tCost");
        int x = capacity;
        double tot = 0.0;
        for (Items i : items)   {
            if (i.weight <= x)    {
                System.out.println(i.weight + "\t" + i.cost);
                x -= i.weight; 
                tot += (double) i.cost;
            }
            else if (i.weight > x)  {
                System.out.println(x+"/"+i.weight + "\t" + (double) (i.cost * x)/i.weight);
                tot += (double) (i.cost*x)/i.weight;
                break;
            }
        }
        System.out.println("Optimal cost : " + tot);
    }
    public void sortByCost()   {
        Collections.sort(items, Comparator.comparingDouble((Items i) -> i.cost).reversed());
        System.out.println("Items in Knapsack (value) approach");
        System.out.println("weight\tCost");
        int x = capacity;
        double tot = 0.0;
        for (Items i : items)   {
            if (i.weight <= x)    {
                System.out.println(i.weight + "\t" + i.cost);
                x -= i.weight; 
                tot += (double) i.cost;
            }
            else if (i.weight > x)  {
                System.out.println(x+"/"+i.weight + "\t" + (double) (i.cost * x)/i.weight);
                tot += (double) (i.cost*x)/i.weight;
                break;
            }
        }
        System.out.println("Optimal cost : " + tot);
    }
    public void sortByWeight()   {
        Collections.sort(items, Comparator.comparingDouble((Items i) -> i.weight).reversed());
        System.out.println("Items in Knapsack (weight) approach");
        System.out.println("weight\tCost");
        int x = capacity;
        double tot = 0.0;
        for (Items i : items)   {
            if (i.weight <= x)    {
                System.out.println(i.weight + "\t" + i.cost);
                x -= i.weight; 
                tot += (double) i.cost;
            }
            else if (i.weight > x)  {
                System.out.println(x+"/"+i.weight + "\t" + (double) (i.cost * x)/i.weight);
                tot += (double) (i.cost*x)/i.weight;
                break;
            }
        }
        System.out.println("Optimal cost : " + tot);
    }
}

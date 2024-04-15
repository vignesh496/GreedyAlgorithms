import java.util.*;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static double getMaxValue(int[] weights, int[] values, int capacity) {
        List<Item> itemList = new ArrayList<>();

        // Create Items
        for (int i = 0; i < weights.length; i++) {
            itemList.add(new Item(weights[i], values[i]));
        }

        // Sort Items based on value per weight ratio (greedy choice)
        itemList.sort((Item a, Item b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double maxValue = 0;

        // Fill the knapsack greedily
        for (Item item : itemList) {
            if (capacity >= item.weight) {
                maxValue += item.value;
                capacity -= item.weight;
            } else {
                double fraction = (double) capacity / item.weight;
                maxValue += fraction * item.value;
                break;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30, 50};
        int[] values = {60, 100, 120, 250};
        int capacity = 50;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value in Knapsack: " + maxValue);
    }
}

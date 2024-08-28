package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Q. Given weights and values of N items,
 * we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 *
 * Note: Unlike 0/1 knapsack, you are allowed to break the item.
 *
 * Example 1:
 *      Input:
 *          N = 3, W = 50
 *          values[] = {60, 100, 120}
 *          weight[] = {10, 20, 30}
 *
 *      Output:
 *          240.00
 *          Explanation: Total maximum value of item
 *              we can have is 240.00 from the given capacity of sack.
 */

class Item {
    private double weight;
    private double value;
    private Double cost;

    public Item(double weight, double value) {
        super();

        this.weight = weight;
        this.value = value;
        this.cost = value / weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getValue() {
        return value;
    }

    public Double getCost() {
        return cost;
    }
}

// Comparator to sort the Item's array in solve method
class itemComparator implements Comparator<Item> {

    @Override
    public int compare(Item a, Item b) {
//        return a.getCost().compareTo(a.getCost());

        if(a.getCost() < b.getCost()) return 1;
        else if(a.getCost() > b.getCost()) return -1;
        else return 0;
    }
}

public class FractionalKnapsack {
    public static double solve(int W, Item[] arr) {
        // Sort Item array in descending order of items -> value divided by weight.
        Arrays.sort(arr, new itemComparator());

        double currWeight = 0;
        double totalValue = 0;

        for(int i = 0; i < arr.length; i++) {
            if (currWeight + arr[i].getWeight() <= W) {
                currWeight += arr[i].getWeight();
                totalValue += arr[i].getValue();
            } else {
                double remainingWeight = W - currWeight;
                totalValue += (arr[i].getValue()/arr[i].getWeight()) * remainingWeight;
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] arr = new Item[]{
                new Item(10,60),
                new Item(20,100),
                new Item(30,120)
        };

        System.out.println("Max value possible: " + solve(50, arr));
    }
}

// Fractional Knapsack
// Difficulty: MediumAccuracy: 32.46%Submissions: 253K+Points: 4
// Given weights and values of n items, we need to put these items in a knapsack of capacity w to get the maximum total value in the knapsack. Return a double value representing the maximum value in knapsack.
// Note: Unlike 0/1 knapsack, you are allowed to break the item here. The details of structure/class is defined in the comments above the given function.

// Examples :

// Input: n = 3, w = 50, value[] = [60,100,120], weight[] = [10,20,30]
// Output: 240.000000
// Explanation: Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0 Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. 
// Input: n = 2, w = 50, value[] = [60,100], weight[] = [10,20]
// Output: 160.000000
// Explanation: Take both the items completely, without breaking. Total maximum value of item we can have is 160.00 from the given capacity of sack.
// Expected Time Complexity : O(n log n)
// Expected Auxilliary Space: O(1)

// Constraints:
// 1 <= n <= 105
// 1 <= w <= 109
// 1 <= valuei, weighti <= 104


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class itemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b) 
    {
        double r1 = (double)(a.value) / (double)(a.weight); 
        double r2 = (double)(b.value) / (double)(b.weight); 
        if(r1 < r2) return 1; 
        else if(r1 > r2) return -1; 
        else return 0; 
    }
}
class Solution{
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator()); 
        
        int curWeight = 0; 
        double finalvalue = 0.0; 
        
        for (int i = 0; i < n; i++) {
       
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }
     
            else {
                int remain = W - curWeight;
                finalvalue += ((double)arr[i].value / (double)arr[i].weight) * (double)remain;
                break;
            }
        }
     
        return finalvalue;
        
    }
}
// 528. Random Pick with Weight
// Solved
// Medium
// Topics
// Companies
// You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

// You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

// For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).

// the idea here is simple, we need to generate this array
    // if the w array w[]=[1,3,2]
    // then our probability array is [0,1,1,1,2,2]
    //1 zero,3 ones,2 threes

    // its practically not possible to do this so we create cumulative sum array
    //[1,4,6]

    // this indicates that in the array [0,1,1,1,2,2], all indexes below 1 are 0, all indexes below 4 is 1,all indexes below 6 are 2

    // so -Use binary search to find the smallest index i such that cum[i] is greater than or equal to the generated random number
    

class Solution {
    int[] cum;
    Random rand;

    public Solution(int[] w) {
        int wl = w.length;
        cum = new int[wl];
        cum[0] = w[0];
        for (int i = 1; i < wl; i++) {
            cum[i] = cum[i - 1] + w[i];
        }
        rand = new Random();
    }

    public int pickIndex() {
        int lastElem = cum[cum.length - 1];
        int rInt = rand.nextInt(lastElem) + 1; // rand.nextInt(lastElem) gives 0 to lastElem-1, adding 1 to make it 1 to lastElem
        int index = binarySearch(rInt);
        return index;
    }

    private int binarySearch(int target) {
        int low = 0;
        int high = cum.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (cum[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

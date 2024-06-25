// Circular tour
// Difficulty: MediumAccuracy: 34.79%Submissions: 166K+Points: 4
// Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
// 1. The amount of petrol that every petrol pump has.
// 2. Distance from that petrol pump to the next petrol pump.
// Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
// Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.

// Example 1:

// Input:
// N = 4
// Petrol = 4 6 7 4
// Distance = 6 5 3 5
// Output: 1
// Explanation: There are 4 petrol pumps with
// amount of petrol and distance to next
// petrol pump value pairs as {4, 6}, {6, 5},
// {7, 3} and {4, 5}. The first point from
// where truck can make a circular tour is
// 2nd petrol pump. Output in this case is 1
// (index of 2nd petrol pump).
// Your Task:
// Your task is to complete the function tour() which takes the required data as inputs and returns an integer denoting a point from where a truck will be able to complete the circle (The truck will stop at each petrol pump and it has infinite capacity). If there exists multiple such starting points, then the function must return the first one out of those. (return -1 otherwise)

// Expected Time Complexity: O(N)
// Expected Auxiliary Space : O(1)

// Constraints:
// 2 ≤ N ≤ 10000
// 1 ≤ petrol, distance ≤ 1000


//suggest -  watch a video to understand properly 

 class Solution {
    // Function to find starting point where the truck can start to get through
    // the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[]) {
        int n = petrol.length;
        int start = 0;  // Starting point
        int total_petrol = 0;  // Total remaining petrol
        int current_petrol = 0;  // Remaining petrol for current tour segment

        for (int i = 0; i < n; i++) {
            total_petrol += petrol[i] - distance[i];
            current_petrol += petrol[i] - distance[i];

            // If we can't reach the next station, update start and reset current_petrol
            if (current_petrol < 0) {
                start = i + 1;
                current_petrol = 0;
            }
        }

        // If total_petrol is negative, return -1 indicating no possible tour
        return total_petrol >= 0 ? start : -1;
    }
}



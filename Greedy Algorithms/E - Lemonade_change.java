// 860. Lemonade Change
// Solved
// Easy
// Topics
// Companies
// At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill. You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

// Note that you do not have any change in hand at first.

// Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.

 

// Example 1:

// Input: bills = [5,5,5,10,20]
// Output: true
// Explanation: 
// From the first 3 customers, we collect three $5 bills in order.
// From the fourth customer, we collect a $10 bill and give back a $5.
// From the fifth customer, we give a $10 bill and a $5 bill.
// Since all customers got correct change, we output true.
// Example 2:

// Input: bills = [5,5,10,10,20]
// Output: false
// Explanation: 
// From the first two customers in order, we collect two $5 bills.
// For the next two customers in order, we collect a $10 bill and give back a $5 bill.
// For the last customer, we can not give the change of $15 back because we only have two $10 bills.
// Since not every customer received the correct change, the answer is false.
 

// Constraints:

// 1 <= bills.length <= 105
// bills[i] is either 5, 10, or 20.

class Solution {
    public boolean lemonadeChange(int[] bills) {
        // Initialize a counter for $5 bills
        int five = 0; 
        
        // Initialize a counter for $10 bills
        int ten = 0;

        // Iterate through each customer's bill
        for(int i = 0; i < bills.length; i++){
            
            // If the customer's bill is $5
            if(bills[i] == 5){
                
                // Increment the count of $5 bills
                five++;  
            }
            
            // If the customer's bill is $10
            else if(bills[i] == 10){
                
                // Check if there are $5 bills available to give change
                if(five > 0){
                     // Use one $5 bill to give change
                    five--; 
                    // Receive one $10 bill
                    ten++;   
                }
                
                // If no $5 bill available, return false
                else return false;  
            }
            
            // If the customer's bill is $20
            else {
                // Check if there are both $5 and $10 bills available to give change
                if(five > 0 && ten > 0){
                     // Use one $5 bill
                    five--; 
                    // Use one $10 bill
                    ten--;   
                }
                // If there are not enough $10 bills,
                // check if there are at least three $5 bills available
                else if (five >= 3){
                    // Use three $5 bills
                    // to give change
                    five -= 3;  
                }
                // If unable to give change, return false
                else return false;  
            }
        }
        
        // Return true if all customers are served with correct change
        return true;  
    }
}
    
                            

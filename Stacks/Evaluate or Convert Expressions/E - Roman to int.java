// convert roman no. to integer

class Solution {
    public int romanToInt(String s) 
    {
        int ans = 0;
        Stack<Integer> stk = new Stack<>();
        for(char x:s.toCharArray())
        {
            if(stk.isEmpty()) 
            {
                stk.push(value(x))
                ans+=stk.peek();
            }
            else
            {
                if(value(x)>stk.peek())
                {
                    int num = stk.peek();
                    ans= (ans-num)+(value(x)-num);
                    stk.push(value(x));
                }
                else
                {
                    int num = stk.peek();                 
                    ans= ans+value(x);

                    stk.push(value(x));

                }
            }            
        }
        return ans;   
    }
    public static int value(char x)
    {
        if(x=='I')
        {
            return 1;
        }
        else if(x=='V')
        {
            return 5;
        }
        else if(x=='X')
        {
            return 10;
        }
        else if(x=='L')
        {
            return 50;
        }
        else if(x=='C')
        {
            return 100;
        }
        else if(x=='D')
        {
            return 500;
        }
        else if(x=='M')
        {
            return 1000;
        }
        return -1;
    }
}
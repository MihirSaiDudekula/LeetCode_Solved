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

import java.util.HashMap;

class Solution {
    public int minimumSwap(String s1, String s2) {
        int totlen = s1.length() + s2.length();
        if (totlen % 2 != 0) {
            return -1;
        }

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        setCharCount(s1, map1);
        setCharCount(s2, map2);

        int countx1 = map1.getOrDefault('x', 0);
        int county1 = map1.getOrDefault('y', 0);
        int countx2 = map2.getOrDefault('x', 0);
        int county2 = map2.getOrDefault('y', 0);

        if(countx1!=countx2 || county1!=county2)
        {
            return -1;
        }

        


        return 0; 
    }

    private static void setCharCount(String s, HashMap<Character, Integer> map) {
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }
}

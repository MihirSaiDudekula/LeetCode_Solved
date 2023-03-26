class Solution {
    public int[] getConcatenation(int[] nums) {
        int lb = ((nums.length)*2);
        int a[]=new int[lb];
        int k=0;
        for(int i=0;i<lb;i++)
        {
            a[i]=nums[k];
            k++;
            if(i==(nums.length-1))
            {
                k=0;
            }
            
        }
        return a;
    }
}
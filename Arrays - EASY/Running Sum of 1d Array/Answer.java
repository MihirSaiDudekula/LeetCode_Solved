class Solution {
    public int[] runningSum(int[] nums) {
        int l = nums.length;
        int[] a = new int[l];
        a[0]=nums[0];
        for(int i=1;i<l;i++)
        {
            a[i]=a[i-1]+nums[i];
        }
        return a;
    }
}
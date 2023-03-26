class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int lar=0;
        for(int i=0;i<candies.length;i++)
        {
            if(candies[i]>lar)
            {
                lar=candies[i];
            }
        }

        ArrayList<Boolean> b =  new ArrayList<Boolean>();
        for (int i=0;i<candies.length;i++)
        {
            candies[i] = candies[i] + extraCandies;
            if(candies[i]>=lar)
            {
                b.add(true);
            }
            else
            {
                b.add(false);
            }
        }
    return b;
    }
}
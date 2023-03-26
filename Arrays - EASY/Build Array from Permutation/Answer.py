class Solution:
    def buildArray(self, nums: List[int]) -> List[int]:
        l = len(nums)
        a=[]
        for x in range(0,l):
            a.append(nums[nums[x]])
        return a
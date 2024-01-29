class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        numDict = dict()
        for i, num in enumerate(nums):
            complement = target - num
            if complement in numDict:
                return [numDict[complement], i]
            numDict[num] = i

        return None
        
class Solution:
    def canPermutePalindrome(self, s: str) -> bool:
        counts = [0] * 127
        count = 0
        for ch in s:
            i = ord(ch)
            counts[i] += 1
            if counts[i] % 2 == 1:
                count += 1
            else:
                count -= 1

        return count <= 1
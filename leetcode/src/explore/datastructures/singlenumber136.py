class Solution:
	def singleNumber(self, nums: List[int]) -> int:
		used = {}
		for x in nums:
			if x in used:
				del used[x]
			else:
				used[x] = None
		for x in used:
			return x
		
        
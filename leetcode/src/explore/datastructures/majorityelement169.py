class Solution:
	def majorityElement(self, nums: List[int]) -> int:
		count = {}
		for x in nums:
			if x in count:
				count[x] += 1
			else:
				count[x] = 1
			if count[x] >= len(nums)/2:
				return x
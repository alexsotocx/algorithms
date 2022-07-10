from typing import List, Dict
from bisect import bisect

class Solution:
	def threeSum(self, nums: List[int]) -> List[List[int]]:
		nums.sort()
		numMap: Dict[int, List[int]] = {}
		n = len(nums)
		for i in range(n):
			x = nums[i]
			if x in numMap:
				numMap[x].append(i)
			else:
				numMap[x] = [i]
		added = set()
		i = 0
		while i < n:
			x = nums[i]
			
			j = i + 1
			while j < n:
				y = nums[j]
				z = -(x + y)
				if z in numMap:
					psol = numMap[z]
					start = bisect(psol, j)
					if start < len(psol) and psol[start] > j:
						m = [x,y, z]
						m.sort()
						added.add(tuple(m))
				j = bisect(nums, nums[j])
			i = bisect(nums, nums[i])

		return list(added)
						
						
						
		
				
			
		
		
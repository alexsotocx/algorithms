import heapq
from itertools import islice

class MinHeap:
    def __init__(self):
        self.data = []

    def top(self):
        return self.data[0]

    def push(self, val):
        heapq.heappush(self.data, val)

    def pop(self):
        return heapq.heappop(self.data)
    
    def size(self):
        return len(self.data)
    
    def print(self):
        print(self.data)
    
def laptopRentals(times):
    if len(times) == 0:
        return 0
    
    times.sort(key = lambda x: (x[0], x[1]))
    laptops = MinHeap()
    laptops.push((times[0][1], times[0][0], times[0][1]))
    maxLaptops = 1

    for r in times[1:]:
        _, _,end  = laptops.top()
        while r[0] >= end and laptops.size() > 0:
            laptops.pop()
            if laptops.size() > 0:
              _,_, end = laptops.top() 
        laptops.push((r[1], r[0], r[1]))
        maxLaptops = max(maxLaptops, laptops.size())            

    return maxLaptops

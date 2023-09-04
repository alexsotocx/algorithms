import heapq

# Do not edit the class below except for
# the insert method. Feel free to add new
# properties and methods to the class.

class MaxHeap:
    def __init__(self):
        self.data = []

    def top(self):
        return -self.data[0]

    def push(self, val):
        heapq.heappush(self.data, -val)

    def pop(self):
        return -heapq.heappop(self.data)
    
    def size(self):
        return len(self.data)
    
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

class ContinuousMedianHandler:
    def __init__(self):
        self.firstHalf = MaxHeap()
        self.secondHalf = MinHeap()
        self.median = None
        
        

    def insert(self, number):
        if self.firstHalf.size() == 0 or number <= self.firstHalf.top():
            self.firstHalf.push(number)
        else:
            self.secondHalf.push(number)

        if self.secondHalf.size() > self.firstHalf.size():
            self.firstHalf.push(self.secondHalf.pop())


        

    def getMedian(self):
        size = self.firstHalf.size() + self.secondHalf.size()
        if size % 2 == 0:
            return (self.firstHalf.top() + self.secondHalf.top()) / 2
        else:
            return self.firstHalf.top()
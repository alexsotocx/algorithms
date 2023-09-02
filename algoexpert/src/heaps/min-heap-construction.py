# Do not edit the class below except for the buildHeap,
# siftDown, siftUp, peek, remove, and insert methods.
# Feel free to add new properties and methods to the class.
class MinHeap:
    def __init__(self, array: list):
        # Do not edit the line below.
        self.heap = array
        self.buildHeap()
        print(self.heap)

    def buildHeap(self) -> list:
        s = len(self.heap)
        for i in range(s // 2 - 1, -1, -1):
            self.siftDown(i)
        
            

    def leftChild(i):
        return 2 * i + 1
    
    def rightChild(i):
        return 2 * i + 2
    
    def parent(i):
        return (i - 1) // 2
    
    def swap(self, i, j):
        self.heap[i], self.heap[j] = self.heap[j], self.heap[i]

    def siftDown(self, currentIdx: int):
        left, right = MinHeap.leftChild(currentIdx), MinHeap.rightChild(currentIdx)
        size = len(self.heap)
        while left < size:
            smaller = right if right < size and self.heap[left] > self.heap[right] else left
            if self.heap[currentIdx] < self.heap[smaller]:
                break
            self.swap(currentIdx, smaller)
            currentIdx = smaller
            left, right = MinHeap.leftChild(currentIdx), MinHeap.rightChild(currentIdx)


    def siftUp(self, currentIdx: int):
        parent = MinHeap.parent(currentIdx)

        while parent >= 0 and self.heap[parent] > self.heap[currentIdx]:
            self.swap(parent, currentIdx)
            currentIdx = parent
            parent = MinHeap.parent(currentIdx)

    def peek(self):
        return self.heap[0]

    def remove(self):
        top = self.heap[0]
        if len(self.heap) > 1:
            self.swap(0, len(self.heap) - 1)
            self.heap.pop()
            self.siftDown(0)
        return top

    def insert(self, value):
        self.heap.append(value)
        self.siftUp(len(self.heap) - 1)

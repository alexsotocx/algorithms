package heaps

import "../interfaces"

type PriorityQueue struct {
  nodes []interfaces.Comparable
  size uint
}

func (heap *PriorityQueue) Insert(data interfaces.Comparable) {
  heap.nodes = append(heap.nodes, data)
  n := len(heap.nodes)
  shiftUp(n -1, heap.nodes)
  heap.size++
}

func (heap *PriorityQueue) Pop() interfaces.Comparable {
  var data interfaces.Comparable
  data, heap.nodes[0] = heap.nodes[0], heap.nodes[len(heap.nodes) - 1]
  heap.nodes = heap.nodes[:len(heap.nodes) - 1]
  shiftDown(0, heap.nodes)
  heap.size--
  return data
}

func shiftDown(i int, nodes []interfaces.Comparable) {
  n := len(nodes)
  for leftChild(i) < n {
    bigger, left := leftChild(i), leftChild(i)
    right := rightChild(i)
    if right < n {
      if nodes[left].Compare(nodes[right]) == -1 {
        bigger = right
      }
      if nodes[i].Compare(nodes[bigger]) == 1 {
        break
      }
      nodes[i], nodes[bigger] = nodes[bigger], nodes[i]
      i = bigger
    } else {
      if nodes[i].Compare(nodes[left]) == 1 {
        break
      }
      nodes[i], nodes[left] = nodes[left], nodes[i]
      i = left
    }
  }
}

func shiftUp(i int, nodes []interfaces.Comparable) {
  for i > 0 && nodes[i].Compare(nodes[parent(i)]) == 1 {
    nodes[i], nodes[parent(i)] = nodes[parent(i)], nodes[i]
    i = parent(i)
  }
}

func parent(i int) int {
  return (i - 1) / 2
}

func leftChild(i int) int {
  return 2*(i + 1) - 1
}

func rightChild(i int) int {
  return leftChild(i) + 1
}

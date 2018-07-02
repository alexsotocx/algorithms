package heaps_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/data_structures/heaps"
	"github.com/alexsotocx/algorithms/go/interfaces"
)

type Integer struct {
	value int
}

func (i Integer) Value() interface{} {
	return i.value
}

func (i Integer) Compare(a interfaces.Comparable) int8 {
	if i.value == a.(Integer).value {
		return 0
	} else if i.value > a.(Integer).value {
		return 1
	}
	return -1
}

func TestInsert(t *testing.T) {
	heap := heaps.PriorityQueue{}
	heap.Insert(Integer{value: 1})
	heap.Insert(Integer{value: 25})
	heap.Insert(Integer{value: 2})
	heap.Insert(Integer{value: 4})
	heap.Insert(Integer{value: 50})
	heap.Insert(Integer{value: 6})

	correct := []int{50, 25, 6, 4, 2, 1}
	for _, v := range correct {
		p := heap.Pop().Value()
		if v != p {
			t.Errorf("Expect %d got %d", v, p)
		}
	}
}

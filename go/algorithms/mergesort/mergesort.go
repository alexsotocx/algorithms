package mergesort

import (
	"github.com/alexsotocx/algorithms/go/interfaces"
)

type mergeSortContainer struct {
	toSort []interfaces.Comparable
	temp   []interfaces.Comparable
}

func Sort(array []interfaces.Comparable) {
	m := &mergeSortContainer{
		toSort: array,
		temp:   make([]interfaces.Comparable, len(array)),
	}
	m.sort(0, len(m.temp)-1)
}

func SortWith(array []interfaces.Comparable, lessThan func(i, j int) bool) {

}

func (m *mergeSortContainer) sort(low int, hi int) {
	if hi-low >= 1 {
		mid := (low + hi) / 2
		m.sort(low, mid)
		m.sort(mid+1, hi)
		m.merge(low, mid, hi)
	}
}

func (m *mergeSortContainer) merge(lo, mid, hi int) {
	i, j, k := lo, mid+1, 0
	for i <= mid || j <= hi {
		if i <= mid && j <= hi {
			if m.toSort[i].Compare(m.toSort[j]) <= 0 {
				m.temp[k] = m.toSort[i]
				i++
			} else {
				m.temp[k] = m.toSort[j]
				j++
			}
		} else if i <= mid && j >= hi {
			m.temp[k] = m.toSort[i]
			i++
		} else {
			m.temp[k] = m.toSort[j]
			j++
		}
		k++
	}

	for i = 0; i <= hi-lo; i++ {
		m.toSort[lo+i] = m.temp[i]
	}
}

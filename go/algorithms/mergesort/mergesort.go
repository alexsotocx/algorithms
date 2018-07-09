package mergesort

import (
	"reflect"
)

type mergeSortContainer struct {
	toSort   reflect.Value
	temp     []interface{}
	lessFunc func(i, j int) bool
}

func Sort(array interface{}, lessThan func(i, j int) bool) {
	n := reflect.ValueOf(array).Len()
	m := &mergeSortContainer{
		toSort:   reflect.ValueOf(array),
		temp:     make([]interface{}, n),
		lessFunc: lessThan,
	}
	m.sort(0, n-1)
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
			if m.lessFunc(i, j) {
				m.temp[k] = m.toSort.Index(i).Interface()
				i++
			} else {
				m.temp[k] = m.toSort.Index(j).Interface()
				j++
			}
		} else if i <= mid {
			m.temp[k] = m.toSort.Index(i).Interface()
			i++
		} else {
			m.temp[k] = m.toSort.Index(j).Interface()
			j++
		}
		k++
	}

	for i = 0; i <= hi-lo; i++ {
		m.toSort.Index(lo + i).Set(reflect.ValueOf(m.temp[i]))
	}
}

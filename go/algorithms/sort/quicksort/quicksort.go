package quicksort

import (
	"math/rand"
	"reflect"
	"time"
)

type sortContainer struct {
	toSort   reflect.Value
	lessFunc func(i, j int) bool
	swapper  func(i, j int)
}

func Sort(array interface{}, lessThan func(i, j int) bool) {
	rArray := reflect.ValueOf(array)
	n := rArray.Len()
	m := &sortContainer{
		toSort:   rArray,
		lessFunc: lessThan,
		swapper:  reflect.Swapper(array),
	}
	rand.Seed(int64(time.Now().Unix()))

	m.sort(0, n-1)
}

func (m *sortContainer) sort(low int, hi int) {
	if hi-low >= 1 {
		p := rand.Intn(hi-low+1) + low
		m.swapper(low, p)
		i, j := low+1, hi
		for i <= j {
			if m.lessFunc(i, low) {
				i++
			} else {
				m.swapper(i, j)
				j--
			}
		}
		m.swapper(low, i-1)
		m.sort(low, i-2)
		m.sort(i, hi)
	}
}

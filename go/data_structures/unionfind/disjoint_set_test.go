package unionfind_test

import (
	"testing"

	"github.com/alexsotocx/algorithms/go/data_structures/unionfind"
)

func TestSameSet(t *testing.T) {
	djset := unionfind.New(10)
	djset.Join(0, 1)
	djset.Join(0, 2)
	djset.Join(2, 3)
	djset.Join(0, 3)
	djset.Join(9, 3)

	testCases := []*map[string]interface{}{
		&map[string]interface{}{"a": 0, "b": 1, "result": true},
		&map[string]interface{}{"a": 0, "b": 2, "result": true},
		&map[string]interface{}{"a": 0, "b": 3, "result": true},
		&map[string]interface{}{"a": 0, "b": 4, "result": false},
		&map[string]interface{}{"a": 0, "b": 9, "result": true},
	}

	for _, tc := range testCases {
		tcp := *tc
		rs := djset.SameSet(tcp["a"].(int), tcp["b"].(int))
		if rs != tcp["result"] {
			t.Errorf("Expect sameset on %d and %d to be %v but got %v", tcp["a"], tcp["b"], tcp["result"], rs)
		}
	}
}

func TestSets(t *testing.T) {
	djset := unionfind.New(10)
	djset.Join(0, 1)
	djset.Join(0, 2)
	djset.Join(2, 3)

	if djset.Sets() != 7 {
		t.Fatalf("Excepted sets to be %d, but got %d", 7, djset.Sets())
	}

	djset.Join(1, 9)
	if djset.Sets() != 6 {
		t.Fatalf("Excepted sets to be %d, but got %d", 6, djset.Sets())
	}
}

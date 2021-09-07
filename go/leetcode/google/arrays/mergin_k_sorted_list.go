package google

//  Definition for singly-linked list.
type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeKLists(lists []*ListNode) *ListNode {
	var start *ListNode = nil
	current := start
	available := make(map[int]*ListNode)
	for i, v := range lists {
		if v != nil {
			available[i] = v
		}
	}

	for len(available) != 0 {
		min := -1
		for i, v := range available {
			if min == -1 || available[min].Val > v.Val {
				min = i
			}
		}

		if start == nil {
			start = available[min]
			current = start
		} else {
			current.Next = available[min]
			current = available[min]
		}
		temp := available[min].Next
		available[min].Next = nil
		available[min] = temp
		if available[min] == nil {
			delete(available, min)
		}

	}

	return start
}

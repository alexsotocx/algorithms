package google

type ListNode struct {
	Val  int
	Next *ListNode
}

func mergeTwoLists(l1 *ListNode, l2 *ListNode) *ListNode {
	if l1 == nil {
		return l2
	}
	if l2 == nil {
		return l1
	}
	p1 := l1
	p2 := l2
	var head *ListNode
	var current *ListNode
	if p1.Val > p2.Val {
		head = p2
		p2 = p2.Next
	} else {
		head = p1
		p1 = p1.Next
	}
	current = head
	for p1 != nil {
		for p2 != nil && p1.Val > p2.Val {
			current.Next = p2
			current = p2
			p2 = p2.Next
		}
		current.Next = p1
		current = p1
		p1 = p1.Next
	}

	for p2 != nil {
		current.Next = p2
		current = p2
		p2 = p2.Next
	}
	current.Next = nil
	return head
}

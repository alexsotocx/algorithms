package google

/*
i: 0, h = 7, l = 0, mid = 4
i: 1, h = 7, l = 4, mid = 6
i: 2, h = 5, l = 4, mid = 5

i: 0, h = 7, l = 0, mid = 4
i: 1, h = 3, l = 0, mid = 2
i: 2, h = 3, l = 2, mid = 3

*/
func findMissing(root *TreeNode, deep int) int {
	i := 0
	h := (1 << (deep - 1)) - 1
	l := 0

	current := root
	for i != deep {
		mid := h - (h-l)/2
		if hasMiddleNode(current, deep-i) {
			current = current.Right
			l = mid
		} else {
			current = current.Left
			h = mid - 1
		}
		i++
	}
	return (1 << (deep - 1)) - 1 - l
}

func hasMiddleNode(root *TreeNode, deep int) bool {
	currentDeep := 1
	if currentDeep == deep {
		return true
	}
	if root.Right != nil {
		currentDeep++
	} else {
		return false
	}
	n := root.Right
	for currentDeep != deep {
		currentDeep++
		n = n.Left
	}
	return n != nil
}

func countNodes(root *TreeNode) int {
	if root == nil {
		return 0
	}
	current := root
	levels := 0
	for current != nil {
		current = current.Left
		levels++
	}
	if levels <= 1 {
		return levels
	}
	x := findMissing(root, levels)
	total := (1 << (levels)) - 1 - x

	return total
}

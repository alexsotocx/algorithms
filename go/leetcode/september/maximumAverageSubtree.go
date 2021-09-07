package september

/**
  Definition for a binary tree node. */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type pair struct {
	size, sum int
}

func (p *pair) average() float64 {
	return float64(p.sum) / float64(p.size)
}

var maxA = 0.0

func maximumAverageSubtree(root *TreeNode) float64 {
	maxA = 0.0
	maxAverage(root)
	return maxA
}

func maxAverage(root *TreeNode) *pair {
	if root == nil {
		return nil
	}
	p := &pair{size: 1, sum: root.Val}
	pLeft := maxAverage(root.Left)
	pRight := maxAverage(root.Right)
	if pLeft != nil {
		p.size += pLeft.size
		p.sum += pLeft.sum
	}
	if pRight != nil {
		p.size += pRight.size
		p.sum += pRight.sum
	}
	if maxA < p.average() {
		maxA = p.average()
	}
	return p
}

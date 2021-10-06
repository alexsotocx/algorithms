package google

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func maxInt(a, b int) int {
	if a > b {
		return a
	}
	return b
}

var maxPath = 0

func diameterOfBinaryTree(root *TreeNode) int {
	maxPath = 0
	if root == nil {
		return 0
	}
	findDiameter(root)
	return maxPath - 1
}

func findDiameter(root *TreeNode) int {
	if root == nil {
		return 0
	}
	leftPath := findDiameter(root.Left)
	rightPath := findDiameter(root.Right)
	maxPath = maxInt(maxPath, 1+leftPath+rightPath)
	return 1 + maxInt(leftPath, rightPath)
}

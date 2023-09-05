maxSum = -1 * 1<<30

def maxPathSum(tree)-> int:
   global maxSum
   maxSum =  -1 * 1<<30
   maxPathSumHelper(tree)
   return maxSum

def maxPathSumHelper(tree) -> int:
    global maxSum

    response = tree.value
    fullPath = tree.value
    if tree.left is not None:
        left = maxPathSumHelper(tree.left)
        fullPath += left
        response = max(response, left + tree.value)
        maxSum = max(maxSum, left, left + tree.value)

    if tree.right is not None:
        right = maxPathSumHelper(tree.right)
        fullPath += right
        response = max(response, right + tree.value)
        maxSum = max(maxSum, right, right + tree.value)

    maxSum = max(maxSum, fullPath)

    return response
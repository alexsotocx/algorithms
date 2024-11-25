// This is the class of the input root.
// Do not edit it.
class BinaryTree {
  value: number;
  left: BinaryTree | null;
  right: BinaryTree | null;

  constructor(value: number) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

function branchSumsHelper(root: BinaryTree, results: number[], sumUntilhere: number) {
  if (root.left) branchSumsHelper(root.left, results, sumUntilhere + root.left.value);
  results[results.length - 1] += root.value;
  if (root.right) {
    results.push(sumUntilhere);
    branchSumsHelper(root.right, results, sumUntilhere + root.right.value);
  }
}
export function branchSums(root: BinaryTree): number[] {
  // Write your code here.
  if (root) {
    const nums: number[] = [0];
    branchSumsHelper(root, nums, root.value);
    return nums;
  }
  return [-1];
}


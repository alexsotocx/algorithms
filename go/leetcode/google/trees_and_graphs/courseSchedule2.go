package google

var globalVisited []bool
var sort []int

func topologicalSort(start int, adj [][]int, dfsTree []bool) bool {
	globalVisited[start] = true
	dfsTree[start] = true
	for _, v := range adj[start] {

		if !globalVisited[v] {
			if topologicalSort(v, adj, dfsTree) {
				return true
			}
		} else {
			if dfsTree[v] {
				return true
			}
		}
	}
	dfsTree[start] = false

	sort = append(sort, start)
	return false
}

func findOrder(numCourses int, prerequisites [][]int) []int {
	globalVisited = make([]bool, numCourses)
	sort = make([]int, 0)
	adj := make([][]int, numCourses)
	for _, p := range prerequisites {
		adj[p[1]] = append(adj[p[1]], p[0])
	}
	i := 0
	recStack := make([]bool, numCourses)
	for i < numCourses {
		if !globalVisited[i] {
			if topologicalSort(i, adj, recStack) {
				return []int{}
			}
		}
		i++
	}
	ans := make([]int, numCourses)
	i = 0
	for i < numCourses {
		ans[i] = sort[numCourses-i-1]
		i++
	}
	return ans
}

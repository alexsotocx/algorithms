package graphs

import "math"

func (graph *Graph) Mssp() [][]int {
	n := len(graph.adjacencyList)
	mDistance := make([][]int, n)
	for i := range mDistance {
		mDistance[i] = make([]int, n)
		for j := range mDistance[i] {
			mDistance[i][j] = math.MinInt32
		}
	}

	for i := range mDistance {
		mDistance[i][i] = 0
	}

	for i := 0; i < n; i++ {
		for _, v := range graph.adjacencyList[i] {
			mDistance[i][v.vertex] = v.weight
		}
	}

	for k := 0; k < n; k++ {
		for i := 0; i < n; i++ {
			for j := 0; j < n; j++ {
				mDistance[i][j] = min(mDistance[i][j], mDistance[i][k]+mDistance[k][j])
			}
		}
	}

	return mDistance
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

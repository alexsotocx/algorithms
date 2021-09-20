package google

var pathLen [][]int

type pairab struct {
	x, y int
}

func maxAb(a, b int) int {
	if a > b {
		return a
	}
	return b
}

var movs = []pairab{{0, 1}, {-1, 0}, {0, -1}, {1, 0}}

func longestFromStart(matrix [][]int, x, y int) int {
	pathLen[x][y] = 1
	localMax := 1
	for _, mov := range movs {
		dx := x + mov.x
		dy := y + mov.y
		inside := dx >= 0 && dx < len(matrix) && dy >= 0 && dy < len(matrix[x])
		if inside {
			increasing := matrix[x][y] < matrix[dx][dy]
			if !increasing {
				continue
			}
			if pathLen[dx][dy] == -1 {
				localMax = maxAb(1+longestFromStart(matrix, dx, dy), localMax)
			} else {
				localMax = maxAb(1+pathLen[dx][dy], localMax)
			}
		}
	}
	pathLen[x][y] = localMax
	return localMax
}

func longestIncreasingPath(matrix [][]int) int {
	pathLen = make([][]int, len(matrix))
	maxPath := 0
	for i := range pathLen {
		pathLen[i] = make([]int, len(matrix[i]))
		for j := range pathLen[i] {
			pathLen[i][j] = -1
		}
	}

	for i := range pathLen {
		for j, x := range pathLen[i] {
			if x == -1 {
				longestFromStart(matrix, i, j)
			}
			maxPath = maxAb(maxPath, pathLen[i][j])
		}
	}
	return maxPath
}

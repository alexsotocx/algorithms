package google

type pair struct {
	x, y int
}

var mov = []pair{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}

func dfs(grid [][]byte, x, y int) {
	grid[x][y] = '*'
	for _, m := range mov {
		vx := m.x + x
		vy := m.y + y
		inGrid := (vx >= 0 && vx < len(grid) && vy >= 0 && vy < len(grid[x]))
		if inGrid && grid[vx][vy] == '1' {
			dfs(grid, vx, vy)
		}
	}
}
func numIslands(grid [][]byte) int {
	count := 0
	for i := range grid {
		for j, c := range grid[i] {
			if c == '1' {
				count++
				dfs(grid, i, j)
			}
		}
	}
	return count

}

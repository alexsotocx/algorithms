package main

import (
	"bufio"
	"container/list"
	"fmt"
	"os"
	"strings"
)

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

type graph [][]byte

func bfs(g graph, start byte) []int {
	distance := make([]int, 'Z'-'A'+1)
	for i := range distance {
		distance[i] = -1
	}
	distance[start] = 0
	queue := list.New()
	queue.PushBack(start)
	for queue.Len() != 0 {
		s := queue.Front().Value.(byte)
		queue.Remove(queue.Front())
		for _, c := range g[s] {
			if distance[c] == -1 {
				distance[c] = distance[s] + 1
				queue.PushBack(c)
			}
		}
	}
	return distance
}

func solve(str string, conversions []string) int {
	adj := make(graph, 'Z'-'A'+1)
	for _, c := range conversions {
		adj[c[0]-'A'] = append(adj[c[0]-'A'], c[1]-'A')
	}

	distances := make([][]int, 'Z'-'A'+1)
	for i := byte('A'); i <= byte('Z'); i++ {
		distances[i-'A'] = bfs(adj, i-'A')
	}

	minV := 1 << 20
	for i := byte(0); i <= byte('Z'-'A'); i++ {
		sol := 0
		for j := range str {
			c := str[j] - 'A'
			distanceT := distances[c][i]

			if distanceT == -1 {
				sol = -1
				break
			}
			sol += distanceT
		}
		if sol != -1 {
			minV = min(minV, sol)
		}
	}
	if minV == (1 << 20) {
		return -1
	}
	return minV
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	var strB strings.Builder
	var cases int
	fmt.Fscanf(reader, "%d\n", &cases)

	for i := 1; i <= cases; i++ {
		var str string
		fmt.Fscanf(reader, "%s\n", &str)
		var transformations int
		conversions := make([]string, 0)
		fmt.Fscanf(reader, "%d\n", &transformations)
		for transformations != 0 {
			var conversion string
			fmt.Fscanf(reader, "%s\n", &conversion)
			conversions = append(conversions, conversion)
			transformations--
		}
		fmt.Fprintf(&strB, "Case #%d: %d\n", i, solve(str, conversions))
	}
	fmt.Print(strB.String())
}

package google

import "container/list"

// a * b = c
type equality struct {
	a    float64
	b, c string
}

type distanceStruct struct {
	a float64
	b string
}

func solve(top string, bottom string, graph map[string][]equality, zero map[string]struct{}) float64 {
	if _, ok := graph[top]; !ok {
		return -1.0
	}
	if _, ok := graph[bottom]; !ok {
		return -1.0
	}
	if _, ok := zero[top]; ok {
		return 0.0
	}
	q := list.New()
	distance := make(map[string]distanceStruct)
	distance[top] = distanceStruct{1.0, top}
	q.PushBack(top)
	for q.Len() != 0 {
		e := q.Front()
		c := e.Value.(string)
		q.Remove(e)
		if c == bottom {
			break
		}
		currentDistance := distance[c]
		for _, equal := range graph[c] {
			_, visited := distance[equal.b]
			if !visited {
				q.PushBack(equal.b)
				distance[equal.b] = distanceStruct{equal.a * currentDistance.a, equal.b}
			}
		}
	}
	if d, ok := distance[bottom]; ok {
		return d.a
	}
	return -1.0
}

func calcEquation(equations [][]string, values []float64, queries [][]string) []float64 {
	graph := make(map[string][]equality)
	zero := make(map[string]struct{})
	for i, eq := range equations {
		val := values[i]
		a := eq[0]
		b := eq[1]
		// a == 0
		if val == 0 {
			zero[a] = struct{}{}
		} else {
			// a / b = val
			graph[a] = append(graph[a], equality{a: val, b: b, c: a})
			graph[b] = append(graph[b], equality{a: 1.0 / val, b: a, c: b})
		}
	}
	ans := make([]float64, 0)
	for _, q := range queries {
		ans = append(ans, solve(q[0], q[1], graph, zero))
	}
	return ans
}

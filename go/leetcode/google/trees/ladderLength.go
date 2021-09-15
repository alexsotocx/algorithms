package google

import "container/list"

func areWordsAdjacent(a, b string) bool {
	different := 0
	for i := range a {
		if a[i] != b[i] {
			different++
		}
	}
	return different <= 1
}

func findAdjacent(worldList []string) map[string][]string {
	adj := make(map[string][]string)
	for i, ws := range worldList {
		for j := i + 1; j < len(worldList); j++ {
			we := worldList[j]
			if areWordsAdjacent(ws, we) {
				adj[ws] = append(adj[ws], we)
				adj[we] = append(adj[we], ws)
			}
		}
	}
	return adj
}

func ladderLength(beginWord string, endWord string, wordList []string) int {
	inc := findAdjacent(append(wordList, beginWord))
	distance := make(map[string]int)
	distance[beginWord] = 0
	q := list.New()
	q.PushBack(beginWord)
	for q.Len() != 0 {
		e := q.Front()
		s := e.Value.(string)
		q.Remove(e)
		if s == endWord {
			break
		}
		for _, a := range inc[s] {
			if distance[a] == 0 {
				q.PushBack(a)
				distance[a] = distance[s] + 1
			}
		}
	}
	if d, found := distance[endWord]; found {
		return d + 1
	}
	return 0
}

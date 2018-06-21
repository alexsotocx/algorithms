package trie

import (
	"strings"
)

type node struct {
	connections    [26]*node
	word           bool
	suffix         int
	numConnections int
}

func (node *node) setVal(i int, j int, n int) {
	node.word = node.word || (j+1 == n && i == 0)
	if j+1 == n && i != 0 {
		node.suffix = i
	}
}

type Trie struct {
	root *node
}

func (trie *Trie) Insert(data string) {
	if trie.root == nil {
		trie.root = &node{}
	}
	n := int(len(data))
	data = strings.ToUpper(data)
	for i := 0; i < n; i++ {
		current := trie.root
		for j := i; j < n; j++ {
			norma := data[j] - 'A'
			if current.connections[norma] == nil {
				current.numConnections++
				current.connections[norma] = &node{}
			}
			current.connections[norma].setVal(i, j, n)
			current = current.connections[norma]
		}
	}
}

func (trie Trie) Find(data string) bool {
	current := trie.root
	data = strings.ToUpper(data)
	for _, c := range data {
		norma := c - 'A'
		if current.connections[norma] != nil {
			current = current.connections[norma]
		} else {
			current = nil
			return false
		}
	}

	return current.word
}

func (trie Trie) FindSuffix(data string) int {
	current := trie.root
	data = strings.ToUpper(data)
	for _, c := range data {
		norma := c - 'A'
		if current.connections[norma] != nil {
			current = current.connections[norma]
		} else {
			current = nil
			return -1
		}
	}

	return current.suffix
}

func (trie Trie) LRS(data string) int {
	current := trie.root
	data = strings.ToUpper(data)
	for _, c := range data {
		norma := c - 'A'
		if current.connections[norma] != nil {
			current = current.connections[norma]
		} else {
			current = nil
			return -1
		}
	}

	return current.suffix
}

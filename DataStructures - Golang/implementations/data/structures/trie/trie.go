package trie

import "strings"

type node struct {
	connections [26]*node
	word        bool
	suffix      bool
}

func (node *node) setVal(i int, j int, n int) {
	node.word = node.word || j+1 == n && i == 0
	node.suffix = node.suffix || j+1 == n && i != 0
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
				current.connections[norma] = &node{}
			}
			current.connections[norma].setVal(i, j, n)
			current = current.connections[norma]
		}
	}
}

func (trie Trie) Find(data string) (bool, bool) {
	current := trie.root
	data = strings.ToUpper(data)
	for _, c := range data {
		norma := c - 'A'
		if current.connections[norma] != nil {
			current = current.connections[norma]
		} else {
			current = nil
			return false, false
		}
	}

	return current.word, current.suffix
}

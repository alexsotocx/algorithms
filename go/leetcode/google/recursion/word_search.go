package google

var movs = [][]int{{-1, 0}, {0, 1}, {1, 0}, {0, -1}}
var found = make(map[string]struct{})

type trieNode struct {
	children map[rune]*trieNode
	word     string
}

func createTrie(words []string) *trieNode {
	root := &trieNode{children: map[rune]*trieNode{}}
	for _, word := range words {
		node := root
		for _, v := range word {
			if nc, ok := node.children[v]; ok {
				node = nc
			} else {
				newNode := &trieNode{children: map[rune]*trieNode{}}
				node.children[v] = newNode
				node = newNode
			}
		}
		node.word = word
	}
	return root
}

func findWords(board [][]byte, words []string) []string {
	found = make(map[string]struct{})
	trie := createTrie(words)
	for i := range board {
		for j := range board[i] {
			findWordsRecursive(i, j, board, trie)
		}
	}
	s := make([]string, 0)
	for k, _ := range found {
		s = append(s, k)
	}
	return s
}

func findWordsRecursive(x int, y int, board [][]byte, words *trieNode) {
	currentNode := words.children[rune(board[x][y])]
	if currentNode == nil {
		return
	}
	if currentNode.word != "" {
		found[currentNode.word] = struct{}{}
		currentNode.word = ""
	}
	tmp := board[x][y]
	board[x][y] = 0
	for _, mov := range movs {
		dx := x + mov[0]
		dy := y + mov[1]
		inside := dx >= 0 && dx < len(board) && dy >= 0 && dy < len(board[dx])
		if inside && board[dx][dy] != 0 {
			findWordsRecursive(dx, dy, board, currentNode)
		}
	}
	board[x][y] = tmp
}

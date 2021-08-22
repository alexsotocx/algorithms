package google

const one = int64(1)

func maxABC(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func FindClosestApartment(blocks []map[string]bool, requirements []string) int {
	found := int64(0)
	var completed = (one << len(requirements)) - 1
	ws := 0
	inWindow := make(map[string]int)
	blocksLen := len(blocks)
	closestDistance := blocksLen
	closestIndex := -1
	for we, actualBlock := range blocks {
		for i, req := range requirements {
			if actualBlock[req] {
				found |= (one << i)
				inWindow[req] = inWindow[req] + 1
			}
		}
		for found == completed {
			wCenter := (we + ws) / 2
			distance := maxABC(we-wCenter, wCenter-ws)
			if distance < closestDistance {
				closestDistance = distance
				closestIndex = wCenter
			}

			// Remove from start block
			startBlock := blocks[ws]
			for i, req := range requirements {
				if startBlock[req] {
					inWindow[req] = inWindow[req] - 1
					if inWindow[req] == 0 {
						found &= ^(one << i)
					}
				}
			}
			ws++
		}
	}
	return closestIndex
}

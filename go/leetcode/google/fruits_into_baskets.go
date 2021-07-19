package google

func TotalFruits(fruits []int) int {
	if len(fruits) == 1 {
		return 1
	}
	types := [2]int{-1, -1}
	types[0] = fruits[0]
	total := 1
	max := 1
	lastPosition := 0
	for i := 1; i < len(fruits); i++ {
		if types[0] == fruits[i] {
			total++
			if fruits[lastPosition] != types[0] {
				lastPosition = i
			}
		} else if types[1] == fruits[i] {
			total++
			if fruits[lastPosition] != types[1] {
				lastPosition = i
			}
		} else if types[1] == -1 {
			total++
			types[1] = fruits[i]
			lastPosition = i
		} else {
			if max < total {
				max = total
			}
			total = i - lastPosition
			if types[0] == fruits[lastPosition] {
				types[1] = fruits[i]
			} else {
				types[0] = fruits[i]
			}
			total++
			lastPosition = i
		}
	}
	if max < total {
		max = total
	}
	return max
}

// 1 2 2 2 5 5 5

package google

type pair struct {
	s, e int
}

func minABCD(a, b int) int {
	if b < a {
		return b
	}
	return a
}

func searchNextOccupied(seats []int, searchFrom int) int {
	i := searchFrom
	for i < len(seats) && seats[i] != 1 {
		i++
	}
	return i
}

func maxDistToClosest(seats []int) int {
	maxDistance := 0
	i := 0
	for i < len(seats) {
		seat := seats[i]
		if seat == 1 {
			i++
		} else {
			seatRange := pair{i - 1, searchNextOccupied(seats, i)}
			distance := 1 << 20
			if seatRange.e == len(seats) || seatRange.s == -1 {
				distance = seatRange.e - seatRange.s - 1
			} else {
				center := (seatRange.e + seatRange.s) / 2
				distance = minABCD(center-seatRange.s, seatRange.e-center)
			}
			if maxDistance < distance {
				maxDistance = distance
			}

			i = seatRange.e + 1
		}

	}
	return maxDistance
}

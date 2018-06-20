package trie

import "sort"

type suffix struct {
	ri, rj uint8
	sa     int
}

func (s *suffix) equalRank(o *suffix) bool {
	return s.ri == o.ri && s.rj == o.rj
}

type SuffixArray struct {
	str      string
	suffixes []*suffix
}

func (s *SuffixArray) defineRanks(k int) {
	n := len(s.str)

	if k == 1 {
		for i := 0; i < n-1; i++ {
			suf := s.suffixes[i]
			suf.sa = i
			suf.ri, suf.rj = s.str[i], s.str[i+1]
		}
		i := n - 1
		suf := s.suffixes[i]
		suf.sa = i
		suf.ri, suf.rj = s.str[i], -1
	} else {
		r := uint8(0)
		for i := 1; i < n; i++ {
			sp, sc := s.suffixes[i-1], s.suffixes[i]
			if !sc.equalRank(sp) {
				r++
			}
			sc.ri = r
		}
		s.suffixes[0].ri = 0

		for
	}
}

func (s *SuffixArray) sortRanks() {
	sort.Slice(s.suffixes, func(i, j int) bool {
		return s.suffixes[i].ri > s.suffixes[j].ri || s.suffixes[i].rj > s.suffixes[j].rj
	})
}

func New(str string) *SuffixArray {
	n := len(str)
	sufArray := &SuffixArray{str: str, suffixes: make([]*suffix, n)}

	for k := 1; k < n; k *= 2 {
		sufArray.defineRanks(k)
		sufArray.sortRanks()
	}
	return sufArray
}

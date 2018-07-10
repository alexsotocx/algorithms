package suffix_array

import (
	"github.com/alexsotocx/algorithms/go/algorithms/sort/quicksort"
)

type suffix struct {
	sa, ri, rj int
}

type SuffixArray struct {
	str      string
	suffixes []suffix
}

func (s *SuffixArray) defineRanks(k int) {
	n := len(s.str)
	indMap := make([]int, n)
	if k == 1 {
		for i := 0; i < n; i++ {
			suf := &s.suffixes[i]
			suf.sa = i
			suf.ri = int(s.str[i])
			indMap[suf.sa] = i
		}
	} else {
		r := 0
		sf0 := &s.suffixes[0]
		pri, prj := sf0.ri, sf0.rj
		sf0.ri = r
		indMap[sf0.sa] = 0
		for i := 1; i < n; i++ {
			sc := &s.suffixes[i]
			if !(sc.ri == pri && sc.rj == prj) {
				r++
			}
			pri, prj = sc.ri, sc.rj
			sc.ri = r
			indMap[sc.sa] = i
		}
	}

	for i := 0; i < n; i++ {
		suf := &s.suffixes[i]
		suf.rj = -1
		if suf.sa+k < n {
			suf.rj = s.suffixes[indMap[suf.sa+k]].ri
		}
	}
}

func (s *SuffixArray) sortRanks() {
	quicksort.Sort(s.suffixes, func(i, j int) bool {
		if s.suffixes[i].ri == s.suffixes[j].ri {
			return s.suffixes[i].rj < s.suffixes[j].rj
		}
		return s.suffixes[i].ri < s.suffixes[j].ri
	})
}

func New(str string) *SuffixArray {
	n := len(str)
	sufArray := &SuffixArray{str: str, suffixes: make([]suffix, n)}

	for k := 1; k < n; k *= 2 {
		sufArray.defineRanks(k)
		sufArray.sortRanks()
	}
	return sufArray
}

func (s SuffixArray) Show() []string {
	n := len(s.str)
	sufar := make([]string, n)
	for i := 0; i < n; i++ {
		sa := s.suffixes[i].sa
		sufar[i] = s.str[sa:]
	}
	return sufar
}

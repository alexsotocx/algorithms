package google

/*
Input: s = "heeellooo", words = ["hello", "hi", "helo"]
Output: 1
Explanation:
We can extend "e" and "o" in the word "hello" to get "heeellooo".
We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
Example 2:

Input: s = "zzzzzyyyyy", words = ["zzyy","zy","zyy"]
Output: 3
*/

type Pair struct {
	c     byte
	count byte
}

func countOrder(s string) []Pair {
	ans := make([]Pair, 0)
	i := 0
	for i < len(s) {
		c := s[i]
		count := byte(0)
		for i < len(s) && c == s[i] {
			count++
			i++
		}
		ans = append(ans, Pair{c, count})
	}
	return ans
}

func expressiveWords(s string, words []string) int {
	initial := countOrder(s)
	expressive := 0
	for _, word := range words {
		current := countOrder(word)
		if len(current) != len(initial) {
			continue
		}
		expressive++
		for i := range initial {
			if current[i].c != initial[i].c {
				expressive--
				break
			}
			if current[i].count > initial[i].count {
				expressive--
				break
			}
			if initial[i].count == 2 && initial[i].count != current[i].count {
				expressive--
				break
			}
		}
	}
	return expressive
}

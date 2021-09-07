package google

type stack struct {
	container []byte
}

func (s *stack) push(c byte) {
	s.container = append(s.container, c)
}

func (s *stack) pop() byte {
	v := s.container[s.size()-1]
	s.container = s.container[:s.size()-1]
	return v
}

func (s *stack) size() int {
	return len(s.container)
}

var mapper = map[byte]byte{
	')': '(',
	']': '[',
	'}': '{',
}

func isValid(str string) bool {
	s := &stack{}
	for i := range str {
		b := str[i]
		if b == '(' || b == '[' || b == '{' {
			s.push(b)
		} else {
			if s.size() == 0 {
				return false
			}
			opening := s.pop()
			if mapper[b] != opening {
				return false
			}
		}
	}
	return s.size() == 0
}

package interfaces

type Comparable interface {
	Compare(other Comparable) int
	Value() interface{}
}

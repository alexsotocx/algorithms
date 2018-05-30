package interfaces

type Comparable interface {
  Compare(other Comparable) int8
  Value() interface{}
}

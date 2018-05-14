package structures

type Stack interface {
  PushHead(data interface{}) (bool, error)
  DeleteHead() (interface{}, error)
  First() interface{}
  Iterator() IteratorInterface
}

func NewStack() Stack {
  return &DoubleLinkedList{}
}


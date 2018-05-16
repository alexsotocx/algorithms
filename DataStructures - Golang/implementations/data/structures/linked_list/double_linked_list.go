package linked_list

import "errors"

type node struct {
	Prev *node
	Next *node
	Data interface{}
}

type DoubleLinkedList struct {
	size uint
	head *node
	tail *node
}

type iterator struct {
  current *node
}

type reverseIterator struct {
  current *node
}

type IteratorInterface interface {
  Next() (interface{}, error)
}

func (it *iterator) Next() (interface{}, error) {
  if it.current == nil {
    return nil, errors.New("End of the list")
  }
  data := it.current.Data
  it.current = it.current.Next
  return data, nil
}

func (it *reverseIterator) Next() (interface{}, error) {
  if it.current == nil {
    return nil, errors.New("End of the list")
  }
  data := it.current.Data
  it.current = it.current.Prev
  return data, nil
}

func (list *DoubleLinkedList) PushBack(data interface{}) (bool, error) {
	newNode := new(node)
	newNode.Data = data
	if list.IsEmpty() {
		list.head = newNode
		list.tail = newNode
	} else {
		list.tail.Next = newNode
		newNode.Prev = list.tail
		list.tail = newNode
	}
	list.size += 1
	return true, nil
}

func (list *DoubleLinkedList) PushHead(data interface{}) (bool, error) {
	newNode := new(node)
	newNode.Data = data
	if list.IsEmpty() {
		list.head = newNode
		list.tail = newNode
	} else {
		list.head.Prev = newNode
		newNode.Next = list.head
		list.head = newNode
	}
	list.size += 1
	return true, nil
}

func (list *DoubleLinkedList) DeleteHead() (interface{}, error) {
	if list.IsEmpty() {
		return nil, errors.New("List is empty, can't delete")
	} else {
	  data := list.head.Data
		if list.Size() == 1 {
			list.head = nil
			list.tail = nil
		} else {
			list.head = list.head.Next
			list.head.Prev = nil
		}
		list.size -= 1
		return data, nil
	}
}

func (list *DoubleLinkedList) DeleteTail() (bool, error) {
	if list.IsEmpty() {
		return false, errors.New("List is empty, can't delete")
	} else {
		if list.Size() == 1 {
			list.head = nil
			list.tail = nil
		} else {
			list.tail = list.tail.Prev
			list.tail.Next = nil
		}
		list.size -= 1
		return true, nil
	}
}

func (list DoubleLinkedList) Size() uint {
	return list.size
}

func (list DoubleLinkedList) First() interface{} {
	return list.head.Data
}

func (list DoubleLinkedList) Last() interface{} {
	return list.tail.Data
}

func (list DoubleLinkedList) Iterator() IteratorInterface {
  return &iterator{current: list.head}
}

func (list DoubleLinkedList) ReverseIterator() IteratorInterface {
  return &reverseIterator{current: list.tail}
}

func (list DoubleLinkedList) IsEmpty() bool {
	return list.size == 0
}

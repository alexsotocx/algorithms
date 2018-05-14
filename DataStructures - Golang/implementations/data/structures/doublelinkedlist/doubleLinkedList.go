package doublelinkedlist

import "errors"

type node struct {
	Prev *node
	Next *node
	Data interface{}
}

type DoubleLinkedList struct {
	size int
	head *node
	tail *node
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

func (list *DoubleLinkedList) DeleteHead() (bool, error) {
	if list.IsEmpty() {
		return false, errors.New("List is empty, can't delete")
	} else {
		if list.Size() == 1 {
			list.head = nil
			list.tail = nil
		} else {
			list.head = list.head.Next
			list.head.Prev = nil
		}
		list.size -= 1
		return true, nil
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

func (list DoubleLinkedList) Size() int {
	return list.size
}

func (list DoubleLinkedList) First() *node {
	return list.head
}

func (list DoubleLinkedList) Last() *node {
	return list.tail
}

func (list DoubleLinkedList) IsEmpty() bool {
	return list.size == 0
}

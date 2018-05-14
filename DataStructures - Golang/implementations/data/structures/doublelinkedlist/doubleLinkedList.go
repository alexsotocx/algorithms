package doublelinkedlist

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


func (list *DoubleLinkedList) PushBack(data interface{}) int {
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
	return list.size
}

func (list *DoubleLinkedList) PushHead(data interface{}) int {
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
	return list.size
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

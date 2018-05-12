package main

import "fmt"
import "./doubleLinkedList"

func main() {
	list := doubleLinkedList.DoubleLinkedList{}
	list.PushBack(1)
	list.PushBack(2)
	list.PushBack(3)
	list.PushHead(4)

	for i := 0; i < list.Size(); i++ {

	}
}

import sys
sys.path.append('../DoubleLinkedList')

from double_linked_list import DoubleLinkedList

class Stack:
  def __init__(self):
    self.__linked_list = DoubleLinkedList()

  def first(self):
    return self.__first().data

  def __first(self):
    return self.__linked_list.first

  def pop(self):
    return self.__linked_list.delete(self.__first()).data

  def empty(self):
    return self.__linked_list.empty()

  def __len__(self):
    return self.__linked_list.size

  def insert(self, data):
    self.__linked_list.prepend(data)

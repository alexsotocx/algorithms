import sys
sys.path.append('../DoubleLinkedList')

from double_linked_list import DoubleLinkedList

class Queue:
  def __init__(self):
    self.__linked_list = DoubleLinkedList()

  def __first(self):
    return self.__linked_list.first

  def top(self):
    return self.__first().data

  def pop(self):
    return self.__linked_list.delete(self.__first()).data

  def empty(self):
    return self.__linked_list.empty()

  def __len__(self):
    return self.__linked_list.size

  def insert(self, data):
    self.__linked_list.append(data)

from double_linked_list import DoubleLinkedList

def generate_list():
  linked_list = DoubleLinkedList()
  linked_list.append(1)
  linked_list.append(2)
  linked_list.prepend(3)
  linked_list.append(5)
  return linked_list

print "Insertion"
for link in generate_list():
  print(link.data)

print "deletion at the middle"
linked_list = generate_list()
linked_list.delete(2)
for link in linked_list:
  print(link.data)

print "deletion at the start"
linked_list = generate_list()
linked_list.delete(3)
for link in linked_list:
  print(link.data)

print "deletion at the end"
linked_list = generate_list()
linked_list.delete(5)
for link in linked_list:
  print(link.data)

print "deletion when is just one element"
linked_list = DoubleLinkedList()
linked_list.append(1)
linked_list.delete(1)
if linked_list.first is None and linked_list.last is None and linked_list.empty():
  print("it is an empty list")

print "Size test, size = %s" % (generate_list().size)


print "contains test"
if 3 in generate_list():
  print "works"
else:
  print "Doesnt work"

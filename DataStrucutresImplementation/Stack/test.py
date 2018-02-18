from stack import Stack

def generate_stack():
  stack = Stack()
  stack.insert(5)
  stack.insert(1)
  stack.insert(2)
  stack.insert(3)
  return stack

stack = generate_stack()
print stack.pop()
print stack.pop()
print stack.pop()
print stack.pop()

print "is queue empty = %s" % (stack.empty())

stack.insert(6)

print "Top method returns the first without removing it, size before top: %s, first: %s, size after first: %s" % (len(stack), stack.first(), len(stack))

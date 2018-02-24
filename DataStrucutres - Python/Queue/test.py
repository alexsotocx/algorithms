from queue import Queue

def generate_queue():
  q = Queue()
  q.insert(1)
  q.insert(2)
  q.insert(3)
  q.insert(5)
  return q

q = generate_queue()
print q.pop()
print q.pop()
print q.pop()
print q.pop()

print "is queue empty = %s" % (q.empty())

q.insert(6)

print "Top method returns the first without removing it, size before top: %s, first: %s, size after first: %s" % (len(q), q.first(), len(q))

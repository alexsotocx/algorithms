class Link:
  def __init__(self, data):
    self.data = data
    self.next = None
    self.prev = None

class LinkIterator:
  def __init__(self, link):
    self.next_link = link
    self.count = 0

  def next(self):
    link = self.next_link
    if self.count == 0:
      self.count += 1
    else:
      link = self.next_link = self.next_link.next
    if self.next_link is None:
      raise StopIteration()
    return self.next_link


class DoubleLinkedList:
  def __init__(self):
    self.first = None
    self.last = None
    self.size = 0

  def empty(self):
    return (self.size == 0)

  def append(self, data):
    link = Link(data)
    if self.empty():
      self.first = self.last = link
    else:
      link.prev = self.last
      self.last.next = link
      self.last = link
    self.size += 1
    return link

  def prepend(self, data):
    link = Link(data)
    if self.empty():
      self.first = self.last = link
    else:
      link.next = self.first
      self.first.prev = link
      self.first = link
    self.size += 1
    return link

  def insertAfter(self, data, link):
    new_link = Link(data)
    if link.next is not None:
      new_link.next = link.next
      link.next.prev = new_link
    new_link.prev = link
    link.next = new_link
    return new_link

  def find(self, data):
    for link in self:
      if data == link.data:
        return link
    return None

  def delete(self, link):
    if link is not None:
      if link.prev is None: # Is the first one
        next_link = self.first.next
        if next_link is not None:
          next_link.prev = None
        else:
          self.last = None
        self.first = next_link
      elif link.next is None: # Is the last one
        last_link = self.last.prev
        if last_link is not None:
          last_link.next = None
        else:
          self.first = None
        self.last = last_link
      else: # In the middle
        link.prev.next = link.next
        link.next.prev = link.prev
      self.size -= 1
      return link
    return None

  def __iter__(self):
    return LinkIterator(self.first)

  def __contains__(self, data):
    return self.find(data) != None

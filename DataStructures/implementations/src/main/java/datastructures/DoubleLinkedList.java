package datastructures;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<DoubleLinkedList.Link> {
  private Link<T> first;
  private Link<T> last;
  private int size = 0;

  public Link<T> append(T data) {
    Link<T> link = new Link<>(data);
    if (isEmpty()) {
      first = last = link;
    } else {
      last.next = link;
      link.prev = last;
      last = link;
    }
    size++;
    return link;
  }

  public Link<T> prepend(T data) {
    Link<T> link = new Link<>(data);
    if (isEmpty()) {
      first = last = link;
    } else {
      first.prev = link;
      link.next = first;
      first = link;
    }
    size++;
    return link;
  }

  public Link<T> find(T data) {
    for (Link<T> link : this) {
      if (link.data.equals(data)) {
        return link;
      }
    }
    return null;
  }

  public Link<T> delete(Link<T> linkToDelete) {
    if (linkToDelete == null) return null;
    if (linkToDelete.prev == null) deleteFirst();
    else if (linkToDelete.next == null) deleteLast();
    else {
      linkToDelete.next.prev = linkToDelete.prev;
      linkToDelete.prev.next = linkToDelete.next;
    }

    size--;
    return linkToDelete;
  }

  public Link<T> deleteFirst() {
    Link<T> temp = this.first;
    first.next.prev = null;
    first = first.next;
    return temp;
  }

  public Link<T> deleteLast() {
    Link<T> temp = last;
    last.prev.next = null;
    last = last.prev;
    return temp;
  }

  public Link<T> getFirst() {
    return first;
  }

  public Link<T> getLast() {
    return last;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public Link<T> insertAfter(Link<T> link, T data) {
    Link<T> newLink = new Link<>(data);
    if (link.next == null) newLink = append(data);
    else {
      link.next.prev = newLink;
      newLink.next = link.next;
      newLink.prev = link;
      link.next = newLink;
      size++;
    }
    return newLink;
  }

  public Link<T> inserBefore(Link<T> link, T data) {
    Link<T> newLink = new Link<>(data);
    if (link.prev == null) newLink = prepend(data);
    else {
      link.prev.next = newLink;
      newLink.prev = link.prev;
      newLink.next = link;
      link.prev = newLink;
      size++;
    }
    return newLink;
  }

  @Override
  public Iterator<Link> iterator() {
    return new LinkIterator(first, false);
  }

  public Iterator<Link> reversedIterator() {
    return new LinkIterator(last, true);
  }


  class LinkIterator implements Iterator<Link> {
    private Link<T> current;
    private boolean reversed;

    public LinkIterator(Link<T> link, boolean reversed) {
      current = link;
      this.reversed = reversed;
    }

    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public Link<T> next() {
      Link<T> temp = current;
      current = nextLink(current);
      return temp;
    }


    private Link<T> nextLink(Link<T> link) {
      if (reversed) return link.prev;
      return link.next;
    }
  }

  public class Link<T> {
    T data;
    Link<T> next;
    Link<T> prev;

    public Link(T data) {
      this.data = data;
    }
  }
}
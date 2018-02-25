package datastructures;
import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<DoubleLinkedList.Link>{
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
      if (link.data.equals(data)){
        return link;
      }
    }
    return null;
  }

  public Link<T> delete(Link<T> linkToDelete) {
    if(linkToDelete == null) return null;
    if(linkToDelete.prev == null) deleteFirst();
    else if (linkToDelete.next == null) deleteLast();
    else {
      linkToDelete.next.prev = linkToDelete.prev;
      linkToDelete.prev.next = linkToDelete.next;
    }

    this.size--;
    return linkToDelete;
  }

  public Link<T> deleteFirst() {
    Link<T> temp = this.first;
    this.first.next.prev = null;
    this.first = this.first.next;
    return temp;
  }

  public Link<T> deleteLast() {
    Link<T> temp = this.last;
    this.last.prev.next = null;
    this.last = this.last.prev;
    return temp;
  }

  public Link<T> getFirst() {
    return this.first;
  }

  public Link<T> getLast() {
    return this.last;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Iterator<Link> iterator() {
    return new LinkIterator(first);
  }

  class LinkIterator implements Iterator<Link> {
    private Link<T> current;
    private boolean isFirst = true;

    public LinkIterator(Link<T> link) {
      this.current = first;
    }

    @Override
    public boolean hasNext() {
      return (current != null);
    }

    @Override
    public Link<T> next() {
      Link<T> temp = current;
      if (isFirst) {
        isFirst = false;
        current = current.next;
        return temp;
      }
      current = current.next;
      return temp;
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
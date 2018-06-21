# DoubleLinkedList

A double linked list is  very versatile data structure, It allows very fast insertions but slow search.

## Structure

The double linked list consist in 'List of links'(Separated objects), where each link points to the next and previous one in the list.


![Linked-List-Image](https://kalpacg.files.wordpress.com/2015/08/25b19-ll5.gif)


## Operations

| Operation              | Big O Time | Explanation                                                                                        |
|------------------------|------------|----------------------------------------------------------------------------------------------------|
| Insertion at the start | O(1)       | Simple references changes                                                                          |
| Insertion at the end   | O(1)       | Simple references changes                                                                          |
| Find an object         | O(N)       | Since the data structure has no random access, we have to traverse all the list to find the object |
| Delete                 | O(N)       | It relays on find object to delete it converts to O(N), The deletion takes O(1)                    |


## Usages

* Used to code the Stack and Queue Data.
* Simulations

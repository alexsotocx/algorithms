// This is an input class. Do not edit.
export class LinkedList {
  value: number;
  next: LinkedList | null;

  constructor(value: number) {
    this.value = value;
    this.next = null;
  }
}

export function middleNode(linkedList: LinkedList) {
  let fastP: LinkedList | null = linkedList;
  let slowP: LinkedList | null = linkedList;
  while(fastP?.next) {
    fastP = fastP.next?.next || null;
    slowP = slowP.next!;
  }
  return slowP;
}


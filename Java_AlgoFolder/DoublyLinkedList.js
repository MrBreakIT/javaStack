// There is no reason why a linked list node must refer to only one other node. For the best flexibility when traversing a list, we might want to be connected in both directions: forward and backward. Where singly linked lists feature nodes that only know about their forward neighbor '.next', doubly linked lists have nodes with both a '.prev' and a '.next' property.

// For the doubly linked list all of the concepts and techniques of singly linked lists apply. This extra flexibility comes with a cost however. Maintaining both sets of pointers can be tedious.
// Given the above information, and basic class implementations build out the following methods on the DLL class:

// | Method Signature | Description                                         |
// |------------------|-----------------------------------------------------|
// | .push(value)     | add the value to the end of the list                |
// | .pop()           | remove the value from the end of the list           |
// | .front()         | return the value at the start of the list           |
// | .back()          | return the value at the end of the list             |
// | .contains(value) | return true if the value is present false otherwise |
// | .size()          | return the number of values stored in the list      |

// Prepend Value
// Create a .prepend(newVal, existingVal) method that will add the 'newVal' to before the 'existingVal' in a doubly linked list.

// Is Palindrome
// Return whether the values in a DLL are arranged in a palindrome (can be read the same forwards or backwards).

// Reverse
// Create a .reverse() method that will reverse the order of the values in the doubly linked list.

// ***************************************************************************************************************

function doubleLinkedList() {
    let Node = function (element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }

    let length = 0;
    let head = null;
    let tail = null;

    //Add new element
    this.append = function (element) {
        let node = new Node(element),
            current = head,
            previous;
        if (!head) {
            head = node;
            tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
        length++;
    }


    //Add element 
    this.insert = function (position, element) {
        //Check of out-of-bound values
        if (position >= 0 && position <= length) {
            let node = new Node(element),
                current = head,
                previous,
                index = 0;
            if (position === 0) {
                if (!head) {
                    head = node;
                    tail = node;
                } else {
                    node.next = current;
                    current.prev = node;
                    head = node;
                }
            } else if (position === length) {
                current = tail;
                current.next = node;
                node.prev = current;
                tail = node;
            } else {
                while (index++ < position) {
                    previous = current;
                    current = current.next;
                }
                node.next = current;
                previous.next = node;

                //New
                current.prev = node;
                node.prev = previous;
            }
            length++;
            return true;
        } else {
            return false;
        }
    }

    //Remove element at any position
    this.removeAt = function (position) {
        //look for out-of-bounds value
        if (position > -1 && position < length) {
            let current = head, previous, index = 0;
            //Removing first item
            if (position === 0) {
                head = current.next;
                //if there is only one item, update tail //NEW
                if (length === 1) {
                    tail = null;
                } else {
                    head.prev = null;
                }
            } else if (position === length - 1) {
                current = tail;
                tail = current.prev;
                tail.next = null;
            } else {
                while (index++ < position) {
                    previous = current;
                    current = current.next;
                }

                //link previous with current's next - skip it
                previous.next = current.next;
                current.next.prev = previous;
            }

            length--;
            return current.element;
        } else {
            return null;
        }
    }

    //Get the indexOf item 
    this.indexOf = function (elm) {
        let current = head,
            index = -1;

        //If element found then return its position
        while (current) {
            if (elm === current.element) {
                return ++index;
            }

            index++;
            current = current.next;
        }

        //Else return -1
        return -1;
    };

    //Find the item in the list
    this.isPresent = (elm) => {
        return this.indexOf(elm) !== -1;
    };

    //Delete an item from the list
    this.delete = (elm) => {
        return this.removeAt(this.indexOf(elm));
    };

    //Delete first item from the list
    this.deleteHead = function () {
        this.removeAt(0);
    }

    //Delete last item from the list
    this.deleteTail = function () {
        this.removeAt(length - 1);
    }

    //Print item of the string
    this.toString = function () {
        let current = head,
            string = '';

        while (current) {
            string += current.element + (current.next ? '\n' : '');
            current = current.next;
        }

        return string;
    };

    //Convert list to array
    this.toArray = function () {
        let arr = [],
            current = head;

        while (current) {
            arr.push(current.element);
            current = current.next;
        }

        return arr;
    };

    //Check if list is empty
    this.isEmpty = function () {
        return length === 0;
    };

    //Get the size of the list
    this.size = function () {
        return length;
    }

    //Get the head
    this.getHead = function () {
        return head;
    }

    //Get the tail
    this.getTail = function () {
        return tail;
    }
    //Reverse
    this.reverse = function () {
        this.temp = null
        this.current = head;

        //swap next and prev for all nodes 
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }
}

// Input:
let dll = new doubleLinkedList();
dll.size();
dll.append('One');
dll.append('Two');
dll.append('Three');
dll.append('Four');
dll.append('JohnnyBoy');
dll.insert(1, 'Five');
dll.deleteHead();
dll.deleteTail();
dll.reverse();
dll.size();
console.log(dll.toArray());



// this.append
// this.prepend
// this.insert
// this.removeAt
// this.indexOf
// this.isPresent
// this.delete
// this.deleteHead
// this.deleteTail
// this.toString
// this.toArray
// this.isEmpty
// this.size
// this.getHead
// this.getTail
// this.palindrome

// this.push
// this.pop
// this.front
// this.back
// this.contains
// this.size





    //    *********************************** from AhmetDillace ***************************************
    //         class DLL {

    //             //constructor
    //             constructor() {
    //                 this.head = null;
    //                 this.tail = null;
    //             }

    //             //add the value to the end of the list  
    //             append(val) {

    //                 //create head
    //                 const newNode = new Node(val);

    //                 //check head
    //                 if (this.head == null) {

    //                     //add new node
    //                     this.head = newNode;

    //                     //add to tail since we have a node in the link already
    //                 } else {

    //                     //add this node to the prev node's next value
    //                     this.tail.next = newNode;

    //                     //set this node's prev val to current tail
    //                     newNode.prev = this.tail;

    //                 }

    //                 //append new node to tail
    //                 this.tail = newNode;

    //             }


    //             //add to front  
    //             prepend(val) {

    //                 //create head
    //                 const newNode = new Node(val);

    //                 //head is empty
    //                 if (this.head == null) {

    //                     this.head = newNode;

    //                     //head has node
    //                 } else {

    //                     //add current head to new node's next value
    //                     newNode.next = this.head;

    //                     //head prev is new node now
    //                     this.head.prev = newNode;

    //                     //place new node into head
    //                     this.head = newNode;

    //                 }

    //             }

    //             //return the value at the start of the list
    //             front() {

    //                 console.log("First value in list is", this.head.value)

    //             }

    //             //return the value at the end of the list
    //             back() {

    //                 console.log("Last value in list is", this.tail.value)

    //             }

    //             //return true if the value is present false otherwise
    //             contains(val) {

    //                 let runner = this.head;
    //                 while (runner != null) {

    //                     //increment
    //                     if (runner.value == val) {
    //                         console.log("The value", val, "found!")
    //                         return;
    //                     }
    //                     //go to next node
    //                     runner = runner.next;

    //                 }

    //                 console.log("The value", val, "was not found...")

    //             }

    //             //return the number of values stored in the list      
    //             size() {

    //                 let runner = this.head, count = 1;
    //                 while (runner != this.tail) {

    //                     //increment
    //                     count++;

    //                     //go to next node
    //                     runner = runner.next;

    //                 }

    //                 //output
    //                 console.log("This list has", count, (count > 1) ? "nodes." : "node.");

    //             }

    //             //show all 
    //             display() {

    //                 //check head
    //                 if (this.head == null) {
    //                     console.log("no nodes in list.")
    //                     return;
    //                 }

    //                 //print seperated
    //                 console.log("---------");

    //                 let runner = this.head;
    //                 while (runner != null) {

    //                     console.log(runner.value)
    //                     runner = runner.next;

    //                 }

    //                 //print seperated
    //                 console.log("---------");

    //             }

    //         }
// }
    // dlist = new DLL();
    // dlist.append(1);
    // dlist.append(2);
    // dlist.append(3);
    // dlist.prepend(4);
    // dlist.display();
    // dlist.front();
    // dlist.back();
    // dlist.contains(3)
    // dlist.size();


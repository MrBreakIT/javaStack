// starting from a SLL class, write a method that will reverse the order of the values stored in a Singly Linked list
// ************************ from EricViera
class Node {
    constructor(val) {
        this.val = val;
        this.next = null;
    }
}

class SLL {
    constructor() {
        this.head = null;
    }
    add(val) {
        var newNode = new Node(val);
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            var runner = this.head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    display() {
        var runner = this.head;
        while (runner != null) {
            console.log(runner.val);
            runner = runner.next;
        }
    }

    // reverse() {
    //     var runner = this.head;
    //     var nextUp = null;
    //     var prev = null;
    //     while (runner != null) {
    //         nextUp = runner.next;
    //         // save runner.next
    //         runner.next = prev;
    //         // set current runner.next to prev
    //         prev = runner;
    //         // set prev to the current runner
    //         runner = nextUp;
    //         // set runner to runner.next
    //     }
    //     // set this.head to the last node
    //     this.head = prev;
    // }
    // prepend(val, existingVal) {
    //     var newNode = new DLNode(val);
    //     var runner = this.head;
    //     while (runner.next.value != existingVal) {
    //         runner = runner.next;
    //     }
    //     var exVal = runner.next;
    //     exVal.prev = newNode;
    //     runner.next = newNode;
    //     newNode.next = exVal;
    //     newNode.prev = runner;
    // }

    // isPalindrome() {
    //     var runner1 = this.head;
    //     var runner2 = this.tail;
    //     while (runner1 != runner2) {
    //         if (runner1.value == runner2.value) {
    //             console.log("here");
    //             console.log("runner1", runner1.value)
    //             console.log("runner2", runner2.value)
    //             runner1 = runner1.next;
    //             runner2 = runner2.prev;
    //         }
    //         else {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // reverse() {
    //     var runner = this.tail;
    //     var last = this.tail;
    //     var first = this.head;
    //     while (runner != this.head) {
    //         var nextNode = runner.prev;
    //         runner.prev = runner.next;
    //         runner.next = nextNode;
    //         runner = runner.next;
    //     }
    //     runner.prev = runner.next;
    //     runner.next = null;
    //     this.head = last;
    //     this.tail = first;
    // }
}
var list = new SLL();
list.add(3);
list.add(4);
list.add(5);
list.add(6);
list.add(7);
list.display();
console.log("***********");
// list.reverse();
list.display();



























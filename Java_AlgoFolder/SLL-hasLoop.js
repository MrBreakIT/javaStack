
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
    hasLoop() {
        var slow = this.head;
        var fast = this.head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 hop
            fast = fast.next.next;     // 2 hops 

            if (slow == fast)  // fast caught up to slow, so there is a loop
                return true;
        }
        console.log("something")
        return false;  // fast reached null, so the list terminates
    }
}
var lastNode = list.head.next.next;
lastNode.next = list.head;
var list = new SLL();
list.add(1);
list.add(2);
list.add(3);
console.log("****************");
list.hasLoop();
list.display();



// ************************



// *************************from WillGoode
class Node {
    constructor(val) {
        this.value = val;
        this.next = null;
    }
}

class SLL {
    constructor() {
        this.head = null;
    }

    add(val) {
        const temp = new Node(val);
        if (this.head === null) {
            this.head = temp;
        } else {
            temp.next = this.head;
            this.head = temp;
        }
    }

    print() {
        let runner = this.head;
        let output = "";
        while (runner) {
            output += runner.value + " -> ";
            runner = runner.next;
        }
        console.log(output);
    }

    remove(val) {
        if (!this.head) {
            return false;
        }
        if (this.head.value === val) {
            this.head = this.head.next;
            return true;
        }
        let runner = this.head;
        while (runner.next) {
            if (runner.next.value === val) {
                runner.next = runner.next.next;
                return true;
            }
            runner = runner.next;
        }
        return false;
    }

    removeAt(index) {
        if (!this.head) {
            return null;
        }
        if (index === 0) {
            let output = this.head.value;
            this.head = this.head.next;
            return output;
        }
        let runner = this.head;
        for (let i = 0; i < index - 1; i++) {
            runner = runner.next;
            if (!runner) {
                return null;
            }
        }
        if (!runner && !runner.next) {
            return null;
        }
        let response = runner.next.value;
        runner.next = runner.next.next;
        return response;
    }

}

const list1 = new SLL();
list1.add(5);
list1.add(4);
list1.add(3);
list1.add(2);
list1.add(1);
list1.print();
list1.remove(4);
list1.removeAt(1);
list1.print();

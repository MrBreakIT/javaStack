// The BST structures the data in a tee rather than a flat linear sequence. BSTs always start with a single node which in a Linked List we call the 'head' and in a tree we call the 'root'. A Binary Tree Node can have a left child and/or a right child; each child might have left and/or right children of its own. An entire section of a family might descend from one sibling as opposed to another. A binary search tree adds a requirement that for each node, all nodes to the left must have smaller values. Similarly the right must contain larger or equal values. This constraint holds for every node in the tree. BST nodes without children are called 'leaf' nodes. Depending on its values, no node is required to have both a left and right node. Even in a tree containing many values the root might only have one left or right child.

class BTNode {
    constructor(val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }
}

class BST {
    constructor() {
        this.root = null;
    }

    insert(val) {
        const newNode = new BTNode(val);
        if (this.root === null) {
            this.root = newNode;
            return;
        }
        let squirrel = this.root;
        while (squirrel !== null) {
            if (val < squirrel.value) {
                if (squirrel.left === null) {
                    squirrel.left = newNode;
                    return;
                } else {
                    squirrel = squirrel.left;
                }
            } else {
                if (squirrel.right === null) {
                    squirrel.right = newNode;
                    return;
                } else {
                    squirrel = squirrel.right;
                }
            }
        }
    }

    print(pointer = this.root) {
        if (pointer !== null) {
            console.log(pointer.value);
            this.print(pointer.left);
            this.print(pointer.right);
        }
    }
    // Write a size() method that returns the number of nodes (values) contained in the tree.
    // Return the smallest value stored in the BST
    // Return whether a value is stored in a BST

    min() {
        if (this.root === null) {
            return null;
        }
        let squirrel = this.root;
        while (squirrel.left !== null) {
            squirrel = squirrel.left;
        }
        return squirrel.value;
    }

    contains(val) {
        if (this.root === null) {
            return false;
        }
        let squirrel = this.root;
        while (squirrel !== null) {
            if (squirrel.value === val) {
                return true;
            }
            if (val < squirrel.value) {
                squirrel = squirrel.left;
            } else {
                squirrel = squirrel.right;
            }
        }
        return false;
    }

    size(pointer = this.root) {
        if (pointer === null) {
            return 0;
        } else {
            return this.size(pointer.left) + this.size(pointer.right) + 1;
        }
    }

    // Build a height() method on the BST object that returns the total height of the tree – the longest sequence of nodes from root node to leaf node.

    height(pointer = this.root) {
        if (pointer === null) {
            return 0;
        } else {
            var leftHeight = this.height(pointer.left);
            var rightHeight = this.height(pointer.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

    }
    // Write a remove(value) method that will remove the first instance of the value from the BST. If the value is stored in a "leaf" node we may simply remove the pointer to it, if the value is stored in a node with one "child" we can change the pointer from it to its child, and if the node has two "children" we will have to determine the "in-order-successor".
    deleteNodeHelper(root, key) {
        if (root === null) {
            // Empty tree return false;
        }
        if (key < root.data) {
            root.left = deleteNodeHelper(root.left, key);
            return root;
        } else if (key > root.data) {
            root.right = deleteNodeHelper(root.right, key);
            return root;
        } else {
            // No children
            //case 1 - a leaf node
            if (root.left === null && root.right === null) {
                root = null;
                return root;
            }
            // Single Child cases
            if (root.left === null) return root.right;
            if (root.right === null) return root.left;

            // Both children, so need to find successor
            let currNode = root.right;
            while (currNode.left !== null) {
                currNode = currNode.left;
            }
            root.data = currNode.data;
            // Delete the value from right subtree.
            root.right = deleteNodeHelper(root.right, currNode.data);
            return root;
        }
    }

}

const oak = new BST();
oak.insert(100);
oak.insert(50);
oak.insert(200);
oak.insert(170);
oak.insert(300);
oak.deleteNodeHelper(170);
// console.log(oak);
// oak.print();
console.log(oak.min());
console.log("contains 170", oak.contains(170));
console.log("contains 180", oak.contains(180));
console.log("size =", oak.size());
console.log("height =", oak.height());
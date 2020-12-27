// Trie can and is used for things like autocomplete.

class TrieNode {
    constructor(val) {
        this.value = val;
        this.children = {};
        this.isWord = false;
    }
}

class Trie {
    constructor() {
        this.root = new TrieNode("");
    }

    add(word) {
        let runner = this.root;
        let val = "";
        for (let letter of word) {
            val += letter;
            if (!runner.children[letter]) {
                runner.children[letter] = new TrieNode(val);
            }
            runner = runner.children[letter];
        }
        runner.isWord = true;
    }

    print(pointer = this.root) {
        if (pointer != null) {
            console.log(pointer.value);
            for (let key in pointer.children) {
                this.print(pointer.children[key]);
            }
        }
    }

}

const t1 = new Trie();
t1.add("car");
t1.add("cat");
t1.add("cap");
t1.add("carrot");
t1.add("belt");
t1.print();
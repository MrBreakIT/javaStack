class TrieNode {
    constructor(val) {
        this.value = val;
        this.children = {};
        this.count = 0;
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
        runner.count++;
    }

    print(pointer = this.root) {
        if (pointer != null) {
            console.log(pointer.value);
            for (let key in pointer.children) {
                this.print(pointer.children[key]);
            }
        }
    }

    autocomplete(start) {
        let runner = this.root;
        for (let letter of start) {
            if (!runner.children[letter]) {
                throw new Error("No results for search: ", start);
            }
            runner = runner.children[letter];
        }
        // we're at the starting point now
        const results = [];
        function helper(pointer) {
            if (pointer.count > 0) {
                results.push(pointer);
            }
            for (let key in pointer.children) {
                helper(pointer.children[key]);
            }
        }
        helper(runner);
        return results.sort((a, b) => b.count - a.count).map(r => r.value);
    }

}

const t1 = new Trie();
t1.add("cat");
t1.add("cap");
t1.add("car");
t1.add("cat");
t1.add("car");
t1.add("car");
t1.add("carrot");
t1.add("belt");
console.log(t1.autocomplete("c"));
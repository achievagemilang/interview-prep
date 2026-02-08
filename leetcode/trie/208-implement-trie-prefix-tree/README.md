# Implement Trie (Prefix Tree)

## Problem Description

Implement a trie with `insert`, `search`, and `startsWith` methods.

- `insert(word)` — Inserts word into the trie
- `search(word)` — Returns true if word is in trie
- `startsWith(prefix)` — Returns true if any word starts with prefix

## Examples

**Example:**

```
Input: ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
       [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output: [null, null, true, false, true, null, true]
```

## Solution Approach

Use a tree structure where each node contains:

- A map of child nodes (character → TrieNode)
- A flag indicating end of word

**Insert**: Traverse/create nodes for each character, mark last as end.
**Search**: Traverse nodes, return true only if end flag is set.
**StartsWith**: Traverse nodes, return true if path exists.

## Complexity Analysis

- **Time Complexity:** $O(M)$ for all operations, where $M$ is word/prefix length.
- **Space Complexity:** $O(N \cdot M)$ where $N$ is number of words.

## Code Structure

```java
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            node = node.children.get(c);
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}
```

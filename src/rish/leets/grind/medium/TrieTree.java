package rish.leets.grind.medium;

import java.util.Arrays;

/*
 * Grind 75 : Week 3
 * 
 * Problem #: 208
 * Problem link : https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 * Date Attempted: 23/07/2023
 * 
 * @author Rishabh Soni
 *
 */
public class TrieTree {

    class TrieNode {

        char info;
        int leafCount;
        TrieNode[] childs;

        public TrieNode() {
            this.leafCount = 0;
            this.childs = new TrieNode[26];
            Arrays.fill(childs, null);
        }

        public TrieNode(char c) {
            this.info = c;
            this.leafCount = 0;
            this.childs = new TrieNode[26];
            Arrays.fill(childs, null);
        }

    }

    TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        int len = word.length();
        TrieNode level = root;

        for (int i = 0; i < len; i++) {

            char letter = word.charAt(i);
            TrieNode node = level.childs[letter - 'a'];

            if (node == null) {
                node = new TrieNode(letter);
                level.childs[letter - 'a'] = node;
            }

            level = node;
        }

        level.leafCount++;
    }

    public boolean search(String word) {

        int len = word.length();
        TrieNode level = root;

        for (int i = 0; i < len; i++) {

            char letter = word.charAt(i);
            TrieNode node = level.childs[letter - 'a'];

            if (node == null) {
                return false;
            }

            level = node;
        }

        return level.leafCount > 0;
    }

    public boolean startsWith(String prefix) {

        int len = prefix.length();
        TrieNode level = root;

        for (int i = 0; i < len; i++) {

            char letter = prefix.charAt(i);
            TrieNode node = level.childs[letter - 'a'];

            if (node == null) {
                return false;
            }

            level = node;
        }

        return true;
    }

    public static void main(String[] args) {

        TrieTree tree = new TrieTree();
        tree.insert("app");
        tree.insert("apple");
        tree.insert("bear");
        tree.insert("add");
        tree.insert("jam");
        tree.insert("rental");

        System.out.println(tree.search("apps"));
        System.out.println(tree.search("app"));
        System.out.println(tree.search("apple"));
    }

}

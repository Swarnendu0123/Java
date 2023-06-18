import java.util.*;

public class TrieImp {
    // defination of node of Tire
    static class Node {
        Node[] children = new Node[26];
        boolean endOfWord;
    }

    // root node (init)
    public static Node root = new Node();

    // function to add a string to trie
    public static void add(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true;
    }

    // function to search a particular string exist or not
    public static boolean search(String str) {
        Node curr = root;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return (curr.endOfWord == true);
    }

    // word break problem
    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }
        for (int i = 1; i <= key.length(); i++) {
            String First = key.substring(0, i);
            String Second = key.substring(i);
            if (search(First)) {
                if (wordBreak(Second)) {
                    return true;
                }
            }
        }
        return false;
    }

    // function to count nodes of a tire
    public static int countNodes(Node curr) {
        if (curr == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                count += countNodes(curr.children[i]);
            }
        }
        return count + 1;
    }

    // question : Longest word with all prefixes
    public static String finalAns = "";

    public static void quest(Node root1, StringBuilder tempAns) {
        if (root1 == null) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (root1.children[i] != null && root1.children[i].endOfWord == true) {
                tempAns.append((char) (i + 'a'));
                if (finalAns.length() < tempAns.length()) {
                    // update final ans
                    finalAns = tempAns.toString();
                }
                quest(root1.children[i], tempAns);
                // backtracking
                tempAns.deleteCharAt(tempAns.length() - 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        String[] ans = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        for (int i = 0; i < ans.length; i++) {
            add(ans[i]);  
        }
        quest(root, new StringBuilder(""));
        System.out.println(finalAns);
    }
}
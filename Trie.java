
class TrieNode {
    char data;
    boolean isTerminated;
    TrieNode children[];
    int count;

    TrieNode(char data) {
        this.data = data;
        isTerminated = false;
        children = new TrieNode[26];
        count = 0;
    }
}

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode('\0');
    }

    private void add(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminated = true;
            return;
        }
        int index = word.charAt(0) - 'a';
        TrieNode child = root.children[index];
        if (child == null) {
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
            root.count++;
        }
        add(child, word.substring(1));
    }

    public void add(String word) {
        add(root, word);
    }

    private boolean search(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminated;
        }
        int index = word.charAt(0) - 'a';
        TrieNode child = root.children[index];
        if (child == null)
            return false;
        return search(child, word.substring(1));
    }

    public boolean search(String word) {
        return search(root, word);
    }

    private void remove(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminated = false;
            return;
        }
        int index = word.charAt(0) - 'a';
        TrieNode child = root.children[index];
        if (child == null) {
            return;
        }
        remove(child, word.substring(1));
        if ((!child.isTerminated) && child.count == 0) {
            root.children[index] = null;
            child = null;
            root.count--;
        }

    }

    public void remove(String word) {
        remove(root, word);
    }

    public static void main(String argss[]) {
        Trie t = new Trie();
        t.add("be");
        t.add("bat");
        t.add("cat");
        t.remove("be");
        System.out.println(t.search("bat"));
        System.out.println(t.search("be"));

    }

}

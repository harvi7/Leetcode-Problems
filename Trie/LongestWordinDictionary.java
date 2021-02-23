// https://www.youtube.com/watch?v=waIgDZZp9Wc

class Solution {
    public String longestWord(String[] words) {
//         Arrays.sort(words);
//         HashSet<String> builtWords = new HashSet();
//         String result = "";
//         for (String w : words) {
//             if (w.length() == 1 || builtWords.contains(w.substring(0, w.length() - 1))) {
//                 if (w.length() > result.length()) result = w;
//                 builtWords.add(w);
//             }
//         }
        
//         return result;
        
        // Trie + Depth-First Search
        Trie trie = new Trie();
        int index = 0;
        for (String word: words) {
            trie.insert(word, ++index); //indexed by 1
        }
        trie.words = words;
        return trie.dfs();
    }
}

class Node {
    char c;
    HashMap<Character, Node> children = new HashMap();
    int end;
    public Node(char c){
        this.c = c;
    }
}

class Trie {
    Node root;
    String[] words;
    public Trie() {
        root = new Node('0');
    }

    public void insert(String word, int index) {
        Node cur = root;
        for (char c: word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node(c));
            cur = cur.children.get(c);
        }
        cur.end = index;
    }

    public String dfs() {
        String ans = "";
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            if (node.end > 0 || node == root) {
                if (node != root) {
                    String word = words[node.end - 1];
                    if (word.length() > ans.length() ||
                            word.length() == ans.length() && word.compareTo(ans) < 0) {
                        ans = word;
                    }
                }
                for (Node nei: node.children.values()) {
                    stack.push(nei);
                }
            }
        }
        return ans;
    }
}
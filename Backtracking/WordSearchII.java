// https://www.youtube.com/watch?v=2LM90p1izhA
// https://www.youtube.com/watch?v=EmvsBM7o-5k
class Solution {
    
    int[] x = {0,0,-1,1};
    int[] y = {1,-1,0,0};
    
    public boolean outside(char[][] board, int i , int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return true;
        return false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie tr = new Trie();
        TrieNode root = tr.root;
        Set<String> res = new HashSet<>();
        for (String w : words) 
            tr.insert(w);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (root.child[c - 'a'] != null) {
                    dfs(board, i, j, root, c, res);
                }
            }
        }    
        return new ArrayList<>(res);
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode cur, char c, Set<String> res){
        if (outside(board, i, j) || board[i][j] == '#' || cur.child[c - 'a'] == null) 
            return;
        char temp = board[i][j]; board[i][j] = '#';
        cur = cur.child[temp - 'a'];
        if (cur != null && cur.word)
            res.add(cur.words);
        for (int k = 0; k < x.length; k++) {
            int ro = i + x[k]; 
            int co = j + y[k];
            if (outside(board, ro, co)) 
                continue;
            dfs(board, ro, co, cur, board[ro][co], res);
        }
        board[i][j] = temp;
        return;
    }
}


class Trie{
    TrieNode root = new TrieNode();
    public void insert(String str) {
        TrieNode cur = root;
        for (int i = 0; i < str.length(); i++){
            int ind = str.charAt(i) - 'a';
            if (cur.child[ind] == null)
                cur.child[ind] = new TrieNode();
            cur = cur.child[ind];
        }
        cur.words = str;
        cur.word = true;
    }
}

class TrieNode{
    TrieNode[] child = new TrieNode[26];
    boolean word;
    String words;
    TrieNode() {
        for(int i = 0; i < child.length; i++)
            child[i] = null;
        word = false;
        words = null;
    }
}
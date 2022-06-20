/**
Time Complexity: O(N) + O(V) 
// Where N is the total number of Node & V is number of Vertices of DFS
Space Complixity: O(M) // Where M is the total number of node
**/

class TrieNode {
    String word;
    TrieNode[] childNode;
    
    TrieNode() {
        word = "";
        childNode = new TrieNode[26];
    }
}

class Solution {
    public TrieNode root;
    
    Solution() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currentNode = root;
        
        for(int i = 0; i < word.length(); ++i) {
            int position = word.charAt(i) - 'a';
            
            if(currentNode.childNode[position] ==  null) {
                currentNode.childNode[position] = new TrieNode();
            }
            currentNode = currentNode.childNode[position];
        }
        currentNode.word = word;
    }
    
     List<String> dfs(TrieNode current, List<String> words) {
         
        System.out.println(current);
         if(current != null) System.out.println(current.word);
        
        if(current == null || words.size() == 3) return words;
        
        if(current.word.length() > 0 && words.size() < 3) {
            words.add(current.word);
        }
        
        for(int i  = 0 ; i < 26; ++i) {
            words = dfs(current.childNode[i], words);
        }
        
        return words;
    }
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        for(int i = 0; i < products.length; ++i) {
            insert(products[i]);
        }
        List<List<String>> resultList =  new ArrayList();
        char [] searchWordChar = searchWord.toCharArray();
        
        for(char c : searchWordChar) {
            // System.out.println(c);
            if(root != null && root.childNode[c - 'a'] != null) {
                 root = root.childNode[c - 'a'];
                 List<String> words = new ArrayList();
                 dfs(root, words);
                 resultList.add(words);
            }else {
                root = null;
            }
        }
         return resultList;
    }
}
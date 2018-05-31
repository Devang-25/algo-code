package ds;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public boolean isWord;
    public Map<Character, TrieNode> childrenMap = new HashMap<>();
}
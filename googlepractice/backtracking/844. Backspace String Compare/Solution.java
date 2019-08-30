class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();
        
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#' && !s1.isEmpty()) {
                s1.pop();
            }
            if (S.charAt(i) != '#') {
                s1.push(S.charAt(i));
            }
        }
        
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#' && !s2.isEmpty()) {
                s2.pop();
            }
            if (T.charAt(i) != '#') {
                s2.push(T.charAt(i));
            }
        }
        
        if (s1.size() != s2.size()) return false;
        while(!s1.isEmpty()) {
            char c1 = s1.pop();
            char c2 = s2.pop();
            if (c1 != c2) return false;
        }
        return true;
    }
}

//20. Valid Parentheses

import java.util.EmptyStackException;

class Solution {
    Stack<Character> stack = new Stack();
    public boolean isValid(String s) {
        try {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else {
                    char c2 = stack.pop();
                    if (c2 != c) {
                        return false;
                    }
                }
            }

            if (stack.isEmpty()) {
                return true;
            }
            return false;
        } catch (EmptyStackException ex) {
            return false;
        }
    }
}

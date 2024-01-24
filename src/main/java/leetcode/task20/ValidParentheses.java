package leetcode.task20;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.empty() || stack.pop() != '(')
                        return false;
                    break;
                case ']':
                    if(stack.empty() || stack.pop() != '[')
                        return false;
                    break;
                case '}':
                    if(stack.empty() || stack.pop() != '{')
                        return false;
                    break;
            }
        }

        return stack.empty();
    }
}

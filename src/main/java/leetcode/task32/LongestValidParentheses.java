package leetcode.task32;

import java.util.Stack;

import static java.lang.Math.max;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int open = 0;
        int max = 0;
        int partialMax = 0;
        char[] chars = s.toCharArray();
        int i = 0;
        char lastChar = '_'; //anything but '(' or ')'

        Stack<ParserState> parserStates = new Stack<>();

        while (i < chars.length) {
            switch (chars[i]) {
                case '(':
                    if (lastChar == ')') {
                        parserStates.push(new ParserState(open, partialMax));
                        partialMax = 0;
                        open = 0;
                    }
                    open++;
                    lastChar = '(';
                    break;
                case ')':
                    open--;
                    if (open >= 0) {
                        partialMax += 2;
                        if (open == 0) {
                            if (!parserStates.empty()) {
                                ParserState parserState = parserStates.pop();
                                partialMax += parserState.partialMax();
                                open = parserState.open();
                            }
                        }
                    } else {
                        open = 0;
                        partialMax = 0;
                    }
                    max = max(max, partialMax);
                    lastChar = ')';
            }
            i++;
        }

        return max;
    }
}

record ParserState(int open, int partialMax) {
}

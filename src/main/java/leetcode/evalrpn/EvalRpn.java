package leetcode.evalrpn;

import java.util.Stack;

public class EvalRpn {

    public int evalRPN(String[] tokens) {
        Stack<String> tokenStack = new Stack<>();
        for (String token : tokens) {
            tokenStack.push(token);
        }

        return evalExpression(tokenStack);
    }

    private int evalExpression(Stack<String> tokens) {
        String token = tokens.pop();

        switch (token) {
            case "+":
                return evalExpression(tokens) + evalExpression(tokens);
            case "-": {
                int second = evalExpression(tokens);
                int first = evalExpression(tokens);
                return first - second;
            }
            case "*":
                return evalExpression(tokens) * evalExpression(tokens);
            case "/": {
                int second = evalExpression(tokens);
                int first = evalExpression(tokens);
                return first / second;
            }
            default:
                return Integer.parseInt(token);
        }
    }
}

package leetcode.task22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();

        char[] str = new char[2 * n];
        innerGenerate(0, 0, n, str);
        return result;
    }

    private void innerGenerate(int usedOpen, int usedClose, int max, char[] str) {
        if (usedOpen == max && usedClose == max) {
            result.add(new String(str));
            str[2 * max - 1] = '\0';
            return;
        }
        if (usedOpen < max) {
            str[usedOpen + usedClose] = '(';
            innerGenerate(usedOpen + 1, usedClose, max, str);
            str[usedOpen + usedClose] = '\0';
        }
        if (usedClose < usedOpen) {
            str[usedOpen + usedClose] = ')';
            innerGenerate(usedOpen, usedClose + 1, max, str);
            str[usedOpen + usedClose] = '\0';
        }
    }
}

package leetcode.task17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    char[][] mappings = {{},
            {}, {'a', 'b', 'c'}, {'d', 'e', 'f'},
            {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    int[] digNums;
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }


        char[] digChars = digits.toCharArray();
        digNums = new int[digits.length()];
        for (int i = 0; i < digChars.length; i++) {
            digNums[i] = digChars[i] - 48;
        }

        internalLetterCombinations(0, new char[digits.length()], result);
        return result;
    }

    private void internalLetterCombinations(int index, char[] str, List<String> result) {
        if (index == str.length) {
            result.add(new String(str));
            return;
        }
        for (char letter : mappings[digNums[index]]) {
            str[index] = letter;
            internalLetterCombinations(index + 1, str, result);
        }
    }
}

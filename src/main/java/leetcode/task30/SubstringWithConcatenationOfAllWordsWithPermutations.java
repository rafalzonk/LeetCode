package leetcode.task30;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class SubstringWithConcatenationOfAllWordsWithPermutations implements SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.length() < words.length * words[0].length())
            return emptyList();

        List<Integer> result = new ArrayList<>();
        generatePermutations(words, words.length, s, result);

        return result;
    }

    private static void checkForOccurences(String haystack, String needle, List<Integer> result) {
        int start = 0, indexOf;
        while ((indexOf = haystack.indexOf(needle, start)) >= 0) {
            result.add(indexOf);
            start = indexOf + 1;
        }
    }

    private void generatePermutations(String[] words, int n, String s, List<Integer> result) {
        if (n == 1) {
            checkForOccurences(s, generateNewWord(words), result);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutations(words, n - 1, s, result);
                if (n % 2 == 0) {
                    swap(words, i, n - 1);
                } else {
                    swap(words, 0, n - 1);
                }
            }
        }
    }

    private String generateNewWord(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
        }
        return sb.toString();
    }

    private void swap(String[] words, int a, int b) {
        String tmp = words[a];
        words[a] = words[b];
        words[b] = tmp;
    }
}
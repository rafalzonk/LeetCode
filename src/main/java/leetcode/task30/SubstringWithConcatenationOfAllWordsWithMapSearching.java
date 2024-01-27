package leetcode.task30;

import java.util.*;

import static java.util.Collections.emptyList;

public class SubstringWithConcatenationOfAllWordsWithMapSearching implements SubstringWithConcatenationOfAllWords {
    int wordLength;

    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        wordLength = words[0].length();
        int substringLength = words.length * wordLength;

        if (s.length() < substringLength)
            return emptyList();

        Map<String, Integer> occurences = new HashMap<>();
        for (String word : words) {
            int n = occurences.getOrDefault(word, 0);
            occurences.put(word, n + 1);
        }

        List<Integer> result = new ArrayList<>();
        Set<String> wordsSet = occurences.keySet();
        int indexOf;

        for (String word : wordsSet) {
            indexOf = s.indexOf(word);
            while (indexOf >= 0 && indexOf <= s.length() - substringLength) {
                if (checkForSubstring(s, indexOf, occurences))
                    result.add(indexOf);
                indexOf = s.indexOf(word, indexOf + 1);
            }
        }

        return result;
    }

    private boolean checkForSubstring(String s, int indexOf, Map<String, Integer> wordOccurences) {

        Map<String, Integer> words = new HashMap<>(wordOccurences);

        while (!words.isEmpty()) {
            String word = s.substring(indexOf, indexOf + wordLength);
            if (words.containsKey(word)) {
                int i = words.get(word) - 1;
                if (i == 0) {
                    words.remove(word);
                } else {
                    words.put(word, i);
                }
                indexOf += wordLength;
            } else {
                return false;
            }
        }

        return true;
    }
}

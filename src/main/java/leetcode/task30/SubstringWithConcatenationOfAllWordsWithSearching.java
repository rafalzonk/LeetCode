package leetcode.task30;

import java.util.*;

import static java.util.Collections.emptyList;

public class SubstringWithConcatenationOfAllWordsWithSearching implements SubstringWithConcatenationOfAllWords {
    @Override
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words[0].length();
        int substringLength = words.length * wordLength;

        if (s.length() < substringLength)
            return emptyList();

        List<Integer> result = new ArrayList<>();
        Set<String> wordsSet = new HashSet<>(List.of(words));
        int indexOf;

        for (String word : wordsSet) {
            indexOf = s.indexOf(word);
            while (indexOf >= 0 && indexOf <= s.length() - substringLength) {
                if (checkForSubstring(s, indexOf, words))
                    result.add(indexOf);
                indexOf = s.indexOf(word, indexOf + 1);
            }
        }

        return result;
    }

    private boolean checkForSubstring(String s, int indexOf, String[] words) {
        int wordLength = words[0].length();
        List<String> wordList = new LinkedList<>(List.of(words));

        while (!wordList.isEmpty()) {
            String word = s.substring(indexOf, indexOf + wordLength);
            if (wordList.contains(word)) {
                wordList.remove(word);
                indexOf += wordLength;
            } else {
                return false;
            }
        }

        return true;
    }
}

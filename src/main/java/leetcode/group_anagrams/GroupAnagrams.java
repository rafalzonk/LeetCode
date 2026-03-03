package leetcode.group_anagrams;

import java.util.*;

import static java.lang.String.copyValueOf;
import static java.util.Arrays.sort;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> charSets = new HashMap<>();

        for (String str : strs) {
            char[] charSet = str.toCharArray();
            sort(charSet);
            String key = copyValueOf(charSet);
            if (!charSets.containsKey(key)) {
                List<String> value = new ArrayList<>();
                value.add(str);
                charSets.put(key, value);
            } else {
                charSets.get(key).add(str);
            }
        }

        return charSets.values().stream().toList();
    }
}
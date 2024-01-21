package leetcode.task14;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;

            while (j < str.length() &&
                    j < prefix.length() &&
                    str.charAt(j) == prefix.charAt(j))
                j++;

            if (j == 0)
                return "";
            else if (j < prefix.length())
                prefix = prefix.substring(0, j);
        }

        return prefix;
    }
}

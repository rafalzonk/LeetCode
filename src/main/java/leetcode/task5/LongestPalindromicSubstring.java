package leetcode.task5;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String evenPalindrome = findLongestEvenPalindrome(s);
        String oddPalindrome = findLongestoddPalindrome(s);

        return evenPalindrome.length() > oddPalindrome.length() ?
                evenPalindrome :
                oddPalindrome;
    }

    private String findLongestoddPalindrome(String s) {
        String longestSoFar = s.substring(0, 1); // there will always be at least one letter
        int i = 1;

        while (i < s.length() && i + longestSoFar.length() / 2 < s.length()) {
            String candidate = checkForOddPalindrome(i, s);
            if (candidate.length() > longestSoFar.length())
                longestSoFar = candidate;

            i++;
        }

        return longestSoFar;
    }

    private String checkForOddPalindrome(int seedIndex, String s) {
        int left = seedIndex - 1, right = seedIndex + 1;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    private String findLongestEvenPalindrome(String s) {
        String longestSoFar = "";
        int i = 0;

        while (i < s.length() - 1 && i + longestSoFar.length()/2 < s.length()) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                String candidate = checkForEvenPalindrome(i, s);
                if (candidate.length() > longestSoFar.length())
                    longestSoFar = candidate;
            }

            i++;
        }

        return longestSoFar;
    }

    private String checkForEvenPalindrome(int seedIndex, String s) {
        int left = seedIndex - 1;
        int right = seedIndex + 2;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}

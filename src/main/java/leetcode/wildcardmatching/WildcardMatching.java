package leetcode.wildcardmatching;

public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray());
    }

    private boolean isMatch(char[] s, char[] p) {
        int sIndex = 0, pIndex = 0;
        int star = -1;
        int match = 0;

        while (sIndex < s.length) {
            if (pIndex < p.length && (p[pIndex] == '?' || p[pIndex] == s[sIndex])) {
                pIndex++;
                sIndex++;
            } else if (pIndex < p.length && p[pIndex] == '*') {
                star = pIndex;
                pIndex++;
                match = sIndex;
            } else if (star != -1) {
                pIndex = star + 1;
                match++;
                sIndex = match;
            } else {
                return false;
            }
        }
        while (pIndex < p.length && p[pIndex] == '*')
            pIndex++;

        return pIndex == p.length;
    }
}
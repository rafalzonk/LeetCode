package leetcode.task10;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.equals(".*") || p.equals(s))
            return true;

        return isMatchInternal(s, p);
    }

    private boolean isMatchInternal(String s, String p) {
        if (p.equals(".*") || p.equals(s)) {
            return true;
        }
        if (p.isEmpty()) {
            return false;
        }
        if (s.isEmpty()) {
            return checkEmptynessPattern(p);
        }

        char sChar = s.charAt(0);
        char patternChar = p.charAt(0);

        if (patternChar == '*')
            return isMatchInternal(s, p.substring(1));

        if ((patternChar > 96 && patternChar < 123) || patternChar == '.') {
            if (p.length() > 1 && p.charAt(1) == '*') {
                if (patternChar == '.') {
                    if (isMatchInternal(s, p.substring(2)))
                        return true;
                    else {
                        int i = 0;
                        while (i < s.length()) {
                            if (!isMatchInternal(s.substring(i + 1), p.substring(2)))
                                i++;
                            else
                                return true;
                        }
                    }
                } else {
                    if (isMatchInternal(s, p.substring(2)))
                        // * can match zero characters, so proceeding with next part of the pattern
                        return true;
                    else {
                        int i = 0;
                        while (i < s.length() && s.charAt(i) == patternChar) {
                            if (!isMatchInternal(s.substring(i + 1), p.substring(2)))
                                i++;
                            else
                                return true;
                        }
                    }

                }
            } else if (sChar == patternChar || patternChar == '.') { //if it is the same letter as in pattern or any letter is allowed
                //continue matching recursively without first letter form pattern and the string
                return isMatchInternal(s.substring(1), p.substring(1));

            }
        }
        return false;
    }

    private boolean checkEmptynessPattern(String p) {
        if (p.isEmpty())
            return true;
        if (p.charAt(0) == '*')
            return checkEmptynessPattern(p.substring(1));
        if (p.length() > 1 && p.charAt(1) == '*') {
            return checkEmptynessPattern(p.substring(2));
        }
        return false;
    }
}

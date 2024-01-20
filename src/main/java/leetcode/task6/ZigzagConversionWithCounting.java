package leetcode.task6;

public class ZigzagConversionWithCounting implements ZigzagConversion {
    @Override
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length())
            return s;
        if (numRows == 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i += 2) {
                sb.append(s.charAt(i));
            }
            for (int i = 1; i < s.length(); i += 2) {
                sb.append(s.charAt(i));
            }
            return sb.toString();
        }

        int n = (numRows - 1) * 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += n)
            sb.append(s.charAt(i));
        for (int r = 1; r < numRows - 1; r++) {
            sb.append(s.charAt(r));
            for (int i = n; i - r < s.length(); i += n) {
                sb.append(s.charAt(i - r));
                if (i + r < s.length()) {
                    sb.append(s.charAt(i + r));
                }
            }
        }
        for (int i = numRows - 1; i < s.length(); i += n)
            sb.append(s.charAt(i));

        return sb.toString();
    }
}

package leetcode.task6;

public class ZigzagConversionWithArray implements ZigzagConversion {
    @Override
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows > s.length())
            return s;
        if (numRows == 2) {
            return processTwoRows(s);
        }

        char[][] zigZagArray = new char[numRows][1 + (s.length() / 2)];

        int i = 0;
        int x, y = 0;

        while (i < s.length()) {
            for (x = 0; x < numRows && i < s.length(); x++) {
                zigZagArray[x][y] = s.charAt(i);
                i++;
            }
            x -= 2;
            y += 1;
            for (; x > 0 && i < s.length(); x--) {
                zigZagArray[x][y] = s.charAt(i);
                i++;
                y++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (x = 0; x < numRows; x++) {
            sb.append(zigZagArray[x]);
        }
        return sb.toString().replace("\0", "");
    }

    private String processTwoRows(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        for (int i = 1; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

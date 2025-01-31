package leetcode.task38;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        var rle = countAndSay(n - 1);
        int index = 0;
        StringBuilder sb = new StringBuilder();

        do {
            char c = rle.charAt(index);
            int count = 1;
            while (++index < rle.length()
                    && c == rle.charAt(index)) {
                count++;
            }
            sb.append(count).append(c);
        } while (index < rle.length());

        return sb.toString();
    }
}

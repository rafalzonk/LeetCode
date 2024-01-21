package leetcode.task12;

public class IntegerToRoman {
    public String intToRoman(int num) {

        StringBuilder result = new StringBuilder();
        int digit = num / 1000;
        num %= 1000;
        switch (digit) {
            case 3:
                result.append("MMM");
                break;
            case 2:
                result.append("MM");
                break;
            case 1:
                result.append("M");
            default:
        }

        digit = num / 100;
        num %= 100;

        switch (digit) {
            case 9:
                result.append("CM");
                break;
            case 8:
                result.append("DCCC");
                break;
            case 7:
                result.append("DCC");
                break;
            case 6:
                result.append("DC");
                break;
            case 5:
                result.append("D");
                break;
            case 4:
                result.append("CD");
                break;
            case 3:
                result.append("CCC");
                break;
            case 2:
                result.append("CC");
                break;
            case 1:
                result.append("C");
            default:
        }

        digit = num / 10;
        num %= 10;

        switch (digit) {
            case 9:
                result.append("XC");
                break;
            case 8:
                result.append("LXXX");
                break;
            case 7:
                result.append("LXX");
                break;
            case 6:
                result.append("LX");
                break;
            case 5:
                result.append("L");
                break;
            case 4:
                result.append("XL");
                break;
            case 3:
                result.append("XXX");
                break;
            case 2:
                result.append("XX");
                break;
            case 1:
                result.append("X");
            default:
        }

        switch (num) {
            case 9:
                result.append("IX");
                break;
            case 8:
                result.append("VIII");
                break;
            case 7:
                result.append("VII");
                break;
            case 6:
                result.append("VI");
                break;
            case 5:
                result.append("V");
                break;
            case 4:
                result.append("IV");
                break;
            case 3:
                result.append("III");
                break;
            case 2:
                result.append("II");
                break;
            case 1:
                result.append("I");
            default:
        }

        return result.toString();
    }
}
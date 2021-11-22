public class leetcode_md_12_inttoroman {
    int pow = 0;
    final String[] ones = { "I", "X", "C", "M" };
    final String[] fours = { "IV", "XL", "CD" };
    final String[] fives = { "V", "L", "D" };
    final String[] nines = { "IX", "XC", "CM" };

    // 28m
    public String intToRoman(int num) {
        if(num == 0) return "";
        String append = convert(num%10, pow++);
        return intToRoman(num/10) + append;
    }

    public String convert(int n, int pow){
        
        switch(n){
            case 1: case 2: case 3:
                return ones[pow].repeat(n);
            case 4:
                return fours[pow];
            case 5: case 6: case 7: case 8:
                return fives[pow] + ones[pow].repeat(n-5);
            case 9:
                return nines[pow];
            default: return "";
        }
    }
}

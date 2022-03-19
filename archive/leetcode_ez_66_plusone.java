public class leetcode_ez_66_plusone {

    // 17m
    public int[] plusOne(int[] digits) {
        boolean plus1 = true;
        int idx = digits.length-1;
        while(idx >= 0 && plus1){
            digits[idx] += plus1 ? 1 : 0;
            if(digits[idx] > 9)
                digits[idx] %= 10;
            else
                plus1 = false;
            --idx;
        }

        if(plus1 && idx == -1){     // only comes in here when all other digits were 9
            digits = new int[digits.length+1];
            digits[0] = 1;
        }

        return digits;
    }
}

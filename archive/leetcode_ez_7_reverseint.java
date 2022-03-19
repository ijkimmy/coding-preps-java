public class leetcode_ez_7_reverseint {

    // 29m
    public int reverse(int x) {
        if(x==0) return x;

        int sign = 1, rev = 0;
        
        if(x < 0){
            sign = -1;
            x *= sign;
        }
        
        int maxdiv10 = Integer.MAX_VALUE / 10;
        while(x > 0){
            if(rev > maxdiv10) return 0;
            else if(rev == maxdiv10){
                if(x%10 > 7){
                    if(sign == -1 && x%10 == 8) return rev * -10 - 8;
                    return 0;
                }
            }
            
            rev = rev*10 + x%10;
            x /= 10;
        }

        return rev * sign;
    }
}

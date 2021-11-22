public class leetcode_ez_9_palindrome {

    // 14m
    public boolean isPalindrome(int x) {
        // // not-optimal
        // if(x<0) return false;

        // String strx = String.valueOf(x);
        // for(int i=0; i<strx.length()/2; ++i){
        //     if(strx.charAt(i)!=strx.charAt(strx.length()-1-i))
        //         return false;
        // }
        // return true;


        // optimal solution
        if(x<0 || x%10==0) return false;
        int rev = 0;
        while(rev<x){
            rev = rev*10 + x%10;
            x /= 10;
        }
        return rev==x || rev==x/10;
    }
}

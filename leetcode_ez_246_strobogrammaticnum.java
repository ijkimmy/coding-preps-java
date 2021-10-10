public class leetcode_ez_246_strobogrammaticnum {

    // 15m
    public boolean isStrobogrammatic(String num) {
        for(int i=0; i<=num.length()/2; ++i){
            int val = num.charAt(i) - '0';

            char flip;
            switch(val){
                case 0: flip = '0'; break;
                case 1: flip = '1'; break;
                case 6: flip = '9'; break;
                case 8: flip = '8'; break;
                case 9: flip = '6'; break;
                default: return false;
            }

            if(num.charAt(num.length()-i-1) != flip) return false;
        }

        return true;
    }
}

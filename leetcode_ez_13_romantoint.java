public class leetcode_ez_13_romantoint {

    // 29m
    public int romanToInt(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return unit(s.charAt(0));

        int val0 = unit(s.charAt(0));
        int val1 = unit(s.charAt(1));
        if(val0 < val1){
            return val1 - val0 + romanToInt(s.substring(2));
        }
        else{
            return val0 + romanToInt(s.substring(1));
        }
    }

    public int unit(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
}
